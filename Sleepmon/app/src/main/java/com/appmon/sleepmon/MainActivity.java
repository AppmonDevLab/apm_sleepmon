package com.appmon.sleepmon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.appmon.sleepmon.Fragments.AlarmFragment;
import com.appmon.sleepmon.Fragments.ChartFragment;
import com.appmon.sleepmon.Fragments.DiaryFragment;
import com.appmon.sleepmon.Fragments.MusicFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{

    public AlarmFragment alarm;
    public ChartFragment chart;
    public DiaryFragment diary;
    public MusicFragment music;
    private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> list = new ArrayList<>();
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();

        initView();
        initBottomBar();
    }

    private void initView() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom);
    }

    private void initBottomBar() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.sleep_pressed, "睡眠")
                        .setActiveColorResource(R.color.sleep).setInactiveIconResource(R.drawable.sleep_normal))
                .addItem(new BottomNavigationItem(R.drawable.analysis_pressed, "睡眠报告")
                        .setActiveColorResource(R.color.analysis).setInactiveIconResource(R.drawable.analysis_normal))
                .addItem(new BottomNavigationItem(R.drawable.diary_pressed, "眠梦日记")
                        .setActiveColorResource(R.color.diary).setInactiveIconResource(R.drawable.diary_normal))
                .addItem(new BottomNavigationItem(R.drawable.music_pressed, "催眠曲")
                        .setActiveColorResource(R.color.music).setInactiveIconResource(R.drawable.music_normal))
                .initialise();
        onTabSelected(0);
        bottomNavigationBar.setTabSelectedListener(this);
    }

    public void hideFragment(FragmentTransaction transaction) {
        for (Fragment fragment : list) {
            transaction.hide(fragment);
        }
    }

    @Override
    public void onTabSelected(int position) {

        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (position) {
            case 0:
                if (alarm == null) {
                    alarm = new AlarmFragment();
                    transaction.add(R.id.layFrame, alarm);
                    list.add(alarm);
                } else {
                    transaction.show(alarm);
                }
                DiaryFragment.tag = true;
                break;
            case 1:
                if (chart != null) {
                    chart = null;
                }
                chart = new ChartFragment();
                transaction.add(R.id.layFrame, chart);
                list.add(chart);
                DiaryFragment.tag = true;
                break;
            case 2:
                if (diary != null) {
                    diary = null;
                }
                diary = new DiaryFragment();
                transaction.add(R.id.layFrame, diary);
                list.add(diary);
                break;
            case 3:
                if (music == null) {
                    music = new MusicFragment();
                    transaction.add(R.id.layFrame, music);
                    list.add(music);
                } else {
                    transaction.show(music);
                }
                DiaryFragment.tag = true;
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabReselected(int position) {}

    @Override
    public void onTabUnselected(int position) {}

    @Override
    public void onActivityResult(int resquestCode, int resultCode, Intent data1) {
        if (resquestCode == 6 || resquestCode == 9) {
            diary = null;
            DiaryFragment.tag = false;
            onTabSelected(2);
        }
    }
}
