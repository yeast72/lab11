package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Append all the words from the dictionary to a String. This shows why you
 * should be careful about using "string1"+"string2".
 * 
 * @author Wisarut Boonnumma
 */
public class Task5 implements Runnable {
	// Limit number of words read. Otherwise, the next task could be very
	// sloooow.
	static final int MAXCOUNT = 50_000;

	@Override
	public void run() {
		InputStream instream = Dictionary.getWordAsStream();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(instream));
		} catch (Exception ex) {
			out.println("Could not open dictionary: " + ex.getMessage());
			return;
		}

		String result = "";
		String word = null;
		int count = 0;
		try {
			while ((word = br.readLine()) != null && count < MAXCOUNT) {
				result = result + word;
				count++;
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.printf("Done appending %d words to string.\n", count);
	}

	public String toString() {
		return " append " + MAXCOUNT + " words to a String using +";
	}
}
