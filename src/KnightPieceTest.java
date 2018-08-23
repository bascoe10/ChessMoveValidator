import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnightPieceTest {
	private KnightPiece w_piece;
	private KnightPiece b_piece;
	
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
	public void testValidMovesForPieceNoOtherPieces() {
		b_piece = (KnightPiece) b_factory.build("Nd5");
		black.add(b_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(8, moves.size());
	}
	@Test
	public void testValidMovesForPieceInCornerQuad1NoOtherPieces() {
		b_piece = (KnightPiece) b_factory.build("Nh8");
		black.add(b_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(2, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceInCornerQuad2NoOtherPieces() {
		b_piece = (KnightPiece) b_factory.build("Na8");
		black.add(b_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(2, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceInCornerQuad3NoOtherPieces() {
		b_piece = (KnightPiece) b_factory.build("Na1");
		black.add(b_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(2, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceInCornerQuad4NoOtherPieces() {
		b_piece = (KnightPiece) b_factory.build("Nh1");
		black.add(b_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(2, moves.size());
	}
	
	@Test
	public void testValidMovesForPiecePieceOfSameSuitIn2Locations() {
		b_piece = (KnightPiece) b_factory.build("Nd5");
		
		Piece p1 = (PawnPiece) b_factory.build("Pc7");
		Piece p2 = (PawnPiece) b_factory.build("Pe3");
		
		black.add(b_piece);
		black.add(p1);
		black.add(p2);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(6, moves.size());
	}
	
	@Test
	public void testValidMovesForPiecePieceOfDifferentSuitIn2Locations() {
		b_piece = (KnightPiece) b_factory.build("Nd5");
		
		Piece p1 = (PawnPiece) w_factory.build("Pc7");
		Piece p2 = (PawnPiece) w_factory.build("Pe3");
		
		black.add(b_piece);
		
		white.add(p1);
		white.add(p2);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(8, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceWhenSurroundedByOtherPiecesIn2Locations() {
		b_piece = (KnightPiece) b_factory.build("Nd5");
		
		Piece p1 = (PawnPiece) w_factory.build("Pc4");
		Piece p2 = (PawnPiece) w_factory.build("Pc5");
		Piece p3 = (PawnPiece) w_factory.build("Pc6");
		Piece p4 = (PawnPiece) w_factory.build("Pd4");
		Piece p5 = (PawnPiece) w_factory.build("Pe4");
		Piece p6 = (PawnPiece) w_factory.build("Pe5");
		Piece p7 = (PawnPiece) w_factory.build("Pe6");
		Piece p8 = (PawnPiece) w_factory.build("Pd6");
		
		black.add(b_piece);
		
		white.add(p1);
		white.add(p2);
		white.add(p3);
		white.add(p4);
		white.add(p5);
		white.add(p6);
		white.add(p7);
		white.add(p8);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(8, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceWhenKingInCheck() {
		w_piece = (KnightPiece) w_factory.build("Nf2");
		Piece k_piece = (KingPiece) w_factory.build("Kg2");
		
		Piece p1 = (RookPiece) b_factory.build("Rg4");
		
		black.add(p1);
		
		white.add(w_piece);
		white.add(k_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(1, moves.size());
	}
	
	@Test
	public void testStringRepresentationOfPiece(){
		w_piece = (KnightPiece) w_factory.build("Nc3");
		
		Assert.assertEquals("N", w_piece.toString());
	}

}
