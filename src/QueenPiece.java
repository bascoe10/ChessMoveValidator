import java.util.ArrayList;

public class QueenPiece extends Piece {

	QueenPiece(Color color, File file, int rank) {
		super(color, file, rank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Location> valid_moves() {
		ArrayList<Location> moves = new ArrayList<Location>();
		// Diagonal motion
		File file = location.file.getNext();
		int temp_rank = location.rank;
		//to top right
		while(file != null){
			temp_rank += 1;
			if(temp_rank > 0 && temp_rank < 9)
				moves.add(new Location(file, temp_rank));
			else
				break;
			file = file.getNext();
		}
		
		// to bottom left
		file = location.file.getPrev();
		temp_rank = location.rank;
		while(file != null){
			temp_rank -= 1;
			if(temp_rank > 0 && temp_rank < 9)
				moves.add(new Location(file, temp_rank));
			else
				break;
			file = file.getPrev();
		}
		
		file = location.file.getNext();
		temp_rank = location.rank;
		// to bottom right
		while(file != null){
			temp_rank -= 1;
			if(temp_rank > 0 && temp_rank < 9)
				moves.add(new Location(file, temp_rank));
			else
				break;
			file = file.getNext();
		}
		
		file = location.file.getPrev();
		temp_rank = location.rank;
		// to top left
		while(file != null){
			temp_rank += 1;
			if(temp_rank > 0 && temp_rank < 9)
				moves.add(new Location(file, temp_rank));
			else
				break;
			file = file.getPrev();
		}
		
		//axis motion
		for(int i =1; i<= 8; i++){
			if(location.rank != i)
				moves.add(new Location(location.file, i));
		}
		file = File.A;
		while(file != null){
			if(location.file != file)
				moves.add(new Location(file, location.rank));
			file = file.getNext();
		}
		return moves;
	}
	
	
	public String toString(){
		return "Q";
	}

}
