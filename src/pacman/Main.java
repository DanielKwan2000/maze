package pacman;
/*
 * Testing BFS for bigMaze.txt
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pacman.*;
public class Main {

    public static void main(String args[])
    {   int nodes_explored = 0;
        //char[][] a = MazeReader.arr;
        MazeReader b = new MazeReader("src/pacman/bigMaze.txt");
        //constructor


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
        int x_a = 0;
        char[][] pathExists = breakfast(a, start_x, start_y, end_x, end_y);

        for(int i = 0; i < pathExists.length; i++){
            System.out.println(Arrays.toString(pathExists[i]));
            for(int j =0; j< pathExists.length; j++){
                if(pathExists[i][j] == 'P') nodes_explored++;
            }
        }
        System.out.println("Explored nodes: " + nodes_explored);

    }

    public static char[][] breakfast(char[][] matrix, int start_x, int  start_y, int end_x, int end_y) {
        //System.out.println(matrix.length);
        //how many rows it has
        int N = matrix.length;

        int count = 0;

        List<Node> queue = new ArrayList<Node>();
        queue.add(new Node(start_x, start_y, null)); //insert starting position node <- want to mark visited and check neighbours
        boolean pathExists = false;

        while(!queue.isEmpty()) { //not empty
            Node current = queue.remove(0); //dequeue first
            //just to see the path
            if(matrix[current.x][current.y] ==  matrix[end_x][end_y]) {
                pathExists = true;
                while(current.prev != null){
                    System.out.println( current.prev.x + " " + current.prev.y);
                    matrix[current.prev.x][current.prev.y] = 'P';
                    current = current.prev;
                }
                break;
            }
            count ++; //to keep track of movements for testing purposes

            matrix[current.x][current.y] = '0'; // mark as visited

            List<Node> neighbors = getNeighbors(matrix, current); //now we check neighbours, pass current node
            queue.addAll(neighbors);
        }
        System.out.println(count);
        return matrix;
    }

    public static List<Node> getNeighbors(char[][] matrix, Node current) {
        List<Node> neighbors = new ArrayList<Node>(); //create list of neighbours
        //down
        if(isValid(matrix, current.x + 1, current.y)) {
            neighbors.add(new Node(current.x + 1, current.y,current));
        }
        //up
        if(isValid(matrix, current.x - 1, current.y)) {
            neighbors.add(new Node(current.x - 1, current.y,current));
        }
        //right
        if(isValid(matrix, current.x, current.y + 1)) {
            neighbors.add(new Node(current.x, current.y + 1,current));
        }
        //left
        if(isValid(matrix, current.x, current.y - 1)) {
            neighbors.add(new Node(current.x, current.y - 1,current));
        }


        return neighbors;
    }
    //pass matrix and the coords
    public static boolean isValid(char[][] matrix, int x, int y) {
        //not visited and not wall
        return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0');
        //x and y pos can't be negative , out of bounds and can't be greater than length of matrix
    }

}
