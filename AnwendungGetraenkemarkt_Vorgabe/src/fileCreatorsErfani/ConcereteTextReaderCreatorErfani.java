package fileCreatorsErfani;

public class ConcereteTextReaderCreatorErfani extends ReaderCreatorErfani{

	@Override
	public ReaderProductErfani factoryMethod() {
		
		return new ConcereteTextReaderProduct();
	}
	
	

}
