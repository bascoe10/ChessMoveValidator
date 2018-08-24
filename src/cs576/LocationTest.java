package cs576;
import org.junit.Assert;
import org.junit.Test;

public class LocationTest {

	@Test
	public void testStringRepresentation() {
		Location location = new Location(File.A, Rank.ONE);
		Assert.assertEquals("A1", location.toString());
	}
	
	@Test
	public void testEqualityTrue() {
		Location location1 = new Location(File.A, Rank.ONE);
		Location location2 = new Location(File.A, Rank.ONE);
		Assert.assertTrue(location1.equals(location2));
	}
	
	@Test
	public void testEqualityFalse1() {
		Location location1 = new Location(File.A, Rank.ONE);
		Location location2 = new Location(File.A, Rank.TWO);
		Assert.assertFalse(location1.equals(location2));
	}
	
	@Test
	public void testEqualityFalse2() {
		Location location1 = new Location(File.A, Rank.ONE);
		Location location2 = new Location(File.B, Rank.ONE);
		Assert.assertFalse(location1.equals(location2));
	}
	
	@Test
	public void testEqualityFalse3() {
		Location location1 = new Location(File.A, Rank.ONE);
		Location location2 = new Location(File.B, Rank.TWO);
		Assert.assertFalse(location1.equals(location2));
	}
	
	@Test
	public void testEqualityWithNull() {
		Location location1 = new Location(File.A, Rank.ONE);
		Assert.assertFalse(location1.equals(null));
	}
	
	@Test
	public void testEqualityOfHashCode() {
		Location location1 = new Location(File.A, Rank.ONE);
		Location location2 = new Location(File.A, Rank.ONE);
		Assert.assertEquals(location1.hashCode(), location2.hashCode());
	}

}
