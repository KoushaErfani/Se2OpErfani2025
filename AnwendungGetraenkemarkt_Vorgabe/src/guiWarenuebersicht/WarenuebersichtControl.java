package guiWarenuebersicht;

import java.io.IOException;

import businessGetraenk.GetrankeModel;
import businessSnack.SnackModel;
import javafx.stage.Stage;

public class WarenuebersichtControl {

	private WarenuebersichtView warenuebersichtView;
	private GetrankeModel getraenkeModel;
	private SnackModel snackModel;
	
	
	public WarenuebersichtControl(Stage primaryStage){
		this.getraenkeModel = GetrankeModel.getInstacne();
		this.snackModel = SnackModel.getInstacne();
		this.setWarenuebersichtView(new WarenuebersichtView(this, primaryStage,getraenkeModel,snackModel));
}


	public WarenuebersichtView getWarenuebersichtView() {
		return warenuebersichtView;
	}


	public void setWarenuebersichtView(WarenuebersichtView warenuebersichtView) {
		this.warenuebersichtView = warenuebersichtView;
	}
	
	public void leseSporthallenAusCsvDatei(){
		try{
			this.snackModel.leseSporthallenAusCsvDatei();
		}
		catch(IOException exc){
			this.warenuebersichtView.zeigeFehlermeldungsfensterAn("IOException beim Lesen von Sporthallen!");
		}
		catch(Exception exc){
			this.warenuebersichtView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen von Sporthallen!");
		}
	}


}
