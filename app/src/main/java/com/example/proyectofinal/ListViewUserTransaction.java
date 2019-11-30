package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewUserTransaction extends AppCompatActivity {
    BDHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_user_transaction);

        ListView listView = (ListView) findViewById(R.id.listViewUsersTransaction);
        myDB = new BDHelper(this);

        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents2();
        if(data.getCount() == 0){
            Toast.makeText(this, "NO HAY REGISTROS !",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(0)+"-"+data.getString(1)+"-"
                        +data.getString(2)+"-"+data.getString(3)+"-"+
                        data.getString(4)+"-"+data.getString(5));

                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
