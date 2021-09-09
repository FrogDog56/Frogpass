import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI{
	
	protected JLabel label;
	protected JFrame frame;
	protected JButton button;
	protected JPanel panel;
	protected JTextArea textArea;
	
	public GUI() {
		
        frame = new JFrame();
        
        textArea = new JTextArea("");
   

        button = new JButton("Enter");
        button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
    		
				String contents = textArea.getText();
				System.out.println(contents);
			}
        });

        label = new JLabel("Please enter length of password here");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(textArea);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Password Generator");
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(960 ,540);
		
	}
	

	public static void main(String[] args) {
        new GUI();
	}    
	

    
    	
}