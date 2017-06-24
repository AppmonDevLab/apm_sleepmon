package com.appmon.sleepmon.Utility;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.appmon.sleepmon.Fragments.Diary_edit;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Ravens on 2017/6/24.
 */
public class myDBTest extends AndroidTestCase {

    private myDB mydb;
    private final String TABLE_NAME = "diary_table";
    private String year = "2017";
    private String month = "2";
    private String day = "28";
    private String hour = "8";
    private String minute = "23";
    private String weekdayTrans = "周日";
    private String diary_content = "23";
    private String datestr;

    public void test() throws Exception {
        myDB mydb = new myDB(getContext());
        SQLiteDatabase db = mydb.getWritableDatabase();
        ContentValues cv = new ContentValues();
        datestr = year+"年"+month+"月"+day+"日"+" "+hour+":"+minute +" "+ weekdayTrans;
        cv.put("date", day);
        cv.put("month", month);
        cv.put("week", weekdayTrans);
        cv.put("time", hour+":"+minute);
        cv.put("diary", diary_content);
        cv.put("sum_time", datestr);

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }


}