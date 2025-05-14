package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import PD.Credit;
import PD.Register;
import PD.Sale;
import PD.Session;
import PD.Store;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CreditEntry extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public CreditEntry(Store store, JFrame currentFrame, Session session, Sale sale) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(195, 10, 58, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Payment Due:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(74, 55, 85, 28);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(74, 93, 96, 19);
		textField.setText(sale.calcTotal().toString());
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount Tendered:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(74, 122, 115, 28);
		add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(74, 160, 96, 19);
		textField_1.setText(sale.calcAmtTendered().toString());
		add(textField_1);
		
		JButton btnNewButton = new JButton("Cash");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashEntry(store, currentFrame, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(74, 189, 85, 21);
		add(btnNewButton);
		
		JButton btnCard = new JButton("Credit");
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CreditEntry(store, currentFrame, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCard.setBounds(74, 220, 85, 21);
		add(btnCard);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CheckEntry(store, currentFrame, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCheck.setBounds(74, 251, 85, 21);
		add(btnCheck);
		
		JButton btnNewButton_1 = new JButton("Payment Complete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new SaleEntry(store, currentFrame, session, sale));
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(268, 251, 139, 21);
		btnNewButton_1.setEnabled(false);
		add(btnNewButton_1);
		
		JLabel lblEntrerPayment = new JLabel("Enter Credit Payment");
		lblEntrerPayment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEntrerPayment.setBounds(273, 35, 134, 28);
		add(lblEntrerPayment);
		
		JLabel lblNewLabel_1_2 = new JLabel("Amount : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(214, 64, 85, 28);
		add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBounds(311, 70, 96, 19);
		add(textField_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Card Type : ");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(214, 102, 85, 28);
		add(lblNewLabel_1_2_1);
		DefaultComboBoxModel<String> sList = new DefaultComboBoxModel<String>();
		JComboBox<String> comboBox = new JComboBox<String>(sList);
		sList.addElement("Visa");
		sList.addElement("Master Card");
		comboBox.setBounds(311, 108, 96, 19);
		add(comboBox);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Account Num : ");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(214, 140, 96, 28);
		add(lblNewLabel_1_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setText((String) null);
		textField_3.setColumns(10);
		textField_3.setBounds(311, 146, 96, 19);
		add(textField_3);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Expire Date : ");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1_1.setBounds(214, 178, 96, 28);
		add(lblNewLabel_1_2_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setText((String) null);
		textField_4.setColumns(10);
		textField_4.setBounds(311, 184, 96, 19);
		add(textField_4);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal bigDecimal = new BigDecimal(textField_2.getText().toString());
				Credit credit = new Credit(sale.calcAmountForPayment(bigDecimal),new BigDecimal(textField_2.getText()), sList.getSelectedItem().toString(), textField_3.getText(), textField_4.getText());
				sale.addPayment(credit);
				textField_1.setText(sale.calcAmtTendered().toString());
				
				if(sale.isPaymentEnough()) {
					btnNewButton_1.setEnabled(true);
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBounds(242, 221, 85, 21);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntry(store, currentFrame, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(337, 221, 85, 21);
		add(btnCancel);
		if(sale.isPaymentEnough())
			btnNewButton_1.setEnabled(true);

	}
}