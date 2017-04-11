package org.hypik.test.perf.testint;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class TestIntBox {
  
  int i = 0;
  int n = 0;
  
  @Benchmark
  public Integer testBoxing() {
    return boxing(n++, i++);
  }
  
  @Benchmark
  public int testNoBoxing() {
    return noboxing(n++, i++);
  }

  @Benchmark
  public Integer testNewInt() {
    return newInt(n++, i++);
  }

  @Benchmark
  public Integer testValueOfInt() {
    return valueOfInt(n++, i++);
  }
  
  private Integer boxing(int n, int i) {
    return n + i * 3;
  }

  private int noboxing(int n, int i) {
    return n + i * 3;
  }

  private Integer newInt(int n, int i) {
    return new Integer(n + i * 3);
  }

  private Integer valueOfInt(int n, int i) {
    return Integer.valueOf(n + i * 3);
  }
}
