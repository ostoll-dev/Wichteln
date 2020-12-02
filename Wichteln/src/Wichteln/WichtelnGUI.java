package Wichteln;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WichtelnGUI {

	int anzahlTeilnehmer = 0;
	String anzahlTeilnehmerStr = "";
	JButton plusButton = new JButton("+");
	JButton minusButton = new JButton("-");
	JButton goButton = new JButton("Go");
	JTextField anzahlAusgabe = new JTextField();
	DefaultTableModel model = new DefaultTableModel();
	JTable jt = new JTable(model);
	JScrollPane jsp = new JScrollPane(jt);
	DefaultListModel<String> listModel = new DefaultListModel<>();
	JList<String> jl = new JList<>(listModel);
	
	public WichtelnGUI() {
		JFrame frame = new JFrame();
		//JTextField field = new JTextField();
		DerHandler handler = new DerHandler();
		
		frame.setSize(1200, 900);
		//frame.add(field);
		frame.add(plusButton);
		frame.add(minusButton);
		frame.add(anzahlAusgabe);
		frame.add(jsp);
		frame.add(goButton);
		frame.add(jl);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Wichteln");
		frame.setVisible(true);
		frame.setLayout(null);
		
		//field.setBounds(200, 200, 350, 500);
		//field.setEditable(false);
		
		jl.setBounds(200, 200, 350, 500);
		jl.setVisible(true);
		
		jsp.setBounds(50, 200, 150, 500);
		jsp.setVisible(true);
		model.addColumn("Teilnehmer:");
		
		plusButton.addActionListener(handler);
		plusButton.setBounds(150,55, 50,40);
		minusButton.addActionListener(handler);
		minusButton.setBounds(50, 55, 50, 40);
		goButton.addActionListener(handler);
		goButton.setBounds(200, 55, 100, 40);
		
		anzahlAusgabe.setBounds(100,50, 50,50);
		anzahlAusgabe.setEditable(false);
		anzahlAusgabe.setHorizontalAlignment(JTextField.CENTER);
		
	}
	
	public static void main(String[] args) {
		
		new WichtelnGUI();
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
			
			if(event.getSource() == goButton) {
				listModel.clear();
				String[] teilnehmerStr = new String[anzahlTeilnehmer];
				for(int i = 0; i < anzahlTeilnehmer ; i++) {
					teilnehmerStr[i] = (String) model.getValueAt(i, 0);
				}
				
				String[] ausgabe = Wichteln.WichtelnAusgabe(teilnehmerStr, anzahlTeilnehmer);
				for(int i = 0 ; i < ausgabe.length ; i++) {
					listModel.addElement(ausgabe[i]);
				}
			}
		}
	}
}