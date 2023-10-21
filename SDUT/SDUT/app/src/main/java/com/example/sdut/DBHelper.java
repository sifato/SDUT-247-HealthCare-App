package com.example.sdut;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // Constants for Login Table
    public static final String LOGIN_TABLE_NAME = "users";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    // Constants for Book Library Table
    private static final String BOOK_LIBRARY_TABLE_NAME = "books";
    private static final String COL_ID = "id";
    private static final String COL_TITLE = "title";
    private static final String COL_AUTHOR = "author";
    private static final String COL_PAGES = "pages";

    public DBHelper(Context context) {
        super(context, "BookLibrary.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Login Table
        String createLoginTableQuery = "CREATE TABLE " + LOGIN_TABLE_NAME + " (" +
                COL_USERNAME + " TEXT PRIMARY KEY, " +
                COL_PASSWORD + " TEXT)";
        db.execSQL(createLoginTableQuery);

        // Create Book Library Table
        String createBookLibraryTableQuery = "CREATE TABLE " + BOOK_LIBRARY_TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_TITLE + " TEXT, " +
                COL_AUTHOR + " TEXT, " +
                COL_PAGES + " INTEGER)";
        db.execSQL(createBookLibraryTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop Login Table if exists
        db.execSQL("DROP TABLE IF EXISTS " + LOGIN_TABLE_NAME);

        // Drop Book Library Table if exists
        db.execSQL("DROP TABLE IF EXISTS " + BOOK_LIBRARY_TABLE_NAME);

        onCreate(db);
    }

    // Login Table Methods

    public Boolean insertData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_PASSWORD, password);
        long result = db.insert(LOGIN_TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LOGIN_TABLE_NAME + " WHERE " + COL_USERNAME + " = ?", new String[]{username});
        return cursor.getCount() > 0;
    }

    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + LOGIN_TABLE_NAME + " WHERE " + COL_USERNAME + " = ? AND " + COL_PASSWORD + " = ?", new String[]{username, password});
        return cursor.getCount() > 0;
    }

    // Book Library Table Methods

    public boolean insertBook(String title, String author, int pages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TITLE, title);
        contentValues.put(COL_AUTHOR, author);
        contentValues.put(COL_PAGES, pages);
        long result = db.insert(BOOK_LIBRARY_TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + BOOK_LIBRARY_TABLE_NAME, null);
    }

    public boolean updateData(String id, String title, String author, String pages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, id);
        contentValues.put(COL_TITLE, title);
        contentValues.put(COL_AUTHOR, author);
        contentValues.put(COL_PAGES, pages);
        db.update(BOOK_LIBRARY_TABLE_NAME, contentValues, COL_ID + " = ?", new String[]{id});
        return true;
    }

    public boolean deleteOneRow(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(BOOK_LIBRARY_TABLE_NAME, COL_ID + " = ?", new String[]{id});
        return result > 0;
    }

    public void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + BOOK_LIBRARY_TABLE_NAME);
    }
}
