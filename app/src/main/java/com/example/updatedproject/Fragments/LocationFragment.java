package com.example.updatedproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.updatedproject.CurrentLocationMap;
import com.example.updatedproject.R;
import com.example.updatedproject.ViewCurrentAddress;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class LocationFragment extends Fragment {
Button button1,button2,button3;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){
        View view = inflater.inflate(R.layout.activity_location_fragment, viewGroup, false);
        button1 = view.findViewById(R.id.lalf_addressbutton);
        button2 = view.findViewById(R.id.lalf_locationmapbutton);
        button3 = view.findViewById(R.id.lalf_routebutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ViewCurrentAddress.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CurrentLocationMap.class);
                startActivity(intent);
            }
        });

        return view;
    }



}
