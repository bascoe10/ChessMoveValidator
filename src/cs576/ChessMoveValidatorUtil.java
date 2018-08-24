package cs576;
import java.util.ArrayList;

public class ChessMoveValidatorUtil {

	public static void main(String[] args) {
		ConfigurationLoader loader = configurationLoader(args[0], args[1]);
		PiecesBuilder builder = PiecesBuilder.get_instance(loader);
		
		ArrayList<Piece> black_pieces = builder.black_pieces;
		ArrayList<Piece> white_pieces = builder.white_pieces;
		Piece p = builder.piece_to_move;
		
		Board board = new Board(black_pieces, white_pieces);
		System.out.println(board);
		LocationList moves;
		
		MoveValidator validator = new MoveValidator(board, p);
		moves = validator.legalMoves();
		if(moves.isEmpty())
			System.out.println("No valid moves");
		else{
			for(Location l: moves)
				System.out.println(l);
		}
	}
	
	public static ConfigurationLoader configurationLoader(String filetype, String filename){
		ConfigurationLoader loader = null;
		switch(filetype){
		case "-j": 
			loader = new JsonConfigurationLoader(filename);
			break;
		default: System.out.println("File Type not supported");
			break;
		}
		return loader;
	}

}
