package com.example.votingsystemmfs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database";
    private static final int DATABASE_VERSION = 1;
    public static final String ID = "id";
    public static final String CANDIDATES_TABLE = "candidates_table";
    public static final String POSITION_NAME = "position_name";
    public static final String CANDIDATES_NAME = "candidates_names";
    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";

    public static final String USER_TABLE = "user_table";
    public static final String VOTERNAME = "votername";
    public static final String VOTE = "vote";

    SQLiteDatabase db;


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String table = "CREATE TABLE " +
                CANDIDATES_TABLE + " ( " +
                ID + " INTEGER PRIMARY KEY, "  +
                POSITION_NAME + " TEXT, " +
                CANDIDATES_NAME + " TEXT, " +
                START_TIME + " TEXT, " +
                END_TIME + " TEXT " +
                ")";
        final String table2 = "CREATE TABLE " +
                USER_TABLE + " ( " +
                ID + " INTEGER PRIMARY KEY, "  +
                VOTERNAME + " TEXT, " +
                VOTE + " TEXT " +
                ")";
        db.execSQL(table);
        db.execSQL(table2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ CANDIDATES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ USER_TABLE);
        onCreate(db);

    }

    public void DataAddtoDatabase(String pos_nm, String can_nm, String str_time, String end_time){
        db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(POSITION_NAME, pos_nm);
        contentValues.put(CANDIDATES_NAME, can_nm);
        contentValues.put(START_TIME, str_time);
        contentValues.put(END_TIME, end_time);

        db.insert(CANDIDATES_TABLE, null, contentValues);
    }

    public void UserDataAddtoDatabase(String voter_name){
        db = getWritableDatabase();
        int vt = 0;
        ContentValues contentValues = new ContentValues();
        contentValues.put(VOTERNAME, voter_name);
        contentValues.put(VOTE, vt);

        db.insert(CANDIDATES_TABLE, null, contentValues);
    }



    public List<Candidates> getData() {
        List<Candidates> candidateList = new ArrayList<>();
        db = getReadableDatabase();
        String sql = "SELECT * FROM " + CANDIDATES_TABLE;

        Cursor cursor = db.rawQuery(sql, null);


        if(cursor.moveToFirst()){
            do {
                Candidates candidate = new Candidates();
                candidate.setId(cursor.getInt(cursor.getColumnIndex(ID)));
                candidate.setPosition_NM(cursor.getString(cursor.getColumnIndex(POSITION_NAME)));
                candidate.setCandidate_NM(cursor.getString(cursor.getColumnIndex(CANDIDATES_NAME)));
                candidate.setStart_TM(cursor.getString(cursor.getColumnIndex(START_TIME)));
                candidate.setEnd_TM(cursor.getString(cursor.getColumnIndex(END_TIME)));
                candidateList.add(candidate);
            }while (cursor.moveToNext());

        }
        cursor.close();
        return candidateList;
    }

    public List<Users> getUserData(){
        List<Users> userList = new ArrayList<>();
        db = getReadableDatabase();
        String sql = "SELECT * FROM " + USER_TABLE;

        Cursor cursor2 = db.rawQuery(sql, null);


        if(cursor2.moveToFirst()){
            do {
                Users user = new Users();
                user.setUserId(cursor2.getInt(cursor2.getColumnIndex(ID)));
                user.setVoter_NM(cursor2.getString(cursor2.getColumnIndex(VOTERNAME)));
                user.setVote(cursor2.getInt(cursor2.getColumnIndex(VOTE)));
                userList.add(user);
            }while (cursor2.moveToNext());

        }

        cursor2.close();
        return userList;
    }

    public int UpdateUserTable(int id, int i){
        db = getWritableDatabase();
        ContentValues contentVal = new ContentValues();
        contentVal.put(VOTE, i);
        return db.update(USER_TABLE, contentVal,ID + " = ? ", new String[]{String.valueOf(id)});

    }



}
