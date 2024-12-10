package university.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final Gson gson = new Gson();

    public static <T> List<T> loadFromFile(String fileName, Type typeOfList) {
        File file = new File(fileName);

        // If the file does not exist, create it with an empty array
        if (!file.exists()) {
            try (Writer writer = new FileWriter(file)) {
                writer.write("[]"); // Initialize with an empty JSON array
            } catch (IOException e) {
                System.err.println("Error initializing file: " + fileName);
                e.printStackTrace();
            }
        }

        // Load the data from the file
        try (Reader reader = new FileReader(file)) {
            List<T> data = gson.fromJson(reader, typeOfList);
            return data != null ? data : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static <T> void saveToFile(List<T> data, String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
            e.printStackTrace();
        }
    }
}
