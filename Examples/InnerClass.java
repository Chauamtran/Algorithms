import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Color;
import java.net.URL;
import java.applet.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;


public class InnerClass 
	extends Applet
	implements ActionListener
{
	TextArea tA = new TextArea(20, 60);
	TextField tF = new TextField(40);
	eButton eBt; 
	
	public InnerClass() {
		eBt = new eButton();
		tF.setFocusable(true);
		tA.append( "Constructor for InnerClass. Create a new eButton instance\n" );
	}
	
	public void actionPerformed (ActionEvent ev) {
		String inputText = tF.getText();
		if (inputText.equals("")) {
			eBt.setLabel("Blank");
			eBt.setIconButton();
		}	
		else {
			eBt.setLabel(inputText);
			eBt.setIconButton();
		}
	}
	
	public void init() {
		eBt.addActionListener(this);
		setBackground(Color.pink);
		add(eBt);
		add(tF);
		add(tA);
		validate();
	}
	
	class eButton extends JButton {
		public eButton() {
			super();
			tA.append("This is an extended class of Button\n");
		}
		
		@SuppressWarnings("deprecation")
		public void setLabel(String inText) {
			super.setLabel(inText);
			tA.append( "This is setLabel of eButton" );
			setBackground(Color.green);
		}
		
		public void setIconButton() {
			URL urlImg = getClass().getResource("img/icon1.jpg");
			ImageIcon i = new javax.swing.ImageIcon(urlImg);
			if ( urlImg == null) {
				tA.append("Couldn't find an image.\n");
			} else {
				setIcon(i);
				tA.append("Set an icon.\n");
			}
		}
	}
	
	
}
