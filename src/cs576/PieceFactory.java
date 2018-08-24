package cs576;
public abstract class PieceFactory {
	
	private Color color = null;
	
	public PieceFactory(Color color){
		this.color = color;
	}
	
	public Piece build(String piece_config){
		char type = piece_config.charAt(0);
		File file = char_to_file(piece_config.charAt(1));
		Rank rank = char_to_rank(piece_config.charAt(2));
		// TODO validate rank and file
		return build_piece(type, file, rank);
	}
	
	private Rank char_to_rank(char rank) {
		Rank _rank = null;
		switch(rank){
		case '1': _rank = Rank.ONE;
			break;
		case '2': _rank = Rank.TWO;
			break;
		case '3': _rank = Rank.THREE;
			break;
		case '4': _rank = Rank.FOUR;
			break;
		case '5': _rank = Rank.FIVE;
			break;
		case '6': _rank = Rank.SIX;
			break;
		case '7': _rank = Rank.SEVEN;
			break;
		case '8': _rank = Rank.EIGHT;
			break;
		default:
			// TODO raise 
		}
		return _rank;
	}

	private Piece build_piece(char type, File file, Rank rank){
		Piece piece = null;
		switch(type){
		case 'K': piece = new KingPiece(color, file, rank);
			break;
		case 'Q': piece = new QueenPiece(color, file, rank);
			break;
		case 'B': piece = new BishopPiece(color, file, rank);
			break;
		case 'N': piece = new KnightPiece(color, file, rank);
			break;
		case 'R': piece = new RookPiece(color, file, rank);
			break;
		case 'P': piece = new PawnPiece(color, file, rank);
			break;
		default:
			// TODO raise exception
			
		}
		return piece;
		
	}
	
	private File char_to_file(char file){
		File _file = null;
		switch(file){
		case 'a': _file = File.A;
			break;
		case 'b': _file = File.B;
			break;
		case 'c': _file = File.C;
			break;
		case 'd': _file = File.D;
			break;
		case 'e': _file = File.E;
			break;
		case 'f': _file = File.F;
			break;
		case 'g': _file = File.G;
			break;
		case 'h': _file = File.H;
			break;
		default:
			// TODO raise 
		}
		return _file;
	}
}
