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
 * Same as AddressBook, but now, we want to be able to read different file formats. As a first solution, we include more
 * parameters to indicate the formats. NOT a good way to modify our previous implementation. We will try different
 * designs later.
 * 
 * @author Mathieu
 */
public class ComplexAddressBook {
	
	private static final String ROOT = "C:\\Users\\Mathieu\\Contacts\\";
	
	private Map<String, Set<Integer>> contacts = new HashMap<>();
	
	/**
	 * We want to read any text format where each line contains a name and a number, indicated by different separators.
	 * Note the extra parameters, and complex manipulations! This is NOT a good design. To locate the name, we will look
	 * between nameStart and nameEnd. E.g., if nameStart == "(", and nameEnd == ")", the name should be in parentheses
	 * on the line. Idem for numbers. Use the empty string for the start of the line, and null for the end.
	 * 
	 * This is just a beginning: to make the method even more general, we would need even more parameters, with more
	 * complex operations in the body of the method (i.e., hard to use for both the writer of the method and its users).
	 * 
	 * @param group
	 *            identifying the file
	 * @param extension
	 *            File extension
	 * @param nameStart
	 *            String indicating where the name begins
	 * @param nameEnd
	 *            String indicating where the name ends
	 * @param numStart
	 *            String indicating where the number begins
	 * @param numEnd
	 *            String indicating where the number ends
	 */
	public void readContacts(String group,
			String extension,
			String nameStart,
			String nameEnd,
			String numStart,
			String numEnd) {
		String fullPath = ROOT + group + extension;
		try (BufferedReader in = new BufferedReader(new FileReader(fullPath))) {
			for (String line = in.readLine(); line != null; in.readLine()) {
				// We just added a lot more complexity here to make the code more flexible
				int start1 = line.indexOf(nameStart) + nameStart.length(); // assuming nameStart != null
				int end1 = nameEnd == null ? line.length() : line.indexOf(nameEnd);
				String name = line.substring(start1, end1);
				int start2 = line.indexOf(numStart) + numStart.length();
				int end2 = numEnd == null ? line.length() : line.indexOf(numEnd);
				int number = Integer.parseInt(line.substring(start2, end2));
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
	 * Just to show how to use the previous, here are the arguments to pass to get the same results as AddressBook.
	 * FORMAT: Mathieu:1234567890
	 */
	public void readContacts(String group) {
		readContacts(group, ".txt", "", ":", ":", null); // equivalent to AddressBook.readContacts(String)
	}
	
	/**
	 * Another example of parameters, but to read numbers first (FORMAT: 1234567890:Mathieu)
	 */
	public void readContactsNumberFirst(String group) {
		readContacts(group, ".txt2", ":", null, "", ":");
	}
	
	public Set<Integer> getNumbers(String name) {
		return Collections.unmodifiableSet(contacts.get(name));
	}
}
