import java.util.ArrayList;

public class Board {
	private ArrayList<Piece> black;
	private ArrayList<Piece> white;
	
	Piece[][] board = new Piece[8][8];
	
	public Board(ArrayList<Piece> black, ArrayList<Piece> white){
		this.black = black;
		this.white = white;
		for(Piece piece: black){
			board[piece.location.rank-1][piece.location.file.ordinal()] = piece;
		}
		
		for(Piece piece: white){
			board[piece.location.rank-1][piece.location.file.ordinal()] = piece;
		}
		
		// TODO check for piece conflict
	}
	
	public void display(){
		for(int i = 7; i>=0; i--){
			System.out.println(i+1 + "|" + piece_string(board[i][0]) + "|" + piece_string(board[i][1]) + "|" + piece_string(board[i][2]) + "|" + piece_string(board[i][3]) + "|" + piece_string(board[i][4]) + "|" + piece_string(board[i][5]) + "|" + piece_string(board[i][6]) + "|" + piece_string(board[i][7]) + "|");
		
//			System.out.println("---------------");
		}	
		System.out.println(" |A|B|C|D|E|F|G|H|");
	}
	
//	public void valid_move(File file, int rank){
//		Piece piece = board[rank][file.ordinal()];
//		ArrayList moves = piece.valid_moves();
//		
//	}
	
	private String piece_string(Piece piece){
		if(piece == null)
			return " ";
		return piece.toString();
	}

	public boolean is_vacant_at(Location location) {
		return board[location.rank-1][location.file.ordinal()] == null;
	}

	public boolean can_capture(Piece piece, Location location) {
		return piece.color != board[location.rank-1][location.file.ordinal()].color;
	}
	
	public boolean can_piece_move_lead_to_check(Piece piece){
		KingPiece king = find_king(piece.color);
		MoveValidator validator = null;
		boolean check = false;
		Piece temp = null;
		
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				temp = board[i][j];
				
				if(temp != null && temp.color.equals(piece.color)){
					validator = new MoveValidator(this, temp);
					for(Location location: validator.validate()){
						if(location.equals(king.location)){
							check = false;
							break;
						}
					}
				}
			}
		}
		return check;
	}
	
	public Board clone(){
		return new Board(black, white);
	}

	public void move_piece(Piece piece, Location location) {
		board[piece.location.rank-1][piece.location.file.ordinal()] = null;
		board[location.rank-1][location.file.ordinal()] = piece;
		return;
	}

	public void move_piece_back(Piece piece, Location location) {
		board[piece.location.rank-1][piece.location.file.ordinal()] = piece;
		board[location.rank-1][location.file.ordinal()] = null;
		return;
	}
	
	private KingPiece find_king(Color color){
		KingPiece king = null;
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				if(board[i][j] instanceof KingPiece && board[i][j].color.equals(color)){
					king = (KingPiece) board[i][j];
					break;
				}
					
			}
		}
		return king;
	}
}
