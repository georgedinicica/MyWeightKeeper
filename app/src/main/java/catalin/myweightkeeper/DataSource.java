package catalin.myweightkeeper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.inputmethodservice.Keyboard;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Catalin on 30/05/2017.
 */

public class DataSource {

    private MySQLiteHelper mySQLiteHelper;
    private SQLiteDatabase db;

    DataSource(Context context) {
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public void openDB() throws SQLException {
        db = mySQLiteHelper.getWritableDatabase();
    }

    public void closeDB() {
        db.close();
    }

    public boolean addPerson(Person p) {
        openDB();
        try {
            ContentValues values = new ContentValues();
            values.put(MySQLiteHelper.KeyPerson.KEY_NAME, p.getName());
            values.put(MySQLiteHelper.KeyPerson.KEY_AGE, p.getAge());
            values.put(MySQLiteHelper.KeyPerson.KEY_WEIGHT, p.getWeight());
            db.insert(MySQLiteHelper.KeyPerson.TABLE_PEOPLE, null, values);}
        catch (SQLiteException e) {
        Log.d(getClass().getSimpleName(),e.toString());
        return false;
        }
        finally {
            closeDB();
        }
        return true;
    }
    public Cursor getCursor(){
        openDB();
        Cursor cursor = db.query(MySQLiteHelper.KeyPerson.TABLE_PEOPLE, null, null, null, null, null, null);
        //cursor.close();
        //closeDB();


        return cursor;
    }
    public List<Person> getAllPeople() {
        List<Person> personList = new ArrayList<Person>();
        // Select All Query
//        String selectQuery = "SELECT  * FROM " + MySQLiteHelper.KeyPerson.TABLE_PEOPLE;
        openDB();
        Cursor cursor = db.query(MySQLiteHelper.KeyPerson.TABLE_PEOPLE, null, null, null, null, null, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setID(Integer.parseInt(cursor.getString(0)));
                person.setName(cursor.getString(1));
                person.setAge(cursor.getInt(2));
                person.setWeight(cursor.getFloat(3));
                // Adding contact to list
                personList.add(person);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return personList;
    }
}


