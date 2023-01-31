import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreT {
  public static void main(String[] args) {
	  
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"));
	    String hscore;
	    while((hscore = reader.readLine()) != null) {
	      System.out.printf("The current high score is: ");
	      System.out.println(hscore);
	    }
	    reader.close();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
  }
}

	
}
