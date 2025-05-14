package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import PD.CashDrawer;
import PD.Cashier;
import PD.Item;
import PD.Register;
import PD.Sale;
import PD.Session;
import PD.TaxCategory;
import PD.Store;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;



public class LogIn extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private Session session;

	/**
	 * Create the panel.
	 */
	public LogIn(Store store, JFrame currentFrame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(186, 36, 45, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(71, 94, 106, 13);
		add(lblNewLabel_1);
		
DefaultComboBoxModel<Cashier> cList = new DefaultComboBoxModel<Cashier>();
		
		for(Cashier cashier : store.getCashiers().values()) {
			cList.addElement(cashier);
		}
		
		JComboBox<Cashier> comboBox = new JComboBox<Cashier>(cList);
		comboBox.setBounds(186, 93, 101, 17);
		add(comboBox);
		
DefaultComboBoxModel<Register> rList = new DefaultComboBoxModel<Register>();
		
		for(Register register : store.getRegisters().values()) {
			rList.addElement(register);
		}
		
		JComboBox<Register> comboBox_2 = new JComboBox<Register>(rList);
		comboBox_2.setBounds(186, 116, 101, 16);
		add(comboBox_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Register Number");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(71, 117, 106, 13);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Starting Cash");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(71, 140, 106, 13);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Password");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_2.setBounds(71, 163, 106, 13);
		add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Incorrect Password, Please Try Again");
		lblNewLabel_2.setBounds(98, 203, 227, 16);
		add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cashier cashier = new Cashier();
				cashier = (Cashier)cList.getSelectedItem();
				if(passwordField.getText().equals(cashier.getPassword())) {
					Register register = new Register();
					register = (Register)rList.getSelectedItem();
					CashDrawer cashDrawer = new CashDrawer();
					BigDecimal bigDecimal = new BigDecimal(textField.getText());
					cashDrawer.setCashAmount(bigDecimal);
					register.setCashDrawer(cashDrawer);
					session = new Session(cashier, register);
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new SaleEntry(store, currentFrame, session, new Sale()));
					currentFrame.getContentPane().revalidate();
				}else {
					lblNewLabel_2.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(107, 232, 85, 21);
		add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainScreenPanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(202, 233, 85, 21);
		add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(186, 138, 101, 19);
		add(textField);
		textField.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 161, 101, 19);
		add(passwordField);
		
		
		


	}
}
