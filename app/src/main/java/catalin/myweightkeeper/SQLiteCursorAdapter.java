package catalin.myweightkeeper;

import android.content.Context;
import android.database.Cursor;
import android.inputmethodservice.Keyboard;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by Catalin on 29/05/2017.
 */

public class SQLiteCursorAdapter extends CursorAdapter {

//    @BindView(R.id.myId)
//    TextView itemId;
//    @BindView(R.id.myName)
//    TextView itemName;
//    @BindView(R.id.myAge)
//    TextView itemAge;
//    @BindView(R.id.myWeight)TextView itemWeight;
//TODO: these vars ar not accurate**/
    public SQLiteCursorAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_show, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView itemId=(TextView) view.findViewById(R.id.myId);
//        cursor.moveToLast();
        itemId.setText(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.KeyPerson.KEY_ID)));
        TextView itemName=(TextView) view.findViewById(R.id.myName);
            itemName.setText(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.KeyPerson.KEY_NAME)));
        TextView itemAge=(TextView) view.findViewById(R.id.myAge);
        itemAge.setText(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.KeyPerson.KEY_AGE)));
        TextView itemWeight=(TextView) view.findViewById(R.id.myWeight);
        itemWeight.setText(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.KeyPerson.KEY_WEIGHT)));

//        itemId.setText("a");
//
//        itemName.setText("name");
//
//        itemAge.setText(("age"));
//
//        itemWeight.setText(("weight"));
    }
}
