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
		
		String str_board = new StringBuilder("8| | | | | | | | |7| | | | | | | | |6| | | | | | | | |5| | | | | | | | |4| | | | | | | | |3| | | | | | | | |2| | | | | | | | |1| | | | | | | | | |A|B|C|D|E|F|G|H|").toString();
		
		Assert.assertEquals(str_board, board.toString());
	}
	
	@Test
	public void testBoardDisplayMethodWithFillBoard() {
		white.add(new PawnPiece(Color.WHITE, File.A, 2));
		white.add(new PawnPiece(Color.WHITE, File.B, 2));
		white.add(new PawnPiece(Color.WHITE, File.C, 2));
		white.add(new PawnPiece(Color.WHITE, File.D, 2));
		white.add(new PawnPiece(Color.WHITE, File.E, 2));
		white.add(new PawnPiece(Color.WHITE, File.F, 2));
		white.add(new PawnPiece(Color.WHITE, File.G, 2));
		white.add(new PawnPiece(Color.WHITE, File.H, 2));
		
		white.add(new RookPiece(Color.WHITE, File.A, 1));
		white.add(new KnightPiece(Color.WHITE, File.B, 1));
		white.add(new BishopPiece(Color.WHITE, File.C, 1));
		white.add(new QueenPiece(Color.WHITE, File.D, 1));
		white.add(new KingPiece(Color.WHITE, File.E, 1));
		white.add(new BishopPiece(Color.WHITE, File.F, 1));
		white.add(new KnightPiece(Color.WHITE, File.G, 1));
		white.add(new RookPiece(Color.WHITE, File.H, 1));
		
		
		black.add(new PawnPiece(Color.BLACK, File.A, 7));
		black.add(new PawnPiece(Color.BLACK, File.B, 7));
		black.add(new PawnPiece(Color.BLACK, File.C, 7));
		black.add(new PawnPiece(Color.BLACK, File.D, 7));
		black.add(new PawnPiece(Color.BLACK, File.E, 7));
		black.add(new PawnPiece(Color.BLACK, File.F, 7));
		black.add(new PawnPiece(Color.BLACK, File.G, 7));
		black.add(new PawnPiece(Color.BLACK, File.H, 7));
		
		black.add(new RookPiece(Color.BLACK, File.A, 8));
		black.add(new KnightPiece(Color.BLACK, File.B, 8));
		black.add(new BishopPiece(Color.BLACK, File.C, 8));
		black.add(new QueenPiece(Color.BLACK, File.D, 8));
		black.add(new KingPiece(Color.BLACK, File.E, 8));
		black.add(new BishopPiece(Color.BLACK, File.F, 8));
		black.add(new KnightPiece(Color.BLACK, File.G, 8));
		black.add(new RookPiece(Color.BLACK, File.H, 8));
		
		board = new Board(black, white);
		
		String str_board = new StringBuilder("8|R|N|B|Q|K|B|N|R|7|P|P|P|P|P|P|P|P|6| | | | | | | | |5| | | | | | | | |4| | | | | | | | |3| | | | | | | | |2|P|P|P|P|P|P|P|P|1|R|N|B|Q|K|B|N|R| |A|B|C|D|E|F|G|H|").toString();
		
		Assert.assertEquals(str_board, board.toString());
	}

}
