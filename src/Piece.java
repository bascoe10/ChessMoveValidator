
public abstract class Piece {
	protected Color color;
	protected Location location;
	
	Piece(Color color, File file, int rank){
		this.color = color;
		this.location = new Location(file, rank);
	}
	
	public void get_location(){
		System.out.println(this.color + "-" + this.getClass() + "-" + this.location.file + "-" + this.location.rank);
	}
	
	public abstract LocationList valid_moves(Board board);
}
