package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import fileCreatorsErfani.ConcereteCsvReaderCreatorErfani;
import fileCreatorsErfani.ConcereteTextReaderCreatorErfani;
import fileCreatorsErfani.ConcreteCsvReaderProductErfani;
import fileCreatorsErfani.ReaderCreatorErfani;
import fileCreatorsErfani.ReaderProductErfani;


public class GetrankeModel {
	 private Getraenk getraenk;

	public Getraenk getGetraenk() {
		return getraenk;
	}

	public void setGetraenk(Getraenk getraenk) {
		this.getraenk = getraenk;
	}
	
	 public void leseAusDatei(String typ)throws Exception{
		 if(typ.equals("csv")) {
		 ReaderCreatorErfani creator = new ConcereteCsvReaderCreatorErfani();
		 ReaderProductErfani reader = creator.factoryMethod();
	    	
	      			String[] zeile =reader.leseAusDatei();
	      			this.getraenk = new Getraenk(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				Float.parseFloat(zeile[2]), 
	      				zeile[3], 
	      				zeile[4].split("_"));
	      				reader.schliesseDatei();
		 }
		 else {
			 ReaderCreatorErfani creator = new ConcereteTextReaderCreatorErfani();
			 ReaderProductErfani reader = creator.factoryMethod();
			 String []zeile = reader.leseAusDatei();
			 this.getraenk = new Getraenk(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				Float.parseFloat(zeile[2]), 
	      				zeile[3], 
	      				zeile[4].split("_"));
	      				reader.schliesseDatei();
			 
		 }
	      	  			
	      		}
	     
		
			
		public void schreibeBahnhoefeInCsvDatei()throws Exception {
				BufferedWriter aus= new BufferedWriter(new FileWriter("GetraenkeAusgabe.csv", true));
				aus.write(this.getraenk.gibGetraenkZurueck(';'));
				aus.close();
	   			
		}

}
