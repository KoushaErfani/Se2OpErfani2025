package fileCreatorsErfani;

import java.io.IOException;

public abstract class ReaderProductErfani {
	public abstract String[] leseAusDatei() throws IOException;
	public abstract void schliesseDatei()throws IOException;

}
