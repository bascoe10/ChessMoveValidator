
import java.util.ArrayList;

public class PawnPiece extends Piece {

	PawnPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Location> valid_moves() {
		// TODO account handle special move
		ArrayList<Location> moves = new ArrayList<Location>();
		if(color == Color.WHITE)
			moves.add(new Location(this.location.file, this.location.rank-1));
		else
			moves.add(new Location(this.location.file, this.location.rank+1));
		return moves;
	}
	
	public String toString(){
		return "P";
	}

}
