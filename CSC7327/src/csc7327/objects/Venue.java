/**
 * 
 */
package csc7327.objects;

/**
 * The {@link Venue} represent the information of venue
 * @author luongnv89
 *
 */
public class Venue {
	/**
	 * The id of venue
	 */
	String venueID;
	/**
	 * The category of venue: Coffee shop, restaurant,....
	 */
	String venueCategory;
	/**
	 * @param venueID
	 * @param venueCategory
	 */
	public Venue(String venueID, String venueCategory) {
		this.venueID = venueID;
		this.venueCategory = venueCategory;
	}
	/**
	 * @return the venueID
	 */
	public String getVenueID() {
		return venueID;
	}
	/**
	 * @return the venueCategory
	 */
	public String getVenueCategory() {
		return venueCategory;
	}
	
	public boolean equals(Venue other) {
		if(!(other instanceof Venue)||other == null) return false;
		return this.venueID.equals(other.getVenueID()) && this.venueCategory.equals(other.getVenueCategory());
	}
	
	@Override
	public String toString(){
		return venueID+"\t"+venueCategory; 
	}
	
	
}
