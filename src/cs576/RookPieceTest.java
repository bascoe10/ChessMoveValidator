package cs576;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RookPieceTest {
	
	private RookPiece w_piece;
//	private RookPiece b_piece;
	
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
	public void testValidMovesForPieceNoOtherPiecesInPath() {
		w_piece = (RookPiece) w_factory.build("Ra1");
		white.add(w_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(14, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceInCornerSqWithSameSuitePiecesInPath() {
		Piece ph = (RookPiece) w_factory.build("Ra5");
		Piece pv = (RookPiece) w_factory.build("Re1");
		
		w_piece = (RookPiece) w_factory.build("Ra1");
		white.add(w_piece);
		white.add(ph);
		white.add(pv);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(6, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceInCornerSqWithDifferentSuitePiecesInPath() {
		Piece ph = (RookPiece) b_factory.build("Ra5");
		Piece pv = (RookPiece) b_factory.build("Re1");
		
		w_piece = (RookPiece) w_factory.build("Ra1");
		white.add(w_piece);
		black.add(ph);
		black.add(pv);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(8, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceWithSameSuitePiecesInPath() {
		Piece ph1 = (RookPiece) w_factory.build("Rd7");
		Piece ph2 = (RookPiece) w_factory.build("Rd2");
		
		Piece pv1 = (RookPiece) w_factory.build("Rb4");
		Piece pv2 = (RookPiece) w_factory.build("Rg4");
		
		w_piece = (RookPiece) w_factory.build("Rd4");
		white.add(w_piece);
		white.add(ph1);
		white.add(ph2);
		
		white.add(pv1);
		white.add(pv2);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(6, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceWithDifferentSuitePiecesInPath() {
		Piece ph1 = (RookPiece) b_factory.build("Rd7");
		Piece ph2 = (RookPiece) b_factory.build("Rd2");
		
		Piece pv1 = (RookPiece) b_factory.build("Rb4");
		Piece pv2 = (RookPiece) b_factory.build("Rg4");
		
		w_piece = (RookPiece) w_factory.build("Rd4");
		white.add(w_piece);
		black.add(ph1);
		black.add(ph2);
		
		black.add(pv1);
		black.add(pv2);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(10, moves.size());
	}
	
	@Test
	public void testValidMoveForPieceWithKingToDefend(){
		Piece p_piece = (PawnPiece) b_factory.build("Pf3");
		
		Piece k_piece = (KingPiece) w_factory.build("Kg2");
		
		w_piece = (RookPiece) w_factory.build("Rg3");
		white.add(w_piece);
		white.add(k_piece);
		
		black.add(p_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(1, moves.size());
	}
	
	@Test
	public void testStringRepresentationOfPiece(){
		w_piece = (RookPiece) w_factory.build("Rc3");
		
		Assert.assertEquals("R", w_piece.toString());
	}

}
