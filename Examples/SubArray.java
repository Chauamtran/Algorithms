import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.applet.Applet;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SubArray 
    extends Applet 
    implements ActionListener 
{ 
  TextArea ta ; 
  Button btns, btnr ; 
  LinkedList<Integer> mArray = new LinkedList<Integer>();
  MaxSubarray output;
  GetResult result;
  int count = 0;
  
	public static String millisToShortDHMS(long duration) {
    String res = "";
    long days  = TimeUnit.MILLISECONDS.toDays(duration);
    long hours = TimeUnit.MILLISECONDS.toHours(duration)
                   - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
    long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
                     - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration));
    long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
                   - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration));
    if (days == 0) {
      res = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    else {
      res = String.format("%dd%02d:%02d:%02d", days, hours, minutes, seconds);
    }
    return res;
  }
  
  public void actionPerformed( ActionEvent ev ) 
  { 
  			
    if ( ev.getSource() == btns ) 
    {
    	BufferedWriter bw = null;
    	ArrayList<Integer> outArray = null;
    	
    	if ( count == 0 ) {
    		ta.append("Data is not loaded. Read file first!\n");
    		return;
    	}
    	else
    		ta.append ( "Data has been updated\n\n" ) ;
    	
    	try {
    		FileWriter fileOutput = new FileWriter("E:\\MasterCourse\\JavaWorkSpace\\Test1\\src\\file\\outSubArray");
    		bw = new BufferedWriter(fileOutput);
    		
    		long startTime = System.currentTimeMillis();
    		outArray = new ArrayList<Integer>(mArray);
    		output = new MaxSubarray();
    		result = output.FindMaxSubarray(outArray, 0, count-1);
    		bw.write("left: ");
    		//bw.write("" + result.getMaxLeft());
    		bw.write( String.valueOf(result.getMaxLeft()) );
    		bw.write("\tright: ");
    		bw.write( String.valueOf(result.getMaxRight()) );
    		bw.write("\tsum: ");
    		bw.write( String.valueOf(result.getSum()) );
    		System.out.println("\nleft: " + result.getMaxLeft() + 
    												" right: " + result.getMaxRight() + 
    												" sum: " + result.getSum());
    		long endTime = System.currentTimeMillis();
    		
    		ta.append ( "It took " + millisToShortDHMS(endTime-startTime) + "\n\n" ) ;

    	}
    	
    	catch ( Exception e ){
    		ta.append( "== IO Error ===" + e + "\n" );
    	}
    	 
    	finally {
    		
    		if ( bw != null ) { 
    			try {
    				bw.close();
    			}
    			
    			catch ( Exception e ){
    				ta.append( "==Could close file==" + e + "\n" );
    			}
    		}
    	}
    	
      return ; 
    } 
    
    if ( ev.getSource() == btnr ) 
    { 
    	Scanner scan = null ; 

    	try { 
    		File file = new File( "file//inSubArray" ) ; 
    		scan = new Scanner( file ) ; 
    		
    		while ( scan.hasNextInt() ) {
    			int nr = scan.nextInt();
    			System.out.println( "nr: " + nr + "\n");
    			mArray.add(Integer.valueOf(nr));
    		}
    	  ta.append ("==End Of File reached==\n\n");      	
    	}
   	
      catch ( Exception e ) 
      { 
        ta.append ("== IO Error ===" + e + "\n") ; 
      } 
      
    	try 
      { 
      if ( scan != null ) 
        scan.close (); 
      }
      
      catch (Exception e) 
      { 
        ta.append ( "Error : can't close "  + e + "\n" ) ; 
      }
    	
    	count = mArray.size();
      return ; 
    } 
  } 
 
  public SubArray ( ) 
  { 
    ta = new TextArea ( 12, 40 ) ; 
    btns = new Button ( "Do Action" ) ; 
    btnr = new Button ( "Read File" ) ; 
  } 
 
  public void init() 
  { 
    add ( btns ) ; 
    add ( btnr ) ; 
    btns.addActionListener ( this ) ; 
    btnr.addActionListener ( this ) ; 
    add ( ta ) ; 
    setBackground ( Color.orange ) ; 
    validate() ; 
  } 
} 
 