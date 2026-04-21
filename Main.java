import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream("db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Error: Could not find db.properties file.");
            return;
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String pass = props.getProperty("db.pass");

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to database successfully.");
            StudentDAO dao = new StudentDAO(conn);

            while (true) {
                System.out.println("\n1.Insert\n2.Search\n3.Fetch\n4.Update\n5.Delete\n6.Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Age: ");
                        int age = sc.nextInt();
                        dao.insertStudent(name, age);
                        break;

                    case 2:
                        System.out.print("ID: ");
                        dao.searchStudent(sc.nextInt());
                        break;

                    case 3:
                        dao.fetchAllStudents();
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Name: ");
                        String n = sc.nextLine();
                        System.out.print("New Age: ");
                        int a = sc.nextInt();
                        dao.updateStudent(id, n, a);
                        break;

                    case 5:
                        System.out.print("ID: ");
                        dao.deleteStudent(sc.nextInt());
                        break;

                    case 6:
                        return;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}