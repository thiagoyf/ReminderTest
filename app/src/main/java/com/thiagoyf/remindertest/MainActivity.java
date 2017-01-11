package com.thiagoyf.remindertest;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import utils.DateTimeFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtDate, edtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtDate = (EditText) findViewById(R.id.activity_main_edtDate);
        edtTime = (EditText) findViewById(R.id.activity_main_edtTime);
    }

    public void chooseDate(View view) {
        Calendar calendar = Calendar.getInstance();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog
                .OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year,
                                  int month, int day) {

                try {
                    edtDate.setText(DateTimeFormat.dateFormat(year, month + 1, day, DateTimeFormat
                            .LITTLE_ENDIAN, "/"));
                } catch (Exception e) {
                    Log.d("DateTimeFormat", e.getMessage());
                    e.printStackTrace();
                }

            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
        edtDate.setError(null);
    }

    public void chooseTime(View view){
        Calendar calendar = Calendar.getInstance();
        int mHour = calendar.get(Calendar.HOUR_OF_DAY);
        int mMinute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener(){

            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                edtTime.setText(DateTimeFormat.timeFormat(hour, minute));
            }
        }, mHour, mMinute, true);
        timePickerDialog.show();
        edtTime.setError(null);
    }
}
