package template.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a simple address book that reads contacts (name and phone number) from a text file. Each file
 * in which contacts are saved corresponds to a "group" of contacts (e.g., work, friends, etc.).
 * 
 * @author Mathieu
 */
public class AddressBook {
	
	private static final String ROOT = "C:\\Users\\Mathieu\\Contacts\\";
	
	private Map<String, Set<Integer>> contacts = new HashMap<>();
	
	/**
	 * The method of interest. This method reads the contacts inside the file associated with a group.
	 * 
	 * @param group
	 *            the group of contacts to load. This parameter uniquely identifies the file to read from.
	 */
	public void readContacts(String group) {
		String fullPath = ROOT + group + ".txt";
		try (BufferedReader in = new BufferedReader(new FileReader(fullPath))) {
			for (String line = in.readLine(); line != null; in.readLine()) {
				// FORMAT OF EACH LINE:
				// name:number
				// E.G.
				// Mathieu:1234567890
				// Assume the file is well formatted. There's no code handling errors here.
				String name = line.substring(0, line.indexOf(':'));
				int number = Integer.parseInt(line.substring(line.indexOf(':') + 1));
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
	 * Simple accessor. Note the use of Collections.unmodifiableSet, to avoid breaking encapsulation.
	 * 
	 * @param name
	 *            what contact to look for
	 * @return numbers associated with this contact
	 */
	public Set<Integer> getNumbers(String name) {
		return Collections.unmodifiableSet(contacts.get(name));
	}
}
