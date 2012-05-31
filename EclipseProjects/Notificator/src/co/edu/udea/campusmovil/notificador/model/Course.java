package co.edu.udea.campusmovil.notificador.model;

public class Course {

    public static String[] COLS = new String[] {"id", "name"};
    public static String DATABASE_TABLE = "courses";

    public static String TABLE_CREATE = "create table " + Course.DATABASE_TABLE + " ("
        + Course.COLS[0] + " integer primary key autoincrement, "
        + Course.COLS[1] + " text not null);";

    private String id;
    private String name;

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
}
