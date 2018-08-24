package as3879.cs576.project;

public abstract class Piece {
	protected Color color;
	protected Location location;
	protected LocationList moves;
	
	Piece(Color color, File file, Rank rank){
		this.color = color;
		this.location = new Location(file, rank);
		this.moves = new LocationList();
	}
	
	public abstract LocationList validMoves(Board board);
}
