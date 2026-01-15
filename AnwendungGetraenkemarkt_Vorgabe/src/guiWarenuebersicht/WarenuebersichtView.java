package guiWarenuebersicht;

import businessGetraenk.Getraenk;
import businessGetraenk.GetrankeModel;
import businessSnack.Snack;
import businessSnack.SnackModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//import javafx.stage.WindowEvent;
import ownUtil.MeldungsfensterAnzeiger;
import ownUtil.Observable;
import ownUtil.Observer;

public class WarenuebersichtView implements Observer {
			private WarenuebersichtControl warenuebersichtControl;
			private GetrankeModel getraenkeModel;
			private SnackModel snackModel;
			//private Stage stage;
	    	//---Anfang Attribute der grafischen Oberflaeche---
	    	private Pane pane = new  Pane();
	    	private Label lblAnzeigeGetraenke= new Label("Anzeige Getraenke");
	    	private Label lblAnzeigeSnack= new Label("Anzeige Snacks");
	    	private TextArea txtAnzeigeGetraenke  = new TextArea();
	    	private TextArea txtAnzeigeSnack = new TextArea();
	    	private Button btnAnzeigeGetraenke = new Button("Anzeige");
	    	private Button btnAnzeigeSnack = new Button("csv-Import und Anzeige");
	    	//-------Ende Attribute der grafischen Oberflaeche-------
	    
	    	public WarenuebersichtView(WarenuebersichtControl warenuebersichtControl, Stage primaryStage, GetrankeModel getraenkeModel,SnackModel snackModel){
	    		Scene scene = new Scene(this.pane, 560, 340);
	    		primaryStage.setScene(scene);
	    		primaryStage.setTitle("Anzeige der Warenuebersicht");
	    		primaryStage.show();
	    		this.warenuebersichtControl = warenuebersichtControl;
	    		this.getraenkeModel = getraenkeModel;
	    		this.snackModel = snackModel;
	    		this.snackModel.addObserver(this);
	    		this.getraenkeModel.addObserver(this);
	    		//this.stage = stage;
	    		this.initKomponentenGetraenk();
	    		this.initKomponentenSnack();
	    		this.initListenerGetraenke();
	    		this.initListenerSnacks();
	    	}
	
	 	private void initKomponentenGetraenk(){
	    		// Label
	 		Font font = new Font("Arial", 20);
	       	lblAnzeigeGetraenke.setLayoutX(310);
	    		lblAnzeigeGetraenke.setLayoutY(40);
	    		lblAnzeigeGetraenke.setFont(font);
	    		lblAnzeigeGetraenke.setStyle("-fx-font-weight: bold;"); 
	       	pane.getChildren().add(lblAnzeigeGetraenke);           
	// Textbereich	
	        	txtAnzeigeGetraenke.setEditable(false);
	     		txtAnzeigeGetraenke.setLayoutX(310);
	    		txtAnzeigeGetraenke.setLayoutY(90);
	     		txtAnzeigeGetraenke.setPrefWidth(220);
	    		txtAnzeigeGetraenke.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeigeGetraenke);        	
	        	// Button
	          	btnAnzeigeGetraenke.setLayoutX(310);
	        	btnAnzeigeGetraenke.setLayoutY(290);
	        	pane.getChildren().add(btnAnzeigeGetraenke); 
	   }
		private void initKomponentenSnack(){
    		// Label
 		Font font = new Font("Arial", 20);
 			lblAnzeigeSnack.setLayoutX(0);
    		lblAnzeigeSnack.setLayoutY(40);
    		lblAnzeigeSnack.setFont(font);
    		lblAnzeigeSnack.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeSnack);           
// Textbereich	
        	txtAnzeigeSnack.setEditable(false);
     		txtAnzeigeSnack.setLayoutX(0);
    		txtAnzeigeSnack.setLayoutY(90);
     		txtAnzeigeSnack.setPrefWidth(220);
    		txtAnzeigeSnack.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeSnack);        	
        	// Button
          	btnAnzeigeSnack.setLayoutX(0);
        	btnAnzeigeSnack.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeSnack); 
   }
	   private void initListenerGetraenke() {
		    btnAnzeigeGetraenke.setOnAction(new EventHandler<ActionEvent>() {
		    		@Override
		        	public void handle(ActionEvent e) {
		            	update(getraenkeModel);
		        	} 
	   	    });
		   
	    }
	   private void initListenerSnacks() {
		    btnAnzeigeSnack.setOnAction(new EventHandler<ActionEvent>() {
		    		@Override
		        	public void handle(ActionEvent e) {
		            	update(snackModel);
		        	} 
	   	    });
		   
	    }
	   
	   /* public void zeigeGetraenkeAn(){
	    		if(getraenkeModel.getGetraenk() != null){
	    			txtAnzeigeGetraenke.setText(
	    				getraenkeModel.getGetraenk()
	 				.gibGetraenkZurueck(' '));
	    		}
	    		else{
	    			zeigeInformationsfensterAn(
	 				"Bisher wurde kein Getraenk aufgenommen!");
	    		}
	    }
	    */	
	   
	   
	   private void zeigeSnacksnAn(){
	       	warenuebersichtControl.leseSporthallenAusCsvDatei();
	    	 	if(snackModel.getSnack().size() > 0){
	    			StringBuffer text = new StringBuffer();
	    			for(Snack sn:snackModel.getSnack()) {
	    				text.append(sn.gibSnackZurueck(' ') + "\n");
	    			}
	    			this.txtAnzeigeSnack.setText(text.toString());
	    		}
	    		else{
	    			zeigeInformationsfensterAn( "Es gibt keine Snacks in der csv-Datei!");
	    		}
	 	}	
	   private void zeigeGetraenkeAn(){
			if(getraenkeModel.getGetraenk().size()>0){
				StringBuffer text = new StringBuffer();
				for(Getraenk getraenk : getraenkeModel.getGetraenk()) {
					text.append(getraenk.gibGetraenkZurueck(' ')).append("\n");
				}
				txtAnzeigeGetraenke.setText(text.toString());
			}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Getraenk aufgenommen!");
    		}
		   
	   }
	   
	   
	   @Override
		public void update(Observable o) {
		   if(o instanceof GetrankeModel) {
			   zeigeGetraenkeAn();
		   }
		   
		   if(o instanceof SnackModel) {
			   zeigeSnacksnAn();
		   }
		
			
		}

	 


	   
	   
	   
	   
	   
	   
	    private void zeigeInformationsfensterAn(String meldung){
	    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
	               	"Information", meldung).zeigeMeldungsfensterAn();
	    }

		
		void zeigeFehlermeldungsfensterAn(String meldung){
  	    	new MeldungsfensterAnzeiger(AlertType.ERROR,"Fehler", meldung).zeigeMeldungsfensterAn();
    	}

	    


}
