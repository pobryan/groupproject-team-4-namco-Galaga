package starter;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import acm.graphics.GLabel;

public class Menu extends GraphicsPane {
	private MainApplication program;
	
	private int X=325, Y=300;
	private ArrayList<GLabel> names;
	
	public Menu(MainApplication program){
		this.program=program;
		names= new ArrayList<GLabel>();
		
		GLabel ryan= new GLabel("Ryan Ribbel");
		GLabel nupur=new GLabel("Nupur Sompura");
		GLabel marissa=new GLabel("Marissa Morones");
		GLabel paxton=new GLabel("Paxton O'Bryan");
		GLabel vincent=new GLabel("Vincent Torres");
		
		names.add(ryan);
		names.add(nupur);
		names.add(marissa);
		names.add(paxton);
		names.add(vincent);
		
		for(GLabel name:names) {
			name.setLocation(X, Y);
			name.setFont(new Font("Consolas",Font.BOLD, 20));
			name.setColor(Color.cyan);
			Y+=20;
		}
	}
	
	@Override
	public void showContents() {
		for(int i=0; i<names.size();i++) {
			program.add(names.get(i));
		}
	}
	
	@Override
	public void hideContents() {
		for(GLabel name: names) {
			program.remove(name);
		}
	}
}