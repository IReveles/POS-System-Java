package UI;

import javax.swing.JLabel;
import javax.swing.JPanel;

import PD.Store;

public class MainScreenPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainScreenPanel(Store store) {

			setLayout(null);
			JLabel lblNewLabel = new JLabel(store.getName());
			lblNewLabel.setBounds(235, 162, 183, 47);
			add(lblNewLabel);
	}

}
