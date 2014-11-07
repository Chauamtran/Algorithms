import java.util.Scanner;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner n1 = new Scanner(System.in);
		System.out.println("Type a line and press Enter");
		String ln = n1.nextLine();
		ln = ln.toUpperCase();
		System.out.println("Uppercase:" + ln);
		
		String w = n1.next();
		while ( !w.equalsIgnoreCase("bye") )
		{
			System.out.println( w );
			w = n1.next();
		}

	}

}
