import java.util.ArrayList;

public class PiecesBuilder {
	private static PiecesBuilder instance = null;
	public ArrayList<Piece> black_pieces;
	public ArrayList<Piece> white_pieces;
	public Piece piece_to_move;
	
	private PiecesBuilder(ConfigurationLoader config){
		black_pieces = new ArrayList<Piece>();
		white_pieces = new ArrayList<Piece>();
		BlackPieceFactory b_factory = BlackPieceFactory.getInstance();
		WhitePieceFactory w_factory = WhitePieceFactory.getInstance();
		Piece temp;
		// TODO redundant code refactor
		for(String black_piece_config: config.black_pieces_config){
			temp = b_factory.build(black_piece_config);
			if(config.piece_to_move.equals(black_piece_config))
				piece_to_move = temp;
			black_pieces.add(temp);
		}
		
		for(String white_piece_config: config.white_pieces_config){
			temp = w_factory.build(white_piece_config);
			if(config.piece_to_move.equals(white_piece_config))
				piece_to_move = temp;
			white_pieces.add(temp);
		}
	}
	
	public static PiecesBuilder get_instance(ConfigurationLoader config){
		if(instance == null)
			instance = new PiecesBuilder(config);
		return instance;
	}

}
