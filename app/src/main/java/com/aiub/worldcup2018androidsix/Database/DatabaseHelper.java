package com.aiub.worldcup2018androidsix.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.aiub.worldcup2018androidsix.ModelClasses.MatchModel;
import com.aiub.worldcup2018androidsix.ModelClasses.Team;

import java.util.ArrayList;
import java.util.List;

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

    private static final String MATCH_TABLE_NAME = "matches";
    private static final String MATCH_NAME = "match_name";
    private static final String MATCH_STAGE = "match_stage";
    private static final String MATCH_HOME_TEAM = "match_home_team";
    private static final String MATCH_AWAY_TEAM = "match_away_team";
    private static final String MATCH_HOME_RESULT = "match_home_result";
    private static final String MATCH_AWAY_RESULT = "match_away_result";
    private static final String MATCH_TIME = "match_time";
    private static final String MATCH_STADIUM = "match_stadium";

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

        String CREATE_MATCH_TABLE = "CREATE TABLE " + MATCH_TABLE_NAME + " ("
                + MATCH_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MATCH_HOME_TEAM + " INTEGER, "
                + MATCH_AWAY_TEAM + " INTEGER, "
                + MATCH_HOME_RESULT + " INTEGER, "
                + MATCH_AWAY_RESULT + " INTEGER, "
                + MATCH_STADIUM + " INTEGER, "
                + MATCH_STAGE + " TEXT, "
                + MATCH_TIME + " TEXT DEFAULT NULL)";
        db.execSQL(CREATE_MATCH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TEAM_TABLE = "DROP TABLE IF EXISTS " + TEAM_TABLE_NAME;
        db.execSQL(DROP_TEAM_TABLE);

        String DROP_MATCH_TABLE = "DROP TABLE IF EXISTS " + MATCH_TABLE_NAME;
        db.execSQL(DROP_MATCH_TABLE);
    }

    public void addTeam(Team team) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TEAM_ID, team.getId());
        contentValues.put(TEAM_NAME, team.getName());
        contentValues.put(TEAM_FIFA_CODE, team.getfifaCode());
        contentValues.put(TEAM_GROUP_NAME, team.getGroupName());
        contentValues.put(TEAM_FLAG_URL, team.getIcon());

        long rowId = sqLiteDatabase.insert(TEAM_TABLE_NAME, null, contentValues);
        Log.e(TAG, "row ID " + rowId);

        sqLiteDatabase.close();
    }

    public List<Team> getAllTeams() {
        List<Team> teamList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String query = "SELECT * FROM " + TEAM_TABLE_NAME + " ORDER BY " + TEAM_ID;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Team team = new Team();
                team.setId(cursor.getInt(cursor.getColumnIndex(TEAM_ID)));
                team.setName(cursor.getString(cursor.getColumnIndex(TEAM_NAME)));
                team.setfifaCode(cursor.getString(cursor.getColumnIndex(TEAM_FIFA_CODE)));
                team.setGroupName(cursor.getString(cursor.getColumnIndex(TEAM_GROUP_NAME)));
                team.setIcon(cursor.getString(cursor.getColumnIndex(TEAM_FLAG_URL)));

                teamList.add(team);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();

        return teamList;
    }

    public void updateFlagUrl(int id, String url) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TEAM_FLAG_URL, url);

        sqLiteDatabase.update(TEAM_TABLE_NAME, contentValues,
                TEAM_ID + " = ?", new String[]{"" + id});

        sqLiteDatabase.close();
    }

    public List<Team> getTeamsByGroup(String groupName) {
        List<Team> group = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String query = "SELECT * FROM " + TEAM_TABLE_NAME + " WHERE "
                + TEAM_GROUP_NAME + " = '" + groupName + "' ORDER BY " + TEAM_ID;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Team team = new Team();
                team.setId(cursor.getInt(cursor.getColumnIndex(TEAM_ID)));
                team.setName(cursor.getString(cursor.getColumnIndex(TEAM_NAME)));
                team.setfifaCode(cursor.getString(cursor.getColumnIndex(TEAM_FIFA_CODE)));
                team.setGroupName(cursor.getString(cursor.getColumnIndex(TEAM_GROUP_NAME)));
                team.setIcon(cursor.getString(cursor.getColumnIndex(TEAM_FLAG_URL)));

                group.add(team);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();

        return group;
    }

    public void addMatch(MatchModel matchModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MATCH_NAME, matchModel.getMatchName());
        contentValues.put(MATCH_AWAY_RESULT, matchModel.getAwayResult());
        contentValues.put(MATCH_AWAY_TEAM, matchModel.getAwayTeam());
        contentValues.put(MATCH_HOME_RESULT, matchModel.getHomeResult());
        contentValues.put(MATCH_HOME_TEAM, matchModel.getHomeTeam());
        contentValues.put(MATCH_STADIUM, matchModel.getStadiumId());
        contentValues.put(MATCH_STAGE, matchModel.getMatchStage());
        contentValues.put(MATCH_TIME, matchModel.getMatchTime());

        long rowId = sqLiteDatabase.insert(MATCH_TABLE_NAME, null, contentValues);
        Log.e(TAG, "row ID " + rowId);

        sqLiteDatabase.close();
    }
}
