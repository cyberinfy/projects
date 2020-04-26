package project.nriit.ped;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of project.nriit.myapplication.DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }



    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }


    public Cursor getAll() {
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT LOWER(word) as l FROM DICTIONARY order by l", null);
        cursor.moveToFirst();
        return cursor;
    }

    public Cursor findDetails(int id){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DICTIONARY WHERE _id = "+(id)+";", null);
        cursor.moveToFirst();
        if(!cursor.isAfterLast()) {
            return cursor;
        }
        cursor.close();
        return null;
    }

    public Cursor findDetails(String word){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM DICTIONARY where LOWER(WORD)=\""+word.toLowerCase()+"\"", null);
        cursor.moveToFirst();
        if(!cursor.isAfterLast()) {
            return cursor;
        }
        return null;
    }

    public boolean insertDetails(String word,String type,String definition){
        ContentValues contentValues = new ContentValues();
        contentValues.put("word", word);
        contentValues.put("type", type);
        contentValues.put("definition", definition);
        database.insert("DICTIONARY", null, contentValues);
        return true;
    }

    public boolean insertRawDetails(String details)
    {
        String sql="INSERT INTO DICTIONARY (WORD,TYPE,DEFINITION) VALUES ("+details.toString();
        try {
            database.execSQL(sql, null);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public boolean updateDetails(String srcWord,String word,String type,String definition){
        ContentValues contentValues = new ContentValues();
        contentValues.put("word", word);
        contentValues.put("type", type);
        contentValues.put("definition", definition);
        database.update("DICTIONARY", contentValues, "LOWER(word) = ? ", new String[] { srcWord.toLowerCase() } );
        return true;
    }

    public boolean deleteDetails(String word){
        database.delete("DICTIONARY", "LOWER(word) = ? ", new String[] { word.toLowerCase()});
        return true;
    }



}