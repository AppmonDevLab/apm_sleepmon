package com.appmon.sleepmon.Fragments;

import android.app.Fragment;

import com.appmon.sleepmon.MainActivity;

import static org.junit.Assert.*;

/**
 * Created by Ravens on 2017/6/24.
 */
public class ChartFragmentTest extends android.test.ActivityInstrumentationTestCase2<MainActivity> {
    MainActivity myFragmentActivity;
    ChartFragment myFragment;

    public ChartFragmentTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        myFragmentActivity = (MainActivity) getActivity();
        myFragment = myFragmentActivity.chart;
    }

    public void testPreConditions() {
        assertNotNull(myFragmentActivity);
        assertNotNull(myFragment);
    }

    public void testAnythingFromMyFragment() {
        // access any public members of myFragment to test
    }
}