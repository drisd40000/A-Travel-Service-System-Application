package com.example.updatedproject.AdapterFolder;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.updatedproject.BusDetails;
import com.example.updatedproject.Fragments.HistoryFragment;
import com.example.updatedproject.HistoryDatabaseHelper;
import com.example.updatedproject.HistoryDetailActivity;
import com.example.updatedproject.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private   Context context;
    private  ArrayList ha_id,ha_name, ha_number, ha_start,ha_end, ha_date,ha_time;
    int position;
    HistoryDatabaseHelper mydb;
    HistoryFragment data;
    public HistoryAdapter(Context context){
        this.context = context;
    }
    public HistoryAdapter(Context context, ArrayList ha_id, ArrayList ha_name, ArrayList ha_number,ArrayList ha_start,ArrayList ha_end,
                          ArrayList ha_date, ArrayList ha_time ) {
        this.context = context;
        this.ha_id = ha_id;
        this.ha_name = ha_name;
        this.ha_number = ha_number;
        this.ha_start = ha_start;
        this.ha_end = ha_end;
        this.ha_date = ha_date;
        this.ha_time = ha_time;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_history_row_design,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final HistoryAdapter.MyViewHolder holder, final int position) {
        this.position = position;

        holder.ha_id_txt.setText(String.valueOf(ha_id.get(position)));
        holder.ha_name_txt.setText(String.valueOf(ha_name.get(position)));
        holder.ha_number_txt.setText(String.valueOf(ha_number.get(position)));
        holder.ha_start_txt.setText(String.valueOf(ha_start.get(position)));
        holder.ha_end_txt.setText(String.valueOf(ha_end.get(position)));
        holder.ha_date_txt.setText(String.valueOf(ha_date.get(position)));
        holder.ha_time_txt.setText(String.valueOf(ha_time.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HistoryDetailActivity.class);
                intent.putExtra("id", String.valueOf(ha_id.get(position)));
                intent.putExtra("name", String.valueOf(ha_name.get(position)));
                intent.putExtra("number", String.valueOf(ha_number.get(position)));
                intent.putExtra("start", String.valueOf(ha_start.get(position)));
                intent.putExtra("end", String.valueOf(ha_end.get(position)));
                intent.putExtra("date", String.valueOf(ha_date.get(position)));
                intent.putExtra("time", String.valueOf(ha_time.get(position)));
                context.startActivity(intent);
            }
        });

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
                popup.inflate(R.menu.options_menu);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                String name =String.valueOf(ha_name.get(position));
                                String number =String.valueOf(ha_number.get(position));
                                String startnode =String.valueOf(ha_start.get(position));
                                String endnode =String.valueOf(ha_end.get(position));
                                String date =String.valueOf(ha_date.get(position));
                                String time =String.valueOf(ha_time.get(position));
                                String message = "Bus Name: "+ name +"\nBus Number: "+ number + "\nBus Route: \n" + startnode + " - " +endnode+"\n\nDate & Time: \n"+ date + " - " +time;
                                Intent intent1 = new Intent(Intent.ACTION_SEND);
                                intent1.setType("text/plain");
                                intent1.putExtra(Intent.EXTRA_TEXT, message);
                                context.startActivity(intent1);
                                break;
                            case R.id.menu2:
                                String id  = String.valueOf(ha_id.get(position));
                                int i_id = Integer.parseInt(id);
                               mydb = new HistoryDatabaseHelper(context);
                               mydb.deleteContact(i_id);
                                ((Activity) context).recreate();
                               // context.startActivity(((FragmentActivity) context).getIntent());



                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ha_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mainLayout;
        TextView ha_id_txt, ha_name_txt, ha_number_txt, ha_start_txt, ha_end_txt, ha_date_txt, ha_time_txt,buttonViewOption;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ha_id_txt = itemView.findViewById(R.id.lhrd_busid);
            ha_name_txt = itemView.findViewById(R.id.lhrd_busname);
            ha_number_txt = itemView.findViewById(R.id.lhrd_busnum);
            ha_start_txt = itemView.findViewById(R.id.lhrd_busstart);
            ha_end_txt = itemView.findViewById(R.id.lhrd_busend);
            ha_date_txt = itemView.findViewById(R.id.lhrd_busdate);
            ha_time_txt = itemView.findViewById(R.id.lhrd_bustime);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            buttonViewOption = (TextView)itemView.findViewById(R.id.lhrd_Optionsmenu);
        }
    }
}