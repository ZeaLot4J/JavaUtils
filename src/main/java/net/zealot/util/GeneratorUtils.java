package net.zealot.util;

import java.util.Iterator;

/** Integer and Character range generator */
public class GeneratorUtils {
  public static void main(String[] args) {
    for (char c : range('a', 'z')) {
      System.out.println(c);
    }
  }

  public static Iterable<Integer> range(int end) {
    return range(0, end);
  }

  public static Iterable<Integer> range(int start, int end) {
    return range(start, end, 1);
  }

  /** end is exclusive */
  public static Iterable<Integer> range(int start, int end, int step) {
    return new Iterable<Integer>() {
      int i = start;

      public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
          public boolean hasNext() {
            return i < end;
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

  public static Iterable<Character> range(char start, char end) {
    return range(start, end, 1);
  }

  /** end is inclusive */
  public static Iterable<Character> range(char start, char end, int step) {
    return new Iterable<Character>() {
      char i = start;

      public Iterator<Character> iterator() {
        return new Iterator<Character>() {
          public boolean hasNext() {
            return i <= end;
          }

          public Character next() {
            char j = i;
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
