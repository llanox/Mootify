package co.edu.udea.campusmovil.notificador.helpers;

import java.util.ArrayList;
import java.util.List;

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

    @Override
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

    private SQLiteDatabase setUpDataBase() {
        Log.i(GenericDAO.LOG, "Opening The DataBase: " + this.sql);
        this.db = this.getWritableDatabase();

        return (this.db);
    }

    public long insert(String tableName, ContentValues values) {

        return (this.db.insert(tableName, null, values));
    }

    public List<Course> getAllCourses() {
         List<Course> list = new ArrayList<Course>();

         Cursor cursor = this.getAllFromTable(Course.DATABASE_TABLE, Course.COLS);
         if (cursor == null || cursor.getCount() == 0) {

             return (list);
         }
         cursor.moveToFirst();

         for (int i = 0; i < cursor.getCount(); i++) {
             String id = cursor.getString(cursor.getColumnIndex(Course.COLS[1]));
             String name = cursor.getString(cursor.getColumnIndex(Course.COLS[2]));

             list.add(new Course(id, name));
             cursor.moveToNext();
         }
         cursor.close();

         return (list);
    }

    public List<Forum> getAllForums() {
        List<Forum> list = new ArrayList<Forum>();

        Cursor cursor = this.getAllFromTable(Forum.DATABASE_TABLE, Forum.COLS);
        if (cursor == null || cursor.getCount() == 0) {

            return (list);
        }
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            String id = cursor.getString(cursor.getColumnIndex(Forum.COLS[1]));
            String name = cursor.getString(cursor.getColumnIndex(Forum.COLS[2]));
            String type = cursor.getString(cursor.getColumnIndex(Forum.COLS[3]));
            String courseId = cursor.getString(cursor.getColumnIndex(Forum.COLS[4]));

            list.add(new Forum(id, name, type, courseId));
            cursor.moveToNext();
        }
        cursor.close();

        return (list);
   }

    public List<Message> getAllMessages() {
        List<Message> list = new ArrayList<Message>();

        Cursor cursor = this.getAllFromTable(Message.DATABASE_TABLE, Message.COLS);
        if (cursor == null || cursor.getCount() == 0) {

            return (list);
        }
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            String id = cursor.getString(cursor.getColumnIndex(Message.COLS[1]));
            String name = cursor.getString(cursor.getColumnIndex(Message.COLS[2]));
            String date = cursor.getString(cursor.getColumnIndex(Message.COLS[3]));
            String content = cursor.getString(cursor.getColumnIndex(Message.COLS[4]));
            String forumId = cursor.getString(cursor.getColumnIndex(Message.COLS[4]));

            list.add(new Message(id, name, date, content, forumId));
            cursor.moveToNext();
        }
        cursor.close();

        return (list);
   }

    private Cursor getAllFromTable(String tableName, String[] columns) {

        return (this.db.query(tableName, columns, null, null, null, null, null));
    }

    public Course getCourseById(boolean isUdeAId, String idCourse) {
         Cursor cursor = this.getOneFromTable(isUdeAId, Course.DATABASE_TABLE, Course.COLS, idCourse);
         if (cursor == null || cursor.getCount() == 0) {
             if (cursor != null) {
                 cursor.close();
             }

             return null;
         }

         String idTemp = idCourse;
         if (!isUdeAId) {
             idTemp = cursor.getString(cursor.getColumnIndex(Course.COLS[1]));
         }

         String name = cursor.getString(cursor.getColumnIndex(Course.COLS[2]));
         cursor.close();

         return (new Course(idTemp, name));
    }

    public Forum getForumById(boolean isUdeAId, String idForum) {
         Cursor cursor = this.getOneFromTable(isUdeAId, Forum.DATABASE_TABLE, Forum.COLS, idForum);
         if (cursor == null || cursor.getCount() == 0) {
             if (cursor != null) {
                 cursor.close();
             }

             return null;
         }

         String idTemp = idForum;
         if (!isUdeAId) {
             idTemp = cursor.getString(cursor.getColumnIndex(Forum.COLS[1]));
         }

         String name = cursor.getString(cursor.getColumnIndex(Forum.COLS[2]));
         String type = cursor.getString(cursor.getColumnIndex(Forum.COLS[3]));
         String courseId = cursor.getString(cursor.getColumnIndex(Forum.COLS[4]));
         cursor.close();

         return (new Forum(idTemp, name, type, courseId));
    }

    public Message getMessageById(boolean isUdeAId, String idMessage) {
         Cursor cursor = this.getOneFromTable(isUdeAId, Message.DATABASE_TABLE, Message.COLS, idMessage);
         if (cursor == null || cursor.getCount() == 0) {
             if (cursor != null) {
                 cursor.close();
             }

             return null;
         }

         String idTemp = idMessage;
         if (!isUdeAId) {
             idTemp = cursor.getString(cursor.getColumnIndex(Message.COLS[1]));
         }

         String name = cursor.getString(cursor.getColumnIndex(Message.COLS[2]));
         String date = cursor.getString(cursor.getColumnIndex(Message.COLS[3]));
         String content = cursor.getString(cursor.getColumnIndex(Message.COLS[4]));
         String forumId = cursor.getString(cursor.getColumnIndex(Message.COLS[4]));
         cursor.close();

         return (new Message(idTemp, name, date, content, forumId));
    }

    /*
     * isUdeAID - Es para identificar sí el id enviado como parámetro es el Ude@ o el autoincrement.
     * id - Es el id de Ude@.
     */
    private Cursor getOneFromTable(boolean isUdeAId, String tableName, String[] columns, String id) {
        Cursor cursor = null;
        if (isUdeAId) {
            cursor = this.db.query(true, tableName, columns, columns[1] + "=" + id, null, null, null, null, null);
        } else {
            cursor = this.db.query(true, tableName, columns, columns[0] + "=" + id, null, null, null, null, null);
        }

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public List<Forum> getForumsByCourse(String idCourse) {
        Cursor cursor = this.db.query(true, Forum.DATABASE_TABLE, Forum.COLS, Forum.COLS[4] + "=" + idCourse,
            null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        List<Forum> list = new ArrayList<Forum>();
        if (cursor == null || cursor.getCount() == 0) {

            return (list);
        }

        for (int i = 0; i < cursor.getCount(); i++) {
            String id = cursor.getString(cursor.getColumnIndex(Forum.COLS[1]));
            String name = cursor.getString(cursor.getColumnIndex(Forum.COLS[2]));
            String type = cursor.getString(cursor.getColumnIndex(Forum.COLS[3]));
            String courseId = cursor.getString(cursor.getColumnIndex(Forum.COLS[4]));

            list.add(new Forum(id, name, type, courseId));
            cursor.moveToNext();
        }
        cursor.close();

        return list;
    }

    public List<Message> getMessagesByForum(String idForum) {
        Cursor cursor = this.db.query(true, Message.DATABASE_TABLE, Message.COLS, Message.COLS[5] + "=" + idForum,
            null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        List<Message> list = new ArrayList<Message>();
        if (cursor == null || cursor.getCount() == 0) {

            return (list);
        }

        for (int i = 0; i < cursor.getCount(); i++) {
            String id = cursor.getString(cursor.getColumnIndex(Message.COLS[1]));
            String name = cursor.getString(cursor.getColumnIndex(Message.COLS[2]));
            String date = cursor.getString(cursor.getColumnIndex(Message.COLS[3]));
            String content = cursor.getString(cursor.getColumnIndex(Message.COLS[4]));
            String forumId = cursor.getString(cursor.getColumnIndex(Message.COLS[4]));

            list.add(new Message(id, name, date, content, forumId));
            cursor.moveToNext();
        }
        cursor.close();

        return (list);
    }

    public int deleteCourse(boolean isUdeAId, String id) {
        int counter = 0;
        List<Forum> list = this.getForumsByCourse(id);

        for (int k = 0; k < list.size(); k++) {
            Forum forum = list.get(k);
            counter = counter + this.deleteForum(true, forum.getId());
        }
        this.delete(isUdeAId, Course.DATABASE_TABLE, Course.COLS, id);

        return counter;
    }

    public int deleteForum(boolean isUdeAId, String idForum) {
        int counter = 0;
        List<Message> list = this.getMessagesByForum(idForum);
        
        for (int k = 0; k < list.size(); k++) {
            Message message = (Message) list.get(k);
            counter = counter + this.deleteMessage(true, message.getId());
        }
        this.delete(isUdeAId, Forum.DATABASE_TABLE, Forum.COLS, idForum);

        return counter;
    }

    public int deleteMessage(boolean isUdeAId, String idMessage) {

        return (this.delete(isUdeAId, Message.DATABASE_TABLE, Message.COLS, idMessage));
    }

    private int delete(boolean isUdeAId, String tableName, String[] columns, String id) {
        if (isUdeAId) {

            return (this.db.delete(tableName, columns[1] + "=" + id, null));
        } else {

            return (this.db.delete(tableName, columns[0] + "=" + id, null));
        }
    }
}
