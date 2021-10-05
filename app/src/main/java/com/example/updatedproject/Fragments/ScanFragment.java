package com.example.updatedproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.updatedproject.BusDetails;
import com.example.updatedproject.CameraOpens;
import com.example.updatedproject.HistoryDatabaseHelper;
import com.example.updatedproject.R;
import com.example.updatedproject.ShareActivity;

public class ScanFragment<tempResult> extends Fragment {

    public static TextView textView;
    public static String savedate;
    public static String saveTime;
    Button scanButton, shareButton;
    public static  String tempResult;
    public static String sharetempResult;
    BusDetails busDetails;
    ScanFragment scanFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle)
    {
        View view = inflater.inflate(R.layout.activity_scan_fragment, viewGroup, false);
       textView = view.findViewById(R.id.lasf_text2);
       scanButton = view.findViewById(R.id.lasf_scanbutton);
       shareButton = view.findViewById(R.id.lasf_sharebutton);

       scanButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), CameraOpens.class);
               startActivity(intent);
           }
       });


       shareButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), ShareActivity.class);
               intent.putExtra("ScanResult",sharetempResult);
               intent.putExtra("ScanDate",savedate);
               intent.putExtra("ScanTime",saveTime);
               startActivity(intent);
           }
       });


        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        if(tempResult!=null){
            saveDataToHistory();}
    }
    public void saveDataToHistory()
    {
        busDetails = new BusDetails(tempResult);
        busDetails.splitBusDetails(tempResult);

        String message11 = busDetails.getBd_busname();
        String message12 = busDetails.getBd_busnumber();
        String message13 = busDetails.getBd_busstart();
        String message14 = busDetails.getBd_busend();
        HistoryDatabaseHelper mydb = new HistoryDatabaseHelper(getContext());
        mydb.addHistory(message11,message12,message13,message14,savedate,saveTime);
        sharetempResult = tempResult;
        tempResult =null;}
}
