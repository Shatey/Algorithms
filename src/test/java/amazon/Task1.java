package amazon;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    @Test
    void test1() {
        var list = cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1);
        System.out.println(list);
        list = cellCompete(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2);
        System.out.println(list);

    }

    @Test
    void test2() {
        var gcd = generalizedGCD(5, new int[]{2,4,6,8,10});
        System.out.println(gcd);

    }

    public int generalizedGCD(int num, int[] arr) {
        int tmp = 1;
        int res = 1;
        int count = 0;
        int length = arr.length;
        int max = 0;
        while (true) {
            for (int i : arr) {
                if (i / tmp >= 1 && i % tmp == 0) {
                    count++;
                }
                if (i / tmp == 0 && i % tmp != 0) {
                    max++;
                }
            }
            if (count == num) {
                res = tmp;
            }
            if (length - max < num) {
                break;
            }
            count = 0;
            max = 0;
            tmp++;
        }
        return res;
    }

    int gcd(int a, int b) {
        if (a == 0){
            return b;
        } else if (b == 0) {
            return a;
        } else if (a == b) {
            return a;
        } else if (a > b) {
            return gcd(a-b, b);
        } else {
            return gcd(a, b-a);
        }
    }


    public List<Integer> cellCompete(int[] states, int days) {
        List<Integer> res = new ArrayList<>();
        while (days-- > 0) {
            res.clear();
            for (int i = 0; i < states.length; i++) {
                if (i == 0) {
                    res.add(states[i + 1] == 0 ? 0 : 1);
                } else if (i == states.length - 1) {
                    res.add(states[i - 1] == 0 ? 0 : 1);
                } else {
                    res.add(states[i - 1] == states[i + 1] ? 0 : 1);
                }
            }
            states = res.stream().mapToInt(i -> i).toArray();
        }
        return res;
    }
}
