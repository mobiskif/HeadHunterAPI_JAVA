package med;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import utils.Booble;


/**
 * Created with IntelliJ IDEA. User: user Date: 20.10.13 Time: 15:58 To change
 * this template use File | Settings | File Templates.
 */
public class Clinic extends BaseComponent {
	public Clinic(String s) {
		super(s);
		Doctor doctor1 = new Doctor("dr Петров");
		doctor1.add(new Patient("Паршин"));
		doctor1.add(new Patient("Жукова"));
		add(doctor1);

		Doctor doctor2 = new Doctor("dr Сидоров");
		Patient patient = new Patient("Дубницкий");
		patient.add(new Pathology("Грипп"));
		doctor2.add(patient);
		doctor2.add(new Patient("Беленко"));
		//doctor2.add(new Booble());
		add(doctor2);

		print(0);
	}
}
