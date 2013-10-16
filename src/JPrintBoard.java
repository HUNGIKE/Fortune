import java.awt.Font;
import java.awt.PrintJob;
import java.awt.Toolkit;

import javax.swing.*;


public class JPrintBoard extends JPanel {
	private JEditorPane jep=new JEditorPane();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame j=new JFrame();j.setSize(300,600);
		java.awt.PrintJob pr=Toolkit.getDefaultToolkit().getPrintJob(j,"asdfadsf",null);
		
	}
	
	public JPrintBoard(){
		this.setLayout(null);
		JScrollPane jscr=new JScrollPane(jep);
		this.add(jscr).setBounds(0,0,300,300);
		jep.setFont(new Font(Font.SANS_SERIF,Font.ROMAN_BASELINE,24));
		jep.setText("adfadfsa\nfadafdsfa");
		
		
	}
	

}
