import java.util.ArrayList;

public class MoveValidator {
	private Board board;
	private Piece piece;
	private Validator validator;
	private ArrayList<Location> moves;
	
	public MoveValidator(Board board, Piece piece){
		this.board = board;
		this.piece = piece;
		validator = chooseValidator();
	}
	
	public ArrayList<Location> validate(){
		moves = validator.validate();
		return moves;
	}
	
	public LocationList moves_that_can_lead_to_check(){
		LocationList valid_moves = new LocationList();
		Board new_board = null;
		
		for(Location location: validator.validate()){
			new_board = board.clone();
			new_board.move_piece(piece, location);
			System.out.println("-------------------------------");
			new_board.display();
			if(!(board.can_piece_move_lead_to_check(piece)))
				valid_moves.add(location);
		}
		return valid_moves;
	}
	
	private Validator chooseValidator(){
		if(piece instanceof PawnPiece)
			return new PawnValidator(board, piece);
		
		if(piece instanceof KnightPiece)
			return new KnightValidator(board, piece);
		
		if(piece instanceof RookPiece)
			return new RookValidator(board, piece);
		
		if(piece instanceof BishopPiece)
			return new BishopValidator(board, piece);
		
		if(piece instanceof QueenPiece)
			return new QueenValidator(board, piece);
		
		if(piece instanceof KingPiece)
			return new KingValidator(board, piece);
		
		return null;
	}
}
