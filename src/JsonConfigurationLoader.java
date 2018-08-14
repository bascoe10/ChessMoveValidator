import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonConfigurationLoader extends ConfigurationLoader {
	
	public JsonConfigurationLoader(String filename) {
		super(filename);
	}

	void load_config(){
		try {
			Object obj = new JSONParser().parse(new FileReader(this.filename));
			JSONObject config = (JSONObject) obj;
			// load config for black pieces
			for(Object o: (JSONArray)config.get("black"))
				black_pieces_config.add((String) o);
			
			// load config for white piecez
			for(Object o: (JSONArray)config.get("white"))
				white_pieces_config.add((String) o);
			
			// load config for piece to move
			this.piece_to_move = (String) config.get("piece_to_move");
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
