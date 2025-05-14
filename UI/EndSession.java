package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PD.SaleLineItem;
import PD.Session;
import PD.Store;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class EndSession extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public EndSession(Store store, JFrame currentFrame, Session session) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Session Summary");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(166, 10, 114, 16);
		add(lblNewLabel);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Cashier ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(37, 38, 56, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(session.getCashier().getNumber() + " " + session.getCashier().getPerson().getName());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(95, 38, 80, 17);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Register ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(37, 67, 56, 16);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(session.getRegister().getNumber());
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(95, 67, 80, 17);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Number of Sales : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(37, 93, 114, 16);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Total Sales : ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(37, 119, 114, 16);
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Enter Cash : ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1.setBounds(37, 146, 114, 16);
		add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Cash Count Diff : ");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1_1_1.setBounds(37, 172, 114, 16);
		add(lblNewLabel_1_1_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(180, 93, 107, 19);
		textField.setText(String.valueOf(session.getSales().size()) );
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 119, 107, 19);
		textField_1.setText(session.calcTotal().toString());
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 143, 107, 19);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(180, 170, 107, 19);
		add(textField_3);
		
		textField_2.addActionListener(new java.awt.event.ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	 	textField_3.setText(session.calcCashCountDiff(new BigDecimal(textField_2.getText())).toString());
		  		}
		    });
		
		JButton btnNewButton = new JButton("End Session");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainScreenPanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(180, 223, 107, 21);
		add(btnNewButton);

	}

}
