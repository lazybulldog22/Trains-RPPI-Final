package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class trainsEdit implements EventHandler<ActionEvent> {
    //FOR EDITING SCENE
    Stage editStage = new Stage();
    ComboBox<String> comboBoxEditRegion = new ComboBox<>();
    ComboBox<String> comboBoxEditStation = new ComboBox<>();
    ComboBox<String> comboBoxEditPlatform = new ComboBox<>();
    ComboBox<String> comboBoxWheelchairEdit = new ComboBox<>();
    ComboBox<Integer> comboBoxPlatLengthEdit = new ComboBox<>();
    TextArea editRegion = new TextArea();
    TextArea editStation = new TextArea();
    TextArea editPlatform = new TextArea();
    Label showPlatformsEdit = new Label();
    Button btnEditPlatform = new Button();
    Button btnConfirmEdit = new Button();

    public void editingTrains(){
        //FOR EDITING SCENE

        editRegion.setPrefSize(135,5);
        editRegion.setMaxSize(135,5);
        editRegion.setPromptText("Change Region");
        editRegion.setTranslateX(-75);
        editRegion.setTranslateY(-70);

        editStation.setPrefSize(135,5);
        editStation.setMaxSize(135,5);
        editStation.setPromptText("Change Station");
        editStation.setTranslateX(75);
        editStation.setTranslateY(-70);

        editPlatform.setPrefSize(135,5);
        editPlatform.setMaxSize(135,5);
        editPlatform.setPromptText("Change Platform");
        editPlatform.setTranslateX(-75);
        editPlatform.setTranslateY(10);


        //creating ComboBoxes, giving them items, promptText as a background text, using translate to position it
        comboBoxEditRegion.getItems().addAll("Pardubický Kraj","Královehradecký Kraj");
        //setting prefered size
        comboBoxEditRegion.setPrefSize(135,20);
        comboBoxEditRegion.setPromptText("Region");
        //positioning
        comboBoxEditRegion.setTranslateX(-75);
        comboBoxEditRegion.setTranslateY(-110);


        comboBoxEditStation.setPrefSize(135,20);
        comboBoxEditStation.setPromptText("Train Station");
        comboBoxEditStation.setTranslateX(75);
        comboBoxEditStation.setTranslateY(-110);


        comboBoxEditPlatform.getItems().addAll("1","1A","2","3C");
        comboBoxEditPlatform.setPrefSize(135,20);
        comboBoxEditPlatform.setPromptText("Platform");
        comboBoxEditPlatform.setTranslateX(-75);
        comboBoxEditPlatform.setTranslateY(-30);


        comboBoxWheelchairEdit.setPrefSize(190,5);
        comboBoxWheelchairEdit.setMaxSize(190,5);
        comboBoxWheelchairEdit.setPromptText("Wheelchair Accessible");
        comboBoxWheelchairEdit.setTranslateX(-47);
        comboBoxWheelchairEdit.setTranslateY(45);
        comboBoxWheelchairEdit.getItems().addAll("Yes","No");

        comboBoxPlatLengthEdit.setPrefSize(190,5);
        comboBoxPlatLengthEdit.setMaxSize(190,5);
        comboBoxPlatLengthEdit.setPromptText("Platform Length in Meters");
        comboBoxPlatLengthEdit.setTranslateX(-47);
        comboBoxPlatLengthEdit.setTranslateY(75);
        for (int j = 10; j < 510; j+=10) {
            comboBoxPlatLengthEdit.getItems().addAll(j);
        }


        showPlatformsEdit.setText("Platforms:");
        //showPlatformsEdit.setStyle("-fx-border-color:black");
        showPlatformsEdit.setStyle("-fx-text-alignment: left; -fx-alignment: top-left");
        showPlatformsEdit.setPrefSize(90,130);
        showPlatformsEdit.setTranslateX(97);
        showPlatformsEdit.setTranslateY(23);


        btnEditPlatform.setText("Edit Platform");
        btnEditPlatform.setTranslateX(-100);
        btnEditPlatform.setTranslateY(105);

        btnConfirmEdit.setText("Confirm All");
        btnConfirmEdit.setTranslateX(0);
        btnConfirmEdit.setTranslateY(105);


        comboBoxEditStation.setOnAction(this);
        comboBoxEditRegion.setOnAction(this);
        comboBoxEditPlatform.setOnAction(this);
        btnEditPlatform.setOnAction(this);
        btnConfirmEdit.setOnAction(this);

        //creating new panel with buttons to add new things
        StackPane layoutEdit = new StackPane();

        //displaying all the values on the scene
        layoutEdit.getChildren().addAll(comboBoxEditRegion,comboBoxEditStation,comboBoxEditPlatform,comboBoxPlatLengthEdit,
                comboBoxWheelchairEdit,editPlatform, editRegion, editStation,showPlatformsEdit,btnEditPlatform,btnConfirmEdit);
        Scene sceneEditStage = new Scene(layoutEdit,300,250);
        editStage.setTitle("Edit existing Station");
        editStage.setScene(sceneEditStage);
        editStage.show();
    }


    public void handle(ActionEvent event){
        //test if the first ComboBox is for Pardubický Kraj od Královehradecký Kraj, change the second ComboBox based on that to show the correct Cities in that region
        if(event.getSource()==comboBoxEditRegion){
            if(comboBoxEditRegion.getValue()=="Pardubický Kraj"){
                //using .clear() to clear all the items on click so it does not stack infinitely
                comboBoxEditStation.getItems().clear();
                //adding elements to ComboBox
                comboBoxEditStation.getItems().addAll("Pardubice Hlavní Nádraží","Choceň");

                editRegion.clear();
                editRegion.setText(comboBoxEditRegion.getValue());
            }
            if(comboBoxEditRegion.getValue()=="Královehradecký Kraj"){
                //using .clear() to clear all the items on click so it does not stack infinitely
                comboBoxEditStation.getItems().clear();
                //adding elements to ComboBox
                comboBoxEditStation.getItems().addAll("Hradec Králové");

                editRegion.clear();
                editRegion.setText(comboBoxEditRegion.getValue());
            }
        }

        //if editStation then automatically put it in the editStation TextArea
        if(event.getSource()==comboBoxEditStation){
            editStation.setText(comboBoxEditStation.getValue());
        }

        if(event.getSource()==comboBoxEditPlatform){
            editPlatform.setText(comboBoxEditPlatform.getValue());
        }

        if(event.getSource()==btnEditPlatform){

            if(comboBoxWheelchairEdit.getValue()==null||comboBoxPlatLengthEdit.getValue()==null||editPlatform.getText().trim().isEmpty()){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    Platform.runLater(() -> {
                        System.out.println("Null values");
                        Alert dialog = new Alert(Alert.AlertType.ERROR, "Select Platform name, \nWheelchair Accssesibility \nand Platform Length");
                        dialog.show();
                    });
                }
            }else{
                System.out.println("btnEditPlatform");
                showPlatformsEdit.setText(showPlatformsEdit.getText()+"\n"+editPlatform.getText()+" W: "+comboBoxWheelchairEdit.getValue()+" L: "+comboBoxPlatLengthEdit.getValue());
                editPlatform.clear();
                comboBoxWheelchairEdit.setValue(null);
                comboBoxPlatLengthEdit.setValue(null);
            }

        }



        if(event.getSource()==btnConfirmEdit){
            if(editRegion.getText().trim().isEmpty()||editStation.getText().trim().isEmpty()){
                try {
                    throw new Exception();
                } catch (Exception e) {
                    Platform.runLater(() -> {
                        System.out.println("Null values");
                        Alert dialog = new Alert(Alert.AlertType.ERROR, "Fill out all the options");
                        dialog.show();
                    });
                }
            }else{
                System.out.println("\n"+editStation.getText()+"\n"+editRegion.getText()+"\n"+showPlatformsEdit.getText());
                System.out.println("btnDeleteConfirm");
                editStage.close();
            }

        }

    }

}
