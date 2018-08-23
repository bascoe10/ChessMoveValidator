import java.util.ArrayList;

public abstract class ConfigurationLoader {
	protected String filename = null;
	public ArrayList<String> black_pieces_config = new ArrayList<String>();
	public ArrayList<String> white_pieces_config = new ArrayList<String>();
	public String piece_to_move = null;
	
	public ConfigurationLoader(String filename){
		this.filename = filename;
		this.loadConfig();
	}

	abstract protected void loadConfig();
}
