package guiWarenuebersicht;

import business.GetrankeModel;
import javafx.stage.Stage;

public class WarenuebersichtControl {

	private WarenuebersichtView warenuebersichtView;
	private GetrankeModel getraenkeModel;
	
	
	public WarenuebersichtControl(Stage primaryStage){
		this.getraenkeModel = GetrankeModel.getInstacne(); 		
		this.warenuebersichtView = new WarenuebersichtView(this, primaryStage,getraenkeModel);
}

}
