package com.example.practical9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    SQLiteDatabase db;
    TableLayout tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        db=openOrCreateDatabase("sample", Context.MODE_PRIVATE,null);
        tab = findViewById(R.id.view);
        data();
    }

    private void data(){
        Cursor c = db.rawQuery("select * from student;",null);
        while(c.moveToNext()){
            TableRow tr = rowdata(c);
            tab.addView(tr);
        }
    }

    private TableRow rowdata(Cursor c)
    {
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
        TextView t[] = new TextView[3];
        t[0] = new TextView(this);
        t[1] = new TextView(this);
        t[2] = new TextView(this);
        for(int i=0; i<t.length; i++)
        {
            t[i].setGravity(Gravity.CENTER);
            t[i].setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
        }
        t[0].setText(""+c.getInt(0));
        t[1].setText(c.getString(1));
        t[2].setText(""+c.getInt(2));
        tableRow.addView(t[0]);
        tableRow.addView(t[1]);
        tableRow.addView(t[2]);
        return tableRow;
    }

    @Override
    public void onStop()
    {
        db.close();
        tab.removeAllViews();
        super.onStop();
    }
}