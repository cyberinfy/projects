package project.nriit.ped;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by kvrks on 31-12-2017.
 */

public class SplashActivity extends AppCompatActivity {
    private Thread mSplashThread;
    static ArrayList<String> wordsList;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(SplashActivity.this);
                        databaseAccess.open();
                        wordsList = new ArrayList<String>();
                        Cursor cursor = databaseAccess.getAll();
                        while (!cursor.isAfterLast()) {
                        wordsList.add(cursor.getString(0));
                        cursor.moveToNext();

                        }
                        cursor.close();
                        databaseAccess.close();
                        wait(1);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        };
        mSplashThread.start();
    }
}