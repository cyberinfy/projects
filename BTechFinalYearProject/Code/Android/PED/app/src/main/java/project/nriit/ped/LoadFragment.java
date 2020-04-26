package project.nriit.ped;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.nbsp.materialfilepicker.MaterialFilePicker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static android.support.v4.content.PermissionChecker.checkSelfPermission;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoadFragment extends Fragment {
    String[] values;
    int total=0,completed=0,remaining=0,newlyadded=0,existing=0,percentage=0;
    pl.droidsonroids.gif.GifImageView imageView;
    static EditText inputFilePath;
    TextView percent;
    ListView list;
Button browseBtn,loadBtn;
    private Thread dbTaskThread;

    public LoadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity)getActivity()).setActionBarTitle("Load");
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.M && checkSelfPermission(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1001);
        }
        return inflater.inflate(R.layout.fragment_load, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        hideSoftKeyBoard();
        percent = (TextView)view.findViewById(R.id.percent);
        list = (ListView) view.findViewById(R.id.listView);
        imageView = (pl.droidsonroids.gif.GifImageView)view.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.white);
        percent.setText("");
        String[] values = new String[] { "Words-Details","Total: ","Completed: ","Remaining: ","Newly added: ","Already existing: " };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
//        list.setAdapter(adapter);
        inputFilePath = (EditText) view.findViewById(R.id.inputPath);
        browseBtn = (Button) view.findViewById(R.id.browseBtn);
        loadBtn = (Button) view.findViewById(R.id.loadBtn);
        browseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new MaterialFilePicker()
                        .withActivity((MainActivity)getActivity())
                        .withRequestCode(1000)
                        .withFilter(Pattern.compile(".*\\.txt$"))
                        .withHiddenFiles(true) // Show hidden files and folders
                        .start();


            }
        });
        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hideSoftKeyBoard();
                if (inputFilePath.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "No input given", Toast.LENGTH_SHORT).show();

                }
                else{


                loadBtn.setEnabled(false);
                browseBtn.setEnabled(false);
                total = completed = remaining = newlyadded = existing = percentage = 0;
                imageView.setImageResource(R.drawable.loading);
                try {
                    total = numberOfLinesInAFile();
                    Toast.makeText(getActivity(), "Please wait for the loading to complete!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(getActivity(), "unable to load", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                percent.setText(percentage + "%");
                dbTaskThread = new Thread() {
                    @Override
                    public void run() {
                        try {

                            synchronized (this) {
                                addToDB();
                                wait(1);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            final String[] values = new String[]{};
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageResource(R.drawable.white);
                                    percent.setText("");

                                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                                            android.R.layout.simple_list_item_1, values);
                                    list.setAdapter(adapter);
                                    Toast.makeText(getActivity(), "unable to load", Toast.LENGTH_SHORT).show();

                                }
                            });
                        }


                    }
                };
                dbTaskThread.start();
            }
            }

        });
    }

    public boolean addToDB() {

        FileInputStream fis = null;
        BufferedReader reader = null;

        ResultSet n = null;
        try {
            String fileloc = inputFilePath.getText().toString();
            fis = new FileInputStream(fileloc);
            reader = new BufferedReader(new InputStreamReader(fis));
            String line = new String(reader.readLine());
            remaining = total;
           while (line != null) {
                if(line.length()==0) continue;
                    DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
                    databaseAccess.open();
                    String[] details = (line.substring(1,line.length()-3)+" ").split("\",\"");
//                    Cursor cursor = databaseAccess.findDetails(details[0]);

                    if(MainActivity.wordsList.indexOf(containsIgnoreCase(details[0],MainActivity.wordsList))>=0)
                    {
                      existing+=1;
                        databaseAccess.close();
                    }

                    else
                    {
                        databaseAccess = DatabaseAccess.getInstance(getContext());
                        databaseAccess.open();
                        if(line.substring(line.length()-4,line.length()-3).equals("\""))
                            details = (line.substring(1,line.length()-3)+" ").split("\",\"");
                        else
                        details = line.substring(1,line.length()-3).split("\",\"");
                        if(details.length<3)
                            details[2] = "";
                        System.out.println(details[0]);
                        boolean op = databaseAccess.insertDetails(details[0],details[1],details[2].replaceAll("\\|","\n"));
                        databaseAccess.close();


                        if(op) {
                            MainActivity.wordsList.add(details[0]);
                            Collections.sort(MainActivity.wordsList);
                            newlyadded += 1;
                            System.out.println(details[0]);
                            }
                    }
                completed+=1;
                remaining-=1;
                percentage = (completed*100/total);
                values = new String[] { "Words-Details","Total: "+total,"Newly added: "+newlyadded,"Already existing: "+existing };
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(getActivity()!=null) {
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                                    android.R.layout.simple_list_item_1, values);
                            list.setAdapter(adapter);
                            percent.setText(percentage + "%");

                            if (percentage == 100) {

                                loadBtn.setEnabled(true);
                                browseBtn.setEnabled(true);
                                imageView.setImageResource(R.drawable.white);
                                percent.setText("");
                                Toast.makeText(getActivity(), "Successfully loaded", Toast.LENGTH_SHORT).show();


                            }

                        }
                    }
                });
               if (percentage == 100) {
                   return true;
               }
                line = new String(reader.readLine());
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            if (getActivity()!=null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                                android.R.layout.simple_list_item_1, values);
                        list.setAdapter(adapter);

                        Toast.makeText(getActivity(), "unable to load", Toast.LENGTH_SHORT).show();

                        imageView.setImageResource(R.drawable.white);
                        percent.setText("");

                        loadBtn.setEnabled(true);
                        browseBtn.setEnabled(true);

                    }});
            return false;
            }
        }
        if(getActivity()!=null) {
            loadBtn.setEnabled(true);
            browseBtn.setEnabled(true);
        }
        return true;


    }


    @Override

    public void onRequestPermissionsResult(int requestCode,

                                           @NonNull String permissions[], @NonNull int[] grantResults) {

        switch (requestCode) {

            case 1001: {

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(),"Permission granted!",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(),"permission denied!",Toast.LENGTH_SHORT).show();

                }

            }

        }

    }


    public int numberOfLinesInAFile() throws IOException
    {
        int number = 0;
        FileInputStream fis =  new FileInputStream(new File(inputFilePath.getText().toString()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line = new String(reader.readLine());
        while(line!=null)
        {
            if(line.length()>0)
                number = number+1;
            try {
                line = new String(reader.readLine());
            }
            catch(Exception e)
            {
                line = null;
            }

        }
        return number;
    }

    private void hideSoftKeyBoard() {

        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);

        if(imm.isAcceptingText()) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
    public String containsIgnoreCase(String str, ArrayList<String> list){
        for(String i : list){
            if(i.equalsIgnoreCase(str))
                return i;
        }
        return str;
    }
}
