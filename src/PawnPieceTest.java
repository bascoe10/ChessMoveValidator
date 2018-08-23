import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PawnPieceTest {
	private PawnPiece w_piece;
	private PawnPiece b_piece;

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
	public void testValidMovesWhenInStartingPositionBlack() {
		b_piece = (PawnPiece) b_factory.build("Pc7");
		black.add(b_piece);

		board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(2, moves.size());
	}

	@Test
	public void testValidMovesWhenNotInStartingPositionBlack() {
		b_piece = (PawnPiece) b_factory.build("Pc6");
		black.add(b_piece);

		board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(1, moves.size());
	}

	@Test
	public void testValidMovesWhenNotInStartingPositionAndPieceCanCaptureLeftDiagonalBlack() {

		w_piece = (PawnPiece) w_factory.build("Pd5");
		b_piece = (PawnPiece) b_factory.build("Pc6");

		black.add(b_piece);
		white.add(w_piece);

		board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(2, moves.size());
	}

	@Test
	public void testValidMovesWhenNotInStartingPositionAndPieceCanCaptureRightDiagonalBlack() {

		w_piece = (PawnPiece) w_factory.build("Pd5");
		b_piece = (PawnPiece) b_factory.build("Pe6");

		black.add(b_piece);
		white.add(w_piece);

		board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, b_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(2, moves.size());
	}

	@Test
	public void testValidMovesWhenNotInStartingPositionAndPieceCanCaptureLeftDiagonalWhite() {

		w_piece = (PawnPiece) w_factory.build("Pf4");
		b_piece = (PawnPiece) b_factory.build("Pe5");

		black.add(b_piece);
		white.add(w_piece);

		board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(2, moves.size());
	}

	@Test
	public void testValidMovesWhenNotInStartingPositionAndPieceCanCaptureRightDiagonalWhite() {

		w_piece = (PawnPiece) w_factory.build("Pf4");
		b_piece = (PawnPiece) b_factory.build("Pg5");

		black.add(b_piece);
		white.add(w_piece);

		board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(2, moves.size());
	}

	@Test
	public void testValidMovesWhenInStartingPositionWhite() {
		w_piece = (PawnPiece) w_factory.build("Pc2");
		black.add(w_piece);

		Board board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(2, moves.size());
	}

	@Test
	public void testValidMovesWhenNotInStartingPositionWhite() {
		w_piece = (PawnPiece) w_factory.build("Pc3");
		black.add(w_piece);

		Board board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(1, moves.size());
	}

	@Test
	public void testValidMovesIfKingWillBeInCheck() {
		KingPiece kp = (KingPiece) w_factory.build("Kg2");
		w_piece = (PawnPiece) w_factory.build("Pf3");
		RookPiece rp = (RookPiece) b_factory.build("Rg4");

		black.add(rp);
		white.add(w_piece);
		white.add(kp);

		Board board = new Board(black, white);

		MoveValidator validator = new MoveValidator(board, w_piece);
		LocationList moves = validator.legalMoves();

		Assert.assertEquals(1, moves.size());
	}

	@Test
	public void testStringRepresentationOfPiece() {
		w_piece = (PawnPiece) w_factory.build("Pc3");

		Assert.assertEquals("P", w_piece.toString());
	}

}
