public abstract class PieceFactory {
	
	private Color color = null;
	
	public PieceFactory(Color color){
		this.color = color;
	}
	
	public Piece build(String piece_config){
		char type = piece_config.charAt(0);
		File file = char_to_file(piece_config.charAt(1));
		int rank = Character.getNumericValue(piece_config.charAt(2));
		// TODO validate rank and file
		return build_piece(type, file, rank);
	}
	
	private Piece build_piece(char type, File file, int rank){
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
