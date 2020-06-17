package pacman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class fileConverter {
    public fileConverter(char[][] matrix){

    try{
        System.out.println(matrix.length);
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < matrix.length; i++)//for each row
            {
                for(int j = 0; j < matrix[i].length; j++)//for each column
                {if(matrix[i][j] == '0') {
                    builder.append('%' + "");//if its a wall
                }else if(matrix[i][j] == '1'){
                    builder.append(' ' + "");//if its a path
                }else if(matrix[i][j] == '.'){
                    builder.append('.' + "");//append to the output string
                }else if(matrix[i][j] == 'P'){
                    builder.append('.' + "");//append to the output string
                }
                else if(matrix[i][j] == 'V'){
                    builder.append(' ' + "");//append to the output string
                }

                }
                builder.append("\n");//append new line at the end of the row
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("haha.txt"));
            writer.write(builder.toString());//save the string representation of the board
            writer.close();
    }



        catch(IOException e){
            System.out.println(e);
        }

    }
}
