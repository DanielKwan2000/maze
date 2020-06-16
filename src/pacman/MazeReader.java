package pacman;
/*
 * text maze reader to translate symbols and spaces into 2D array for BFS implementation
 */

//line count big = 37
import java.io.*;
import java.util.*;
public class MazeReader{
    public static int start_x = 0; //starting x pos
    public static int start_y = 0; //starting y pos for big maze.txt
    public static int end_x = 0; //ending x pos
    public static int end_y = 0; //ending y pos
    public static char[][] arr = new char[37][37];

    public MazeReader() {
        try {
            //read file into 2D array for position x,y
            File file = new File("src/pacman/bigMaze.txt");

            BufferedReader a = new BufferedReader(new FileReader(file));

            String l;
            int x_index = 0;
            //just x counter
            while ((l = a.readLine()) != null) {
                //position for 2d array
                for (int i = 0; i < l.length(); i++) {

                    if (l.charAt(i) == '%') {
                        arr[x_index][i] = '0';
                    } else if (l.charAt(i) == 'P') {
                        end_x = x_index;
                        end_y = i;
                        arr[x_index][i] = 'X';
                    } else if (l.charAt(i) == '.') {
                        arr[x_index][i] = 'S';
                        start_x = x_index;
                        start_y = i;
                    } else {
                        arr[x_index][i] = '1';
                    }
                }
                x_index++;

            }
        } catch (IOException e) {
            System.out.println("haha");
        }
        //testing
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
    //return our 2d array for use
    public static char[][] getArr() {
        return arr;
    }
    //gets the starting position if needed
    public static int getStart_x(){
        return start_x;
    }
    public static int getStart_y(){
        return start_y;
    }
    public static int getEnd_x(){
        return end_x;
    }
    public static int getEnd_y(){
        return end_y;
    }
}




