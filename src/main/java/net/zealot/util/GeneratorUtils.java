package net.zealot.util;

import java.util.Iterator;

/** Integer and Character range generator */
public final class GeneratorUtils {
  private GeneratorUtils() {}

  /** check whether the parameters are legal */
  private static void checkParams(int start, int end, int step) {
    if ((start < end && step < 0) || (start > end && step > 0) || (start != end && step == 0)) {
      throw new IllegalArgumentException();
    }
  }

  public static Iterable<Integer> range(int end) {
    return range(0, end);
  }

  public static Iterable<Integer> range(int start, int end) {
    return range(start, end, 1);
  }

  /** end is exclusive */
  public static Iterable<Integer> range(final int start, final int end, final int step) {
    checkParams(start, end, step);
    final boolean isIncre = start < end;
    return new Iterable<Integer>() {

      public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
          int i = start;

          public boolean hasNext() {
            return isIncre ? i < end : i > end;
          }

          public Integer next() {
            int j = i;
            i += step;
            return j;
          }

          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }
}
