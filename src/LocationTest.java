import org.junit.Assert;
import org.junit.Test;

public class LocationTest {

	@Test
	public void testStringRepresentation() {
		Location location = new Location(File.A, 1);
		Assert.assertEquals("A1", location.toString());
	}
	
	@Test
	public void testEqualityTrue() {
		Location location1 = new Location(File.A, 1);
		Location location2 = new Location(File.A, 1);
		Assert.assertTrue(location1.equals(location2));
	}
	
	@Test
	public void testEqualityFalse1() {
		Location location1 = new Location(File.A, 1);
		Location location2 = new Location(File.A, 2);
		Assert.assertFalse(location1.equals(location2));
	}
	
	@Test
	public void testEqualityFalse2() {
		Location location1 = new Location(File.A, 1);
		Location location2 = new Location(File.B, 1);
		Assert.assertFalse(location1.equals(location2));
	}
	
	@Test
	public void testEqualityFalse3() {
		Location location1 = new Location(File.A, 1);
		Location location2 = new Location(File.B, 2);
		Assert.assertFalse(location1.equals(location2));
	}
	
	@Test
	public void testEqualityWithNull() {
		Location location1 = new Location(File.A, 1);
		Assert.assertFalse(location1.equals(null));
	}
	
	@Test
	public void testEqualityOfHashCode() {
		Location location1 = new Location(File.A, 1);
		Location location2 = new Location(File.A, 1);
		Assert.assertEquals(location1.hashCode(), location2.hashCode());
	}

}
