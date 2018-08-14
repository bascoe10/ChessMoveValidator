
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

}
