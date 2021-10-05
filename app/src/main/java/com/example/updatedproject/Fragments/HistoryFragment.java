package com.example.updatedproject.Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.updatedproject.AdapterFolder.HistoryAdapter;
import com.example.updatedproject.BusDetails;
import com.example.updatedproject.HistoryDatabaseHelper;
import com.example.updatedproject.R;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    public static String savedate;
    public static String savetime;
    public static String tempResult;
    RecyclerView recyclerView;
    HistoryDatabaseHelper mydb;
    HistoryAdapter historyAdapter;
    ArrayList<String>BusName,BusNo,bus_date,BusID,BusStart,BusEnd,BusTime;
    BusDetails busDetails;


   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
       View view = inflater.inflate(R.layout.activity_history_fragment,viewGroup,false);
       recyclerView = view.findViewById(R.id.lahf_recycler);
       BusID = new ArrayList<>();
      BusName = new ArrayList<>();
       BusNo = new ArrayList<>();
       BusStart = new ArrayList<>();
       BusEnd = new ArrayList<>();
       BusTime = new ArrayList<>();
       bus_date = new ArrayList<>();
       mydb = new HistoryDatabaseHelper(getContext());
       if(tempResult==null) {
           displayHistory();
       }

       if(tempResult!=null){
          // saveDataToHistory();
           displayHistory();}

       historyAdapter = new HistoryAdapter( getContext(),BusID,BusName,BusNo,BusStart,BusEnd,bus_date,BusTime);
       recyclerView.setAdapter(historyAdapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

     return view;
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
        mydb.addHistory(message11,message12,message13,message14,savedate,savetime);
        tempResult =null;

       /* String[] infos = tempResult.split("\\n");
        // int infoNo = Integer.parseInt(infos[1]);
        HistoryDatabaseHelper mydb = new HistoryDatabaseHelper(getContext());
        mydb.addHistory(infos[0],infos[1],infos[2],infos[3],savedate,savetime);
        tempResult =null;*/
        // Toast.makeText(getActivity(), "saved successfully", Toast.LENGTH_SHORT).show();

    }

    public void displayHistory() {
        HistoryDatabaseHelper mydb = new HistoryDatabaseHelper(getContext());
        Cursor cursor = mydb.readAllHistory();
        if (cursor.getCount() == 0)
            Toast.makeText(getActivity(), "Nothing To Display", Toast.LENGTH_SHORT).show();
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                BusID.add(cursor.getString(0));
                BusName.add(cursor.getString(1));
                BusNo.add(cursor.getString(2));
                BusStart.add(cursor.getString(3));
                BusEnd.add(cursor.getString(4));
                bus_date.add(cursor.getString(5));
                BusTime.add(cursor.getString(6));
            }
            Toast.makeText(getActivity(), "displayed", Toast.LENGTH_SHORT).show();
        }
    }
}



