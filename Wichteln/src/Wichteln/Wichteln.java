package Wichteln;

import javax.swing.JOptionPane;
import java.lang.Math;

public class Wichteln {

	public static void main(String[] args) {
		
		boolean kontrolle = true;
		
		int doItAgain = 0;
		int maxLaengeName = 0;
		int anzahlTeilnehmer = 0;
		int endlosschleifeFailOver = 0;
		
		String anzahlStr = null;
		
		//Abfrage, wie viele Teilnehmer teilnehmen sollen
		do {
			doItAgain = 0;
			try {
				
				anzahlStr = JOptionPane.showInputDialog(null, "Wie viele Teilnehmer willst du?");
				anzahlTeilnehmer = Integer.parseInt(anzahlStr);
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Das war wohl keine Zahl...");
				doItAgain = 1;
			}
		} while(doItAgain == 1);
		
		
		String[] neuerTeilnehmer = new String[anzahlTeilnehmer];
		
		String[] zieherString = new String[anzahlTeilnehmer];
		String[] gezogenerString = new String[anzahlTeilnehmer];
		int zieher[] = new int[anzahlTeilnehmer];
		int gezogener[] = new int[anzahlTeilnehmer];
		
		//Eingabe aller Teilnehmer
		for(int i = 0 ; i < anzahlTeilnehmer ; i++) {
			neuerTeilnehmer[i] = JOptionPane.showInputDialog(null, "Gib einen weiteren Teilnehmer ein:");
		}
		
		//Herausfinden, welcher Name der längste ist, um die Ausgabe schöner zu gestalten
		try {
			for(int i = 0 ; i < anzahlTeilnehmer ; i ++) {
				maxLaengeName = Math.max(neuerTeilnehmer[i].length(), maxLaengeName);
			}
		} catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Du hast wohl ein Feld leer gelassen, da gab es eine NullPointerException...\nVersuch's nochmal...");
			return;
		}
		
		//Zuweisung von zufälligen Zahlen in die beiden Zahlenarrays
		for(int i = 0 ; i < anzahlTeilnehmer ; i++) {
			zieher[i] = (int) ((Math.random() * anzahlTeilnehmer)+1);
			gezogener[i] = (int) ((Math.random() * anzahlTeilnehmer)+1);
			
			for(int j = 0 ; j < i ; j++) {
				if(zieher[j] == zieher[i])
					kontrolle = false;
				if(gezogener[j] == gezogener[i])
					kontrolle = false;
			}
			
			//Kontrolle, ob der Zieher sich selbst gezogen hat
			if(zieher[i] == gezogener[i])
				kontrolle = false;
			
			//Kontrolle, ob ein Ziehfehler eingetreten ist, wenn ja soll dieser Schritt wiederholt werden
			if(kontrolle == false) {
				i = i-1;
				kontrolle = true;
				endlosschleifeFailOver = endlosschleifeFailOver + 1;
			}
			
			//Kontrolle, ob die For-Schleife schon so oft durchgelaufen ist, dass sie sich wahrscheinlich in einer Endlosschleife befindet. Dann soll neugestartet werden
			if(endlosschleifeFailOver >= 1000) {
				i = 0;
				kontrolle = true;
				endlosschleifeFailOver = 0;
				JOptionPane.showMessageDialog(null,"Endlosschleife eingetreten");
			}
		}
		
		//Zuweisung der Zahlenarrays zu den Teilnehmern
		for(int i = 0 ; i < anzahlTeilnehmer ; i++) {
			
			zieherString[i] = (neuerTeilnehmer[zieher[i]-1]);
			
			for(int u = neuerTeilnehmer[zieher[i]-1].length() ; u < maxLaengeName ; u++) {
				zieherString[i] = zieherString[i] + " ";
			}
			
			gezogenerString[i] = (neuerTeilnehmer[gezogener[i]-1]);
		}

		//Ausgabe des Ziehergebnisses
		for(int i = 0; i < anzahlTeilnehmer ; i++) {
			
			System.out.println(zieherString[i] + " zieht: " + gezogenerString[i]);
			
		}
	}
}