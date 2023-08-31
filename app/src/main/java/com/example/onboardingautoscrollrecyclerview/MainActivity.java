package com.example.onboardingautoscrollrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.onboardingautoscrollrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    AutoScrollAdapter autoScrollAdapter1;
    AutoScrollAdapter autoScrollAdapter2;
    AutoScrollAdapter autoScrollAdapter3;


    ArrayList<Integer> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpData();
        setUpRecyclerView1();
        setUpRecyclerView3();
        setUpRecyclerView2();

    }


    private void setUpData() {
        data = new ArrayList<Integer>();
        data.add(R.drawable.pic1);
        data.add(R.drawable.pic2);
        data.add(R.drawable.pic3);
        data.add(R.drawable.pic4);
        data.add(R.drawable.pic5);
        data.add(R.drawable.pic6);
        data.add(R.drawable.pic7);
        data.add(R.drawable.pic4);
        data.add(R.drawable.pic5);
        data.add(R.drawable.pic6);
        data.add(R.drawable.pic7);
        data.add(R.drawable.pic6);
        data.add(R.drawable.pic7);
        data.add(R.drawable.pic4);

    }

    private void setUpRecyclerView3() {

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rv1.setLayoutManager(linearLayoutManager1);
        autoScrollAdapter1 = new AutoScrollAdapter(this,data);
        binding.rv1.setAdapter(autoScrollAdapter1);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (linearLayoutManager1.findLastCompletelyVisibleItemPosition() < (data.size() - 1)){
                    linearLayoutManager1.smoothScrollToPosition(binding.rv1, new RecyclerView.State(), (data.size() - 1));
                }else if(linearLayoutManager1.findLastCompletelyVisibleItemPosition() == (data.size() - 1)){
                    linearLayoutManager1.smoothScrollToPosition(binding.rv1, new RecyclerView.State(), 0);
                }
            }
        }, 1000, 5000);

    }

    private void setUpRecyclerView2() {

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rv2.setLayoutManager(linearLayoutManager2);
        binding.rv2.scrollToPosition(data.size() - 1);
        autoScrollAdapter2 = new AutoScrollAdapter(this,data);
        binding.rv2.setAdapter(autoScrollAdapter2);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (linearLayoutManager2.findLastCompletelyVisibleItemPosition() < (data.size() - 1)){
                    linearLayoutManager2.smoothScrollToPosition(binding.rv2, new RecyclerView.State(), (data.size() - 1));
                }else if(linearLayoutManager2.findLastCompletelyVisibleItemPosition() == (data.size() - 1)){
                    linearLayoutManager2.smoothScrollToPosition(binding.rv2, new RecyclerView.State(), 0);
                }
            }
        }, 1000, 5000);

    }

    private void setUpRecyclerView1() {

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rv3.setLayoutManager(linearLayoutManager3);
        autoScrollAdapter3 = new AutoScrollAdapter(this,data);
        binding.rv3.setAdapter(autoScrollAdapter3);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (linearLayoutManager3.findLastCompletelyVisibleItemPosition() < (data.size() - 1)){
                    linearLayoutManager3.smoothScrollToPosition(binding.rv3, new RecyclerView.State(), (data.size() - 1));
                }else if(linearLayoutManager3.findLastCompletelyVisibleItemPosition() == (data.size() - 1)){
                    linearLayoutManager3.smoothScrollToPosition(binding.rv3, new RecyclerView.State(), 0);
                }
            }
        }, 1000, 5000);

    }

}