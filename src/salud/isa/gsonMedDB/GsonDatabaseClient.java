package salud.isa.gsonMedDB;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GsonDatabaseClient {

	public static void main(String[] args) {
		try{
			// creamos la cadena de mando:
			ActiveIngredients AI = new ActiveIngredients(null);
			Inhalers I = new Inhalers(AI);
			Medicine M = new Medicine(I);
			MedicinePresentations MP = new MedicinePresentations(M);
			Phisioterapies P = new Phisioterapies(MP);
			Posologies Po = new Posologies(P);
			RescueMedicinePresentations RMP = new RescueMedicinePresentations(Po);
			UserManualSteps UMS = new UserManualSteps(RMP);
			UserManualsPhisioSteps UMPS = new UserManualsPhisioSteps(UMS);
			DatabaseJSonReader DJR = new DatabaseJSonReader(UMPS);

			try {
				System.out.println(DJR.parse("./datos.json"));
			} finally {
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
