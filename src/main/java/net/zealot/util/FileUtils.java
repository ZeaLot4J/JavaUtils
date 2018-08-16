package net.zealot.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** File utils to conveniently read and write with files using character stream */
public class FileUtils {
  public static void main(String[] args) {
    String dir = System.getProperty("user.dir");
    File dest = new File(dir, "pom.xml");
    File origin = new File(dir, "pom.gz");
  }

  private static int DEFAULT_BUFFER_SIZE = 1024;

  public static String readFile(String filename) {
    return readFile(new File(filename));
  }

  public static String readFile(File file) {
    StringBuilder sb = new StringBuilder();
    String line = null;
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }

  public static void writeFile(String filename, Object content) {
    writeFile(new File(filename), content, false);
  }

  public static void writeFile(File file, Object content) {
    writeFile(file, content, false);
  }

  public static void writeFile(File file, Object content, boolean doAppend) {
    BufferedWriter bw = null;
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      bw = new BufferedWriter(new FileWriter(file, doAppend));
      bw.write(content.toString());
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bw != null) {
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
