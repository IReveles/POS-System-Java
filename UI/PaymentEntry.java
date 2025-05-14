package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import PD.Sale;
import PD.Session;
import PD.Store;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentEntry extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PaymentEntry(Store store, JFrame currentFrame, Session session, Sale sale) {
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
		
		
		JButton btnNewButton_1_1 = new JButton("Cancel");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new SaleEntry(store, currentFrame, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBounds(264, 251, 139, 21);
		add(btnNewButton_1_1);

	}
}
