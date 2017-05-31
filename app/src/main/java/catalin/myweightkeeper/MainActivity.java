package catalin.myweightkeeper;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//why I cannot use butterknife for other resourcesfile
public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";
//    @BindView(R.id.myId)
//    TextView myId;
//    @BindView(R.id.myName)
//    TextView myName;
//    @BindView(R.id.myAge)
//    TextView myAge;
//    @BindView(R.id.myWeight)
//    TextView myWeight;
//TODO: the name should be saved as a preference

    @BindView(R.id.mainListView)
    ListView mainListView;

    DataSource dataSource;
    Cursor cursor;
    SQLiteDatabase db;
    List<Person> personList;
    List<String> actualList = new ArrayList<>();
    String testString[] = {"ala", "bala", "portocala"};
//TODO: for somereason every object is added 2 times. This is wrong

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dataSource = new DataSource(this);
        personList = dataSource.getAllPeople();
        cursor=dataSource.getCursor();

        if (cursor.moveToFirst()) {
//TODO: how do I set the realtime update after adding a new Item*/

            SQLiteCursorAdapter listAdapter = new SQLiteCursorAdapter(this, cursor);

            mainListView.setAdapter(listAdapter);
        }
//        MyAdapter adapter = new MyAdapter(this, android.R.layout.simple_list_item_1, testString);
//        mainListView.setAdapter(adapter);
//         startActivity(new Intent(this,TestTempActivity.class));
//TODO: implement the listView to show something first
        defaultAddings();
    }

    private class MyAdapter extends ArrayAdapter {
        public MyAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Object[] objects) {
            super(context, resource, objects);
        }

        public MyAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;

            //  LayoutInflater.from(getContext()).inflate(R.layout.item_show,null);
            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                v = vi.inflate(R.layout.item_show, null);
            }



            return v;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        cursor=dataSource.getCursor();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void newActivityLaunch() {

        Intent intent = new Intent(this, SetPeopleActivity.class);
        startActivity(intent);
    }

    private void defaultAddings() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newActivityLaunch();
                Snackbar.make(view, "size", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


}
