package co.edu.udea.campusmovil.notificador.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class GenericDAO extends SQLiteOpenHelper {
	private SQLiteDatabase db;
	
	private static final String LOG = "GenericDAO";
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

	public static GenericDAO getInstance(Context context, String dataBaseName, String sql, String tableName, int version) {
		if (instance == null) {
			instance = new GenericDAO(context, dataBaseName, sql, tableName, version);
			try {
				
				instance.onCreate(instance.setUpDB());
				
			} catch (SQLiteException e) {
				Log.e(LOG, e.getMessage());
			}
		}
		
		return instance;
	}

	private SQLiteDatabase setUpDB() {
		db = this.getWritableDatabase();
		return db;
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
