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
            char[][] a= b.getArr();

            for (int i = 0; i < a.length; i++)
                System.out.println(Arrays.toString(a[i]));

            //0 for wall 1 for path
            boolean pathExists = breakfast(a);

            System.out.println(pathExists ? "YES" : "NO");
        }

        public static boolean breakfast(char[][] matrix) {
            //System.out.println(matrix.length);
            //how many rows it has
            int N = matrix.length;

            List<Node> queue = new ArrayList<Node>();
            queue.add(new Node(35, 1)); //insert starting position node <- want to mark visited and check neighbours
            boolean pathExists = false;

            while(!queue.isEmpty()) { //not empty
                Node current = queue.remove(0); //dequeue first

                if(matrix[current.x][current.y] == 'X') {
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
