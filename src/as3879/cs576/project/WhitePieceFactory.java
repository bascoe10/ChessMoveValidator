package as3879.cs576.project;

public class WhitePieceFactory extends PieceFactory {
	private static WhitePieceFactory instance = null;
	
	private WhitePieceFactory(Color color){
		super(color);
	}
	
//	private BlackPieceFactory();
	public static WhitePieceFactory getInstance(){
		if(instance == null)
			instance = new WhitePieceFactory(Color.WHITE);
		return instance;
	}
}
