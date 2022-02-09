package com.example.phantronghuy_final_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtMaSach,edtTenSach,edtTacGia,edtNamXb,edtSoLuong;
    Button btnAdd,btnQuery,btnDelete,btnUpdate;
    public static  SQLiteDatabase qlsach= null;
    public static final String Table_Name="tablesach";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
        //----------- Tạo table nếu không tồn tại ------------
        qlsach=openOrCreateDatabase("dbqlsach.db",MODE_PRIVATE,null);
        try {
            // Tạo table
            doCreateTable();
        }
        catch (Exception e){
            Log.e("Error", "Table is exists");
        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddToDataBase();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateToDataBase();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteToDataBase();
            }
        });

        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QueryToDataBase();
            }
        });
    }

    private void QueryToDataBase() {
     Intent intent =new Intent(MainActivity.this,DisplayActivity.class);
     startActivity(intent);
    }

    private void DeleteToDataBase() {
        String d_maSach=edtMaSach.getText().toString();

        int d=qlsach.delete(Table_Name,"masach=?",new String[]{d_maSach});
        String notification = "";
        if(d ==0){
            notification="Delete Row "+d_maSach +" Fail";
        }else{
            notification ="Delete Row "+d_maSach +" Sucessful";
        }
        Toast.makeText(MainActivity.this,notification,Toast.LENGTH_SHORT).show();


    }

    private void UpdateToDataBase() {
        String u_maSach=edtMaSach.getText().toString();

        int u_soluong= Integer.parseInt(edtSoLuong.getText().toString());

        ContentValues contentValues= new ContentValues();
        contentValues.put("masach",u_maSach);
        contentValues.put("soluong",u_soluong);

        String notification="";

        if (qlsach.update(Table_Name,contentValues,"masach=?",
                new String[]{u_maSach})!=0){
            notification="Update Successful";
        }
        else{
            notification="Update Failed";
        }
        Toast.makeText(MainActivity.this,notification,Toast.LENGTH_SHORT).show();
    }

    private void AddToDataBase() {
            String a_maSach=edtMaSach.getText().toString();
            String a_tenSach=edtTenSach.getText().toString();
            String a_tacGia=edtTacGia.getText().toString();
            int a_namxb= Integer.parseInt(edtNamXb.getText().toString());
            int a_soluong=Integer.parseInt(edtSoLuong.getText().toString()) ;

            Log.e("loi",a_maSach+a_tenSach+a_tacGia+
                    a_namxb+a_soluong);

        ContentValues contentValues= new ContentValues();
        contentValues.put("masach",a_maSach);
        contentValues.put("tensach",a_tenSach);
        contentValues.put("tacgia",a_tacGia);
        contentValues.put("namxb",a_namxb);
        contentValues.put("soluong",a_soluong);
        String notification="";
        if(qlsach.insert(Table_Name,null,contentValues)!=-1){
            notification="Insert Successful";
        }
        else{
            notification="Insert Failed";
        }
        Toast.makeText(MainActivity.this,notification,Toast.LENGTH_SHORT).show();
    }

    private void doCreateTable() {

        String sql1="CREATE TABLE tablesach (masach TEXT primary key, tensach TEXT, tacgia TEXT, namxb INTEGER , soluong INTEGER )";
        qlsach.execSQL(sql1);
    }


    private void AddControls() {
        edtMaSach=findViewById(R.id.edtMaSach);
        edtTenSach=findViewById(R.id.edtTenSach);
        edtTacGia=findViewById(R.id.edtTacGia);
        edtNamXb=findViewById(R.id.edtNamXb);
        edtSoLuong=findViewById(R.id.edtSoLuong);

        btnAdd=findViewById(R.id.btnAdd);
        btnQuery=findViewById(R.id.btnQuery);
        btnDelete=findViewById(R.id.btnDelete);
        btnUpdate=findViewById(R.id.btnUpdate);
    }

}