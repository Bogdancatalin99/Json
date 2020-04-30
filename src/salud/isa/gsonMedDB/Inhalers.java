package salud.isa.gsonMedDB;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class Inhalers extends CDM{

	private static final String INHALERS_TAGNAME = "inhalers";
	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEP = ";";

	public Inhalers(CDM s) {
		super(s);

	}

	public StringBuffer readCategory(JsonReader reader, String name) 
			throws IOException {
		if(name.equals(INHALERS_TAGNAME)) {
			return super.everyPart(reader, name);
		}
		else {
			if(next != null) {
				return super.readCategory(reader, name);
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
		String inha_name = null;
		String inha_ima = null;
		while(reader.hasNext()) {
			String name = reader.nextString();
			if(name.equals(NAME_FIELD_TAGNAME)) {
				inha_name = reader.nextString();
			}
			else if(name.equals(IMAGE_FIELD_TAGNAME)) {
				inha_ima = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}

		return inha_name + FIELD_SEP + inha_ima;
	}

}
