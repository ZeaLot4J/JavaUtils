package net.zealot.util;

import static net.zealot.util.GeneratorUtils.range;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;

public class GeneratorUtilsTest {
  @Test
  public void testRangeInt1() {
    int start = 0, end = 9999, step = 3;
    List<Integer> actualList = new ArrayList<>();
    List<Integer> expectedList = new ArrayList<>();
    for (int i : range(start, end, step)) {
      actualList.add(i);
    }
    for (int i = start; i < end; i += step) {
      expectedList.add(i);
    }
    assertArrayEquals(actualList.toArray(), expectedList.toArray());
  }

  @Test
  public void testRangeInt2() {
    int start = 9999, end = 0, step = -5;
    List<Integer> actualList = new ArrayList<>();
    List<Integer> expectedList = new ArrayList<>();
    for (int i : range(start, end, step)) {
      actualList.add(i);
    }
    for (int i = start; i > end; i += step) {
      expectedList.add(i);
    }
  }

  @Test
  public void testRangeInt3() {
    int start = 9999, end = 9999, step = 9;
    List<Integer> list = new ArrayList<>();
    for (int i : range(start, end, step)) {
      list.add(i);
    }
    assertTrue(list.isEmpty());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRangeIntException1() {
    int start = 0, end = 9999, step = -3;
    for (int i : range(start, end, step)) {}
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRangeIntException2() {
    int start = 9999, end = 9, step = 5;
    for (int i : range(start, end, step)) {}
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRangeIntException3() {
    int start = 9999, end = 9, step = 0;
    for (int i : range(start, end, step)) {}
  }
}
