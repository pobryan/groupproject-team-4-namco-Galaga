package starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import acm.graphics.GLabel;

public class Credits extends GraphicsPane implements MouseListener {
	private MainApplication program;
	
	private int X=325, Y=200;
	private GLabel credit;
	private ArrayList<GLabel> names;
	private GButton back;
	
	Credits(MainApplication program){
		this.program=program;
		names= new ArrayList<GLabel>();
		
		credit= new GLabel("Credits");
		credit.setColor(Color.cyan);
		credit.setFont(new Font("Consolas",Font.BOLD, 20));
		credit.setLocation(X-50, Y-25);
		
		GLabel ryan= new GLabel("Ryan Ribbel");
		GLabel nupur=new GLabel("Nupur Sompura");
		GLabel marissa=new GLabel("Marissa Morones");
		GLabel paxton=new GLabel("Paxton O'Bryan");
		GLabel vincent=new GLabel("Vincent Torres");
		
		back=new GButton("Back", 10,10, 50,30);
		
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
		program.setBackground(Color.black);
		program.add(credit);
		program.add(back);
		for(int i=0; i<names.size();i++) {
			program.add(names.get(i));
		}
	}
	
	@Override
	public void hideContents() {
		program.removeAll();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
    	if(back.contains(e.getX(), e.getY())) {
           program.switchToMenu();
        }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}
}