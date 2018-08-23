import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LocationList implements Collection<Location> {
	ArrayList<Location> locations;
	
	public LocationList() {
		this.locations = new ArrayList<Location>();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return locations.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return locations.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return locations.contains(o);
	}

	@Override
	public Iterator<Location> iterator() {
		// TODO Auto-generated method stub
		return locations.iterator();
	}

	@Override
	public Object[] toArray() {
		return locations.toArray();
	}

	@Override
	public boolean add(Location location) {
		return locations.add(location);
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return locations.remove(o);
	}

	@Override
	public void clear() {
		locations.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		Object[] array = locations.toArray();
		if(array == null)
			return null;
		return (T[]) array;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return locations.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Location> c) {
		return locations.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return locations.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return locations.retainAll(c);
	}

}
