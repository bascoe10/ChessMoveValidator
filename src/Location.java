
public class Location {
	public File file;
	public int rank;
	
	Location(File file, int rank){
		this.file = file;
		this.rank = rank;
	}
	
	public String toString(){
		StringBuilder string = new StringBuilder("");
		string = string.append(file);
		string = string.append(String.valueOf(rank));
		return string.toString();
	}
	
	public boolean equals(Object o){
		Location location = (Location) o;
		if(location == null)
			return false;
		return(this.file == location.file && this.rank == location.rank);
	}
	
	public int hashCode() {
	  return 206; // any arbitrary constant will do
	}
}
