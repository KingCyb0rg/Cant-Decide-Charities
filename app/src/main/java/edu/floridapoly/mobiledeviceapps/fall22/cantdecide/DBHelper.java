package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Can't Decide Database";

    // Common columns
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_MISSION = "Mission";
    public static final String COLUMN_REGION = "Region";
    public static final String COLUMN_WEBSITE = "Website";


    public static final String CHARITY_TABLE_NAME = "Charities";

    public static final String CREATE_CHARITY_TABLE =
            "CREATE TABLE " + CHARITY_TABLE_NAME + "("
            + COLUMN_ID + " TEXT PRIMARY KEY, "
            + COLUMN_NAME + " TEXT, " + COLUMN_MISSION + " TEXT, "
            + COLUMN_REGION + " TEXT, " + COLUMN_WEBSITE + " TEXT"
            + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CHARITY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CHARITY_TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    public List<Charity> getAllCharities() {
        List<Charity> charities = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + CHARITY_TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Charity charity = new Charity();
                charity.setId(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                charity.setName(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)));
                charity.setMission(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MISSION)));
                charity.setRegion(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_REGION)));
                charity.setWebsite(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_WEBSITE)));
                charities.add(charity);
            } while (cursor.moveToNext());
        }
        db.close();
        return charities;
    }
    public long insertCharity(String id, String name, String mission, String region, String website) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_MISSION, mission);
        values.put(COLUMN_REGION, region);
        values.put(COLUMN_WEBSITE, website);

        return db.insert(CHARITY_TABLE_NAME, null, values);
    }
    public boolean isDuplicate(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String searchQuery = "SELECT * FROM " + CHARITY_TABLE_NAME + " WHERE " + COLUMN_ID + " LIKE " + id;
        Cursor cursor = db.rawQuery(searchQuery, null);
        db.close();

        return (cursor.getCount() != 0);
    }
}
