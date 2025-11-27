package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import fileCreatorsErfani.ConcereteCsvReaderCreatorErfani;
import fileCreatorsErfani.ConcereteTextReaderCreatorErfani;
import fileCreatorsErfani.ConcreteCsvReaderProductErfani;
import fileCreatorsErfani.ReaderCreatorErfani;
import fileCreatorsErfani.ReaderProductErfani;
import ownUtil.Observable;
import ownUtil.Observer;


public class GetrankeModel implements Observable{
	
     private Getraenk getraenk;
	 private static GetrankeModel instance ;
	 
	 private Vector<Observer> observers = new Vector<Observer>();
	 
	 
	 private GetrankeModel() {
		
		}
	 
	 
	 public static GetrankeModel getInstacne() {
		 if(instance==null) {
			 instance = new GetrankeModel();
			 
		 }
		 
		 return instance;
	 }


	public Getraenk getGetraenk() {
		return getraenk;
	}

	public void setGetraenk(Getraenk getraenk) {
		this.getraenk = getraenk;
		notifyObservers();
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
	      				notifyObservers();
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
	      				notifyObservers();
			 
		 }
	      	  			
	      		}
	     
		
			
		public void schreibeBahnhoefeInCsvDatei()throws Exception {
				BufferedWriter aus= new BufferedWriter(new FileWriter("GetraenkeAusgabe.csv", true));
				aus.write(this.getraenk.gibGetraenkZurueck(';'));
				aus.close();
	   			
		}


		@Override
		public void addObserver(Observer obs) {
			observers.addElement(obs);
			
		}


		@Override
		public void removeObserver(Observer obs) {
			observers.removeElement(obs);
			
		}


		@Override
		public void notifyObservers() {
			for(Observer obs : observers) {
				obs.update();
			}
			
		}

}
