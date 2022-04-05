package me.frogdog.frogpass.password;

public class Password {
    private String password;
    private final int length;

    public Password(String password) {
        this.password = password;
        this.length = password.length();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLength() {
        return this.length;
    }
}