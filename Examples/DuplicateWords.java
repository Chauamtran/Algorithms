import java.util.HashSet;
import java.util.Set;

public class DuplicateWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set <String> uniques = new HashSet<String>();
		Set <String> dups    = new HashSet<String>();
		
		for (String a : args)
			if ( !uniques.add(a))
				dups.add(a);

	}

}
