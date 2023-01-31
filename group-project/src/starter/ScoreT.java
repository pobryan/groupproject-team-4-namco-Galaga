import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreT {
  public static void main(String[] args) {
	String hscore;
	String temp = "1";
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));
	    while((hscore = reader.readLine()) != null) {
	      System.out.printf("The current high score is: ");
	      System.out.println(hscore);
	      temp = hscore;
	    }
	    reader.close();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	
    try{
        int number = Integer.parseInt(temp);
        System.out.println(number); // output = 25
    }
    catch (NumberFormatException ex){
        ex.printStackTrace();
    }


    
  }
}
