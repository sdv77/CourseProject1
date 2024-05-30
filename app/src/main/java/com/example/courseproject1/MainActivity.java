package com.example.courseproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DaysAdapter.OnItemClickListener {


    private RecyclerView recyclerView;
    private DaysAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Устанавливаем горизонтальную ориентацию
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new DaysAdapter(getNextSevenDays(), this);
        recyclerView.setAdapter(adapter);

        // Отключение прокрутки
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        recyclerView.setHorizontalScrollBarEnabled(false);
    }

    private int[] getNextSevenDays() {
        int[] days = new int[7];
        Calendar calendar = Calendar.getInstance();

        // Установите календарь на понедельник текущей недели
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        for (int i = 0; i < 7; i++) {
            days[i] = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return days;
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Clicked day: " + position, Toast.LENGTH_SHORT).show();
    }
}