package net.zealot.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** File utils to conveniently read and write with files using character stream */
public class FileUtils {
  public static void main(String[] args) {
    String path =
        File.separator + "root" + File.separator + ".emacs.d" + File.separator + "test.txt";
    File file = new File(path);
    //    String result = readFile(path);
    writeFile(path, " Lancelot", true);
  }

  public static String readFile(String filename) {
    File file = new File(filename);
    if (!file.exists()) {
      try {
        throw new FileNotFoundException("file " + filename + " not found.");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (!file.isFile()) {
      throw new RuntimeException("file " + filename + " is not a file.");
    }
    StringBuilder sb = new StringBuilder();
    String line = null;
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      while ((line = br.readLine()) != null) {
        sb.append(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();
  }

  public static void writeFile(String filename, Object content, boolean doAppend) {
    File file = new File(filename);
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
