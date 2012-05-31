package co.edu.udea.campusmovil.notificador.model;

public class Message {

    public static String[] COLS = new String[] {"id", "idforum", "name", "data"};
    public static String DATABASE_TABLE = "messages";

    public static String TABLE_CREATE = "create table " + Message.DATABASE_TABLE + " ("
        + Message.COLS[0] + " integer primary key autoincrement, "
        + Message.COLS[1] + " text not null,"
        + Message.COLS[2] + " text not null, "
        + Message.COLS[3] + " text not null);";

    private String id;
    private String name;
    private String data;
    private String idForum;

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
    public String getIdForum() {

        return idForum;
    }

    public void setIdForum(String idForum) {
        this.idForum = idForum;
    }
}
