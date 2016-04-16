package mvc;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JFrame;

import mvc.Controller;
import mvc.View;

public class Main extends Applet {

	public Main() {//throws HeadlessException {
		super();
		setLayout( new BorderLayout());
	
		View v = new View (
					new Model (
						new Controller()
					)
				);
		add(v);
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		View v = new View (
					new Model(
						new Controller()
					)
				);
		
		f.setSize(600, 400);
		f.setVisible(true);
		f.setContentPane(v);
	}

}
