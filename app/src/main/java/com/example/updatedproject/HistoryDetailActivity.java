package com.example.updatedproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HistoryDetailActivity extends AppCompatActivity {
TextView textinput_id,textinput_name,textinput_number,textinput_route,textinput_date_time;
String id,name,number,start,end,date,time;
Button sharebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
      //  textinput_id = findViewById(R.id.lahd_busid);
        textinput_name = findViewById(R.id.lahd_busname);
        textinput_number = findViewById(R.id.lahd_busnumber);
        textinput_route =findViewById(R.id.lahd_route);
        textinput_date_time =findViewById(R.id.lahd_date_time);
        sharebutton = findViewById(R.id.lahd_share);
        getandsetIntentData();
    }
    void getandsetIntentData(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("number") && getIntent().hasExtra("start") && getIntent().hasExtra("end") && getIntent().hasExtra("date") && getIntent().hasExtra("time")){
           // id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            number = getIntent().getStringExtra("number");
            start = getIntent().getStringExtra("start");
            end = getIntent().getStringExtra("end");
            date = getIntent().getStringExtra("date");
            time = getIntent().getStringExtra("time");
            String route = start + "\t-\t" +end;
            String data_time= date +"\t-\t"+time;
           // textinput_id.setText(id);
            textinput_name.setText(name);
            textinput_number.setText(number);
            textinput_route.setText(route);
            textinput_date_time.setText(data_time);
        }
        else
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();

        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");

                String sendmsg = "Bus Name: "+ name +"\nBus Number: "+ number + "\nBus Route: \n" + start + " - " +end+"\n\nDate & Time: \n"+ date + " - " +time;
                intent1.putExtra(Intent.EXTRA_TEXT, sendmsg);
                startActivity(intent1);
            }
        });
    }

}
