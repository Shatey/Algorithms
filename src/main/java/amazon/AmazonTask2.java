package amazon;

import java.util.List;
import java.util.stream.Collectors;

public class AmazonTask2 {

    public static long maximumQuality(List<Integer> packets, int channels) {
        double res = 0;
        int size = packets.size();
        if (size == 0) {
            res = 1;
        } else if (size == channels) {
            res = packets.stream()
                    .reduce(0, Integer::sum);
        } else {
            packets = packets.stream().sorted().collect(Collectors.toList());
            for (int i = size - channels + 1; i < size; i++) {
                res += packets.get(i);
            }
            size -= channels;
            if (size % 2 == 0) {
                res += packets.get(size / 2);
            } else {
                double value = packets.get(size / 2) + packets.get((size / 2) + 1);
                res += value / 2;
            }
        }
        return (long) Math.ceil(res);
    }
}
