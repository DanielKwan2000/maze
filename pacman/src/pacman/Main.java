package pacman;
/*
 * Testing BFS for bigMaze.txt
 */
import java.util.*;
import java.lang.*;

import pacman.MazeReader;
import pacman.Node;
public class Main {

        public static void main(String args[])
        {
            //char[][] a = MazeReader.arr;
            MazeReader b = new MazeReader();
            char[][] a = b.getArr();
            int start_x = b.getStart_x();
            int start_y = b.getStart_y();
            int end_x = b.getEnd_x();
            int end_y = b.getEnd_y();
            //importing the starting and ending positions to check goal state.

            for (int i = 0; i < a.length; i++)
                System.out.println(Arrays.toString(a[i]));

            System.out.println("------------------");
            //0 for wall 1 for path
            boolean pathExists = breakfast(a, start_x, start_y, end_x, end_y);

            System.out.println(pathExists);
        }

        public static boolean breakfast(char[][] matrix, int start_x, int  start_y, int end_x, int end_y) {
            //System.out.println(matrix.length);
            //how many rows it has
            int N = matrix.length;

            List<Node> queue = new ArrayList<Node>();
            queue.add(new Node(start_x, start_y)); //insert starting position node <- want to mark visited and check neighbours
            boolean pathExists = false;

            while(!queue.isEmpty()) { //not empty
                Node current = queue.remove(0); //dequeue first

                if(matrix[current.x][current.y] ==  matrix[end_x][end_y]) {
                    pathExists = true;
                    break;
                }

                matrix[current.x][current.y] = '0'; // mark as visited

                List<Node> neighbors = getNeighbors(matrix, current); //now we check neighbours, pass current node
                queue.addAll(neighbors);
            }

            return pathExists;
        }

        public static List<Node> getNeighbors(char[][] matrix, Node current) {
            List<Node> neighbors = new ArrayList<Node>(); //create list of neighbours
            //up
            if(isValid(matrix, current.x - 1, current.y)) {
                neighbors.add(new Node(current.x - 1, current.y));
            }
            //down
            if(isValid(matrix, current.x + 1, current.y)) {
                neighbors.add(new Node(current.x + 1, current.y));
            }
            //left
            if(isValid(matrix, current.x, current.y - 1)) {
                neighbors.add(new Node(current.x, current.y - 1));
            }
            //right
            if(isValid(matrix, current.x, current.y + 1)) {
                neighbors.add(new Node(current.x, current.y + 1));
            }

            return neighbors;
        }
        //pass matrix and the coords
        public static boolean isValid(char[][] matrix, int x, int y) {

            return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0');
            //x and y pos can't be negative , out of bounds and can't be greater than length of matrix
        }



}
