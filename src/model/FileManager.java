package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileManager<T> {
    private static FileManager<?> instance;
    private File dataFolder = new File(System.getProperty("user.dir"));
    private File jsonFile;

    private FileManager() {
        dataFolder = new File(dataFolder + "./data");
        jsonFile = new File(dataFolder, "persistence.json");
    }

    public static FileManager<?> getInstance() {
        if (instance == null) {
            instance = new FileManager<>();
        }
        return instance;
    }

    private void createResources() throws IOException {
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();
            }
        }
    }


    public <T> void saveToJson(ArrayList<T> arr) throws IOException {
        createResources();
        Gson gson = new Gson();
        FileOutputStream fos = new FileOutputStream(jsonFile);
        String data = gson.toJson(arr);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        writer.close();
    }

    public <T> ArrayList<T> loadFromJson(Class<T> clazz) throws IOException {
        createResources();
        Gson gson = new Gson();
        FileInputStream fis = new FileInputStream(jsonFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        StringBuilder content = new StringBuilder();
        String line = "";
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        Type type = TypeToken.getParameterized(ArrayList.class, clazz).getType();
        return gson.fromJson(content.toString(), type);
    }
}



