package com.example.cardviewproject3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<ItemInCardView> list;
    private RecyclerAdapter rAdapter;
    private Button addBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initallize();
    }
    
    private void initallize(){
        recyclerView = (RecyclerView)findViewBYId(R.id.mRecyclerView);
        LinearLayoutManager IManager = new LinearlayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(IManager);

        list = new ArrayList<>();

        list.add(new ItemInCardView(R.mipmap.ic_launcher, "Original Droid"));
        list.add(new ItemInCardView(R.mipmap.ic_launcher_pink, "pink Droid"));
        list.add(new ItemInCardView(R.mipmap.ic_launcher_blue,"Blue Droid"));

        rAdapter = new RecyclerAdapter(getApplicationContext(), list);

        recyclerView.setAdapter(rAdapter);

        addBt=(Button)findViewById(R.id.addBt);
        addBt=setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addBt :
                list.add(new ItemInCardView(R.mipmap.ic_launcher_red, "Red Droid"));
                recyclerView.setAdapter(rAdapter);
                break;
        }
    }
}
