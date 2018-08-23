import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveValidatorTest {

	private PawnPiece w_piece;
	private Board board;
	
	private ArrayList<Piece> black;
	private ArrayList<Piece> white;
	
	private BlackPieceFactory b_factory;
	private WhitePieceFactory w_factory;

	@Before
	public void setUp() throws Exception {
		black = new ArrayList<Piece>();
		white = new ArrayList<Piece>();
	
		b_factory = BlackPieceFactory.getInstance();
		w_factory = WhitePieceFactory.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		black.clear();
		white.clear();
	}
	
	@Test
	public void testLegalMoves() {
		KingPiece kp = (KingPiece) w_factory.build("Kg2");
		w_piece = (PawnPiece) w_factory.build("Pf3");
		RookPiece rp = (RookPiece) b_factory.build("Rg4");
		
		black.add(rp);
		white.add(w_piece);
		white.add(kp);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(1, moves.size());
	}
	
	@Test
	public void testPsuedoLegalMoves(){
		KingPiece kp = (KingPiece) w_factory.build("Kg2");
		w_piece = (PawnPiece) w_factory.build("Pf3");
		RookPiece rp = (RookPiece) b_factory.build("Rg4");
		
		black.add(rp);
		white.add(w_piece);
		white.add(kp);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.psuedoLegalMoves();
		
		Assert.assertEquals(2, moves.size());
	}
	
//	@Test
//	public void testNullPiece(){
//		
//		board = new Board(black, white);
//		
//		MoveValidator validator = new MoveValidator(board, null);
//		
//		Assert.assertEquals(2, 2);
//	}

}
