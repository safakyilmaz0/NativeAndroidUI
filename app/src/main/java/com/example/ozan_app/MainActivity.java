package com.example.ozan_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    float[] rainfall = {98.8f,123.8f,24.2f};
    String[] chartNames = {"satis 1","satis 2","satis 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void setupPieChart(){

        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i = 0 ; i < rainfall.length ; i++) {
            pieEntries.add(new PieEntry(rainfall[i], chartNames[i]));
        }
        PieDataSet dataSet= new PieDataSet(pieEntries, "s");
        dataSet.setValueTextSize(11);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data= new PieData(dataSet);


        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.getDescription().setEnabled(false);
        Legend legend = chart.getLegend();
        legend.setTextSize(20);
        legend.setTextColor(Color.BLACK);
        chart.animateY(1000);
        chart.invalidate();

    }
}