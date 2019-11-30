package com.example.proyectofinal;

public class EstructuraBD2 {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private EstructuraBD2() {}

    /* Inner class that defines the table contents */
    // public static class FeedEntry implements BaseColumns {
    public static final String TABLE_NAME = "userTransaction";
    public static final String TRANSACTION_ID = "transaction_id";
    public static final String USER_ID = "user_id";
    public static final String PAYMENT_ID = "payment_id";
    public static final String AMOUNT = "amount";
    public static final String TYPE = "type";
    public static final String COMMENT = "comment";


    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EstructuraBD2.TABLE_NAME + " (" +
                    EstructuraBD2.TRANSACTION_ID + " INTEGER PRIMARY KEY," +
                    EstructuraBD2.USER_ID + " INTEGER," +
                    EstructuraBD2.PAYMENT_ID + " INTEGER,"+
                    EstructuraBD2.AMOUNT +" INTEGER,"+
                    EstructuraBD2.TYPE + " TEXT,"+
                    EstructuraBD2.COMMENT + " TEXT, "+
                    "FOREIGN KEY("+EstructuraBD2.USER_ID+") REFERENCES "+EstructuraBD.TABLE_NAME+
                    "("+EstructuraBD.USER_ID+") ON DELETE CASCADE)";



    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EstructuraBD2.TABLE_NAME;









    //}
}
