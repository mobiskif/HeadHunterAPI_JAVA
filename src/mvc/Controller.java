package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Controller implements ActionListener, Serializable {
	public TableModel model;
	public TreeView view;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		try {
			ObjectOutputStream oos;
			ObjectInputStream ois;
			
			if (e.getActionCommand().equalsIgnoreCase("Exit")) {
				/*
				try {
					WindowEvent wev = new WindowEvent((Window)this.frame, WindowEvent.WINDOW_CLOSING);
					Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
					
				} catch (Exception e2) {
					System.err.println(e2);
				}
				*/
			}
			
			if (e.getActionCommand().equalsIgnoreCase("Save")) {
				oos = new ObjectOutputStream(new FileOutputStream(view.treeLeft.getClass().getName() + ".txt"));
				oos.writeObject(view.treeLeft);
				oos = new ObjectOutputStream(new FileOutputStream(view.treeRight.getClass().getName() + ".txt"));
				oos.writeObject(view.treeRight);
			}
			if (e.getActionCommand().equalsIgnoreCase("Load")) {
				ois = new ObjectInputStream(new FileInputStream(view.treeRight.getClass().getName() + ".txt"));
				JTree tree = (JTree) ois.readObject();
				view.treeLeft.setModel(tree.getModel());
				/*
				 * ois = new ObjectInputStream(new
				 * FileInputStream("med.Clinic.txt")); Clinic cl = (Clinic)
				 * ois.readObject(); view.getContentPane().add(cl);
				 * view.repaint();
				 */
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	MouseListener listener = new MouseAdapter() {
		public void mousePressed(MouseEvent me) {
			JComponent comp = (JComponent) me.getSource();
			TransferHandler handler = comp.getTransferHandler();
			handler.exportAsDrag(comp, me, TransferHandler.COPY);
		}
	};

}
