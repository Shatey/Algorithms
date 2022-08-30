package googleTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTask5 {

    /*
    Prepare the Bunnies' Escape
===========================

You're awfully close to destroying the LAMBCHOP doomsday device and freeing Commander Lambda's bunny workers, but once they're free of the work duties the bunnies are going to need to escape Lambda's space station via the escape pods as quickly as possible. Unfortunately, the halls of the space station are a maze of corridors and dead ends that will be a deathtrap for the escaping bunnies. Fortunately, Commander Lambda has put you in charge of a remodeling project that will give you the opportunity to make things a little easier for the bunnies. Unfortunately (again), you can't just remove all obstacles between the bunnies and the escape pods - at most you can remove one wall per escape pod path, both to maintain structural integrity of the station and to avoid arousing Commander Lambda's suspicions.

You have maps of parts of the space station, each starting at a work area exit and ending at the door to an escape pod. The map is represented as a matrix of 0s and 1s, where 0s are passable space and 1s are impassable walls. The door out of the station is at the top left (0,0) and the door into an escape pod is at the bottom right (w-1,h-1).

Write a function solution(map) that generates the length of the shortest path from the station door to the escape pod, where you are allowed to remove one wall as part of your remodeling plans. The path length is the total number of nodes you pass through, counting both the entrance and exit nodes. The starting and ending positions are always passable (0). The map will always be solvable, though you may or may not need to remove a wall. The height and width of the map can be from 2 to 20. Moves can only be made in cardinal directions; no diagonal moves are allowed.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit expandingNebula.Solution.java

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

-- Python cases --
Input:
solution.solution([[0, 1, 1, 0], [0, 0, 0, 1], [1, 1, 0, 0], [1, 1, 1, 0]])
Output:
    7

Input:
solution.solution([[0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 1], [0, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0, 0]])
Output:
    11

-- Java cases --
Input:
expandingNebula.Solution.solution(
{
{0, 1, 1, 0},
{0, 0, 0, 1},
{1, 1, 0, 0},
{1, 1, 1, 0}})
Output:
    7

Input:
expandingNebula.Solution.solution(
{
{0, 0, 0, 0, 0, 0},
{1, 1, 1, 1, 1, 0},
{0, 0, 0, 0, 0, 0},
{0, 1, 1, 1, 1, 1},
{0, 1, 1, 1, 1, 1},
{0, 0, 0, 0, 0, 0}})
Output:
    11
     */
//    @Test
    void test() {
        int[][] arr = {
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        };
        var res = solution(arr);
        assertEquals(7, res);
        arr = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        res = solution(arr);
        assertEquals(11, res);
    }

    public static int solution(int[][] map) {
        // Your code here
        var isWallRemoved = false;
        var length = 1;
        var removedWallPos = new int[]{-1, -1};
        var prevPos = new int[]{-1, -1};
        var isSolved = false;
        var i = 0;
        var j = 0;
        while (!isSolved) {
            if (!isWallRemoved) {
                if (j + 1 < map[0].length && map[i][j + 1] == 1) {
                    if (j + 2 < map[0].length && map[i][j + 2] == 0 /*||
                                i + 1 < map.length && map[i + 1][j + 1] == 0 ||
                                i - 1 >= 0 && map[i - 1][j + 1] == 0*/) {
                        prevPos[0] = i;
                        prevPos[1] = j;
                        j += 1;
                        isWallRemoved = true;
                    }
                } /*else if (j - 1 >= 0 && map[i][j - 1] == 1) {
                        if (j - 2 >= 0 && map[i][j - 2] == 0 ||
                                i + 1 < map.length && map[i + 1][j - 1] == 0 ||
                                i - 1 >= 0 && map[i - 1][j - 1] == 0) {
                            prevPos[0] = i;
                            prevPos[1] = j;
                            j -= 1;
                            isWallRemoved = true;
                        }
                    }*/ else if (i + 1 < map.length && map[i + 1][j] == 1) {
                    if (i + 2 < map.length && map[i + 2][j] == 0/* ||
                                j + 1 < map[0].length && map[i + 1][j + 1] == 0 ||
                                j - 1 >= 0 && map[i + 1][j - 1] == 0*/) {
                        prevPos[0] = i;
                        prevPos[1] = j;
                        i += 1;
                        isWallRemoved = true;
                    }
                } else if (i - 1 >= 0 && map[i - 1][j] == 1) {
                    if (i - 2 >= 0 && map[i - 2][j] == 0 ||
                            j + 1 < map[0].length && map[i - 1][j + 1] == 0 ||
                            j - 1 >= 0 && map[i - 1][j - 1] == 0) {
                        prevPos[0] = i;
                        prevPos[1] = j;
                        i -= 1;
                        isWallRemoved = true;
                    }
                }
                if (isWallRemoved) {
                    removedWallPos[0] = i;
                    removedWallPos[1] = j;
                    i = map.length - 1;
                    j = map[0].length - 1;
                    length += 1;
                }
            }
//                if (i + 1 < map.length && map[i + 1][j] == 0 && i + 1 != prevPos[0]) {
//                    prevPos[0] = i;
//                    prevPos[1] = j;
//                    i += 1;
//                    length += 1;
//                } else if (i - 1 >= 0 && map[i - 1][j] == 0 && i - 1 != prevPos[0]) {
//                    prevPos[0] = i;
//                    prevPos[1] = j;
//                    i -= 1;
//                    length += 1;
//                } else if (j + 1 < map[0].length && map[i][j + 1] == 0 && j + 1 != prevPos[1]) {
//                    prevPos[0] = i;
//                    prevPos[1] = j;
//                    j += 1;
//                    length += 1;
//                } else if (j - 1 >= 0 && map[i][j - 1] == 0 && j - 1 != prevPos[1]) {
//                    prevPos[0] = i;
//                    prevPos[1] = j;
//                    j -= 1;
//                    length += 1;
//                }
            if (isSolved(map, prevPos, removedWallPos, i, j)) {
                length = isWallRemoved ? length : length + 1;
                isSolved = true;
            }
        }
        return length;
    }

    private static boolean isSolved(int[][] map, int[] prevPos, int[] removedWallPos, int i, int j) {
        var isSolved = false;
        if (i + 1 != prevPos[0] || j + 1 != prevPos[1]) {
            isSolved = i + 1 == map.length - 1 && j == map[0].length - 1 ||
                    j + 1 == map[0].length - 1 && i == map.length - 1 ||
                    i + 1 == removedWallPos[0] && j == removedWallPos[1] ||
                    j + 1 == removedWallPos[1] && i == removedWallPos[0];
        }
        return isSolved;
    }

}
