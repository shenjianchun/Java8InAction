package demo.chap7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStream {

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i++)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(Long::sum).get();
    }

    public static long rangeSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(Long::sum)
                .getAsLong();
    }

}
