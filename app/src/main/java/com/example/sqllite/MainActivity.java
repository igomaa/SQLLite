package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //reference to button abd controls on the layout
    Button btn_add, btn_viewAll;
    EditText et_name, et_age;
    Switch sw_activeCustomer;
    ListView lv_customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      btn_add= findViewById(R.id.btn_add);

        btn_viewAll= findViewById(R.id.btn_viewAll);

        et_name= findViewById(R.id.et_name);
        et_age= findViewById(R.id.et_age);
        sw_activeCustomer= findViewById(R.id.sw_active);
        lv_customerList= findViewById(R.id.customer_list);


       // button listener
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                CustomerModel customerModel;

                try{
                    customerModel = new CustomerModel(-1, et_name.getText().toString(),Integer.parseInt(et_age.getText().toString()), sw_activeCustomer.isChecked());
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();

                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                    customerModel = new CustomerModel(-1, "error", 0, false);

                }
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean success=  dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "sucess="+success, Toast.LENGTH_LONG).show();
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "View ALL", Toast.LENGTH_SHORT).show();
            }
        });

    }

}