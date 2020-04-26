package project.nriit.ped;


import android.database.Cursor;
import android.os.Bundle;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static android.content.Context.INPUT_METHOD_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {

    AutoCompleteTextView inputWord;
    Button deleteBtn;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setActionBarTitle("Delete");
        return inflater.inflate(R.layout.fragment_delete, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        inputWord = (AutoCompleteTextView) view.findViewById(R.id.dinputWord);
        inputWord.setAdapter(MainActivity.adapter);

        inputWord.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                String selected = (String) arg0.getAdapter().getItem(arg2);

            }
        });
        deleteBtn = (Button) view.findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word="";
                try{
                    word = containsIgnoreCase(inputWord.getText().toString(),MainActivity.wordsList);

                hideSoftKeyBoard();
                if (word.length() == 0) {
                    Toast.makeText(getActivity(), "No input given", Toast.LENGTH_SHORT).show();

                }
                else if (MainActivity.wordsList.indexOf(word) < 0) {
                    Toast.makeText(getActivity(), "Word doesn't exist", Toast.LENGTH_SHORT).show();

                }
                else {

                        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
                        databaseAccess.open();

                            boolean rs = databaseAccess.deleteDetails(word);
                                if (rs){
                                    MainActivity.wordsList.remove(word);
                                    Collections.sort(MainActivity.wordsList);
                                    MainActivity.adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, MainActivity.wordsList);
                                    inputWord.setAdapter(MainActivity.adapter);
                                    Toast.makeText(getActivity(), "Successfully deleted", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getActivity(), "Unable to delete", Toast.LENGTH_SHORT).show();
                                }



                        databaseAccess.close();

                }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
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
