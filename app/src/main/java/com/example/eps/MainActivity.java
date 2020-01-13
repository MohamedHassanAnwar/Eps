package com.example.eps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eps.Model.Item;
import com.example.eps.ViewHolder.RecyclerAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {




    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<String> listData = new ArrayList<>();
    RecyclerAdapter adapter;

    //google_map
    Button btnMap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter(getMylist(),this);
        mRecyclerView.setAdapter(adapter);

        btnMap = (Button)findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });



    }





    private ArrayList<Item> getMylist(){
        ArrayList<Item> models= new ArrayList<>();

        Item m = new Item();
        m.setTitle("people");
        m.setDescription("This is newsfeed description..");
        m.setImg(R.drawable.people);
        models.add(m);


        m = new Item();
        m.setTitle("myphoto");
        m.setDescription("This is myPhoto description..");
        m.setImg(R.drawable.myphoto);
        models.add(m);

        m = new Item();
        m.setTitle("notes");
        m.setDescription("This is notes description..");
        m.setImg(R.drawable.notes);
        models.add(m);

        return models;


    }


}
