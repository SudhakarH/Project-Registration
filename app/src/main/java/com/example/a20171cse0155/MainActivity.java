package com.example.a20171cse0155;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3,editText4,editText5;
    MyDB myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);

        myDbHelper = new MyDB(this,"Project",null,1);
    }
    public void addData_265(View view){
        int Id =Integer.parseInt(editText1.getText().toString());
        String Name = editText2.getText().toString();
        String Title = editText3.getText().toString();
        String Fund = editText4.getText().toString();
        String Guide = editText5.getText().toString();


        myDbHelper.insertData(Id,Name,Title,Fund,Guide);
    }

    public void viewData_265(View view){
        String result = myDbHelper.getData();
        Toast.makeText(this,result,Toast.LENGTH_LONG).show();

    }
    public void viewData_guide(View view){
        String result = myDbHelper.getPerticularData();
        Toast.makeText(this,result,Toast.LENGTH_LONG).show();

    }
}
