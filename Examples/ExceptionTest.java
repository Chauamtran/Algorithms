import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import org.apache.commons.lang3.math.NumberUtils;

public class ExceptionTest
	extends Applet
	implements ActionListener
{
	Button btEnter;
	TextField tF;
	TextArea tA;
	
	public ExceptionTest() {
		tA = new TextArea( 6, 30 );
		tF = new TextField( 30 );
		btEnter = new Button ( "Check" );
	}
	
	public void init() {
		btEnter.addActionListener( this );
		tF.addActionListener( this );
		
		tA.setEditable( false );
		add( tF );
		add( tA );
		add( btEnter );
		
		validate();
		tF.requestFocus();
	}
	
	void check (String user)
		throws NotIntegerException, NotInRangeException
	{
		user = user.trim();
		
		if ( !(NumberUtils.isNumber(user)) )
			throw new NotIntegerException ();
		tA.append( user + " is a number\n" );
		
		int num = Integer.parseInt(user);
		if ( num < 100 || num > 65535 )
			throw new NotInRangeException();
			tA.append( "Good\n" );
	}
	
	public void actionPerformed (ActionEvent ev) {
		tA.setText("");
		
		try {
			String inputText = tF.getText();
			check(inputText);
			tA.append( "PASS\n" );
			setBackground(Color.cyan);
		}
		
		catch (NotIntegerException nie) {
			tA.append( "INVALID NUMBER!\n" );
			tA.append( "Exception specs:" + nie + "\n" );
			Toolkit.getDefaultToolkit().beep();
		}

		catch (NotInRangeException nire){
			tA.append( "WRONG! You haven't typed a number in range\n" );
			tA.append( "Exception specs:" + nire + "\n");
			Toolkit.getDefaultToolkit().beep();
		}
		
		catch (NumberFormatException nfe) {
			tA.append( "WRONG IN FORMAT of NUMBER\n" );
			tA.append( "Exception specs: "  + nfe + "\n" );
		}
		
		finally {
			tA.append( "Coming to finally block" );
		}
		
		tF.requestFocus();
	}
	
}
