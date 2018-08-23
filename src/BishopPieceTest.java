import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BishopPieceTest {

	private BishopPiece w_piece;
	private BishopPiece b_piece;
	
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
		b_piece = (BishopPiece) b_factory.build("Bd4");
		
		black.add(b_piece);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(13, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceSameSuitePiecesInPath() {
		b_piece = (BishopPiece) b_factory.build("Bd4");
		
		Piece p1 = (PawnPiece) b_factory.build("Pa7");
		Piece p2 = (PawnPiece) b_factory.build("Pf2");
		Piece p3 = (PawnPiece) b_factory.build("Pa1");
		Piece p4 = (PawnPiece) b_factory.build("Pf6");
		
		black.add(b_piece);
		
		black.add(p1);
		black.add(p2);
		black.add(p3);
		black.add(p4);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(6, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceDifferentSuitePiecesInPath() {
		b_piece = (BishopPiece) b_factory.build("Bd4");
		
		Piece p1 = (PawnPiece) w_factory.build("Pa7");
		Piece p2 = (PawnPiece) w_factory.build("Pf2");
		Piece p3 = (PawnPiece) w_factory.build("Pa1");
		Piece p4 = (PawnPiece) w_factory.build("Pf6");
		
		black.add(b_piece);
		
		white.add(p1);
		white.add(p2);
		white.add(p3);
		white.add(p4);
		
		board = new Board(black, white);
		
		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();
		
		Assert.assertEquals(10, moves.size());
	}
	
	@Test
	public void testValidMovesForPieceWhenKingInCheck() {
		w_piece = (BishopPiece) w_factory.build("Bd1");
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
		w_piece = (BishopPiece) w_factory.build("Bc3");
		
		Assert.assertEquals("B", w_piece.toString());
	}

}
