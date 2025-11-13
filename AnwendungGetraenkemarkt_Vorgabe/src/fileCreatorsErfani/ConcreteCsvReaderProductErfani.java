package fileCreatorsErfani;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ConcreteCsvReaderProductErfani extends ReaderProductErfani{
	private BufferedReader ein;

	public ConcreteCsvReaderProductErfani() {
		try {
		 ein = new BufferedReader(new FileReader("Getraenk.csv"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		
			String[] zeile = ein.readLine().split(";");
			
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		
		ein.close();
	}

}
