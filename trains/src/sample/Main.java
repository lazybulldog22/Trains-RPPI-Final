package sample;

//imports
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.image.Image ;



public class Main extends Application implements EventHandler<ActionEvent> {
//creating variables
    //FOR FIRST SCENE
    Button btnSearch = new Button();
    Button btnAdd = new Button();
    Button btnEdit = new Button();
    Button btnDelete = new Button();

    Stage displayStage = new Stage();
    ComboBox<String> comboBoxRegion = new ComboBox<>();
    ComboBox<String> comboBoxStation = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //dataTrains dataTrains = new dataTrains();
        //dataTrains.dataAboutTrains();
        //String[][] data = dataTrains.data;
        //String stations = dataTrains.stations;

        //FOR FIRST SCENE

        //creating new search button, comboBox for choosing, using setTranslate to position them
        btnSearch.setText("Search");
        btnSearch.setPrefSize(150,20);
        btnSearch.setTranslateX(-68);
        btnSearch.setTranslateY(-60);

        //creating new Add button for adding new Stations using setTranslate to position them
        btnAdd.setText("Add new Station");
        btnAdd.setPrefSize(150,20);
        btnAdd.setTranslateX(-68);
        btnAdd.setTranslateY(-30);

        //creating Edit button
        btnEdit.setText("Edit");
        btnEdit.setPrefSize(150,20);
        btnEdit.setTranslateX(-68);
        btnEdit.setTranslateY(0);

        //creating new Delete button
        btnDelete.setText("Delete");
        btnDelete.setPrefSize(150,20);
        btnDelete.setTranslateX(-68);
        btnDelete.setTranslateY(30);

        //creating ComboBoxes, giving them items, promptText as a background text, using translate to position it
        comboBoxRegion.getItems().addAll(/*stations*/"Pardubický Kraj","Královehradecký Kraj");
        //setting prefered size
        comboBoxRegion.setPrefSize(135,20);
        comboBoxRegion.setPromptText("Region");
        //positioning
        comboBoxRegion.setTranslateX(-75);
        comboBoxRegion.setTranslateY(-110);

        //setting prefered size
        comboBoxStation.setPrefSize(135,20);
        comboBoxStation.setPromptText("Train Station");
        //positioning
        comboBoxStation.setTranslateX(75);
        comboBoxStation.setTranslateY(-110);

        //giving set actions to buttons, so they can be used with action events
        btnSearch.setOnAction(this);
        btnAdd.setOnAction(this);
        btnEdit.setOnAction(this);
        btnDelete.setOnAction(this);
        comboBoxStation.setOnAction(this);
        comboBoxRegion.setOnAction(this);


        //creating new panel with buttons
        StackPane layout = new StackPane();
        //displaying all the values on the scene
        layout.getChildren().addAll(btnSearch, btnAdd, btnEdit,btnDelete,comboBoxRegion,comboBoxStation);

        //picture of a train because why not
        Image imageTrain = new Image("File:train.png");
        ImageView picTrain = new ImageView();
        picTrain.setTranslateX(90);
        picTrain.setTranslateY(-5);
        picTrain.setFitWidth(130);
        picTrain.setFitHeight(130);
        picTrain.setImage(imageTrain);

        Image imageTK = new Image("File:trainsbykevca.png");
        ImageView picTK = new ImageView();
        picTK.setTranslateX(-70);
        picTK.setTranslateY(110);
        picTK.setFitWidth(150);
        picTK.setFitHeight(75);
        picTK.setImage(imageTK);

        layout.getChildren().addAll(picTrain,picTK);

        //creating new FIRST scene, showing it all
        Scene scene = new Scene(layout, 300,250);
        primaryStage.setTitle("Train Stations");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    @Override
    public void handle(ActionEvent event){

        //ACTIONS FOR FIRST SCENE


        //test if the first ComboBox is for Pardubický Kraj od Královehradecký Kraj, change the second ComboBox based on that to show the correct Cities in that region
        if (event.getSource() == comboBoxRegion) {
            if (comboBoxRegion.getValue().equals("Pardubický Kraj")) {
                //using .clear() to clear all the items on click so it does not stack infinitely
                comboBoxStation.getItems().clear();
                //adding elements to ComboBox
                comboBoxStation.getItems().addAll("Pardubice Hlavní Nádraží", "Choceň");
            }
            if (comboBoxRegion.getValue().equals("Královehradecký Kraj")) {
                //using .clear() to clear all the items on click so it does not stack infinitely
                comboBoxStation.getItems().clear();
                //adding elements to ComboBox
                comboBoxStation.getItems().addAll("Hradec Králové");
            }

        }

        //if the Search button is clicked
                if(event.getSource()==btnSearch) {
                    System.out.println("Search");
                    //checking if the values are selected and not null, if null throw error message to user
                    if (comboBoxRegion.getValue() == null || comboBoxStation.getValue() == null) {
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            Platform.runLater(() -> {
                                System.out.println("Null values");
                                Alert dialog = new Alert(Alert.AlertType.ERROR, "Select Region and Train Station");
                                dialog.show();
                            });
                        }
                        //if not
                    } else {
                        System.out.println("Search");
                        //create new TextFlow that will display Region, Train Station,...
                        TextFlow flowShow = new TextFlow(
                                new Text("Region: " + comboBoxRegion.getValue() + "\n" + "Train Station: " + comboBoxStation.getValue() + "\n"),
                                new Text("Platform: " + "1A" + "\n" + "Wheelchair accesible: " + "Yes")
                        );

                        //create second Stage as a new window with all the values displayed
                        Scene sceneDisplayStage = new Scene(flowShow, 300, 250);
                        displayStage.setTitle("Station Information");
                        displayStage.setScene(sceneDisplayStage);
                        displayStage.show();

                    }
                }


        //ACTIONS FOR ADDING SCENE
        //if the Add button is clicked call addingTrains class
        if(event.getSource()==btnAdd) {
            System.out.println("Add");
            trainsAdd trainsAdd = new trainsAdd();
            trainsAdd.addingTrains();
        }


        //ACTIONS FOR EDITING SCENE
        //if the btnEdit button is clicked call editingTrains class
        if(event.getSource()==btnEdit){
            System.out.println("Edit");
            trainsEdit trainsEdit = new trainsEdit();
            trainsEdit.editingTrains();
        }


        //ACTIONS FOR DELETE SCENE
        //if btnDelete is clicked call deleteTrains class
        if(event.getSource()==btnDelete){
            System.out.println("Delete");
            deleteTrains trainsDelete = new deleteTrains();
            trainsDelete.deletingTrains();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }

}
