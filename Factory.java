/**
 * @author carlos
 *
 */
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class Factory {

	/**
	 * 
	 */
	public Factory() {
		
	}

	public Set<String> create (int type) {
		switch (type) {
		case 1:
			return new TreeSet<String>();
		case 2:
			return new LinkedHashSet<String>();
		default:
			return new HashSet<String>();
		}
	}
}
