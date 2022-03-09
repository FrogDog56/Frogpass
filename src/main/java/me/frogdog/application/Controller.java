package me.frogdog.application;

import java.awt.datatransfer.Clipboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

	@FXML
	TextField lengthTextField;
	@FXML
	TextField passwordOutput;
	
	public void getPassword(ActionEvent event) {
		String text = lengthTextField.getText();
		int length = Integer.parseInt(text);
		
		Password p = new Password();
		p.setLength(length);
		String password = p.generate();
		passwordOutput.setText(password);
	}
	
	public void copyToClipBoard(ActionEvent event) {
		java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new java.awt.datatransfer.StringSelection(passwordOutput.getText()), null);
	}

}
