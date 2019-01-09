package template.alternatives;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * First solution: use an interface. While it's generally a good idea to think first of interfaces, here this is NOT a
 * good design, because most of the code is needlessly repeated just to modify a few details.
 * 
 * @author Mathieu
 */
public interface IAddressBook {
	
	public void readContacts(String group);
	
	public Set<Integer> getNumbers(String name);
}

/**
 * Exactly the implementation of template.base.AddressBook, but now implementing an interface.
 * FORMAT: "Mathieu:1234567890", extension: .txt
 */
class NameFirstImpl implements IAddressBook {
	
	private static final String ROOT = "C:\\Users\\Mathieu\\Contacts\\";
	
	private Map<String, Set<Integer>> contacts = new HashMap<>();
	
	@Override
	public void readContacts(String group) {
		String fullPath = ROOT + group + ".txt";
		try (BufferedReader in = new BufferedReader(new FileReader(fullPath))) {
			for (String line = in.readLine(); line != null; in.readLine()) {
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
	
	@Override
	public Set<Integer> getNumbers(String name) {
		return contacts.get(name);
	}
}

/**
 * Different implementation for example.
 * FORMAT: "1234567890:Mathieu", extension: .txt2
 * Note: the code is not more complex than the initial base case, but a lot is repeated between NameFirst and NumberFirst.
 *
 */
class NumberFirstImpl implements IAddressBook {
	
	private static final String ROOT = "C:\\Users\\Mathieu\\Contacts\\";
	
	private Map<String, Set<Integer>> contacts = new HashMap<>();
	
	@Override
	public void readContacts(String group) {
		// Here, changed .txt to .txt2
		String fullPath = ROOT + group + ".txt2";
		try (BufferedReader in = new BufferedReader(new FileReader(fullPath))) {
			for (String line = in.readLine(); line != null; in.readLine()) {
				// Here, change how 'name' and 'number' are extracted from the line
				int number = Integer.parseInt(line.substring(0, line.indexOf(':')));
				String name = line.substring(line.indexOf(':') + 1);
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
	
	@Override
	public Set<Integer> getNumbers(String name) {
		return contacts.get(name);
	}
}
