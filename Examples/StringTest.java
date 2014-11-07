/* javalessons.com
For educational purposes only.
See javalessons.com/terms.html Use at own risk.
*/
import java.awt.event.* ;
import java.awt.* ;
import java.applet.*;

import org.apache.commons.lang3.StringUtils;

public class StringTest
	extends Applet
	implements ActionListener
{
	TextArea ta ;
	Button butt ;
	String em = "george.@blackops.net" ;

	
 
	public StringTest()
	{
		butt = new Button ( "Test " + em ) ;
		ta = new TextArea ( 4, 30 ) ;
	}

	public void init()
	{

		butt.addActionListener(this);
		setBackground(Color.blue);
		
		add ( butt ) ;
		add ( ta ) ;
		validate () ;
	}

@Override
	public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
		
		int len = em.length();
		ta.append(len + "\n");
		
		int pos = em.indexOf('@');
		int numAtSign = StringUtils.countMatches(em, "@");
				
		if ( ( pos == -1 ) || ( numAtSign > 1 ) ){
			ta.append("Not a valid email.\n");
			return;
		}
		
		String strLeft = em.substring(0, pos);
		String strRight = em.substring(pos+1);
		
		char cLeft = em.charAt(pos-1);
		char cRight = em.charAt(pos+1);

		if ( (cLeft == '.') || (cRight == '.') ) {
			ta.append("Not a valid email.\n");
			return;
		}
			
		
	}

}
