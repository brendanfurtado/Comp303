package template.alternatives;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Second solution: using a template method. The abstract base class provides most of the implementation, and only a few
 * methods need to be overriden to complete the algorithm. Note how similar this is to the initial base case.
 * 
 * @author Mathieu
 */
public abstract class TemplateAddressBook {
	
	private static final String ROOT = "C:\\Users\\Mathieu\\Contacts\\";
	
	private Map<String, Set<Integer>> contacts = new HashMap<>();
	
	/**
	 * This method now uses 2 abstract methods, which are the only details that change from one format to the next. By
	 * providing an implementation to these abstract methods, subclasses complete the algorithm.
	 */
	public void readContacts(String group) {
		// First abstract method is used here
		String fullPath = ROOT + group + getExtension();
		try (BufferedReader in = new BufferedReader(new FileReader(fullPath))) {
			for (String line = in.readLine(); line != null; in.readLine()) {
				// Second abstract method is used here
				Entry<String, Integer> parsed = parseLine(line);
				String name = parsed.getKey();
				int number = parsed.getValue();
				if (!contacts.containsKey(name)) {
					contacts.put(name, new HashSet<>());
				}
				contacts.get(name).add(number);
			}
		}
		catch (IOException e) {
			System.err.println("Error reading " + fullPath);
			e.printStackTrace();
		}
	}
	
	/**
	 * Two things to note here:
	 * 1. The contract is a small, very well-defined operation. You want to remove as much complexity as possible for the subclass.
	 * 2. The 'protected' visibility: this is visible to the class + any subclass (and the package), but not to other unrelated classes.
	 * 
	 * @return the expected extension of the file (e.g., ".txt").
	 */
	protected abstract String getExtension();
	
	/**
	 * Extracts the name and number from the line. We could have used here 2 methods, one to extract the name, and one to extract the number.
	 */
	protected abstract Entry<String, Integer> parseLine(String line);
	
	public Set<Integer> getNumbers(String name) {
		return Collections.unmodifiableSet(contacts.get(name));
	}
}

/**
 * Example to see how the template works. This is equivalent to the initial base case. Note how simple it is to write the subclass.
 * FORMAT: "Mathieu:1234567890", extension: .txt
 */
class NameFirst extends TemplateAddressBook {

	@Override
	protected String getExtension() {
		return ".txt";
	}

	@Override
	protected Entry<String, Integer> parseLine(String line) {
		return Map.entry(
				line.substring(0, line.indexOf(':')),
				Integer.parseInt(line.substring(line.indexOf(':') + 1))
				);
	}
}

/**
 * Another example with number first format. Note how the code focuses on differences between this implementatation
 * and the previous (i.e., on the differences between subclasses of TemplateAddressBook).
 * FORMAT: "1234567890:Mathieu", extension: .txt2
 */
class NumberFirst extends TemplateAddressBook {

	@Override
	protected String getExtension() {
		return ".txt2";
	}

	@Override
	protected Entry<String, Integer> parseLine(String line) {
		return Map.entry(
				line.substring(line.indexOf(':') + 1),
				Integer.parseInt(line.substring(0, line.indexOf(':')))
				);
	}
}
