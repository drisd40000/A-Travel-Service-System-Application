package com.example.updatedproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShareActivity extends AppCompatActivity {
public TextView textView1,textView2,textView3,textView4;
public TextView normalText1,normalText2,normalText3,normalText4,normalText5;
public String message11,message12,message13,message14,message4,message5;
public Button sharebutton;
public BusDetails busDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        normalText1 = findViewById(R.id.las_normalText1);
        normalText2 = findViewById(R.id.las_normalText2);
        normalText3 = findViewById(R.id.las_normalText3);
        normalText4 = findViewById(R.id.las_normalText4);
        normalText5 = findViewById(R.id.las_normalText5);

        textView1 = findViewById(R.id.las_text1);
        textView2 =findViewById(R.id.las_text2);
        textView3 = findViewById(R.id.las_text3);
        textView4 = findViewById(R.id.las_text4);
        sharebutton =findViewById(R.id.las_sharebutton);

        final Intent intent = getIntent();
        final String message1 = intent.getStringExtra("ScanResult");
        final String message2 = intent.getStringExtra("ScanDate");
        final String message3 = intent.getStringExtra("ScanTime");

       if(message1!=null) {
            busDetails = new BusDetails(message1);
            busDetails.splitBusDetails(message1);

            String message11 = busDetails.getBd_busname();
            String message12 = busDetails.getBd_busnumber();
            String message13 = busDetails.getBd_busstart();
            String message14 = busDetails.getBd_busend();
            String message4 = message13+"\t - \t"+message14;

             String message5 = message2 + "\t - \t" + message3;

           textView1.setText(message11);
            textView2.setText(message12);
            textView3.setText(message4);
            textView4.setText(message5);}

        if(message1==null){
            Toast.makeText(this,"nothing to show",Toast.LENGTH_LONG).show();

        }
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");

                  /* if(message1!=null){ busDetails = new BusDetails(message1);
                    busDetails.splitBusDetails(message1);}*/


                    String message11 = busDetails.getBd_busname();
                    String message12 = busDetails.getBd_busnumber();
                    String message13 = busDetails.getBd_busstart();
                    String message14 = busDetails.getBd_busend();
                    String message = "Bus Name : "+ message11 + "\n"+"Bus Number : " + message12 + "\n"+ "Bus Route : \n"+message13 +
                                      "\t - \t" + message14 + "\n\nDate and Time : \n"+ message2 +"\t"+message3;

                    intent1.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(intent1);



            }

        });
    }
}
