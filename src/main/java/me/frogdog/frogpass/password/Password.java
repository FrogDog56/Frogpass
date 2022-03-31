package me.frogdog.frogpass.password;

import java.util.ArrayList;
import java.util.Random;

public class Password {
    private int length;

    private final String[] chars = {"a","b","c","d","e","f","g","h","i","j","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","#","@",";","-","*","<",">"};

    public Password(int length) {
        this.length = length;
    }

    public String getPassword() {
        String password;
        ArrayList<String> passwordArray = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < this.length; i++) {
            int randIndex = random.nextInt(chars.length);
            passwordArray.add(chars[randIndex]);
        }

        password = passwordArray.toString()
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
