package com.donkingliang.headerviewadapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.donkingliang.headerviewadapter.HeaderViewAdapter;
import com.donkingliang.headerviewadapter.HeaderViewGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = (RecyclerView) findViewById(R.id.rv_list);
        showLinearList();
//        showGridList();
    }

    private void showLinearList() {
        LinearAdapter adapter = new LinearAdapter(this);
        HeaderViewAdapter headerViewAdapter = new HeaderViewAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        View hv1 = LayoutInflater.from(this).inflate(R.layout.layout_header, rvList, false);
        View hv2 = LayoutInflater.from(this).inflate(R.layout.layout_header_view, rvList, false);
        View fv = LayoutInflater.from(this).inflate(R.layout.layout_footer_view, rvList, false);
        headerViewAdapter.addHeaderView(hv1);
        headerViewAdapter.addHeaderView(hv2);
        headerViewAdapter.addFooterView(fv);
        rvList.setAdapter(headerViewAdapter);
    }

    private void showGridList() {
        GridAdapter adapter = new GridAdapter(this);
        HeaderViewAdapter headerViewAdapter = new HeaderViewAdapter(adapter);
        rvList.setLayoutManager(new HeaderViewGridLayoutManager(this, 2, headerViewAdapter));
        View hv1 = LayoutInflater.from(this).inflate(R.layout.layout_header, rvList, false);
        View hv2 = LayoutInflater.from(this).inflate(R.layout.layout_header_view, rvList, false);
        View fv = LayoutInflater.from(this).inflate(R.layout.layout_footer_view, rvList, false);
        headerViewAdapter.addHeaderView(hv1);
        headerViewAdapter.addHeaderView(hv2);
        headerViewAdapter.addFooterView(fv);
        rvList.setAdapter(headerViewAdapter);
    }
}
