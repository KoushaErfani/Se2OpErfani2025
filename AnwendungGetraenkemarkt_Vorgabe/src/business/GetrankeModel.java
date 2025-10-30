package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class GetrankeModel {
	 private Getraenk getraenk;

	public Getraenk getGetraenk() {
		return getraenk;
	}

	public void setGetraenk(Getraenk getraenk) {
		this.getraenk = getraenk;
	}
	
	 public void leseAusDatei(String typ)throws Exception{
	    	
	      			BufferedReader ein = new BufferedReader(new FileReader("Getraenk.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.getraenk = new Getraenk(zeile[0], 
	      				Float.parseFloat(zeile[1]), 
	      				Float.parseFloat(zeile[2]), 
	      				zeile[3], 
	      				zeile[4].split("_"));
	      				ein.close();
	      	  			
	      		}
	     
		
			
		public void schreibeBahnhoefeInCsvDatei()throws Exception {
				BufferedWriter aus= new BufferedWriter(new FileWriter("GetraenkeAusgabe.csv", true));
				aus.write(this.getraenk.gibGetraenkZurueck(';'));
				aus.close();
	   			
		}

}
