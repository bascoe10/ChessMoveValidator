package as3879.cs576.project;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueenPieceTest {

	private QueenPiece w_piece;
	private QueenPiece b_piece;
	
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
		b_piece = (QueenPiece) b_factory.build("Qd4");
		
		black.add(b_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(27, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceSameSuitePiecesInPath() {
		b_piece = (QueenPiece) b_factory.build("Qd4");
		
		Piece p1 = (PawnPiece) b_factory.build("Pa7");
		Piece p2 = (PawnPiece) b_factory.build("Pf2");
		Piece p3 = (PawnPiece) b_factory.build("Pa1");
		Piece p4 = (PawnPiece) b_factory.build("Pf6");
		Piece p5 = (PawnPiece) b_factory.build("Pd7");
		Piece p6 = (PawnPiece) b_factory.build("Pd1");
		Piece p7 = (PawnPiece) b_factory.build("Pa4");
		Piece p8 = (PawnPiece) b_factory.build("Pg4");
		
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
		
		Assert.assertEquals(14, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceDifferentSuitePiecesInPath() {
		b_piece = (QueenPiece) b_factory.build("Qd4");
		
		Piece p1 = (PawnPiece) w_factory.build("Pa7");
		Piece p2 = (PawnPiece) w_factory.build("Pf2");
		Piece p3 = (PawnPiece) w_factory.build("Pa1");
		Piece p4 = (PawnPiece) w_factory.build("Pf6");
		Piece p5 = (PawnPiece) w_factory.build("Pd7");
		Piece p6 = (PawnPiece) w_factory.build("Pd1");
		Piece p7 = (PawnPiece) w_factory.build("Pa4");
		Piece p8 = (PawnPiece) w_factory.build("Pg4");
		
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
		
		Assert.assertEquals(22, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceWhenKingInCheck() {
		w_piece = (QueenPiece) w_factory.build("Qd1");
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
		w_piece = (QueenPiece) w_factory.build("Qc3");
		
		Assert.assertEquals("Q", w_piece.toString());
	}

}
