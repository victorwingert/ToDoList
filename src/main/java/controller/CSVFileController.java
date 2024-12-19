package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileController {

    public static List<String[]> readCSV(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void addCSV(String filePath, String[] newRow) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < newRow.length; i++) {
                sb.append(newRow[i]);
                if (i < newRow.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("\n");
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
