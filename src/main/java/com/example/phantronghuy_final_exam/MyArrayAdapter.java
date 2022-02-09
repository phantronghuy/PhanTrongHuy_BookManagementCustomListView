package com.example.phantronghuy_final_exam;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<ItemSach> {
    Activity context;
    int idLayout;
    ArrayList<ItemSach> myArl;

    public MyArrayAdapter( Activity context, int idLayout, ArrayList<ItemSach> myArl) {
        super(context, idLayout, myArl);
        this.context = context;
        this.idLayout = idLayout;
        this.myArl = myArl;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflater=context.getLayoutInflater();
        convertView=myInflater.inflate(idLayout,null);

        ItemSach myBook=myArl.get(position);
        if(position%2==0){

            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.teal_200));
        }
        else {
            convertView.setBackgroundColor(convertView.getResources().getColor(R.color.purple_200));
        }
        TextView txtMaSach=convertView.findViewById(R.id.txtMaSach);
        TextView txtTenSach=convertView.findViewById(R.id.txtTenSach);
        TextView txtTacGia=convertView.findViewById(R.id.txtTacGia);
        TextView txtNamXb=convertView.findViewById(R.id.txtNamXb);
        TextView txtSoLuong=convertView.findViewById(R.id.txtSoLuong);

        txtMaSach.setText(myBook.getMaSach());
        txtTenSach.setText(myBook.getTenSach());
        txtTacGia.setText(myBook.getTacGia());
        txtNamXb.setText(myBook.getNamXb()+"");
        txtSoLuong.setText(myBook.getSoLuong()+"");

        return convertView;
    }
}
