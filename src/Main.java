import java.applet.Applet;
import java.awt.Button;
import java.awt.HeadlessException;

import javax.swing.JApplet;
import javax.swing.JFrame;

import mvc.Controller;
import mvc.TreeView;
import mvc.View;


public class Main extends Applet {

	public Main() throws HeadlessException {
		super();
        Controller c = new Controller();
        TreeView vv = new TreeView(c);
		add(vv);
		setSize(640, 480);
		setVisible(true);
	}

	public static void main(String[] args) {
        JFrame f = new JFrame();
        Controller c = new Controller();
        TreeView vv = new TreeView(c);
        f.setSize(640, 480);
        f.setVisible(true);
        f.add(vv);
	}

}
