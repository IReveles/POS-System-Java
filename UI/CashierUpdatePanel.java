package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import PD.Cashier;
import PD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierUpdatePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public CashierUpdatePanel(Store store, JFrame currentFrame, Cashier cashierSelected, Boolean isSelected) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Cashier");
		lblNewLabel.setBounds(194, 11, 70, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number:");
		lblNewLabel_1.setBounds(42, 56, 46, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(115, 53, 86, 20);
		if(isSelected) {
			textField.setText(cashierSelected.getNumber());
		}
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(42, 94, 46, 14);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 91, 86, 20);
		if(isSelected) {
			textField_1.setText(cashierSelected.getPerson().getName());
		}
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address:");
		lblNewLabel_3.setBounds(42, 131, 46, 14);
		add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 128, 86, 20);
		if(isSelected) {
			textField_2.setText(cashierSelected.getPerson().getAddress());
		}
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("City:");
		lblNewLabel_4.setBounds(42, 169, 46, 14);
		add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(115, 166, 86, 20);
		if(isSelected) {
			textField_3.setText(cashierSelected.getPerson().getCity());
		}
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone:");
		lblNewLabel_5.setBounds(42, 206, 63, 14);
		add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(115, 203, 86, 20);
		if(isSelected) {
			textField_4.setText(cashierSelected.getPerson().getPhone());
		}
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Password:");
		lblNewLabel_6.setBounds(42, 246, 46, 14);
		add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(115, 243, 86, 20);
		if(isSelected) {
			textField_5.setText(cashierSelected.getPassword());
		}
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("SSN:");
		lblNewLabel_7.setBounds(268, 56, 46, 14);
		add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(324, 53, 86, 20);
		if(isSelected) {
			textField_6.setText(cashierSelected.getPerson().getsSN());
		}
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("State:");
		lblNewLabel_8.setBounds(268, 108, 46, 14);
		add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(324, 105, 86, 20);
		if(isSelected) {
			textField_7.setText(cashierSelected.getPerson().getState());
		}
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Zip:");
		lblNewLabel_9.setBounds(268, 153, 46, 14);
		add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(324, 150, 86, 20);
		if(isSelected) {
			textField_8.setText(cashierSelected.getPerson().getZip());
		}
		add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashierSelected.setNumber(textField.getText());
				cashierSelected.getPerson().setName(textField_1.getText());;
				cashierSelected.getPerson().setAddress(textField_2.getText());
				cashierSelected.getPerson().setCity(textField_3.getText());
				cashierSelected.getPerson().setPhone(textField_4.getText());
				cashierSelected.setPassword(textField_5.getText());
				cashierSelected.getPerson().setsSN(textField_6.getText());
				cashierSelected.getPerson().setState(textField_7.getText());
				cashierSelected.getPerson().setZip(textField_8.getText());
				if(!isSelected) {
					store.addCashier(cashierSelected);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(294, 202, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(294, 242, 89, 23);
		add(btnNewButton_1);

	}
}
