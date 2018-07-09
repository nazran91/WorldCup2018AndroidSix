package com.aiub.worldcup2018androidsix.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.aiub.worldcup2018androidsix.ModelClasses.Team;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "fifa_world_cup";

    private static final String TEAM_TABLE_NAME = "teams";
    private static final String _ID = "row_id";
    private static final String TEAM_ID = "team_id";
    private static final String TEAM_NAME = "team_name";
    private static final String TEAM_FLAG_URL = "team_url";
    private static final String TEAM_FIFA_CODE = "team_fifa_code";
    private static final String TEAM_GROUP_NAME = "team_group_name";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TEAM_TABLE = "CREATE TABLE " + TEAM_TABLE_NAME + " ("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TEAM_ID + " INTEGER, "

                + TEAM_NAME + " TEXT, "
                + TEAM_FLAG_URL + " TEXT DEFAULT NULL, "
                + TEAM_FIFA_CODE + " TEXT, "
                + TEAM_GROUP_NAME + " TEXT DEFAULT NULL)";
        db.execSQL(CREATE_TEAM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TEAM_TABLE = "DROP TABLE IF EXISTS " + TEAM_NAME;
        db.execSQL(DROP_TEAM_TABLE);
    }

    public void addTeam(Team team) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TEAM_ID, team.getId());
        contentValues.put(TEAM_NAME, team.getName());
        contentValues.put(TEAM_FIFA_CODE, team.getfifaCode());

        long rowId = sqLiteDatabase.insert(TEAM_TABLE_NAME, null, contentValues);
        Log.e(TAG, "row ID " + rowId);

        sqLiteDatabase.close();
    }
}
