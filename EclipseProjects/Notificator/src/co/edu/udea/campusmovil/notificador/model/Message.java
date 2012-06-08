package co.edu.udea.campusmovil.notificador.model;

public class Message {

    public static String[] COLS = new String[] {"consecutive_id", "id", "name", "date", "content", "forum_id"};
    public static String DATABASE_TABLE = "messages";

    public static String TABLE_CREATE = "create table " + Message.DATABASE_TABLE + " ("
        + Message.COLS[0] + " integer primary key autoincrement, "
        + Message.COLS[1] + " text not null,"
        + Message.COLS[2] + " text not null, "
        + Message.COLS[3] + " text not null, "
        + Message.COLS[4] + " text not null, "
        + Message.COLS[5] + " text not null, "
        + "UNIQUE (" + Message.COLS[1] + "), "
        + "FOREIGN KEY (" + Message.COLS[5] + ") REFERENCES forums(" + Forum.COLS[1] + "));";
    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int consecutiveId;
    private String id;
    private String name;
    private String date;
    private String content;
    private String forumId;

    public Message(String id, String name, String date, String content, String forumId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.content = content;
        this.forumId = forumId;
    }

    public int getConsecutiveId() {

        return consecutiveId;
    }

    public void setConsecutiveId(int consecutiveId) {
        this.consecutiveId = consecutiveId;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String data) {
        this.content = data;
    }

    public String getForumId() {

        return forumId;
    }

    public void setForumId(String forumId) {
        this.forumId = forumId;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
       this.date = date;
    }
}
