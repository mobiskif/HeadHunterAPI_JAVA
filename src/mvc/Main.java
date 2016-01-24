package mvc;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;

import javax.swing.JApplet;
import javax.swing.JFrame;

import mvc.Controller;
import mvc.TreeView;


public class Main extends Applet {

	public Main() throws HeadlessException {
		super();
       
		Controller c = new Controller();
        TreeView vv = new TreeView(c);
		setSize(640, 480);
		setVisible(true);

		add(vv);
	}

	public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        Controller c = new Controller();
        TreeView vv = new TreeView(c);
        f.setSize(640, 480);
        f.setVisible(true);

        f.setContentPane(vv);
	}

	
	
	
	
	
}
