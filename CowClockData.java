import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
/**
 * This class holds the data for the ASCII cow, as well as the method that returns the current time
 * @author Kit Kindred
 */
public class CowClockData {
	//ZonedDateTime and DateTimeFormatter used to return a meaningful time
	private ZonedDateTime currentDateTime = ZonedDateTime.now();
	private DateTimeFormatter tFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
	//Alternate d/t format: EEE MMM dd HH:mm:ss zzz
	
	CowClockData() {
		
	}
	/**
	 * This method returns an ASCII cow with the current (formatted) time
	 * @return The cow with the time
	 */
	public String generateCowTime() {
		
		String cow = "    <" + tFormat.format(currentDateTime) + ">\n"
				+ "        \\   ^__^\n"
				+ "         \\  (oo)\\_______\n"
				+ "             (__)\\           )\\/\\\n"
				+ "                  ||----w |\n"
				+ "                  ||         ||"; 
		
		return cow;
	}
}
