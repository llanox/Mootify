package co.edu.udea.campusmovil.notificador.helpers;

import co.edu.udea.campusmovil.notificador.model.Course;
import co.edu.udea.campusmovil.notificador.model.Forum;
import co.edu.udea.campusmovil.notificador.model.Message;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class GenericDAO extends SQLiteOpenHelper {
    private static final String LOG = "GenericDAO";

    private SQLiteDatabase db;
    private String dataBaseName;
    private String sql;
    private String tableName;

    private static GenericDAO instance;

    public GenericDAO(Context context, String dataBaseName, String sql, String tableName, int version) {
        super(context, dataBaseName, null, version);

        this.sql = sql;
        this.dataBaseName = dataBaseName;
        this.tableName = tableName;
    }

    public static GenericDAO getInstance(Context context, String dataBaseName, String sql,
        String tableName, int version) {
        if (GenericDAO.instance == null) {
            GenericDAO.instance = new GenericDAO(context, dataBaseName, sql, tableName, version);

            try {
                Log.i(GenericDAO.LOG, "Creating The DataBase: " + dataBaseName);
                GenericDAO.instance.onCreate(GenericDAO.instance.setUpDataBase());
            } catch (SQLiteException e) {
                Log.e(GenericDAO.LOG, e.getMessage());
            }
        } else {
            try {
                Log.i(GenericDAO.LOG, "Creating The Data Base: " + dataBaseName);
                GenericDAO.instance.sql = sql;
                GenericDAO.instance.tableName = tableName;
                GenericDAO.instance.onCreate(GenericDAO.instance.setUpDataBase());
            } catch (SQLiteException e) {
                Log.e(GenericDAO.LOG, e.getMessage());
            }
        }

        return instance;
    }

    private SQLiteDatabase setUpDataBase() {
        Log.i(GenericDAO.LOG, "Opening The DataBase: " + this.sql);
        this.db = this.getWritableDatabase();

        return (this.db);
    }

    public void close() {
        if (GenericDAO.instance != null) {
            Log.i(GenericDAO.LOG, "Closing The Database: " + this.dataBaseName);
            this.db.close();
            GenericDAO.instance = null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(GenericDAO.LOG, "Trying To Create The Table: " + this.tableName);
        db.execSQL(this.sql);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        
    }

    public long insert(String tableName, ContentValues values) {

        return (this.db.insert(tableName, null, values));
    }

    public Cursor getAllFromTable(String tableName, String[] columns) {

        return (this.db.query(tableName, columns, null, null, null, null, null));
    }

    /*
     * isUdeAID - Es para identificar sí el id enviado como parámetro es el Ude@ o el autoincrement.
     * id - Es el id de Ude@.
     */
    public Cursor getOneFromTable(boolean isUdeAID, String tableName, String[] columns, String id) {
        Cursor cursor = null;
        if (isUdeAID) {
            cursor = this.db.query(true, tableName, columns, columns[1] + "=" + id, null, null, null, null, null);
        } else {
            cursor = this.db.query(true, tableName, columns, columns[0] + "=" + id, null, null, null, null, null);
        }

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public Cursor getMessagesByForum(String idForum) {
        Cursor cursor = this.db.query(true, Message.DATABASE_TABLE, Message.COLS, Message.COLS[5] + "=" + idForum, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public Cursor getForumsByCourse(String idCourse) {
        Cursor cursor = this.db.query(true, Forum.DATABASE_TABLE, Forum.COLS, Forum.COLS[4] + "=" + idCourse, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public int deleteCourse(String id) {
        int counter = 0;
        Cursor cursor = this.getForumsByCourse(id);
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(Forum.COLS[1]);

        for (int k = 0; k < cursor.getCount(); k++) {
            counter = counter + this.deleteForum(cursor.getString(indexId));
            cursor.moveToNext();
        }
        this.delete(Course.DATABASE_TABLE, Course.COLS, id);

        return counter;
    }

    public int deleteForum(String id) {

        int counter = 0;
        Cursor cursor = this.getMessagesByForum(id);
        cursor.moveToFirst();
        int indexId = cursor.getColumnIndex(Message.COLS[1]);

        for (int k = 0; k < cursor.getCount(); k++) {
            counter = counter + this.deleteMessage(cursor.getString(indexId));
            cursor.moveToNext();
        }
        this.delete(Forum.DATABASE_TABLE, Forum.COLS, id);

        return counter;
    }

    
    public int deleteMessage(String id) {

        return (this.delete(Message.DATABASE_TABLE, Message.COLS, id));
    }

    public int delete(String tableName, String[] columns, String id) {

        return (this.db.delete(tableName, columns[1] + "=" + id, null));
    }
}
