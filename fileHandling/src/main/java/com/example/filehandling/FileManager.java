package com.example.filehandling;
import android.content.Context;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static File createFile(Context context, String fileName) {
        File file = new File(context.getFilesDir(), fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static File createFolder(Context context, String folderName) {
        File folder = new File(context.getFilesDir(), folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }

    public static void writeFile(Context context, String fileName, String content) {
        File file = new File(context.getFilesDir(), fileName);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(Context context, String fileName) {
        File file = new File(context.getFilesDir(), fileName);
        if (file.exists()) {
            try {
                FileReader reader = new FileReader(file);
                char[] buffer = new char[(int) file.length()];
                reader.read(buffer);
                reader.close();
                return new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static boolean deleteFile(Context context, String fileName) {
        File file = new File(context.getFilesDir(), fileName);
        return file.delete();
    }
}
