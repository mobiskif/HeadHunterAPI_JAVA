import java.applet.Applet;
import java.awt.Button;
import java.awt.HeadlessException;

import javax.swing.JApplet;

import mvc.Controller;
import mvc.TreeView;
import mvc.View;


public class Main extends JApplet {
	

	public Main() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		setSize(640, 480);
		setVisible(true);
		add(new Button("jopa"));
		System.out.println("asdfasfadsf");
	}

	public static void main(String[] args) {
		new Main();
        //Controller c = new Controller();
        //TreeView v = new TreeView(c);
        //View vv = new View(c);
        //MainForm mf = new MainForm();
	}

}
