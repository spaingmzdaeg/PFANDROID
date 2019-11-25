package com.example.proyectofinal;

import android.provider.BaseColumns;

public class EstructuraBD {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private EstructuraBD() {}

    /* Inner class that defines the table contents */
   // public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String USER_ID = "user_id";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String ADDRESS = "address";
    public static final String PERFORMANCE_FACTOR = "performance_factor";


    public static final String CELLPHONE = "cellphone";
    public static final String PAYMENT_ID = "payment_id";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EstructuraBD.TABLE_NAME + " (" +
                    EstructuraBD.USER_ID + " INTEGER PRIMARY KEY," +
                    EstructuraBD.EMAIL + " TEXT," +
                    EstructuraBD.PASSWORD + " TEXT,"+
                    EstructuraBD.FIRST_NAME + " TEXT,"+
                    EstructuraBD.LAST_NAME + " TEXT,"+
                    EstructuraBD.ADDRESS + " TEXT,"+
                    EstructuraBD.PERFORMANCE_FACTOR + " TEXT,"+
                    EstructuraBD.CELLPHONE + " TEXT,"+
                    EstructuraBD.PAYMENT_ID + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EstructuraBD.TABLE_NAME;









    //}

}
