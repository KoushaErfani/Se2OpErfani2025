package businessSnack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import businessGetraenk.Getraenk;
import businessGetraenk.GetrankeModel;
import fileCreatorsErfani.ConcereteCsvReaderCreatorErfani;
import fileCreatorsErfani.ConcereteTextReaderCreatorErfani;
import fileCreatorsErfani.ReaderCreatorErfani;
import fileCreatorsErfani.ReaderProductErfani;
import ownUtil.Observable;
import ownUtil.Observer;

public class SnackModel implements Observable{
	
	private ArrayList<Snack> snacks= new ArrayList<Snack>();
	 private static SnackModel instance ;
	 
	 private Vector<Observer> observers = new Vector<Observer>();
	 
	 
	 private SnackModel() {
		
		}
	 
	 
	 public static SnackModel getInstacne() {
		 if(instance==null) {
			 instance = new SnackModel();
			 
		 }
		 
		 return instance;
	 }


	public ArrayList<Snack> getSnack() {
		return snacks;
	}

	public void addSnack(Snack snack) {
		this.snacks.add(snack);
		notifyObservers();
	}
	
	public void leseSporthallenAusCsvDatei()
			throws IOException {
			BufferedReader ein = new BufferedReader(new FileReader("Snack.csv"));
	 		ArrayList<Snack> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			while(zeileStr != null) {
				String[] zeile = zeileStr.split(";");
	           		ergebnis.add( new Snack(zeile[0], zeile[1], zeile[2]));
	           		zeileStr = ein.readLine();
			}    
	 		ein.close();
	 		this.snacks = ergebnis;
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
				obs.update(this);
			}
			
		}


}
