package sg.edu.rp.c346.myholidaylistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView tvHT;
    ArrayList<Holiday> holidays;
    ArrayList<Holiday>holidaysReligion;
    ArrayAdapter aa;
    ListView lvHoliday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvHT = (TextView)findViewById(R.id.tvHT);
        lvHoliday = (ListView)findViewById(R.id.lvHoliday);

        Intent i = getIntent();
        String holidayTitle = i.getStringExtra("title");
        tvHT.setText(holidayTitle);

        holidays = new ArrayList<Holiday>();

        if(holidayTitle.equals("Secular")){
            holidays.add(new Holiday("New Year's Day","1 Jan 2017"));
            holidays.add(new Holiday("Labour Day","1 May 2017"));
        }
        else{
            holidays.add(new Holiday("Chinese New Year","28-29 Jan 2017"));
            holidays.add(new Holiday(" Good Friday","14 April 2017"));
        }
        aa = new HolidayAdapter(this,R.layout.row,holidays);
        lvHoliday.setAdapter(aa);

        lvHoliday.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedDetail = holidays.get(position);


                Toast.makeText(SecondActivity.this, selectedDetail.getName()+ " Date: " + selectedDetail.getDate(),
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
