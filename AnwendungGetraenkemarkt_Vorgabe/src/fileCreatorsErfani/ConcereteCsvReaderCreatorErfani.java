package fileCreatorsErfani;

public class ConcereteCsvReaderCreatorErfani extends ReaderCreatorErfani {

	@Override
	public ReaderProductErfani factoryMethod() {
		
		return new ConcreteCsvReaderProductErfani();
	}

}
