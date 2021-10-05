package com.example.updatedproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.updatedproject.Fragments.HistoryFragment;
import com.example.updatedproject.Fragments.ScanFragment;
import com.google.zxing.Result;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CameraOpens extends AppCompatActivity implements ZXingScannerView.ResultHandler {
ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result) {
        ScanFragment.textView.setText(result.getText());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Calendar c = Calendar.getInstance();
        String date = sdf.format(c.getTime());

        SimpleDateFormat stime = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String time = stime.format(c.getTime());


        ScanFragment.savedate = date;
        ScanFragment.saveTime = time;

        HistoryFragment.savedate=date;
        HistoryFragment.savetime=time;

        HistoryFragment.tempResult=result.getText();
        ScanFragment.tempResult = result.getText();


        onBackPressed();

    }
    @Override
    public void onResume(){
    super.onResume();
    scannerView.setResultHandler(this);
    scannerView.startCamera();
    }
    @Override
    public void onPause(){
        super.onPause();
        scannerView.stopCamera();

    }
}
