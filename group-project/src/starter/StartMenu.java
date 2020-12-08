package starter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartMenu extends JFrame implements ActionListener {
    private JLabel title;
    private JButton start, help, exit;

    static JFrame frame1 = new JFrame();

    public StartMenu() {
        frame1.setSize(800,600);
        //frame1.setBackground(Color.BLACK);

        Container main = frame1.getContentPane();
        main.setLayout(null);

        title = new JLabel("Galaga");
        start = new JButton("Start");
        help = new JButton("Help");
        exit = new JButton("Exit");


        main.add(title);
        title.setFont(new Font("Consolas",Font.BOLD, 100));
        title.setBounds(200, 50, 500, 100);

        main.add(start);
        start.setFont(new Font("Consolas",Font.BOLD, 40));
        start.setBounds(260, 200, 200, 50);

        main.add(help);
        help.setFont(new Font("Consolas",Font.BOLD, 40));
        help.setBounds(260, 300, 200, 50);


        main.add(exit);
        exit.setFont(new Font("Consolas",Font.BOLD, 40));
        exit.setBounds(260, 400, 200, 50);


        start.addActionListener(this);
        help.addActionListener(this);
        exit.addActionListener(this);

        frame1.setVisible(true);
        frame1.setResizable(false);


    }


    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        if(key == "Start") {
            frame1.dispose();  
        }
        else if(key == "Help") {
        }
        else {
        	System.exit(0);
        }
    }

    public static void main(String[]args) {
        new StartMenu();
    }

}