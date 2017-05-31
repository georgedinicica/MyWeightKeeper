package catalin.myweightkeeper;

import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestTempActivity extends AppCompatActivity {
    String[] blaLow = {"bla1", "bla2", "bla3"};
    // int[] bla=new{1,2,3};
    // @BindView(R.id.testTextView)TextView textView;
    @BindView(R.id.listTemp)
    ListView listView;

    SQLiteDatabase db;
    MySQLiteHelper helper;
    String testString[] = {"ala", "bala", "portocala"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_temp);
        ButterKnife.bind(this);

        MyAdapter adapter = new MyAdapter(this, android.R.layout.simple_list_item_1, testString);
        listView.setAdapter(adapter);

    }

    void insertMyPerson() {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KeyPerson.KEY_NAME, "cata");
        values.put(MySQLiteHelper.KeyPerson.KEY_AGE, 13);
        values.put(MySQLiteHelper.KeyPerson.KEY_WEIGHT, 90f);

        long myId = db.insert(MySQLiteHelper.KeyPerson.TABLE_PEOPLE, null, values);


    }

    private class MyAdapter extends ArrayAdapter {
        public MyAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Object[] objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.item_show, null);
            }

            return v;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void toastMe(View view) {
//        CheckedTextView check= (CheckedTextView) listView.getItemAtPosition(listView.getSelectedItemPosition());
//        check.setChecked(!check.isChecked());

    }
}
