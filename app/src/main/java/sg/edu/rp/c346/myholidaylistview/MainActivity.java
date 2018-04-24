package sg.edu.rp.c346.myholidaylistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvHoliday;
    ArrayList<String> arrayListHoliday;
    ArrayAdapter<String> arrayAdapterHoliday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvHoliday = (ListView) findViewById(R.id.lvHoliday);

        arrayListHoliday = new ArrayList<String>();
        arrayListHoliday.add("Secular");
        arrayListHoliday.add("Ethnic and Religion");

        arrayAdapterHoliday = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayListHoliday);

        lvHoliday.setAdapter(arrayAdapterHoliday);


        lvHoliday.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String title = arrayListHoliday.get(position);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }
}
