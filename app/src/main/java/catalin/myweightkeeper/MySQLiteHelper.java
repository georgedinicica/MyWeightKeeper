package catalin.myweightkeeper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Catalin on 29/05/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public final String TAG = "catalin.weightkeeper";

    private final static String DATABASE_NAME = "peopleWeight"; //peopleweight.sqlHelperDb ??
    private final static int DATABASE_VERSION = 1;
    private String CREATE_PEOPLE_TABLE = "CREATE TABLE " + KeyPerson.TABLE_PEOPLE + "( " +
            KeyPerson.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KeyPerson.KEY_NAME + " TEXT," +
            KeyPerson.KEY_AGE + " INTEGER, " +
            KeyPerson.KEY_WEIGHT + " REAL " + ")";
    private String UPGRADE_PEOPLE_TABLE = "DROP TABLE IF EXISTS " + KeyPerson.TABLE_PEOPLE;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PEOPLE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UPGRADE_PEOPLE_TABLE);
    }

    final static class KeyPerson implements BaseColumns {


        final static String TABLE_PEOPLE = "people";
        static final String KEY_ID = BaseColumns._ID;
        static final String KEY_NAME = "name";
        static final String KEY_AGE = "age";
        static final String KEY_WEIGHT = "weight";
    }

}
