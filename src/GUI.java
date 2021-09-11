import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;

public class GUI implements ActionListener{
	
    JRadioButton radio;
    JRadioButton radio1;
    JRadioButton radio2;
    
    int y = 0;
    String password;
    String passwordText;
    
    public static final Color VERY_LIGHT_RED = new Color(255,102,102);
    public static final Color WHITE = new Color(255,255,255);
    public static final Color BLACK = new Color(0, 0, 0);
	
	protected JLabel label;
	protected JTextField passwordtxt;
	protected JFrame frame;
	protected JButton button;
	protected JPanel panel;
	
	public GUI(){
		
        frame = new JFrame();
        
        radio = new JRadioButton("8");
        radio1 = new JRadioButton("10");
        radio2 = new JRadioButton("16");
        
        ButtonGroup group = new ButtonGroup();
        group.add(radio);
        group.add(radio1);
        group.add(radio2);
        
        radio.addActionListener(this);
        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio.setBackground(BLACK);
        radio.setForeground(VERY_LIGHT_RED);
        radio1.setBackground(BLACK);
        radio1.setForeground(VERY_LIGHT_RED);
        radio2.setBackground(BLACK);
        radio2.setForeground(VERY_LIGHT_RED);
   
        button = new JButton("Enter");
        button.setBackground(VERY_LIGHT_RED);
        button.setForeground(BLACK);
        button.addActionListener(this);

        label = new JLabel("Please select length of password here");
        label.setBackground(BLACK);
        label.setForeground(VERY_LIGHT_RED);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(BLACK);
        panel.add(label);
        panel.add(radio);
        panel.add(radio1);
        panel.add(radio2);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Password Generator");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(960 ,540);
        frame.setBackground(VERY_LIGHT_RED);
        frame.setForeground(VERY_LIGHT_RED);
        frame.setIconImage(null);
        frame.setSize(300, 200);
		
	}
	
	public static void main(String[] args) {
		new GUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==radio) {
			y = 8;
		}else if(e.getSource()==radio1) {
			y= 10;
		}else if(e.getSource()==radio2) {
			y = 16;
		}
		
		String[] characters = {"a","b","c","d","e","f","g","h","i","j","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0",
								"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#","@",";","-","*","<",">"};
		
		Random random = new Random();
		
		ArrayList<String> input = new ArrayList<String>();
		
		if(e.getSource()==button) { 			
		for(int i = 0; i < y; i++) {
			int x = random.nextInt(68);
			password = ((characters[x]));
			input.add(password);
			frame.setVisible(false);
		}
		frame = new JFrame();

	    label = new JLabel("Here is your password");
	    label.setBackground(BLACK);
	    label.setForeground(VERY_LIGHT_RED);
	        
	    String formattedPassword = input.toString()
	    .replace(",","")
	    .replace("[","")
	    .replace("]","")
	    .replace(" ","" )
	    .trim();
	    passwordtxt = new JTextField(formattedPassword);


	    panel = new JPanel();
	    panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
	    panel.setLayout(new GridLayout(0, 1));
	    panel.setBackground(BLACK);
	    panel.add(label);
	    panel.add(passwordtxt);

	    frame.add(panel, BorderLayout.CENTER);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Password Generator");
	    frame.pack();
	    frame.setVisible(true);
	    frame.setLocation(960 ,540);
	    frame.setBackground(VERY_LIGHT_RED);
	    frame.setForeground(VERY_LIGHT_RED);
	    frame.setIconImage(null);
		
		}
	}
}
				
			
		
	    	