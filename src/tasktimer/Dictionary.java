package tasktimer;

import java.io.InputStream;
/**
 * read text file.
 * @author Wisarut Boonnumma
 *
 */
public class Dictionary {
	private static String DICTIONARY = "wordlist.txt";

	/**
	 * getWordAsStream open text file.
	 * @return InputStream from text file
	 */
	public static InputStream getWordAsStream() {
		return TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
	}
}
