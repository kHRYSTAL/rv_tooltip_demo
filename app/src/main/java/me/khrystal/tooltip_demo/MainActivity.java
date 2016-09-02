package me.khrystal.tooltip_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, mDataList);

        mRecyclerView.setAdapter(simpleAdapter);
    }

    private void initList() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDataList.add("" + i);
        }
    }
}
