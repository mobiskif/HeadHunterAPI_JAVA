package mvc;

import java.awt.Point;
import java.awt.event.*;

public class Controller implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	public Model model;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		System.out.println(e.getSource());
		if (e.getActionCommand().equalsIgnoreCase("Найти"))
			model.setModel(model.textField.getText());
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==10)
			model.setModel(model.textField.getText());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getPoint(); 
		//model.table.setRowSelectionAllowed(false); 
		//model.table.changeSelection(model.table.rowAtPoint(p), model.table.columnAtPoint(p), false, false); 
		System.out.println(model.table.getValueAt(model.table.rowAtPoint(p), model.table.columnAtPoint(p)));
		model.textPane.setText((String) model.table.getValueAt(model.table.rowAtPoint(p), model.table.columnAtPoint(p)));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Point p = arg0.getPoint(); 
		//model.table.setRowSelectionAllowed(false); 
		model.textPane.setText((String) model.table.getValueAt(model.table.rowAtPoint(p), model.table.columnAtPoint(p)));
	}

}
