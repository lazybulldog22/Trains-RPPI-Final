package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class trainsAdd implements EventHandler<ActionEvent> {

    //FOR ADDING SCENE
    Stage addStage = new Stage();
    Button btnConfirm = new Button();
    Button btnAddPlatform = new Button();
    TextArea textRegion = new TextArea();
    TextArea textStation = new TextArea();
    TextArea textPlatform = new TextArea();
    ComboBox<String> comboBoxWheelchair = new ComboBox<>();
    ComboBox<Integer> comboBoxPlatLength = new ComboBox<Integer>();
    Label showPlatforms = new Label();

    public void addingTrains(){

        //FOR ADDING SCENE
        btnConfirm.setText("Confirm");
        btnConfirm.setTranslateX(0);
        btnConfirm.setTranslateY(100);


        btnAddPlatform.setText("Add Platform");
        btnAddPlatform.setTranslateX(-102);
        btnAddPlatform.setTranslateY(71);

        showPlatforms.setText("Platforms:");
        //showPlatforms.setStyle("-fx-border-color:black");
        showPlatforms.setStyle("-fx-text-alignment: left; -fx-alignment: top-left");
        showPlatforms.setPrefSize(90,130);
        showPlatforms.setTranslateX(97);
        showPlatforms.setTranslateY(-53);

        textRegion.setPrefSize(190,5);
        textRegion.setMaxSize(190,5);
        textRegion.setPromptText("Add new Region");
        textRegion.setTranslateX(-50);
        textRegion.setTranslateY(-100);

        textStation.setPrefSize(190,5);
        textStation.setMaxSize(190,5);
        textStation.setPromptText("Add new Station");
        textStation.setTranslateX(-50);
        textStation.setTranslateY(-60);

        textPlatform.setPrefSize(190,5);
        textPlatform.setMaxSize(190,5);
        textPlatform.setPromptText("Add new Platform");
        textPlatform.setTranslateX(-50);
        textPlatform.setTranslateY(-20);

        comboBoxWheelchair.setPrefSize(190,5);
        comboBoxWheelchair.setMaxSize(190,5);
        comboBoxWheelchair.setPromptText("Wheelchair Accessible");
        comboBoxWheelchair.setTranslateX(-50);
        comboBoxWheelchair.setTranslateY(15);
        comboBoxWheelchair.getItems().addAll("Yes","No");



        comboBoxPlatLength.setPrefSize(190,5);
        comboBoxPlatLength.setMaxSize(190,5);
        comboBoxPlatLength.setPromptText("Platform Length in Meters");
        comboBoxPlatLength.setTranslateX(-50);
        comboBoxPlatLength.setTranslateY(43);
        for (int i = 10; i < 510; i+=10) {
            comboBoxPlatLength.getItems().addAll(i);
        }

        btnAddPlatform.setOnAction(this);
        btnConfirm.setOnAction(this);

        //creating new panel with buttons to add new things
        StackPane layoutAdd = new StackPane();
        //displaying all the values on the scene
        layoutAdd.getChildren().addAll(btnConfirm, btnAddPlatform, textRegion,textStation, textPlatform, showPlatforms,comboBoxWheelchair,comboBoxPlatLength);


        //create thirdStage as a new window to add new Station

        Scene sceneAddStage = new Scene(layoutAdd,300,250);
        addStage.setTitle("Add new Station");
        addStage.setScene(sceneAddStage);
        addStage.show();


    }


    public void handle(ActionEvent event){


        if(event.getSource()==btnAddPlatform){

            if(comboBoxWheelchair.getValue()==null||comboBoxPlatLength.getValue()==null||textPlatform.getText()==null||textPlatform.getText().trim().isEmpty()){
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
                System.out.println("btnAddPlatform");
                showPlatforms.setText(showPlatforms.getText()+"\n"+textPlatform.getText()+" W: "+comboBoxWheelchair.getValue()+" L: "+comboBoxPlatLength.getValue());
                textPlatform.clear();
                comboBoxWheelchair.setValue(null);
                comboBoxPlatLength.setValue(null);
            }

        }

        if(event.getSource()==btnConfirm){
            if(textRegion.getText().trim().isEmpty()||textStation.getText().trim().isEmpty()){
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
                System.out.println("\n"+textStation.getText()+"\n"+textRegion.getText()+"\n"+showPlatforms.getText());
                System.out.println("btnConfirm");
                addStage.close();
            }

        }


    }
}
