package mvc;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
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
		add(vv);
		setVisible(true);
	}

	public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        Controller c = new Controller();
        TreeView vv = new TreeView(c);
        f.setSize(640, 480);
        f.setLayout(new CardLayout());
        //vv.setSize(f.getWidth(), f.getHeight());
        f.add(vv);
        f.setVisible(true);
	}

	
	
	
	
	
}
