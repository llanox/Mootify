package co.edu.udea.campusmovil.notificador.model;

public class Forum {

    public static String[] COLS = new String[] {"consecutive_id", "id", "name", "type", "course_id"};
    public static String DATABASE_TABLE = "forums";

    public static String TABLE_CREATE = "create table " + Forum.DATABASE_TABLE + " ("
        + Forum.COLS[0] + " integer primary key autoincrement, "
        + Forum.COLS[1] + " text not null,"
        + Forum.COLS[2] + " text not null, "
        + Forum.COLS[3] + " text not null, "
        + Forum.COLS[4] + " text not null, "
        + "UNIQUE (" + Forum.COLS[1] + "), "
        + "FOREIGN KEY (" + Forum.COLS[4] + ") REFERENCES courses(" + Forum.COLS[1] + "));";

    private int consecutive_id;
    private String id;
    private String name;
    private String type;
    private String courseId;

    public Forum(String id, String name, String type, String courseId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.courseId = courseId;
    }

    public int getConsecutive_id() {

        return consecutive_id;
    }

    public void setConsecutive_id(int consecutive_id) {
        this.consecutive_id = consecutive_id;
    }

    public String getCourseId() {

        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
