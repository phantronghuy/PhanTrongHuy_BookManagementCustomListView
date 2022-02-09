package com.example.phantronghuy_final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<ItemSach> arl;
    MyArrayAdapter myArrayAdapter;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        AddControls();

        myArrayAdapter.clear();
        Cursor cursor= MainActivity.qlsach.query(MainActivity.Table_Name,null,null,null,
                null,null,null);
        cursor.moveToFirst();

        while(cursor.isAfterLast()==false){
            ItemSach itemSach= new ItemSach();

            itemSach.setMaSach(cursor.getString(0));
            itemSach.setTenSach(cursor.getString(1));
            itemSach.setTacGia(cursor.getString(2));
            itemSach.setNamXb(cursor.getInt(3));
            itemSach.setSoLuong(cursor.getInt(4));
            arl.add(itemSach);
            cursor.moveToNext();
        }
        Toast.makeText(DisplayActivity.this,"Successfull",Toast.LENGTH_LONG).show();
        cursor.close();
        myArrayAdapter.notifyDataSetChanged();
        lv.setOnTouchListener(new OnSwipeTouchListener(DisplayActivity.this){
            public void onSwipeRight() {
                Intent intent=new Intent(DisplayActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        linearLayout.setOnTouchListener(new OnSwipeTouchListener(DisplayActivity.this){
            public void onSwipeRight() {
                Intent intent=new Intent(DisplayActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AddControls() {

        linearLayout=findViewById(R.id.linear);
        lv=findViewById(R.id.lv);
        arl=new ArrayList<>();
        myArrayAdapter=new MyArrayAdapter(DisplayActivity.this, R.layout.custom_listview,arl);
        lv.setAdapter(myArrayAdapter);

    }
}