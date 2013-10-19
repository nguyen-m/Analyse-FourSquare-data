/**
 * 
 */
package csc7327.objects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import csc7327.enums.DayInWeek;
import csc7327.enums.TimeInDay;

/**
 * @author luongnv89
 * 
 */
public class DataTimeSlot {
	TimeInDay timeInDay;
	DayInWeek dayInWeek;
	String file_venue;
	ArrayList<CheckIn> listCheckIns;
	String file_geographic;
	FileWriter venue_file;
	FileWriter geographic_file;

	/**
	 * @param timeInDay
	 * @param dayInWeek
	 */
	public DataTimeSlot(TimeInDay timeInDay, DayInWeek dayInWeek,
			String cityName) {
		this.timeInDay = timeInDay;
		this.dayInWeek = dayInWeek;
		this.listCheckIns = new ArrayList<CheckIn>();
		this.file_venue = "analysis-tokyo/" + cityName + "_venueCategoryTag" + "_"
				+ timeInDay + "_" + dayInWeek + ".txt";
		this.file_geographic = "analysis-tokyo/" + cityName + "_geographical" + "_"
				+ timeInDay + "_" + dayInWeek + ".txt";
		try {
			venue_file = new FileWriter(file_venue, true);
			geographic_file = new FileWriter(file_geographic, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addACheckIn(CheckIn checkin) {
		listCheckIns.add(checkin);
	}

	public void analyze(String fileName) {

		BufferedWriter write1 = null;
		BufferedWriter write2 = null;
		try {
			write1 = new BufferedWriter(venue_file);
			write2 = new BufferedWriter(geographic_file);
			for (int i = 0; i < listCheckIns.size(); i++) {
				String venueCategory = convertToTag(listCheckIns.get(i).getVenue().getVenueCategory());
				write1.write(venueCategory
						+ "\n");
				write2.write(listCheckIns.get(i).getGpsCoordinates().toString()
						+ "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				write1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				write2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param venueCategory
	 * @return
	 */
	private String convertToTag(String venueCategory) {
		return venueCategory.replace(" ", "").replace("/", "");
	}

	/**
	 * @return the timeInDay
	 */
	public TimeInDay getTimeInDay() {
		return timeInDay;
	}

	/**
	 * @return the dayInWeek
	 */
	public DayInWeek getDayInWeek() {
		return dayInWeek;
	}

}
