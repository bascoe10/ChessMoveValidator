package as3879.cs576.project;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KingPieceTest {

//	private KingPiece w_piece;
	private KingPiece b_piece;
	
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
	public void testValidMovesForPieceNoPieceInPath() {
		b_piece = (KingPiece) b_factory.build("Kd4");
		
		black.add(b_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(8, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceSameSuitePiecesInPath() {
		b_piece = (KingPiece) b_factory.build("Kd5");
		
		Piece p1 = (PawnPiece) b_factory.build("Pc4");
		Piece p2 = (PawnPiece) b_factory.build("Pc5");
		Piece p3 = (PawnPiece) b_factory.build("Pc6");
		Piece p4 = (PawnPiece) b_factory.build("Pd4");
		Piece p5 = (PawnPiece) b_factory.build("Pe4");
		Piece p6 = (PawnPiece) b_factory.build("Pe5");
		Piece p7 = (PawnPiece) b_factory.build("Pe6");
		Piece p8 = (PawnPiece) b_factory.build("Pd6");
		
		black.add(b_piece);
		
		black.add(p1);
		black.add(p2);
		black.add(p3);
		black.add(p4);
		black.add(p5);
		black.add(p6);
		black.add(p7);
		black.add(p8);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(0, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceDifferentSuitePiecesInPath() {
		b_piece = (KingPiece) b_factory.build("Kd5");
		
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
		
		Assert.assertEquals(5, moves.size());
	}
	
	@Test
	public void testStringRepresentationOfPiece(){
		b_piece = (KingPiece) w_factory.build("Kc3");
		
		Assert.assertEquals("K", b_piece.toString());
	}
}