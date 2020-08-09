package Lesson2_dz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import static Lesson_2.MainDB.connect;
import static Lesson_2.MainDB.disconnect;
import static java.sql.Types.INTEGER;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) throws FileNotFoundException {

        try {
            connect();
            create("Students");
            insert("Students","Bob1",10);
            System.out.println("1");
            insert("Students","Bob2",20);
            System.out.println("2");
            insert("Students","Bob3",30);
            System.out.println("3");
            update("Students", 2, 60);

            readFile();
            System.out.println("Прочли файл");


            clear("Students");
            drop();
            System.out.println("Завершение работы");
            disconnect();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void create(String name) throws SQLException {

        stmt.executeUpdate(" CREATE TABLE IF NOT EXISTS " + name + "(" +
                               " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                               " name TEXT, " +
                               " score INTEGER )");
    }

    public static void insert(String tableName, String name, int score) throws SQLException {
        String sql = String.format("INSERT INTO '%s' (name, score) values ('%s', '%d');", tableName, name, score);
        stmt.executeUpdate(sql);

    }

    public static void update(String tableName, int id, int score) throws SQLException {
        String sql = String.format("UPDATE '%s' SET score = '%d' WHERE id = '%d';", tableName, score, id);
        stmt.executeUpdate(sql);

    }

    public static void clear(String name) throws SQLException {
        stmt.executeUpdate("DELETE FROM " + name);
    }

    public static void drop() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS Students;");
    }

    public static void readFile() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("update.txt");
        Scanner scaner = new Scanner(fileInputStream);

        while (scaner.hasNext()){
            String[] str = scaner.nextLine().split(" ");
            try {

            insert("Students", str[1], Integer.parseInt(str[2]));
            System.out.println(str[1] + " " + str[2]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        scaner.close();
    }
    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}

