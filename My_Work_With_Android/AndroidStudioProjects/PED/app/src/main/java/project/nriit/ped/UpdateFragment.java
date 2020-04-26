package project.nriit.ped;


import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.content.Context.INPUT_METHOD_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    String wordoutput,type,definition;
    AutoCompleteTextView inputWord;
    Button findBtn,updateBtn;
    EditText inputType,inputDefinition;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setActionBarTitle("Update");
        return inflater.inflate(R.layout.fragment_update, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        inputWord = (AutoCompleteTextView) view.findViewById(R.id.uinputWord);
        inputType = (EditText) view.findViewById(R.id.utype);
        inputDefinition = (EditText) view.findViewById(R.id.udefinition);
        inputWord.setAdapter(MainActivity.adapter);

        inputWord.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                String selected = (String) arg0.getAdapter().getItem(arg2);

            }
        });
        findBtn = (Button) view.findViewById(R.id.ufindBtn);
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
        updateBtn = (Button) view.findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word="";
                try{
                    word = containsIgnoreCase(inputWord.getText().toString(),MainActivity.wordsList);
                }
                catch(Exception ex)
                {

                }
                if (word.length() == 0) {
                    Toast.makeText(getActivity(), "No input given", Toast.LENGTH_SHORT).show();

                }
                else if (MainActivity.wordsList.indexOf(word) < 0) {
                    Toast.makeText(getActivity(), "Word doesn't exist", Toast.LENGTH_SHORT).show();
                }
                else{

                        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
                        databaseAccess.open();
                        boolean op = databaseAccess.updateDetails(word, word, inputType.getText().toString(), inputDefinition.getText().toString());
                        databaseAccess.close();
                        if (op) {
                            Toast.makeText(getActivity(), "Successfully updated", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Unable to update", Toast.LENGTH_SHORT).show();
                        }
                        databaseAccess.close();

                }
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
