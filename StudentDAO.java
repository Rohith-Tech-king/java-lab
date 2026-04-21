import java.sql.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertStudent(String name, int age) throws SQLException {
        String sql = "INSERT INTO student (name, age) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, age);
        System.out.println(ps.executeUpdate() + " inserted");
    }

    public void searchStudent(int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println(rs.getInt("id") + " " +
                               rs.getString("name") + " " +
                               rs.getInt("age"));
        } else {
            System.out.println("Not found");
        }
    }

    public void fetchAllStudents() throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " +
                               rs.getString(2) + " " +
                               rs.getInt(3));
        }
    }

    public void updateStudent(int id, String name, int age) throws SQLException {
        String sql = "UPDATE student SET name=?, age=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setInt(3, id);
        System.out.println(ps.executeUpdate() + " updated");
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        System.out.println(ps.executeUpdate() + " deleted");
    }
}