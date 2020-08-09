package Lesson_3;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            socket = server.accept();

            Student student = new Student(1, "Bob");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(student);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
