package cs576;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

//	private RookPiece w_piece;
//	private RookPiece b_piece;
	
	private Board board;
	
	private ArrayList<Piece> black;
	private ArrayList<Piece> white;
	
//	private BlackPieceFactory b_factory;
//	private WhitePieceFactory w_factory;

	@Before
	public void setUp() throws Exception {
		black = new ArrayList<Piece>();
		white = new ArrayList<Piece>();
	
//		b_factory = BlackPieceFactory.getInstance();
//		w_factory = WhitePieceFactory.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		black.clear();
		white.clear();
	}

	@Test
	public void testBoardDisplayMethodWithEmptyBoard() {
		board = new Board(black, white);
		
		String str_board = new StringBuilder("8| | | | | | | | |\n7| | | | | | | | |\n6| | | | | | | | |\n5| | | | | | | | |\n4| | | | | | | | |\n3| | | | | | | | |\n2| | | | | | | | |\n1| | | | | | | | |\n |A|B|C|D|E|F|G|H|\n").toString();
		
		Assert.assertEquals(str_board, board.toString());
	}
	
	@Test
	public void testBoardDisplayMethodWithFillBoard() {
		white.add(new PawnPiece(Color.WHITE, File.A, Rank.TWO));
		white.add(new PawnPiece(Color.WHITE, File.B, Rank.TWO));
		white.add(new PawnPiece(Color.WHITE, File.C, Rank.TWO));
		white.add(new PawnPiece(Color.WHITE, File.D, Rank.TWO));
		white.add(new PawnPiece(Color.WHITE, File.E, Rank.TWO));
		white.add(new PawnPiece(Color.WHITE, File.F, Rank.TWO));
		white.add(new PawnPiece(Color.WHITE, File.G, Rank.TWO));
		white.add(new PawnPiece(Color.WHITE, File.H, Rank.TWO));
		
		white.add(new RookPiece(Color.WHITE, File.A, Rank.ONE));
		white.add(new KnightPiece(Color.WHITE, File.B, Rank.ONE));
		white.add(new BishopPiece(Color.WHITE, File.C, Rank.ONE));
		white.add(new QueenPiece(Color.WHITE, File.D, Rank.ONE));
		white.add(new KingPiece(Color.WHITE, File.E, Rank.ONE));
		white.add(new BishopPiece(Color.WHITE, File.F, Rank.ONE));
		white.add(new KnightPiece(Color.WHITE, File.G, Rank.ONE));
		white.add(new RookPiece(Color.WHITE, File.H, Rank.ONE));
		
		
		black.add(new PawnPiece(Color.BLACK, File.A, Rank.SEVEN));
		black.add(new PawnPiece(Color.BLACK, File.B, Rank.SEVEN));
		black.add(new PawnPiece(Color.BLACK, File.C, Rank.SEVEN));
		black.add(new PawnPiece(Color.BLACK, File.D, Rank.SEVEN));
		black.add(new PawnPiece(Color.BLACK, File.E, Rank.SEVEN));
		black.add(new PawnPiece(Color.BLACK, File.F, Rank.SEVEN));
		black.add(new PawnPiece(Color.BLACK, File.G, Rank.SEVEN));
		black.add(new PawnPiece(Color.BLACK, File.H, Rank.SEVEN));
		
		black.add(new RookPiece(Color.BLACK, File.A, Rank.EIGHT));
		black.add(new KnightPiece(Color.BLACK, File.B, Rank.EIGHT));
		black.add(new BishopPiece(Color.BLACK, File.C, Rank.EIGHT));
		black.add(new QueenPiece(Color.BLACK, File.D, Rank.EIGHT));
		black.add(new KingPiece(Color.BLACK, File.E, Rank.EIGHT));
		black.add(new BishopPiece(Color.BLACK, File.F, Rank.EIGHT));
		black.add(new KnightPiece(Color.BLACK, File.G, Rank.EIGHT));
		black.add(new RookPiece(Color.BLACK, File.H, Rank.EIGHT));
		
		board = new Board(black, white);
		
		String str_board = new StringBuilder("8|R|N|B|Q|K|B|N|R|\n7|P|P|P|P|P|P|P|P|\n6| | | | | | | | |\n5| | | | | | | | |\n4| | | | | | | | |\n3| | | | | | | | |\n2|P|P|P|P|P|P|P|P|\n1|R|N|B|Q|K|B|N|R|\n |A|B|C|D|E|F|G|H|\n").toString();
		
		Assert.assertEquals(str_board, board.toString());
	}

}
