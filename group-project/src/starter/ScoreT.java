import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreT {
  public static void main(String[] args) {
	String score;
	String temp = "1";
	int itemp = 1;
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));
	    while((score = reader.readLine()) != null) {
	      System.out.printf("The current high score is: ");
	      System.out.println(score);
	      temp = score;
	    }
	    reader.close();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	
    try{
        int number = Integer.parseInt(temp);
        System.out.println(number); // output = 25
        itemp = number;
    }
    catch (NumberFormatException ex){
        ex.printStackTrace();
    }
    
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt"));
        String s=String.valueOf(itemp);
        writer.write(s);
        
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    
  }
}
