package com.example.forminput;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText name, age, date, time;
    RadioGroup rg;
    RatingBar ratingBar;
    SeekBar seekBar;
    CheckBox veg,nv;
    Spinner spinner;
    String[] branch = {"Chennai","Cuddalore","Coimbatore","Trichy"};
    String getOverallRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        rg = findViewById(R.id.rg);
        ratingBar = findViewById(R.id.rating);
        seekBar = findViewById(R.id.seekbar);
        veg = findViewById(R.id.veg);
        nv = findViewById(R.id.nv);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,branch);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance ();
                int mYear = calendar.get ( Calendar.YEAR );
                int mMonth = calendar.get ( Calendar.MONTH );
                int mDay = calendar.get ( Calendar.DAY_OF_MONTH );

                DatePickerDialog datePickerDialog = new DatePickerDialog ( MainActivity.this, new DatePickerDialog.OnDateSetListener () {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText ( dayOfMonth + "/" + (month + 1) + "/" + year );
                    }
                }, mYear, mMonth, mDay );
                datePickerDialog.show ();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                getOverallRating = String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance ();
                int mHour = calendar.get ( Calendar.HOUR );
                int mMinute = calendar.get ( Calendar.MINUTE );
                final TimePickerDialog timePickerDialog = new TimePickerDialog ( MainActivity.this, new TimePickerDialog.OnTimeSetListener () {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                      String AM_PM;
                      if (hourOfDay>=0&&hourOfDay<12){
                          AM_PM=" AM";
                      }else {
                          hourOfDay-=12;
                          AM_PM=" PM";
                      }
                      time.setText ( hourOfDay + ":" + minute+""+AM_PM );
                    }
                }, mHour, mMinute, false );

                timePickerDialog.show ();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                String msg = "\nName : "+name.getText().toString()+"\n"+"Age : "+age.getText().toString()+"\n"+"Gender : "+getGender()+"\n"
                        +"Visited Date : "+date.getText().toString()+"\n"+"Visited Time : "+time.getText().toString()+"\n"+"Branch : "+spinner.getSelectedItem().toString()+"\n"
                        +"Rating : "+ ratingBar.getRating() +" out of 5.0\n"+"Ordered : "+getOrder()+"\n"+"Overall Rating : "+getOverallRating+" out of 100\n";

                Log.i("msg", msg);
            }
        });


    }

    private String getOrder() {
        String result="";
        if(nv.isChecked() && veg.isChecked()){
            result = result+"Veg & Non-veg";
        }
        else if(nv.isChecked()){
            result = result+"Non-veg";
        }
        else if(veg.isChecked()){
            result = result+"Veg";
        }
        return result;

    }


    private String getGender() {
        int i = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(i);
        return rb.getText().toString();
    }

}