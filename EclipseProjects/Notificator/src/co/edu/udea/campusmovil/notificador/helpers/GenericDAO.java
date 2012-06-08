package co.edu.udea.campusmovil.notificador.helpers;

import android.content.ContentValues;
import android.content.Context;
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
}
