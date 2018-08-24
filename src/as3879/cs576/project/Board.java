package as3879.cs576.project;
import java.util.ArrayList;

public class Board {
	private ArrayList<Piece> black;
	private ArrayList<Piece> white;
	
	private KingPiece black_king;
	private KingPiece white_king;
	
	private Piece piece_to_allow_for_move;
	
	private Piece[][] board = new Piece[8][8];
	
	public Board(ArrayList<Piece> black, ArrayList<Piece> white){
		this.black = black;
		this.white = white;
		for(Piece piece: black){
			board[piece.location.rankInt()][piece.location.fileInt()] = piece;
			if(piece instanceof KingPiece)
				this.black_king = (KingPiece) piece;
		}
		
		for(Piece piece: white){
			board[piece.location.rankInt()][piece.location.fileInt()] = piece;
			if(piece instanceof KingPiece)
				this.white_king = (KingPiece) piece;
		}
		
		// TODO check for piece conflict
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(int i = 7; i>=0; i--){
			builder.append(i+1 + "|" + pieceString(board[i][0]) + "|" + pieceString(board[i][1]) + "|" + pieceString(board[i][2]) + "|" + pieceString(board[i][3]) + "|" + pieceString(board[i][4]) + "|" + pieceString(board[i][5]) + "|" + pieceString(board[i][6]) + "|" + pieceString(board[i][7]) + "|\n");
		}	
		builder.append(" |A|B|C|D|E|F|G|H|\n");
		return builder.toString();
	}
	
	private String pieceString(Piece piece){
		if(piece == null)
			return " ";
		return piece.toString();
	}

	public boolean isVacantAt(Location location) {
		return board[location.rankInt()][location.fileInt()] == null;
	}

	public boolean canCapture(Piece piece, Location location) {
		if(location.file == null || location.rank == null)
			return false;
		if(isVacantAt(location))
			return false;
		return piece.color != board[location.rankInt()][location.fileInt()].color;
	}
	
	public void movePiece(Piece piece, Location location) {
		Piece p_location = board[location.rankInt()][location.fileInt()];
		board[piece.location.rankInt()][piece.location.fileInt()] = null;
		if(p_location != null){
			piece_to_allow_for_move = p_location;
			if(p_location.color == Color.BLACK)
				black.remove(p_location);
			else
				white.remove(p_location);
		}
		board[location.rankInt()][location.fileInt()] = piece;
	}

	public void movePieceBack(Piece piece, Location location) {
		board[piece.location.rankInt()][piece.location.fileInt()] = piece;
		board[location.rankInt()][location.fileInt()] = piece_to_allow_for_move;
		if(piece_to_allow_for_move == null)
			return;
		if(piece_to_allow_for_move.color == Color.BLACK)
			black.add(piece_to_allow_for_move);
		else
			white.add(piece_to_allow_for_move);
		piece_to_allow_for_move = null;
	}
	
	public boolean willLeadToCheck(Piece piece, Location location){
		ArrayList<Piece> pieces = null;
		KingPiece king = null;
		LocationList moves = null;
		Boolean in_check = false;
		
		if(piece.color == Color.BLACK){
			king = black_king;
			pieces = white;
		} else {
			king = white_king;
			pieces = black;
		}
		this.movePiece(piece, location);
		
		for(Piece p: pieces){
			moves = p.validMoves(this);
			for(Location l: moves){
				if(piece instanceof KingPiece){
					if(king != null && l.equals(location)){
						in_check = true;
						break;
					}
				}else{
					if(king != null && l.equals(king.location)){
						in_check = true;
						break;
					}
				}
			}
			if(in_check)
				break;
		}
		this.movePieceBack(piece, location);
		
		return in_check;
	}
}
