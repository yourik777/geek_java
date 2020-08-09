package Lesson_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 8189);


            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Student s2 = (Student)ois.readObject();
            ois.close();
            s2.info();



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
