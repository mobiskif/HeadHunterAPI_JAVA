package mvc;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

	public View(Model model) {
        setLayout(new BorderLayout(0, 0));
        JToolBar toolBar = new JToolBar();
        toolBar.setBorder(null);
		toolBar.add(new JLabel(" Искомая строка "));
		
		JTextField textField = new JTextField("ИТ");
		textField.setMargin(new Insets(2, 4, 2, 2));
		textField.addActionListener(model.controller);
		textField.addKeyListener(model.controller);
		toolBar.add(textField);
		model.textField = textField;
		
		JButton btn = new JButton("Найти");
		btn.addActionListener(model.controller);
		toolBar.add(btn);
		//for (Component comp : toolBar.getComponents()) ((JButton)comp).addActionListener(model.controller);
        add(toolBar, BorderLayout.NORTH);
        add(model.scrollPane, BorderLayout.CENTER);
        
        JTextPane txtpnText = new JTextPane();
        txtpnText.setText("text");
        add(txtpnText, BorderLayout.SOUTH);
        model.textPane = txtpnText;
	}
}
