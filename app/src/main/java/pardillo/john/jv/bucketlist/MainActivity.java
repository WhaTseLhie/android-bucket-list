package pardillo.john.jv.bucketlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("Go to Disneyland");
        list.add("Go fly-boarding");
        list.add("Go kite-boarding");
        list.add("Go Jet-Skiing");
        list.add("Go bungee jumping");
        list.add("Walk the Great Wall of China");

        this.lv = this.findViewById(R.id.listView);
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        this.lv.setAdapter(adapter);
        this.lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selected Item");
        builder.setMessage("Idea: " +list.get(position));
        builder.setNeutralButton("Ok", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}