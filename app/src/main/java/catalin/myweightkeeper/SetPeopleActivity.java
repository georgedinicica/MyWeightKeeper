package catalin.myweightkeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.delay;

public class SetPeopleActivity extends AppCompatActivity {
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.age)
    EditText age;
    @BindView(R.id.weight)
    EditText weight;
    @BindView(R.id.saveBtn)
    Button saveButton;
    DataSource dataSource;

    public SetPeopleActivity() {
        dataSource = new DataSource(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_people);
        ButterKnife.bind(this);
        Toast.makeText(this, "whooo", Toast.LENGTH_LONG).show();


    }

    public void addPerson(View view) {
        Toast.makeText(this, "whooo", Toast.LENGTH_LONG).show();
//TODO: implement functionality for adding saving a new person
        try {
//            MySQLiteHelper sqlHelperDb = new MySQLiteHelper(this);
//TODO: if no text is input save button should be disabled
            dataSource.openDB();

            Person p = new Person();
            p.setName(name.getText().toString());
            p.setAge(Integer.parseInt(age.getText().toString()));
            p.setWeight(Float.parseFloat(weight.getText().toString()));


            clearEditText();
            if (dataSource.addPerson(p)) {
                dataSource.addPerson(p);
                dataSource.closeDB();
                p.logAPerson(p);
                //finish();
            }
        } finally {
            finish();
        }

//        sqlHelperDb.getPerson()
    }

    private void clearEditText() {
        name.setText("");
        age.setText("");
        weight.setText("");
        name.setFocusable(true);
    }

    public void logPeople(View view) {

        Toast.makeText(this, "not implemented", Toast.LENGTH_SHORT).show();
    }
}
