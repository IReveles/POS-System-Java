package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import PD.Cashier;
import PD.Item;
import PD.Register;
import PD.Sale;
import PD.SaleLineItem;
import PD.Session;
import PD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SaleEntry extends JPanel {
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;


	/**
	 * Create the panel.
	 */
	public SaleEntry(Store store, JFrame currentFrame, Session session, Sale sale) {
		setLayout(null);
		
	
		JLabel lblNewLabel = new JLabel("Sale");
		lblNewLabel.setBounds(244, 13, 56, 16);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier: ");
		lblNewLabel_1.setBounds(37, 38, 56, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(session.getCashier().getNumber() + " " + session.getCashier().getPerson().getName());
		lblNewLabel_2.setBounds(95, 38, 80, 17);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Register: ");
		lblNewLabel_1_1.setBounds(37, 67, 56, 16);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(session.getRegister().getNumber());
		lblNewLabel_2_1.setBounds(95, 67, 80, 17);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(" Item : ");
		lblNewLabel_1_1_1.setBounds(12, 106, 56, 16);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Invalid UPC ");
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(332, 28, 79, 34);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Please try again");
		lblNewLabel_4_1.setVisible(false);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(332, 68, 103, 34);
		add(lblNewLabel_4_1);
		
		JButton btnEndSession = new JButton("End Session");
		btnEndSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EndSession(store, currentFrame, session));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEndSession.setBounds(157, 280, 115, 20);
		add(btnEndSession);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(61, 104, 103, 19);
		add(textField);
		
	 DefaultListModel <SaleLineItem> sliList = new DefaultListModel<SaleLineItem>();
	
		JList<SaleLineItem> list = new JList<SaleLineItem>(sliList);
		
		list.setBounds(22, 135, 300, 105);
		add(list);
		
		for(SaleLineItem sli : sale.getSaleLineItems()) {
			sliList.addElement(sli);
		}
		
		textField.addActionListener(new java.awt.event.ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	 
		  			if(store.findItemForUPC(textField.getText()) != null) {
			    		lblNewLabel_4.setVisible(false);
		  				lblNewLabel_4_1.setVisible(false);
		  				btnEndSession.setEnabled(false);
		  				SaleLineItem sli = new SaleLineItem(sale, store.findItemForUPC(textField.getText()), textField_1.getText());
		  				sale.addSaleLineItem(sli);
		  				sliList.addElement(sli);
		  				textField_2.setText(sale.calcSubTotal().toString());
		  				textField_3.setText(sale.calcTax().toString());
		  				textField_4.setText(sale.calcTotal().toString());
		  				textField_5.setText(sale.calcAmtTendered().toString());
		  				textField_6.setText(sale.calcChange().toString());
		  				
			    	}else {
			    		lblNewLabel_4.setVisible(true);
		  				lblNewLabel_4_1.setVisible(true);
			    	}	
		  		}
		    });
			
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel(" Quantity : ");
		lblNewLabel_1_1_1_1.setBounds(171, 106, 70, 16);
		add(lblNewLabel_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(244, 104, 34, 19);
		textField_1.setText("1");
		add(textField_1);
		
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("SubTotal : ");
		lblNewLabel_1_1_1_1_1.setBounds(332, 166, 70, 16);
		add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tax : ");
		lblNewLabel_1_1_1_1_1_1.setBounds(364, 195, 34, 16);
		add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Total : ");
		lblNewLabel_1_1_1_1_1_1_1.setBounds(355, 224, 47, 16);
		add(lblNewLabel_1_1_1_1_1_1_1);
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(407, 164, 70, 19);
		textField_2.setText(sale.calcSubTotal().toString());
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(407, 193, 70, 19);
		textField_3.setText(sale.calcTax().toString());
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(407, 222, 70, 19);
		textField_4.setText(sale.calcTotal().toString());
		add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Amt Tendered : ");
		lblNewLabel_1_1_1_1_1_2.setBounds(307, 253, 95, 16);
		add(lblNewLabel_1_1_1_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(407, 250, 70, 19);
		textField_5.setText(sale.calcAmtTendered().toString());
		add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Change : ");
		lblNewLabel_1_1_1_1_1_3.setBounds(346, 282, 56, 16);
		add(lblNewLabel_1_1_1_1_1_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(407, 279, 70, 19);
		textField_6.setText(sale.calcChange().toString());
		add(textField_6);
		
		JLabel lblNewLabel_3 = new JLabel("TaxFree");
		lblNewLabel_3.setBounds(407, 120, 56, 16);
		add(lblNewLabel_3);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(380, 116, 22, 25);
		add(chckbxNewCheckBox);
		
		JButton btnCompleteSale = new JButton("Complete Sale");
		btnCompleteSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sale.isPaymentEnough()) {
					session.addSale(sale);
					btnEndSession.setEnabled(true);
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new SaleEntry(store, currentFrame, session, new Sale()));
					currentFrame.getContentPane().revalidate();
				}else {
					
					}
				
			}
		});
		btnCompleteSale.setBounds(157, 249, 115, 20);
		add(btnCompleteSale);
		
		
		JButton btnCancelSale = new JButton("Cancel Sale");
		btnCancelSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new SaleEntry(store, currentFrame, session, new Sale()));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancelSale.setBounds(37, 280, 115, 20);
		add(btnCancelSale);
		
		JButton btnPayment = new JButton("Payment");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PaymentEntry(store, currentFrame, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnPayment.setBounds(37, 249, 115, 20);
		add(btnPayment);
		
		
		
		
		
		

	}
}
