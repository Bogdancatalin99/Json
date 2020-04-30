package salud.isa.gsonMedDB;

import java.io.*;

import com.google.gson.stream.JsonReader;

public class ActiveIngredients extends CDM{

	private static final String ACTINGREF_FIELD_TAGNAME = "activeIngredients";
	private static final String NAME_FIELD_TAGNAME = "name";

	public ActiveIngredients(CDM s) {
		super(s);
	}

	public StringBuffer readCat(JsonReader reader, String name)
			throws IOException{
		if(name.equals(ACTINGREF_FIELD_TAGNAME)) {
			return super.everyPart(reader, name);
		}
		else {
			if(next != null) {
				return super.readCat(reader, name);
			}
			else {
				reader.skipValue();
				System.err.println("La categoria: '" + name + "' es incorrecta.");
				return new StringBuffer("");
			}
		}
	}

	public String readEntry(JsonReader reader) 
			throws IOException {
		String acting_name = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if(name.equals(NAME_FIELD_TAGNAME)) {
				acting_name = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}

		return acting_name;
	}
}
