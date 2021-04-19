package Exercise7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class WeightScreen extends JFrame {

	private JPanel contentPane;
	private JTextField Earth_textField;
	private JTextField Mars_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeightScreen frame = new WeightScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WeightScreen() {
		setBackground(SystemColor.text);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 202);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel earthLbl = new JLabel("Weight in Earth(in kg) :");
		earthLbl.setBounds(35, 35, 153, 19);
		earthLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(earthLbl);
		
		Earth_textField = new JTextField();
		Earth_textField.setBounds(198, 36, 91, 20);
		contentPane.add(Earth_textField);
		Earth_textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userWeightInput=Earth_textField.getText();
				Weight weightInput = new Weight();
				Double dble =Double.parseDouble(userWeightInput);
				weightInput.setWeightOnEarth(dble);
				WeightCalculator weigthCalc = new WeightCalculator(weightInput.getWeightOnEarth());
				Double dbl = weigthCalc.calcWeightOnMars();
				weightInput.setWeightOnMars(dbl);
				String str = dbl.toString();
				Mars_textField.setText(str);
			}
		});
		btnNewButton.setBounds(299, 33, 72, 23);
		contentPane.add(btnNewButton);
		
		Mars_textField = new JTextField();
		Mars_textField.setBounds(198, 80, 173, 23);
		contentPane.add(Mars_textField);
		Mars_textField.setColumns(10);
		
		JLabel marsLbl = new JLabel("Weight in Mars :");
		marsLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		marsLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		marsLbl.setBounds(35, 80, 153, 17);
		contentPane.add(marsLbl);
	}
}
