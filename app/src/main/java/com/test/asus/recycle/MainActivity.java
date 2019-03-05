package com.test.asus.recycle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvTeam;
    private ArrayList<ModelActivity> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeam = findViewById(R.id.list);
        rvTeam.setHasFixedSize(true);
        list.addAll(DataActivity.getListData());

        showRecyclerList();

    }
    private void showRecyclerList() {
        rvTeam.setLayoutManager(new LinearLayoutManager(this));
        AdapterActivity TAdapter = new AdapterActivity(this);
        TAdapter.TList(list);
        rvTeam.setAdapter(TAdapter);
    }

}
