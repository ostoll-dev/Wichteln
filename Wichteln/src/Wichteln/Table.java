package Wichteln;
import java.awt.Dimension; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel; 

public class Table extends JPanel{ 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table; 
    public Table(){ 

     String [] header={"Teilnehmer"}; 
     String [][] data={{}}; 


     DefaultTableModel model = new DefaultTableModel(data,header); 

     JTable table = new JTable(model); 

     table.setPreferredScrollableViewportSize(new Dimension(450,63)); 
     table.setFillsViewportHeight(true); 

     JScrollPane scrollPane=new JScrollPane(table); 
     scrollPane.setVisible(true); 
     add(scrollPane); 

    } 

    public static void main(String [] a) { 

     JFrame frame=new JFrame(); 
     Table tab= new Table(); 
     frame.setTitle("Table"); 
     frame.setSize(500, 500); 
     frame.setVisible(true); 
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
     frame.add(tab); 




    } 

} 