package googleTest.fromRoma;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Task5 {

    /*
    Fuel Injection Perfection
=========================

Commander Lambda has asked for your help to refine the automatic quantum antimatter fuel injection
system for the LAMBCHOP doomsday device. It's a great chance for you to get a closer look at the 
LAMBCHOP -- and maybe sneak in a bit of sabotage while you're at it -- so you took the job gladly. 

Quantum antimatter fuel comes in small pellets, which is convenient since the many moving parts of 
the LAMBCHOP each need to be fed fuel one pellet at a time. However, minions dump pellets in bulk 
into the fuel intake. You need to figure out the most efficient way to sort and shift the pellets 
down to a single pellet at a time. 

The fuel control mechanisms have three operations: 

1) Add one fuel pellet
2) Remove one fuel pellet
3) Divide the entire group of fuel pellets by 2 (due to the destructive energy released when a 
quantum antimatter pellet is cut in half, the safety controls will only allow this to happen if 
there is an even number of pellets)

Write a function called solution(n) which takes a positive integer as a string and returns the 
minimum number of operations needed to transform the number of pellets to 1. The fuel intake
 control panel can only display a number up to 309 digits long, so there won't ever be more 
 pellets than you can express in that many digits.

For example:
solution(4) returns 2: 4 -> 2 -> 1
solution(15) returns 5: 15 -> 16 -> 8 -> 4 -> 2 -> 1
Quantum antimatter fuel comes in small pellets, which is convenient since the many moving parts 
of the LAMBCHOP each need to be fed fuel one pellet at a time. However, minions dump pellets in 
bulk into the fuel intake. You need to figure out the most efficient way to sort and shift the 
pellets down to a single pellet at a time. 

The fuel control mechanisms have three operations: 

1) Add one fuel pellet
2) Remove one fuel pellet
3) Divide the entire group of fuel pellets by 2 (due to the destructive energy released when a
quantum antimatter pellet is cut in half, the safety controls will only allow this to happen if
there is an even number of pellets)

Write a function called solution(n) which takes a positive integer as a string and returns the
minimum number of operations needed to transform the number of pellets to 1. The fuel intake
control panel can only display a number up to 309 digits long, so there won't ever be more pellets
than you can express in that many digits.

For example:
solution(4) returns 2: 4 -> 2 -> 1
solution(15) returns 5: 15 -> 16 -> 8 -> 4 -> 2 -> 1

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit Solution.java

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

-- Python cases --
Input:
solution.solution('15')
Output:
    5

Input:
solution.solution('4')
Output:
    2

-- Java cases --
Input:
Solution.solution('4')
Output:
    2

Input:
Solution.solution('15')
Output:
    5

1, 2
2, 5
3, 5
4, 6
5, 6
6, 15
7, 4
8, 1347
    1536
     */

    public static void main(String[] args) {
        System.out.println(solutionLeetCode("1101"));
        System.out.println(solutionLeetCode("10"));
        System.out.println(solutionLeetCode("1"));
        System.out.println(solutionLeetCode("1111011110000011100000110001011011110010111001010111110001"));
        System.out.println(solutionLeetCode("1111110011101010110011100100101110010100101110111010111110110010"));
//        System.out.printf("1, %s%n", solution("4"));
//        System.out.printf("2, %s%n", solution("15"));
//        System.out.printf("3, %s%n", solution("32"));
//        System.out.printf("4, %s%n", solution("31"));
//        System.out.printf("5, %s%n", solution("33"));
//        System.out.printf("6, %s%n", solution("32768"));
//        System.out.printf("7, %s%n", solution("9"));
//        long startTime = System.nanoTime();
//        System.out.printf("8, %s%n", solution("377781123123777811231237778112312377781123123777811231237778112312377781123123777811231237778112312377781123123777811231237778112312377781123123777811231237778112312377781123123777811231237778112312377781123123777811231237778112312377781123123777811231237778112312377781123123777811231237778112312377781123123"));
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//        System.out.println(duration);
    }

    static Map<BigInteger, Integer> pathList = new HashMap<>();
    private static int solution(String s) {
        var number = new BigInteger(s);
        if (pathList.containsKey(number)) {
            return pathList.get(number);
        }
        var res = 0;
        while (number.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) {
            number = number.divide(BigInteger.TWO);
            res++;
        }
        if (number.equals(BigInteger.ONE)) {
            return res;
        }
        var first = solution(number.add(BigInteger.ONE).toString());
        var second = solution(number.subtract(BigInteger.ONE).toString());
        int min = Math.min(first, second) + res + 1;
        pathList.put(new BigInteger(s), min);
        return min;
    }


    private static int solutionLeetCode(String s) {
        long number =Long.parseLong(s,2);
        short res = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number += 1;
            }
            res++;
        }
        return res;
    }

    public static int solutionNew(String x) {
        globalMin =Integer.MAX_VALUE;
        BigInteger number = new BigInteger(x);
        return shortestPath(number, 0);
    }

    static int globalMin;
    /**
     * recursive solution with prunning
     * @param number
     * @return
     */
    public static int shortestPath(BigInteger number, int alreadyPassed){
        if(number.compareTo(BigInteger.ZERO) <= 0){
            return Integer.MAX_VALUE;
        }

        if (number.equals(BigInteger.ONE)){
            return 1;
        }

        int stepsNumber = 0;
        while (!number.testBit(0)){
            stepsNumber++;
            if(stepsNumber + alreadyPassed > globalMin ){
                System.out.println("Prunning for number " + number);
                return Integer.MAX_VALUE;
            }
            number = number.shiftRight(1);
        }

        if (number.equals(BigInteger.ONE)){
            globalMin = alreadyPassed + stepsNumber;
            return alreadyPassed + stepsNumber;
        }

        int nextAlreadyPassed = stepsNumber + alreadyPassed + 1;
        stepsNumber += Math.min(shortestPath(number.add(BigInteger.ONE), nextAlreadyPassed), shortestPath(number.subtract(BigInteger.ONE), nextAlreadyPassed));
        return stepsNumber;
    }
}
