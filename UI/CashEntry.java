package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import PD.Cash;
import PD.Sale;
import PD.Session;
import PD.Store;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CashEntry extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CashEntry(Store store, JFrame currentFrame, Session session, Sale sale) {
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
		btnNewButton_1.setBounds(264, 220, 139, 21);
		btnNewButton_1.setEnabled(false);
		add(btnNewButton_1);
		if(sale.isPaymentEnough())
			btnNewButton_1.setEnabled(true);
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Cash Payment");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(268, 41, 120, 28);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Amount Tendered:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(207, 84, 115, 28);
		add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBounds(332, 90, 96, 19);
		add(textField_2);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal bigDecimal = new BigDecimal(textField_2.getText().toString());
				Cash cash = new Cash(sale.calcAmountForPayment(bigDecimal), textField_2.getText());
				sale.addPayment(cash);
				textField_1.setText(sale.calcAmtTendered().toString());
				
				if(sale.isPaymentEnough()) {
					btnNewButton_1.setEnabled(true);
				}
				
				session.getRegister().getCashDrawer().addCash(cash.getAmount());
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBounds(234, 126, 85, 21);
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
		btnCancel.setBounds(332, 127, 85, 21);
		add(btnCancel);

	}
}