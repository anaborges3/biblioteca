package br.com.biblioteca;

import java.io.*;

public class SerializationUtil {
    public static void serialize(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

