/**
 * 
 */
package csc7327.objects;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * The {@link CheckInTime} present the time of checkin
 * @author luongnv89
 *
 */
public class CheckInTime {
	private final DateTimeFormatter formatter = DateTimeFormat.forPattern("EEEE MMM dd HH:mm:ss yyyy");
	/**
	 * UTC time offset
	 */
	int utcTimeOffset;
	/**
	 * UTC time stamp
	 */
	DateTime cityTime;
	/**
	 * @param utcTimeOffset
	 * @param utcTimeStamp
	 */
	public CheckInTime(int utcTimeOffset, String utcTimeStamp) {
		this.utcTimeOffset = utcTimeOffset;
		this.cityTime = getCityTime(utcTimeStamp);
	}
	
	/**
	 * Get the city time of checkin
	 * @param utcTimeStampString the String represent the utc time of checkin
	 * @return the real time of checkin in the city
	 */
	public DateTime getCityTime(String utcTimeStampString){
		return formatter.parseDateTime(utcTimeStampString).minusMinutes(utcTimeOffset);
	}
}
