package UI;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import PD.Cashier;
import PD.Register;
import PD.Store;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterMaintenance extends JPanel {

	/**
	 * Create the panel.
	 */
	public RegisterMaintenance(Store store, JFrame currentFrame) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Register");
		lblNewLabel.setBounds(198, 32, 46, 14);
		add(lblNewLabel);
		
		DefaultListModel <Register> registerList = new DefaultListModel<Register>();
		for(Register register : store.getRegisters().values()) {
			registerList.addElement(register);
		}
		
		JList <Register> list = new JList<Register>(registerList);
		list.setBounds(161, 76, 128, 129);
		add(list);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterUpdatePanel(store, currentFrame, (Register)list.getSelectedValue(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(184, 238, 89, 23);
		btnNewButton.setEnabled(false);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterUpdatePanel(store, currentFrame, register, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(39, 238, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register = (Register)list.getSelectedValue();
				store.removeRegister(register);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterMaintenance(store, currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setBounds(329, 238, 89, 23);
		btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list.getSelectedValue() != null) {
					btnNewButton.setEnabled(true);
					if(!list.getSelectedValue().isUsed()) {
						btnNewButton_2.setEnabled(true);
					}else btnNewButton_2.setEnabled(false);
				}
			}
		});

	}
}
