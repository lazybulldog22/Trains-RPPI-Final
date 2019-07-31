package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class deleteTrains implements EventHandler<ActionEvent>{


    //FOR DELETE SCENE
    Stage deleteStage = new Stage();
    ComboBox<String> comboBoxDeleteRegion = new ComboBox<>();
    ComboBox<String> comboBoxDeleteStation = new ComboBox<>();
    Button btnConfirmDelete = new Button();
    Button btnDeleteStation = new Button();
    Label showDelete = new Label();

    public void deletingTrains(){

        //FOR DELETE SCENE
        comboBoxDeleteRegion.getItems().addAll("Pardubický Kraj","Královehradecký Kraj");
        comboBoxDeleteRegion.setPrefSize(135,5);
        comboBoxDeleteRegion.setMaxSize(135,5);
        comboBoxDeleteRegion.setPromptText("Choose Region");
        comboBoxDeleteRegion.setTranslateX(-75);
        comboBoxDeleteRegion.setTranslateY(-110);

        comboBoxDeleteStation.setPrefSize(135,5);
        comboBoxDeleteStation.setMaxSize(135,5);
        comboBoxDeleteStation.setPromptText("Choose Station");
        comboBoxDeleteStation.setTranslateX(75);
        comboBoxDeleteStation.setTranslateY(-110);

        showDelete.setText("Deleted Stations:");
        //showDelete.setStyle("-fx-border-color:black");
        showDelete.setStyle("-fx-text-alignment: left; -fx-alignment: top-left");
        showDelete.setPrefSize(90,130);
        showDelete.setTranslateX(-100);
        showDelete.setTranslateY(-10);

        btnDeleteStation.setText("Delete Station");
        btnDeleteStation.setTranslateX(0);
        btnDeleteStation.setTranslateY(75);


        btnConfirmDelete.setText("Confirm");
        btnConfirmDelete.setTranslateX(0);
        btnConfirmDelete.setTranslateY(105);

        comboBoxDeleteRegion.setOnAction(this);
        comboBoxDeleteStation.setOnAction(this);
        btnConfirmDelete.setOnAction(this);
        btnDeleteStation.setOnAction(this);

        //creating new panel with buttons to add new things
        StackPane layoutEdit = new StackPane();

        //displaying all the values on the scene
        layoutEdit.getChildren().addAll(btnConfirmDelete,comboBoxDeleteRegion,comboBoxDeleteStation,btnDeleteStation,showDelete);
        Scene sceneEditStage = new Scene(layoutEdit,300,250);
        deleteStage.setTitle("Delete Station");
        deleteStage.setScene(sceneEditStage);
        deleteStage.show();
    }

    public void handle(ActionEvent event){
        //test if the first ComboBox is for Pardubický Kraj od Královehradecký Kraj, change the second ComboBox based on that to show the correct Cities in that region
        if(event.getSource()==comboBoxDeleteRegion){
            if(comboBoxDeleteRegion.getValue()=="Pardubický Kraj"){
                //using .clear() to clear all the items on click so it does not stack infinitely
                comboBoxDeleteStation.getItems().clear();
                //adding elements to ComboBox
                comboBoxDeleteStation.getItems().addAll("Pardubice Hlavní Nádraží","Choceň");
            }
            if(comboBoxDeleteRegion.getValue()=="Královehradecký Kraj"){
                //using .clear() to clear all the items on click so it does not stack infinitely
                comboBoxDeleteStation.getItems().clear();
                //adding elements to ComboBox
                comboBoxDeleteStation.getItems().addAll("Hradec Králové");

            }
        }



        if(event.getSource()==btnDeleteStation){
            showDelete.setText(showDelete.getText()+"\n"+comboBoxDeleteStation.getValue());
        }


        if(event.getSource()==btnConfirmDelete){
            System.out.println("\n"+comboBoxDeleteStation.getValue()+"\n"+comboBoxDeleteRegion+"\n"+showDelete.getText());
            System.out.println("btnConfirmDelete");
            deleteStage.close();


        }
    }

}
