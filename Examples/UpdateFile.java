import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.applet.Applet;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class UpdateFile 
    extends Applet 
    implements ActionListener 
{ 
  TextArea ta ; 
  Button btns, btnr ; 
  List<Integer> tempArray = new ArrayList<Integer> ();
  MergeSort sort = new MergeSort();
  Double [] mArray = null;
	int left = 0;
	int right = 0;  
  
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
    	if ( right == 0 ) {
    		ta.append("Data is not loaded. Read file first!\n");
    		return;
    	}
    	else
    		ta.append ( "Data has been updated\n\n" ) ;
    	
    	try {
    		FileWriter fileOutput = new FileWriter("//media//outSort.txt");
    		bw = new BufferedWriter(fileOutput);
    		
    		long startTime = System.currentTimeMillis();
    		tempArray = sort.Merge_Sort(tempArray, left, right);
    		for ( int i = 0; i < tempArray.size(); i++ )
    			bw.write( String.valueOf(tempArray.get(i).doubleValue()) + "\n" );
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
    		File file = new File( "file//tempSort.txt" ) ; 
    		scan = new Scanner( file ) ; 
    		
    		while ( scan.hasNextInt() ) {
    			int nr = scan.nextInt();
    			System.out.println( "nr: " + nr + "\n");
    			tempArray.add(new Integer(nr));
    		}
    		right = tempArray.size() - 1;
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
    	
//    	mArray = tempArray.toArray(new Double[tempArray.size()]);
//    	ta.append("Array before sorting:\n" + mArray.toString());

      return ; 
    } 
  } 
 
  public UpdateFile ( ) 
  { 
    ta = new TextArea ( 12, 40 ) ; 
    btns = new Button ( "Sort" ) ; 
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
 