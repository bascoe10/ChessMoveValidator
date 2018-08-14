public class BlackPieceFactory extends PieceFactory {
	private static BlackPieceFactory instance = null;
	
	private BlackPieceFactory(Color color){
		super(color);
	}
	
//	private BlackPieceFactory();
	public static BlackPieceFactory getInstance(){
		if(instance == null)
			instance = new BlackPieceFactory(Color.BLACK);
		return instance;
	}
}