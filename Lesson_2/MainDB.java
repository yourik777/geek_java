package Lesson_2;

import java.sql.*;

public class MainDB {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
//           ResultSet rs = stmt.executeQuery("SELECT id, name FROM students where id > 1");
//           ResultSetMetaData rsmd = rs.getMetaData();
//
//            for (int i = 1; i < rsmd.getColumnCount(); i++) {
//                System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i) + " " + rsmd.getTableName(i));
//            }

//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
//            }

//            boolean res = stmt.execute("DROP TABLE students");
//            System.out.println(res);

//            stmt.executeUpdate(" CREATE TABLE students (" +
//                    " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                    " name TEXT, " +
//                    " score INTEGER )");


//            long t = System.currentTimeMillis();
//            connection.setAutoCommit(false);
//            for (int i = 0; i < 1000; i++) {
//                stmt.addBatch("INSERT INTO students (name, score) VALUES ('unknow', 100)");
//            }
//            stmt.executeBatch();
//            connection.setAutoCommit(true);
//            System.out.println(System.currentTimeMillis() - t);

//            pstmt = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?,?);");
////            for (int i = 0; i < 10; i++) {
////                pstmt.setString(1, "Bob" + i);
////                pstmt.setInt(2, i * 10);
////                pstmt.addBatch();
////            }
////         //   connection.commit();
////            pstmt.executeBatch();

            stmt.executeUpdate("INSERT INTO students (name, score) values ('Bob1', 10);");
            Savepoint spl = connection.setSavepoint();
            //connection.setAutoCommit(false);
            try {
                stmt.executeUpdate("INSERT INTO students (name, score) values ('Bob2', 20);");
            } catch (Exception e) {
                connection.rollback(spl);
            }

            connection.setAutoCommit(true);
            stmt.executeUpdate("INSERT INTO students (name, score) values ('Bob3', 30);");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        // далее работаем БД


    }


    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
