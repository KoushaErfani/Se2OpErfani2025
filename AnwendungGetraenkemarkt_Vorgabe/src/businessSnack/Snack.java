package businessSnack;

public class Snack {
	
	private String snackbeschreibung;
	private int einkaufspreis;
	private int verkaufspreis;
	
	public Snack(String snackbeschreibung, String einkaufspreis, String verkaufspreis) {
		super();
		this.snackbeschreibung = snackbeschreibung;
		this.einkaufspreis = Integer.parseInt(einkaufspreis);
		this.verkaufspreis = Integer.parseInt(verkaufspreis);
	}
	
	public String gibSnackZurueck(char trenner){
  		return this.getSnackbeschreibung() + trenner 
  			+ this.getEinkaufspreis() + trenner
  		    + this.getVerkaufspreis();
   	}

	public String getSnackbeschreibung() {
		return snackbeschreibung;
	}

	public void setSnackbeschreibung(String snackbeschreibung) {
		this.snackbeschreibung = snackbeschreibung;
	}

	public int getEinkaufspreis() {
		return einkaufspreis;
	}

	public void setEinkaufspreis(int einkaufspreis) {
		this.einkaufspreis = einkaufspreis;
	}

	public int getVerkaufspreis() {
		return verkaufspreis;
	}

	public void setVerkaufspreis(int verkaufspreis) {
		this.verkaufspreis = verkaufspreis;
	}
	
}
