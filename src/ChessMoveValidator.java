import java.util.ArrayList;

public class ChessMoveValidator {

	public static void main(String[] args) {
		ConfigurationLoader loader = configuration_loader(args[0], args[1]);
		PiecesBuilder builder = PiecesBuilder.get_instance(loader);
		
		ArrayList<Piece> black_pieces = builder.black_pieces;
		ArrayList<Piece> white_pieces = builder.white_pieces;
		Piece p = builder.piece_to_move;
		System.out.println(p.location);
		
		Board board = new Board(black_pieces, white_pieces);
		board.display();
		LocationList moves;
		
		MoveValidator validator = new MoveValidator(board, p);
//		validator.validate();
//		System.out.println("ROOK F1---------------");
//		p = board.board[0][5];
		validator.validate();
		moves = validator.moves_that_can_lead_to_check();
		if(moves.isEmpty())
			System.out.println("No valid moves");
		else{
			for(Location l: moves)
				System.out.println(l);
		}
		board.display();
//		System.out.println("----------------------");
//		
//		System.out.println("KING G1---------------");
//		p = board.board[0][6];
//		moves = p.valid_moves();
//		for(Location l: moves)
//			System.out.println(l);
//		System.out.println("----------------------");
		
//		System.out.println("BISHOP F5---------------");
//		p = board.board[4][5];
//		moves = p.valid_moves();
//		for(Location l: moves)
//			System.out.println(l);
//		System.out.println("----------------------");
	}
	
	public static ConfigurationLoader configuration_loader(String filetype, String filename){
		ConfigurationLoader loader = null;
		switch(filetype){
		case "-j": loader = new JsonConfigurationLoader(filename);
			break;
		default: System.out.println("File Type not supported");
		}
		return loader;
	}

}
