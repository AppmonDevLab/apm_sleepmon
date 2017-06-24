package com.appmon.sleepmon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, BottomNavigationBar.OnTabSelectedListener{

    private AlarmFragment alarm;
    private ChartFragment chart;
    private DiaryFragment diary;
    private MusicFragment music;
    private ViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initBottomBar();
        setViewPager();
    }

    private void initView() {
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottombar);
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
        bottomNavigationBar.setTabSelectedListener(this);
    }

    private void setViewPager() {
        alarm = new AlarmFragment();
        chart = new ChartFragment();
        diary = new DiaryFragment();
        music = new MusicFragment();
        list.add(alarm);
        list.add(chart);
        list.add(diary);
        list.add(music);
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }


    @Override
    public void onPageSelected(int position) {
        bottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                viewPager.setCurrentItem(0);
                break;
            case 1:
                viewPager.setCurrentItem(1);
                break;
            case 2:
                viewPager.setCurrentItem(2);
                break;
            case 3:
                viewPager.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
