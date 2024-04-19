package com.example.prac8;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FileHelper {

    private static final String FILE_NAME = "blood_group_info.txt";
    private static final String UserFile="user_info.txt";
    // Method to write blood group data to the file
    public static void writeToFile(Context context, String data) {
        try (FileOutputStream fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)) {
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFile1(Context context, String data) {
        try (FileOutputStream fileOutputStream = context.openFileOutput(UserFile, Context.MODE_PRIVATE)) {
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read blood group data from the file
    public static String readFromFile(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = context.openFileInput(FILE_NAME);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
    public static String readFromFile1(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = context.openFileInput(UserFile);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    // Method to count occurrences of different blood groups and write the counts to a file
    public static String countAndWriteBloodGroupCounts(Context context, String data) {
        Map<String, Integer> bloodGroupCounts = new HashMap<>();

        // Assuming each line in the data represents a person's blood group
        String[] bloodGroups = data.split("\n");

        // Count occurrences of each blood group
        for (String bloodGroup : bloodGroups) {
            // Trim any leading or trailing whitespaces
            bloodGroup = bloodGroup.trim();

            // Increment the count for the blood group
            bloodGroupCounts.put(bloodGroup, bloodGroupCounts.getOrDefault(bloodGroup, 0) + 1);
        }

        // Create a String with blood group counts
        StringBuilder countData = new StringBuilder();
        for (Map.Entry<String, Integer> entry : bloodGroupCounts.entrySet()) {
            countData.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return countData.toString();
    }

}
