
public abstract class Piece {
	protected Color color;
	protected Location location;
	protected LocationList moves;
	
	Piece(Color color, File file, Rank rank){
		this.color = color;
		this.location = new Location(file, rank);
	}
	
//	public void get_location(){
//		System.out.println(this.color + "-" + this.getClass() + "-" + this.location.file + "-" + this.location.rank);
//	}
	
	public boolean validRank(int range){
		
		return (range > 0 && range < 9);
	}
	
	public abstract LocationList validMoves(Board board);
}
