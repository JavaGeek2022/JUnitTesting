package MP3UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Rory
 *
 */
class TestMP3 {

	// setting test data global data
	int Validref, invalidRef; // must be above 0 - boundary tests
	String artist;
	String songName;
	int MidRating, LowRating, HighRating;// rating between 1-5 - boundary tests
	int invalidHighRating, invalidLowRating;
	int ValLowSongLength, ValHighSongLength; // between 1-2500 seconds
	int invalidLowSongLength, invalidHighSongLength;

	MP3 MP3Song;

	@BeforeEach
	void setUp() throws Exception {
		invalidRef = 0;
		Validref = 1;

		LowRating = 1;
		MidRating = 2;
		HighRating = 4;
		invalidLowRating = 0;
		invalidHighRating = 5;

		ValLowSongLength = 1;
		ValHighSongLength = 2500;
		invalidLowSongLength = 0;
		invalidHighSongLength = 2600;

		MP3Song = new MP3();

	}

	@Test
	final void testConstructorwithArgs() {
		MP3 MP3con = new MP3(Validref, artist, songName, HighRating, ValHighSongLength);

		assertNotNull(MP3con);

		assertEquals(Validref, MP3con.getRef());
		assertEquals(HighRating, MP3con.getRating());
		assertEquals(ValHighSongLength, MP3con.getsongLength());
	}

	// positive test song length
	@Test
	final void testGetsongLength() {
		MP3Song.setsongLength(ValHighSongLength);
		assertEquals(ValHighSongLength, MP3Song.getsongLength());
		MP3Song.setsongLength(ValLowSongLength);
		assertEquals(ValLowSongLength, MP3Song.getsongLength());
	}
	/**
	 * testing invalid song length input
	 */
	@Test
	final void testGetsongLengthInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {

			MP3Song.setsongLength(invalidHighSongLength);

		});
		System.out.println(exp.getMessage());
		

		exp = assertThrows(IllegalArgumentException.class, () -> {
			MP3Song.setsongLength(invalidLowSongLength);
		});
		System.out.println(exp.getMessage());

	}

	@Test
	final void testGetRating() {
		MP3Song.setRating(HighRating);
		assertEquals(HighRating,	MP3Song.getRating());
		
		MP3Song.setRating(LowRating);
		assertEquals(LowRating, MP3Song.getRating());
	}
	@Test
	final void testGetRatingInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			
		MP3Song.setRating(invalidHighRating);
				 
		});
		System.out.println(exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, ()->{
			MP3Song.setRating(invalidLowRating);
		});
	}
}
