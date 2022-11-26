package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Can't Decide Database";

    // Common columns
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_ID = "ID";

    // Columns unique to the Charity Table
    public static final String COLUMN_PARENT_ID = "Parent_ID";

    // Columns unique to the Causes Table
    public static final String COLUMN_ALIAS = "Alias";
    public static final String COLUMN_MISSION = "Mission";
    public static final String COLUMN_REGION = "Region";
    public static final String COLUMN_WEBSITE = "Website";


    public static final String CHARITY_TABLE_NAME = "Saved Charities";
    public static final String CAUSES_TABLE_NAME = "Causes";

    public static final String CREATE_CAUSES_TABLE =
            "CREATE TABLE " + CAUSES_TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_NAME + " TEXT, " + COLUMN_PARENT_ID + " INTEGER" + ")";

    public static final String CREATE_CHARITY_TABLE =
            "CREATE TABLE " + CHARITY_TABLE_NAME + "(" + COLUMN_ID + " TEXT PRIMARY KEY,"
            + COLUMN_NAME + " TEXT, " + COLUMN_ALIAS + " TEXT, "
            + COLUMN_MISSION + " TEXT, " + COLUMN_REGION + " TEXT, "
            + COLUMN_WEBSITE + " TEXT" + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CAUSES_TABLE);
        sqLiteDatabase.execSQL(CREATE_CHARITY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
