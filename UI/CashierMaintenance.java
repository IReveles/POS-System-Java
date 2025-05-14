package UI;

import javax.swing.JPanel;



import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionListener;

import PD.Cashier;
import PD.Store;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierMaintenance extends JPanel {

	/**
	 * Create the panel.
	 */
	public CashierMaintenance(Store store, JFrame currentFrame) {
		setLayout(null);
		
		DefaultListModel <Cashier> cashierList = new DefaultListModel<Cashier>();
		for(Cashier cashier : store.getCashiers().values()) {
			cashierList.addElement(cashier);
		}
		
		JList <Cashier> list = new JList<Cashier>(cashierList);
		list.setBounds(148, 48, 145, 157);
		add(list);
		  
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier cashier = new Cashier();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierUpdatePanel(store, currentFrame, cashier, false));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnNewButton.setBounds(48, 228, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierUpdatePanel(store, currentFrame, (Cashier)list.getSelectedValue(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier cashier = new Cashier();
				cashier = (Cashier)list.getSelectedValue();
				store.removeCashier(cashier);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(328, 228, 89, 23);
		add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedValue() != null) {
					
					btnNewButton_1.setEnabled(true);
					if(!list.getSelectedValue().isUsed()) {
						btnNewButton_2.setEnabled(true);
					}else btnNewButton_2.setEnabled(false);
						
				}
			}
		});
		
	
		btnNewButton_1.setBounds(184, 228, 89, 23);
		add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		
	
		
	}
}