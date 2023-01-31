import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreT {
  public static void main(String[] args) {
	String score;		//file save variable
	String temp = "1";	//temporary transition variables
	int itemp = 1;
	int newScore = 300;
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));
	    while((score = reader.readLine()) != null) {	//reading file
	      System.out.printf("The current high score is: ");		//printing
	      System.out.println(score);
	      temp = score;		//transition for string -> integer conversion
	    }	
	    reader.close();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	
    try{
        int number = Integer.parseInt(temp);
        itemp = number;
    }
    catch (NumberFormatException ex){
        ex.printStackTrace();
    }
    if (newScore > itemp) {
    	try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt"));
            String s=String.valueOf(newScore);
            System.out.printf("New High Score is: ");
            System.out.println(s);
            writer.write(s);
            
            writer.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }
  }
}
