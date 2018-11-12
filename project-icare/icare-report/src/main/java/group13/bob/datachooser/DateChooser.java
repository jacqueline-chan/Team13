package group13.bob.datachooser;

import java.awt.EventQueue;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

public class DateChooser extends JFrame{

	private JFrame jf;
	private JDateChooser dateChooser1;
	private JDateChooser dateChooser2;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateChooser datePicker = new DateChooser();
					datePicker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DateChooser() {
		
		setBounds(500, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Date Picker");
		
		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(112, 24, 269, 44);
		getContentPane().add(dateChooser1);
		dateChooser1.setDateFormatString("yyyy-MM-dd");
		
		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(112, 177, 269, 44);
		getContentPane().add(dateChooser2);
		dateChooser2.setDateFormatString("yyyy-MM-dd");
	}
}