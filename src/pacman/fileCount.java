package pacman;
/*
 * java class which counts columns and rows of file
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class fileCount {
    public static int r = 0;
    public static int c = 0;
    public fileCount(String file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(reader.readLine() != null){

                r++;
            }
            String firstLine = Files.readAllLines(Paths.get(file)).get(0);
            c = firstLine.length();
            System.out.println("row: " + r);
            System.out.println("col: "+ c);
            reader.close();

        }catch(IOException e){
            System.out.println("no file");
        }

    }

    public int getR(){
        return r;
    }
    public int getC(){
        return c;
    }
}
