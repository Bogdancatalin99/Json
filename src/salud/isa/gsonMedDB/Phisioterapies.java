package salud.isa.gsonMedDB;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class Phisioterapies extends CDM{

	private static final String PHYSIOTHERAPIES_TAGNAME = "physiotherapies";
	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEP = "name";

	public Phisioterapies (CDM s) {
		super(s);
	}

	public StringBuffer readCat(JsonReader reader, String name)
			throws IOException{
		if(name.equals(PHYSIOTHERAPIES_TAGNAME)) {
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
		String phisio_name = null;
		String phisio_ima = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if(name.equals(NAME_FIELD_TAGNAME)) {
				phisio_name = reader.nextString();
			}
			else if (name.equals(IMAGE_FIELD_TAGNAME)){
				phisio_ima = reader.nextString();
			}
			else {
				reader.skipValue();
			}
		}

		return phisio_name + FIELD_SEP + phisio_ima;
	}
}
