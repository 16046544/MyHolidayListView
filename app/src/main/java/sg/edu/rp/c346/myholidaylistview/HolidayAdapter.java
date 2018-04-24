package sg.edu.rp.c346.myholidaylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {


    private ArrayList<Holiday> holidays;
    private Context context;
    private ImageView ivHoliday;
    private TextView tvHoliday;
    private TextView tvDate;

    //added pasta-==============================
    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvHoliday = (TextView) rowView.findViewById(R.id.tvHoliday);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivHoliday = (ImageView) rowView.findViewById(R.id.ivHoliday);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = holidays.get(position);
        // Set the TextView to show the food

        tvHoliday.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
        // Set the image to star or nostar accordingly
        if(currentHoliday.getName().equalsIgnoreCase("New Year's Day")) {
            tvDate.setText(currentHoliday.getDate());
            ivHoliday.setImageResource(R.drawable.newyear);
        }
        else if(currentHoliday.getName().equalsIgnoreCase("Labour Day")) {
            tvDate.setText(currentHoliday.getDate());
            ivHoliday.setImageResource(R.drawable.labourday);
        }
        else if(currentHoliday.getName().equalsIgnoreCase("Chinese New Year")) {
            tvDate.setText(currentHoliday.getDate());
            ivHoliday.setImageResource(R.drawable.cny);
        }
        else{
            tvDate.setText(currentHoliday.getDate());
            ivHoliday.setImageResource(R.drawable.goodfriday);
        }
        // Return the nicely done up View to the ListView
        return rowView;

    }

}
