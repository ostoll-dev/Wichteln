package Wichteln;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class WichtelnGUI {

	int anzahlTeilnehmer = 0;
	String anzahlTeilnehmerStr = "";
	JButton plusButton = new JButton("+");
	JButton minusButton = new JButton("-");
	JButton goButton = new JButton
	JTextField anzahlAusgabe = new JTextField();
	DefaultTableModel model = new DefaultTableModel();
	JTable jt = new JTable(model);
	JScrollPane jsp = new JScrollPane(jt);
	
	public WichtelnGUI() {
		JFrame frame = new JFrame();
		JTextField field = new JTextField();
		DerHandler handler = new DerHandler();
		
		frame.setSize(1200, 900);
		frame.add(field);
		frame.add(plusButton);
		frame.add(minusButton);
		frame.add(anzahlAusgabe);
		frame.add(jsp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Wichteln");
		frame.setVisible(true);
		frame.setLayout(null);
		
		field.setBounds(200, 200, 350, 500);
		field.setEditable(false);
		
		jsp.setBounds(50, 200, 150, 500);
		jsp.setVisible(true);
		model.addColumn("Teilnehmer:");
		
		plusButton.addActionListener(handler);
		plusButton.setBounds(150,55, 50,40);
		minusButton.addActionListener(handler);
		minusButton.setBounds(50, 55, 50, 40);
		
		anzahlAusgabe.setBounds(100,50, 50,50);
		anzahlAusgabe.setEditable(false);
		anzahlAusgabe.setHorizontalAlignment(JTextField.CENTER);
		
	}
	
	private class DerHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == plusButton) {
				anzahlTeilnehmer = anzahlTeilnehmer + 1;
				anzahlTeilnehmerStr = Integer.toString(anzahlTeilnehmer);
				anzahlAusgabe.setText(anzahlTeilnehmerStr);
				model.addRow(new Object[] {""});
			}
			
			if(event.getSource() == minusButton) {
				if(anzahlTeilnehmer > 0) {
					anzahlTeilnehmer = anzahlTeilnehmer - 1;
					anzahlTeilnehmerStr = Integer.toString(anzahlTeilnehmer);
					anzahlAusgabe.setText(anzahlTeilnehmerStr);
					model.removeRow(anzahlTeilnehmer);
				}
			}
			
		}
	}
	public static void main(String[] args) {
		
		new WichtelnGUI();
		
	}
}