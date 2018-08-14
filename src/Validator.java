import java.util.ArrayList;

public abstract class Validator {
	protected Board board;
	protected Piece piece;
	
	public Validator(Board board, Piece piece){
		this.board = board;
		this.piece = piece;
	}
	
	public abstract ArrayList<Location> validate();
}