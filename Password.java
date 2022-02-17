package application;

import java.util.ArrayList;
import java.util.Random;

public class Password {
	
	private int length;
	private String[] chars = {"a","b","c","d","e","f","g","h","i","j","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#","@",";","-","*","<",">"};
	
	public String generate() {
		ArrayList<String> passwordChars = new ArrayList<String>();
		String password;
		Random random = new Random();
		for(int i = 0; i < this.length; i++) {
			int randInt = random.nextInt(chars.length);
			passwordChars.add(chars[randInt]);
		}
		password = passwordChars.toString()
				.replace(",", "")
				.replace("[", "")
				.replace("]", "")
				.replace(" ", "");
		return password;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
}
