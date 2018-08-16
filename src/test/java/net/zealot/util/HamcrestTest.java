package net.zealot.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class HamcrestTest {
  @Test
  public void test1() {
    assertThat(Long.valueOf(1), instanceOf(Long.class));
  }

  @Test
  public void test2() {
    List<Integer> list = Arrays.asList(5, 2, 4);
    assertThat(list, hasSize(3));
    assertThat(list, containsInAnyOrder(2, 5, 4));
    assertThat(list, everyItem(greaterThan(1)));
  }

  @Test
  public void test3() {
    Integer[] ints = new Integer[] {7, 5, 12, 16};
    assertThat(ints, arrayWithSize(4));
    assertThat(ints, arrayContaining(7, 5, 12, 16));
  }

}
