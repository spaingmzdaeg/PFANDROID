package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activityUserTransaction extends AppCompatActivity {

    Button btnInsertar,btnEliminar,btnActualizar,btnConsultar;
    EditText user_id,transaction_id,amount,type,comment,
            payment_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_transaction);

        btnInsertar = (Button)findViewById(R.id.btnagregar2);
        btnEliminar = (Button)findViewById(R.id.btnelimarut);
        btnConsultar = (Button)findViewById(R.id.btnconsultarut);
        btnActualizar = (Button)findViewById(R.id.btnactualizarut);

        user_id = (EditText)findViewById(R.id.etuser_id2);
        transaction_id = (EditText)findViewById(R.id.ettransaction_id);
        amount = (EditText)findViewById(R.id.etamount);
        type = (EditText)findViewById(R.id.ettype);
        comment = (EditText)findViewById(R.id.etcomment);
        payment_id = (EditText)findViewById(R.id.etpayment_id);



        final BDHelper Helper = new BDHelper(this);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Gets the data repository in write mode
                SQLiteDatabase db = Helper.getWritableDatabase();

// Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(EstructuraBD2.TRANSACTION_ID, Integer.parseInt(transaction_id.getText().toString()));
                values.put(EstructuraBD2.USER_ID,Integer.parseInt(user_id.getText().toString()));
                values.put(EstructuraBD2.PAYMENT_ID,Integer.parseInt(payment_id.getText().toString()));
                values.put(EstructuraBD2.AMOUNT,Integer.parseInt(amount.getText().toString()));
                values.put(EstructuraBD2.TYPE,type.getText().toString());
                values.put(EstructuraBD2.COMMENT,comment.getText().toString());



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
                payment_id.setText("payment###");
                amount.setText("monto###");
                type.setText("comment###");
                comment.setText("a###");
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

                values.put(EstructuraBD2.TRANSACTION_ID, Integer.parseInt(transaction_id.getText().toString()));
                values.put(EstructuraBD2.USER_ID,Integer.parseInt(user_id.getText().toString()));
                values.put(EstructuraBD2.PAYMENT_ID,Integer.parseInt(payment_id.getText().toString()));
                values.put(EstructuraBD2.AMOUNT,Integer.parseInt(amount.getText().toString()));
                values.put(EstructuraBD2.TYPE,type.getText().toString());
                values.put(EstructuraBD2.COMMENT,comment.getText().toString());


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
                        EstructuraBD2.USER_ID,
                        EstructuraBD2.PAYMENT_ID,
                        EstructuraBD2.AMOUNT,
                        EstructuraBD2.TYPE,
                        EstructuraBD2.COMMENT


                };

// Filter results WHERE "title" = 'My Title'
                String selection = EstructuraBD2.TRANSACTION_ID + " = ?";
                String[] selectionArgs = { transaction_id.getText().toString() };

// How you want the results sorted in the resulting Cursor
                String sortOrder =
                        EstructuraBD2.TRANSACTION_ID + " DESC";

                try {
                    Cursor cursor = db.query(
                            EstructuraBD2.TABLE_NAME,   // The table to query
                            projection,             // The array of columns to return (pass null to get all)
                            selection,              // The columns for the WHERE clause
                            selectionArgs,          // The values for the WHERE clause
                            null,                   // don't group the rows
                            null,                   // don't filter by row groups
                            null               // The sort order
                    );

                    cursor.moveToFirst();

                    user_id.setText(String.valueOf(cursor.getString(0)));
                    payment_id.setText(String.valueOf(cursor.getString(1)));
                    amount.setText(String.valueOf(cursor.getString(2)));
                    type.setText(cursor.getString(3));
                    comment.setText(cursor.getString(4));


                }catch (Exception e){

                    Toast.makeText(getApplicationContext(),"NO SE ENCONTRO REGISTRO" ,Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void ingresarListViewUT(View view){
        Intent ingresarListView = new Intent(this,ListViewUserTransaction.class);
        startActivity(ingresarListView);
    }
}
