package net.zealot.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import org.junit.*;

public class FileUtilsTest {

  @Test
  public void readFileTest() {
    String filePath = System.getProperty("user.dir") + File.separator + "README.md";
    String actualResult = FileUtils.readFile(filePath);
    System.out.println(actualResult);
    String expectedResult = "# JavaUtilsjava7 self-defined utils.";
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void writeFileTest() {
    String filePath =
        System.getProperty("user.dir")
            + File.separator
            + "resource"
            + File.separator
            + "config.properties";
    String expectedResult = "version=1.0.0";
    FileUtils.writeFile(filePath, expectedResult);
    String actualResult = FileUtils.readFile(filePath);
    assertEquals(expectedResult, actualResult);
  }
}
