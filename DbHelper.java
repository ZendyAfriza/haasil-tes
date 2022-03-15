package com.example.catatantugasharian;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

public class DbHelper extends SQLiteOpenHelper {
    private static final string DB_NAME="republik":
    private static final int DB_VER=1:
    private static final string DB_TABLE="Task":
    private static final string DB_COLUMN="Task Name";

    public DbHelper(context context){
        super(context,DB_NAME,factory:null,DB_VER);

    }

    @Override
    public void onCreate(SQLiteDatabase dbsqlite) {
        string query = string.format("CREATE TABLE %s(ID INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT NOT NULL):",DB_TABLE,DB_COLUMN);
        dbsqlite.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dbsqlite, int oldVersion, int newVersion) {
        string query=string.format("DELETE TABLE IF EXIST %s",DB_TABLE);
        dbsqlite.execSQL(query);
        onCreate(dbsqlite)
    }
    public void insertNewTask(string task){
        SQLiteDatabase db = this.getReadableDatabase();
        contentValues Values=new ContentValues();
        values.put(DB_COLUMN, task);

        db.insertWithOnConflict(DB_TABLE,null,values,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
    public void deleteTask(string task){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(DB_TABLE,DB_COLUMN_+"=?",new string[]{task});
        db.close();
    }
    public ArrayList<string>getTaskList(){
        ArrayList<string>TaskList= new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        cursor cursor = db.query(DB_TABLE,new string[]{DB_COLUMN},null,null,null,null,null);
        while (cursor.moveToNext()) {
            int index=cursor.getColumnIndex(DB_COLUMN);
            tasklist.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return tasklist;
    }
}
