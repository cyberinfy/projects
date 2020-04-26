package project.nriit.ped;

import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.content.ContentValues.TAG;
import static android.content.Context.INPUT_METHOD_SERVICE;


public class FindFragment extends Fragment {
    String input;
    String wordoutput,type,definition;
    AutoCompleteTextView inputWord;
    Button findBtn;
    ImageButton nextBtn,previousBtn,pronounciationBtn;
    EditText inputType,inputDefinition;
    protected TextToSpeech ttobj;

    public FindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MainActivity)getActivity()).setActionBarTitle("Find");
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onDestroy() {


        //Close the Text to Speech Library
        if(ttobj != null) {

            ttobj.stop();
            ttobj.shutdown();
            Log.d(TAG, "TTS Destroyed");
        }
        super.onDestroy();
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        ttobj=new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
            }
        });
        ttobj.setLanguage(Locale.UK);

        inputWord = (AutoCompleteTextView) view.findViewById(R.id.inputWord);
        inputType = (EditText) view.findViewById(R.id.type);
        inputDefinition = (EditText) view.findViewById(R.id.definition);

        inputWord.setAdapter(MainActivity.adapter);

        inputWord.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                String selected = (String) arg0.getAdapter().getItem(arg2);

            }
        });

        pronounciationBtn = (ImageButton) view.findViewById(R.id.pronounciation);
        pronounciationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String utteranceId=this.hashCode() + "";
                String word="";
                try{
                    word = containsIgnoreCase(inputWord.getText().toString(),MainActivity.wordsList);
                }
                catch(Exception ex)
                {

                }

                if(word.length()==0)
                    ttobj.speak("SORRY!       word  not  found  in  the  dictionary", TextToSpeech.QUEUE_FLUSH, null, utteranceId);

                else if(MainActivity.wordsList.indexOf(word)>=0)
                {
                    ttobj.speak(word, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
                }
                else
                {
                    ttobj.speak("SORRY!       wordo  not  found  in  the  dictionary", TextToSpeech.QUEUE_FLUSH, null, utteranceId);
                }

            }
        });
        findBtn = (Button) view.findViewById(R.id.findBtn);
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word="";
                try{
                    word = containsIgnoreCase(inputWord.getText().toString(),MainActivity.wordsList);
                }
                catch(Exception ex)
                {

                }
                hideSoftKeyBoard();
                if (word.length() == 0) {
                    inputType.setText("");
                    inputDefinition.setText("");
                    Toast.makeText(getActivity(), "No input given", Toast.LENGTH_SHORT).show();

                }
                else if (MainActivity.wordsList.indexOf(word)<0) {
                    inputType.setText("");
                    inputDefinition.setText("");
                    Toast.makeText(getActivity(), "Sorry word not found", Toast.LENGTH_SHORT).show();
                    wordoutput = "";
                    type = "";
                    definition = "";
                }
                else {
                    try {
                        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
                        databaseAccess.open();
                        Cursor cursor = databaseAccess.findDetails(word);
                        if (cursor == null) {
                            Toast.makeText(getActivity(), "Sorry word not found", Toast.LENGTH_SHORT).show();
                            wordoutput = "";
                            type = "";
                            definition = "";

                        } else {
                            wordoutput = cursor.getString(1);
                            type = cursor.getString(2);
                            definition = cursor.getString(3).replaceAll("Examples :- ", "\nExamples :- ");
                            inputWord.setText(wordoutput);
                            inputWord.dismissDropDown();
                            inputType.setText(type);
                            inputDefinition.setText(definition);
                            cursor.close();
                        }

                        databaseAccess.close();
                    }
                    catch(Exception e)
                    {
                        inputType.setText("");
                        inputDefinition.setText("");
                        Toast.makeText(getActivity(), "Sorry unable to find", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        previousBtn = (ImageButton) view.findViewById(R.id.previous);
        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word="";
                try{
                    word = containsIgnoreCase(inputWord.getText().toString(),MainActivity.wordsList);
                }
                catch(Exception ex)
                {

                }
                hideSoftKeyBoard();
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
                databaseAccess.open();
                if (word.length() == 0) {
                    inputType.setText("");
                    inputDefinition.setText("");
                    Toast.makeText(getActivity(), "No input given", Toast.LENGTH_SHORT).show();

                }
                else if(MainActivity.wordsList.indexOf(word)<0)
                {
                    inputType.setText("");
                    inputDefinition.setText("");
                    Toast.makeText(getActivity(), "Sorry word not found", Toast.LENGTH_SHORT).show();
                    wordoutput = "";
                    type = "";
                    definition = "";
                }
                else if(MainActivity.wordsList.indexOf(word)==0) {
                    try{
                        Cursor cursor = databaseAccess.findDetails(MainActivity.wordsList.get(MainActivity.wordsList.size()-1));
                        if(cursor!=null) {
                            wordoutput = cursor.getString(1);
                            type = cursor.getString(2);
                            definition = cursor.getString(3).replaceAll("Examples :- ", "\nExamples :- ");
                            inputWord.setText(wordoutput);
                            inputWord.dismissDropDown();
                            inputType.setText(type);
                            inputDefinition.setText(definition);
                            cursor.close();
                        }

                        else
                        {
                            inputType.setText("");
                            inputDefinition.setText("");
                            Toast.makeText(getActivity(), "Sorry word not found", Toast.LENGTH_SHORT).show();
                            wordoutput = "";
                            type = "";
                            definition = "";
                        }
                    }
                    catch(Exception e)
                    {
                        inputType.setText("");
                        inputDefinition.setText("");
                        Toast.makeText(getActivity(), "Sorry unable to find", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    try {
                        Cursor cursor = databaseAccess.findDetails(MainActivity.wordsList.get(MainActivity.wordsList.indexOf(word) - 1));
                        if (cursor != null) {
                            wordoutput = cursor.getString(1);
                            type = cursor.getString(2);
                            definition = cursor.getString(3).replaceAll("Examples :- ", "\nExamples :- ");
                            inputWord.setText(wordoutput);
                            inputWord.dismissDropDown();
                            inputType.setText(type);
                            inputDefinition.setText(definition);
                            cursor.close();
                        }
                    }
                    catch(Exception e)
                    {
                        inputType.setText("");
                        inputDefinition.setText("");
                        Toast.makeText(getActivity(), "Sorry unable to find", Toast.LENGTH_SHORT).show();
                    }

                }



                databaseAccess.close();
            }
        });
        nextBtn = (ImageButton) view.findViewById(R.id.next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word="";
                try{
                    word = containsIgnoreCase(inputWord.getText().toString(),MainActivity.wordsList);
                }
                catch(Exception ex)
                {

                }
                hideSoftKeyBoard();
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
                databaseAccess.open();
                if (word.length() == 0) {
                    inputType.setText("");
                    inputDefinition.setText("");
                    Toast.makeText(getActivity(), "No input given", Toast.LENGTH_SHORT).show();

                }
                else if(MainActivity.wordsList.indexOf(word)<0) {
                    inputType.setText("");
                    inputDefinition.setText("");
                    Toast.makeText(getActivity(), "Sorry word not found", Toast.LENGTH_SHORT).show();
                    wordoutput = "";
                    type = "";
                    definition = "";
                }
                else if(MainActivity.wordsList.indexOf(word)==MainActivity.wordsList.size()-1) {
                    Cursor cursor = databaseAccess.findDetails(MainActivity.wordsList.get(0));
                    wordoutput = cursor.getString(1);
                    type = cursor.getString(2);
                    definition = cursor.getString(3).replaceAll("Examples :- ","\nExamples :- ");
                    inputWord.setText(wordoutput);
                    inputWord.dismissDropDown();
                    inputType.setText(type);
                    inputDefinition.setText(definition);
                    cursor.close();
                }
                else {
                    Cursor cursor = databaseAccess.findDetails(MainActivity.wordsList.get(MainActivity.wordsList.indexOf(word)+1));
                    wordoutput = cursor.getString(1);
                    type = cursor.getString(2);
                    definition = cursor.getString(3).replaceAll("Examples :- ","\nExamples :- ");
                    inputWord.setText(wordoutput);
                    inputWord.dismissDropDown();
                    inputType.setText(type);
                    inputDefinition.setText(definition);
                    cursor.close();
                }

                databaseAccess.close();
            }
        });

    }

    private void hideSoftKeyBoard() {

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);

        if(imm.isAcceptingText()) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }

    public String containsIgnoreCase(String str, ArrayList<String> list){
        for(String i : list){
            if(i.equalsIgnoreCase(str))
                return i;
        }
        return str;
    }
}
