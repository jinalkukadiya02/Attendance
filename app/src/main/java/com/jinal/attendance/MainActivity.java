package com.jinal.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView tvDate,tvTime;
    Button btnPickDate,btnTime;
    RadioButton absent, present;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate = findViewById(R.id.Date);
        tvTime=findViewById(R.id.tvTime);
        btnTime=findViewById(R.id.btnPicktime);
        btnPickDate = findViewById(R.id.btnPickDate);
        rg = findViewById(R.id.gender);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                absent=findViewById(R.id.absent);
                present=findViewById(R.id.present);
                if (absent.isChecked()){
                    Toast.makeText(MainActivity.this,absent.getText().toString(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,present.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int myHour, int myMinute) {
                        String time = "Time:" + String.valueOf("0") + String.valueOf(myHour) + ":" + String.valueOf(myMinute) + String.valueOf("");
                        tvTime.setText(time);
                    }
                },hour, minute, false);
                timePicker.show();
            }
        });
        btnPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.jinal.attendance.DatePicker mDatePickerDialogFragment;
                mDatePickerDialogFragment = new com.jinal.attendance.DatePicker();
                mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
            }
        });
    }
    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        tvDate.setText(selectedDate);
    }
}

