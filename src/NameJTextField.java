import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;


public class NameJTextField extends JFormattedTextField{
	
	
	public NameJTextField() throws ParseException{
			super(new javax.swing.text.MaskFormatter("******"));
	}


	
}
