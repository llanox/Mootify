package co.edu.udea.campusmovil.notificador.model;

public class Message {

    public static String[] COLS = new String[] {"consecutive_id","id", "name", "date", "content", "forum_id"};
    public static String DATABASE_TABLE = "messages";

    public static String TABLE_CREATE = "create table " + Message.DATABASE_TABLE + " ("
        + Message.COLS[0] + " integer primary key autoincrement, "
        + Message.COLS[1] + " unique text not null,"
        + Message.COLS[2] + " text not null, "
        + Message.COLS[3] + " text not null," 
        + Message.COLS[4] + " text not null,"  
        +" FOREIGN KEY (forum_id) REFERENCES forums(id)"
        +");";
    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String id;
    private String name;
    private String data;
    private String forumId;

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

    public String getData() {

        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}
  
}
