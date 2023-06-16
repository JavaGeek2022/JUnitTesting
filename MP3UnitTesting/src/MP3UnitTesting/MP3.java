package MP3UnitTesting;

public class MP3 {
	private int ref;
	private String artist;
	private String songName;
	private int rating;
	private int songLength;

	public final static int LOWER_RATING = 0, HIGH_RATING = 5;
	//default constructor
	public MP3() {
		
	}
	/**
	 * Constructor 
	 * @param ref
	 * @param artist
	 * @param songName
	 * @param rating
	 */
	public MP3(int ref, String artist, String songName, int rating, int songLength) {
		this.ref = ref;
		this.artist = artist;
		this.songName = songName;
		this.rating = rating;
		this.songLength = songLength;
	}


	public int getRef() {
		return ref;
	}
	public int getsongLength() {
		return songLength;
		
	}
	/**
	 * setting songlength to between 1 and 2500 seconds
	 * @param songLength
	 * @throws IllegalArgumentException
	 */
	public void setsongLength(int songLength) throws IllegalArgumentException{
		if (songLength<1 || songLength>2500) {
			
			throw new IllegalArgumentException("Song length not within parameters");
		}
		
		else {
		this.songLength = songLength;	
		}
	}

	/**
	 * If less than zero then throw exception
	 * 
	 * @param ref
	 */
	public void setRef(int ref) throws IllegalArgumentException {

		if (ref < LOWER_RATING) {
			this.ref = LOWER_RATING;
		}
		throw new IllegalArgumentException("Ref less than 0, setting to default 0");
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getRating() {
		return rating;
	}

	/**
	 * 
	 * @param rating should be between 1-5
	 * @throws IllegalArgumentException
	 */
	public void setRating(int rating) throws IllegalArgumentException {
		if ((rating > LOWER_RATING) && (rating < HIGH_RATING)) {
			this.rating = rating;
		} else {
			throw new IllegalArgumentException("Rating outside of scale (1-5)");
		}

	}

}
