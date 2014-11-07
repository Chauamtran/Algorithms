import java.applet.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;

public class Click
	extends Applet
	implements MouseListener
{
	int count = 0;
	public Click(){
	  
		addMouseListener( this );
		setBackground(Color.green);
	
	}
  
	public void paint( Graphics gr){
	
		gr.drawString( "Count is now" + count, 75, 30);
	  
	}
	
	public void mouseEntered (MouseEvent ev){
		
		count++;
		repaint();
		
	}
	
	public void mouseExited (MouseEvent ev){
		
		count--;
		repaint();
		
	}
	

    public void mouseClicked ( java.awt.event.MouseEvent ev  ) 
    { } 
    public void mousePressed ( java.awt.event.MouseEvent ev ) 
    { } 
    public void mouseReleased ( java.awt.event.MouseEvent ev ) 
    { }
    
}
