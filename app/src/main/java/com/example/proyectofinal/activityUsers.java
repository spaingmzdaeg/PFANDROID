package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class activityUsers extends AppCompatActivity {

    Button btnInsertar,btnEliminar,btnActualizar,btnConsultar;
    EditText user_id,password,email,first_name,last_name,address,performance_factor,cellphone,
    payment_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        btnInsertar = (Button)findViewById(R.id.btnAgregar);
        btnEliminar = (Button)findViewById(R.id.btneliminar);
        btnConsultar = (Button)findViewById(R.id.btnconsultar);
        btnActualizar = (Button)findViewById(R.id.btnactualizar);

        user_id = (EditText)findViewById(R.id.ptuser_id);
        email = (EditText)findViewById(R.id.ptemail);
        password = (EditText)findViewById(R.id.ptpassword);
        first_name = (EditText)findViewById(R.id.ptfirst_name);
        last_name = (EditText)findViewById(R.id.pflast_name);
        address = (EditText)findViewById(R.id.ptadress);
        performance_factor = (EditText)findViewById(R.id.ptpf);
        cellphone = (EditText)findViewById(R.id.ptcellphone);
        payment_id = (EditText)findViewById(R.id.ptpayment_id);

        final BDHelper Helper = new BDHelper(this);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Gets the data repository in write mode
                SQLiteDatabase db = Helper.getWritableDatabase();

// Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(EstructuraBD.USER_ID, Integer.parseInt(user_id.getText().toString()));
                values.put(EstructuraBD.EMAIL,email.getText().toString());
                values.put(EstructuraBD.PASSWORD,password.getText().toString());
                values.put(EstructuraBD.FIRST_NAME,first_name.getText().toString());
                values.put(EstructuraBD.LAST_NAME,last_name.getText().toString());
                values.put(EstructuraBD.ADDRESS,address.getText().toString());
                values.put(EstructuraBD.PERFORMANCE_FACTOR,performance_factor.getText().toString());
                values.put(EstructuraBD.CELLPHONE,cellphone.getText().toString());
                values.put(EstructuraBD.PAYMENT_ID, Integer.parseInt(payment_id.getText().toString()));


// Insert the new row, returning the primary key value of the new row
                long newRowId = db.insert(EstructuraBD.TABLE_NAME, null, values);
                Toast.makeText(getApplicationContext(),"Se Guardo el registro con clave" +
                        newRowId,Toast.LENGTH_LONG).show();

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = Helper.getWritableDatabase();

                // Define 'where' part of query.
                String selection = EstructuraBD.USER_ID + " LIKE ?";
// Specify arguments in placeholder order.
                String[] selectionArgs = { user_id.getText().toString() };
// Issue SQL statement.
                int deletedRows = db.delete(EstructuraBD.TABLE_NAME, selection, selectionArgs);

                Toast.makeText(getApplicationContext(),"Registro Eliminado",Toast.LENGTH_LONG).show();

                user_id.setText("User_id###");
                email.setText("email###");
                first_name.setText("fn###");
                last_name.setText("ln###");
                address.setText("address###");
                performance_factor.setText("pf###");
                cellphone.setText("cellphone###");
                payment_id.setText("pid");

            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SQLiteDatabase db = Helper.getWritableDatabase();

// New value for one column
                String title = "MyNewTitle";
                ContentValues values = new ContentValues();

                values.put(EstructuraBD.EMAIL,email.getText().toString());
                values.put(EstructuraBD.PASSWORD,password.getText().toString());
                values.put(EstructuraBD.FIRST_NAME,first_name.getText().toString());
                values.put(EstructuraBD.LAST_NAME,last_name.getText().toString());
                values.put(EstructuraBD.ADDRESS,address.getText().toString());
                values.put(EstructuraBD.PERFORMANCE_FACTOR,performance_factor.getText().toString());
                values.put(EstructuraBD.CELLPHONE,cellphone.getText().toString());
                values.put(EstructuraBD.PAYMENT_ID, Integer.parseInt(payment_id.getText().toString()));;

// Which row to update, based on the title
                String selection = EstructuraBD.USER_ID + " LIKE ?";
                String[] selectionArgs = { user_id.getText().toString() };

                int count = db.update(
                        EstructuraBD.TABLE_NAME,
                        values,
                        selection,
                        selectionArgs);

                Toast.makeText(getApplicationContext(),"SE ACTUALIZO EL REGISTRO" ,Toast.LENGTH_LONG).show();

            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = Helper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
                String[] projection = {
                        //BaseColumns._ID,
                        EstructuraBD.EMAIL,
                        EstructuraBD.PASSWORD,
                        EstructuraBD.FIRST_NAME,
                        EstructuraBD.LAST_NAME,
                        EstructuraBD.ADDRESS,
                        EstructuraBD.PERFORMANCE_FACTOR,
                        EstructuraBD.CELLPHONE,
                        EstructuraBD.PAYMENT_ID

                };

// Filter results WHERE "title" = 'My Title'
                String selection = EstructuraBD.USER_ID + " = ?";
                String[] selectionArgs = { user_id.getText().toString() };

// How you want the results sorted in the resulting Cursor
                String sortOrder =
                        EstructuraBD.USER_ID + " DESC";

                try {
                    Cursor cursor = db.query(
                            EstructuraBD.TABLE_NAME,   // The table to query
                            projection,             // The array of columns to return (pass null to get all)
                            selection,              // The columns for the WHERE clause
                            selectionArgs,          // The values for the WHERE clause
                            null,                   // don't group the rows
                            null,                   // don't filter by row groups
                            null               // The sort order
                    );

                    cursor.moveToFirst();

                    email.setText(cursor.getString(0));
                    password.setText(cursor.getString(1));
                    first_name.setText(cursor.getString(2));
                    last_name.setText(cursor.getString(3));
                    address.setText(cursor.getString(4));
                    performance_factor.setText(cursor.getString(5));
                    cellphone.setText(cursor.getString(6));
                    payment_id.setText(String.valueOf(cursor.getInt(7)));



                }catch (Exception e){

                    Toast.makeText(getApplicationContext(),"NO SE ENCONTRO REGISTRO" ,Toast.LENGTH_LONG).show();
                }

            }
        });
    }



}
