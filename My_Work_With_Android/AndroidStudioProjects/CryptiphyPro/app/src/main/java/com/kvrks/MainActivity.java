package com.kvrks;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public TextView mTextMessage;
    public EditText input,password;
    public Button Convert,ConvertBack;
    public android.support.design.widget.TextInputLayout password_text_input_layout;
    public android.support.design.widget.TextInputLayout user_text_input_layout;

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case com.kvrks.R.id.navigation_home:
                    mTextMessage.setText(" you can use encryption for any number of times with multiple passwords but use those passwords in reverse order when you decrypt like password1,password2,password3 for encryption then use password3,password2,password1 for decryption");
                    input.setEnabled(false);
                    password.setEnabled(false);
                    Convert.setEnabled(false);
                    ConvertBack.setEnabled(false);
                    password_text_input_layout.setVisibility(View.INVISIBLE);
                    user_text_input_layout.setVisibility(View.INVISIBLE);
                    Convert.setVisibility(View.INVISIBLE);
                    ConvertBack.setVisibility(View.INVISIBLE);

                    return true;
                case com.kvrks.R.id.navigation_dashboard:
                    mTextMessage.setText(com.kvrks.R.string.title_ptoc);
                    input.setEnabled(true);
                    input.setHint("            Plain Text");
                    password.setEnabled(true);
                    Convert.setEnabled(true);
                    ConvertBack.setEnabled(false);
                    user_text_input_layout.setVisibility(View.VISIBLE);
                    input.setText("");
                    password_text_input_layout.setVisibility(View.VISIBLE);
                    password.setText("");
                    input.setVisibility(View.VISIBLE);
                    password.setVisibility(View.VISIBLE);
                    Convert.setVisibility(View.VISIBLE);
                    ConvertBack.setVisibility(View.INVISIBLE);
                    return true;
                case com.kvrks.R.id.navigation_notifications:
                    mTextMessage.setText(com.kvrks.R.string.ctop);
                    input.setEnabled(true);
                    input.setHint("            Cipher / Encrypted Text");
                    password.setEnabled(true);
                    Convert.setEnabled(false);
                    ConvertBack.setEnabled(true);
                    input.setText("");
                    password_text_input_layout.setVisibility(View.VISIBLE);
                    user_text_input_layout.setVisibility(View.VISIBLE);
                    password.setText("");
                    input.setVisibility(View.VISIBLE);
                    password.setVisibility(View.VISIBLE);
                    Convert.setVisibility(View.VISIBLE);
                    ConvertBack.setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.kvrks.R.layout.activity_main);

        mTextMessage = (TextView) findViewById(com.kvrks.R.id.message);
        input = (EditText) findViewById(com.kvrks.R.id.input);
        password = (EditText) findViewById(com.kvrks.R.id.password);
        Convert = (Button) findViewById(com.kvrks.R.id.Convert);
        password_text_input_layout = (android.support.design.widget.TextInputLayout) findViewById(com.kvrks.R.id.password_text_input_layout);
        user_text_input_layout = (android.support.design.widget.TextInputLayout) findViewById(com.kvrks.R.id.user_text_input_layout);

        Convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (input.getText().length() > 0 && password.getText().length() > 0)
                    try {
                        char[] inputMessage = input.getText().toString().toCharArray();
                        char[] givenPassword = password.getText().toString().toCharArray();
                        char[] output;
                        KrisTryEncrypt obj = new KrisTryEncrypt();
                        output = obj.Encrypt(givenPassword, inputMessage);
                        input.setText(String.valueOf(output));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

        });
        ConvertBack = (Button) findViewById(com.kvrks.R.id.ConvertBack);
        ConvertBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(input.getText().length()>0&&password.getText().length()>0) {
                    try {
                        char[] inputMessage = input.getText().toString().toCharArray();
                        char[] givenPassword = password.getText().toString().toCharArray();
                        char[] output;
                        KrisTryDecrypt obj = new KrisTryDecrypt();
                        output = obj.Decrypt(givenPassword, inputMessage);
                        input.setText(String.valueOf(output));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        input.setEnabled(false);
        password.setEnabled(false);
        Convert.setEnabled(false);
        input.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        Convert.setVisibility(View.INVISIBLE);
        ConvertBack.setVisibility(View.INVISIBLE);
        password_text_input_layout.setVisibility(View.INVISIBLE);
        user_text_input_layout.setVisibility(View.INVISIBLE);
        mTextMessage.setText("This application is developed by KAMBHAMPATI V R KRISHNA SASTRY , you can use this application for encrypting and decrypting your messages by using below buttons to navigate and perform required tasks");
        BottomNavigationView navigation = (BottomNavigationView) findViewById(com.kvrks.R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }



}
