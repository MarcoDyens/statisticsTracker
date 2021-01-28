import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;


public class Main extends Application {

    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "Game Statistics Database";
    private static String SPREADSHEET_ID = "1tU4Fj2Y30mREPJrYa2z3Cv3Jh5vpxwV-ark-AUqW7i0";

    Stage window;
    Scene mainMenu, newGame, oldGame, statsTrack;
    TableView<PlayerRow> tablePlayers;
    TextField firstNameInput, lastNameInput, numberInput, gameTitle;



    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        window = PrimaryStage;
        window.setTitle("Statistics Tracker Application");

        GridPane outlineMenu = new GridPane();
        outlineMenu.setPadding(new Insets(20,20,20,20));
        outlineMenu.setVgap(40);
        outlineMenu.setHgap(40);

        Label welcome = new Label("Main Menu");
        Button trackNewGame = new Button("Track New Game");
        Button oldGames = new Button("View Old Games");
        Button instructions = new Button("The Instructions");
        instructions.setOnAction(event -> InstructionBox.popup("Instructions", "The instructions for this application: There are two other options in the main menu other than the instructions, \" \n" +
                "                \"the track new game button will bring you to the statistics tracking screen and the view old games button will bring you to a screen that will allow\" \n" +
                "                \"you to open previous statistics of players from the database. In order to save games into the database you must press the submit button in the statistics tracking screen\" \n" +
                "                \"and then click the save button."));


        GridPane.setConstraints(welcome, 3,1);
        GridPane.setConstraints(trackNewGame, 3,2);
        GridPane.setConstraints(oldGames, 3,3);
        GridPane.setConstraints(instructions, 3,4);


        //VBox mainMenuLayout = new VBox(20);
        outlineMenu.getChildren().addAll(welcome, trackNewGame, oldGames, instructions);
        mainMenu = new Scene(outlineMenu, 400, 400);
        oldGames.setOnAction(event -> window.setScene(oldGame));

        window.setScene(mainMenu);
        window.setTitle("Statistics Tracker Application");
        window.show();



        Button backToMenuBtn = new Button("Back To Main Menu");
        backToMenuBtn.setOnAction(event -> window.setScene(mainMenu));


        GridPane oldMenu = new GridPane();
        outlineMenu.setPadding(new Insets(40,40,40,40));
        outlineMenu.setVgap(40);
        outlineMenu.setHgap(40);


        TableColumn<PlayerRow, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setMinWidth(120);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<PlayerRow, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setMinWidth(120);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<PlayerRow, Integer> numberColumn = new TableColumn<>("Number");
        numberColumn.setMinWidth(60);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        //main column created and named
        TableColumn<PlayerRow, String> goalsColumn = new TableColumn<>("Goals");
        //the three sub columns created and named
        TableColumn<PlayerRow, String> addGoalsColumn = new TableColumn<>("Add");
        TableColumn<PlayerRow, String> removeGoalsColumn = new TableColumn<>("Remove");
        TableColumn<PlayerRow, String> totalGoalsColumn = new TableColumn<>("Total");
        //inserting the three sub columns into the correct main column
        goalsColumn.getColumns().addAll(addGoalsColumn, removeGoalsColumn, totalGoalsColumn);
        //adding a button in the first two sub columns cells, and a label on the third one
        addGoalsColumn.setCellValueFactory(new PropertyValueFactory<>("addGoalsButton"));
        removeGoalsColumn.setCellValueFactory(new PropertyValueFactory<>("removeGoalsButton"));
        totalGoalsColumn.setCellValueFactory(new PropertyValueFactory<>("totalGoals"));
        //setting a maximum width for the column so that it is not too big
        goalsColumn.setMaxWidth(75);

        TableColumn<PlayerRow, String> assistsColumn = new TableColumn<>("Assists");
        TableColumn<PlayerRow, String> addAssistsColumn = new TableColumn<>("Add");
        TableColumn<PlayerRow, String> removeAssistsColumn = new TableColumn<>("Remove");
        TableColumn<PlayerRow, String> totalAssistsColumn = new TableColumn<>("Total");
        assistsColumn.getColumns().addAll(addAssistsColumn, removeAssistsColumn, totalAssistsColumn);
        addAssistsColumn.setCellValueFactory(new PropertyValueFactory<>("addAssists"));
        removeAssistsColumn.setCellValueFactory(new PropertyValueFactory<>("removeAssists"));
        totalAssistsColumn.setCellValueFactory(new PropertyValueFactory<>("totalAssists"));
        assistsColumn.setMaxWidth(75);

        TableColumn<PlayerRow, String> shotsTakenColumn = new TableColumn<>("Shots Taken");
        TableColumn<PlayerRow, String> addShotsColumn = new TableColumn<>("Add");
        TableColumn<PlayerRow, String> removeShotsColumn = new TableColumn<>("Remove");
        TableColumn<PlayerRow, String> totalShotsColumn = new TableColumn<>("Total");
        shotsTakenColumn.getColumns().addAll(addShotsColumn, removeShotsColumn, totalShotsColumn);
        addShotsColumn.setCellValueFactory(new PropertyValueFactory<>("addShots"));
        removeShotsColumn.setCellValueFactory(new PropertyValueFactory<>("removeShots"));
        totalShotsColumn.setCellValueFactory(new PropertyValueFactory<>("totalShots"));
        shotsTakenColumn.setMaxWidth(75);

        TableColumn<PlayerRow, String> crossesCompleteColumn = new TableColumn<>("Crosses Complete");
        TableColumn<PlayerRow, String> addCrossesColumn = new TableColumn<>("Add");
        TableColumn<PlayerRow, String> removeCrossesColumn = new TableColumn<>("Remove");
        TableColumn<PlayerRow, String> totalCrossesColumn = new TableColumn<>("Total");
        crossesCompleteColumn.getColumns().addAll(addCrossesColumn, removeCrossesColumn, totalCrossesColumn);
        addCrossesColumn.setCellValueFactory(new PropertyValueFactory<>("addCrosses"));
        removeCrossesColumn.setCellValueFactory(new PropertyValueFactory<>("removeCrosses"));
        totalCrossesColumn.setCellValueFactory(new PropertyValueFactory<>("totalCrosses"));
        crossesCompleteColumn.setMaxWidth(75);

        TableColumn<PlayerRow, String> dribblesCompleteColumn = new TableColumn<>("Dribbles Complete");
        TableColumn<PlayerRow, String> addDribblesColumn = new TableColumn<>("Add");
        TableColumn<PlayerRow, String> removeDribblesColumn = new TableColumn<>("Remove");
        TableColumn<PlayerRow, String> totalDribblesColumn = new TableColumn<>("Total");
        dribblesCompleteColumn.getColumns().addAll(addDribblesColumn, removeDribblesColumn, totalDribblesColumn);
        addDribblesColumn.setCellValueFactory(new PropertyValueFactory<>("addDribbles"));
        removeDribblesColumn.setCellValueFactory(new PropertyValueFactory<>("removeDribbles"));
        totalDribblesColumn.setCellValueFactory(new PropertyValueFactory<>("totalDribbles"));
        dribblesCompleteColumn.setMaxWidth(75);

        TableColumn<PlayerRow, String> passesCompletedColumn = new TableColumn<>("Passes Completed");
        TableColumn<PlayerRow, String> addPassesColumn = new TableColumn<>("Add");
        TableColumn<PlayerRow, String> removePassesColumn = new TableColumn<>("Remove");
        TableColumn<PlayerRow, String> totalPassesColumn = new TableColumn<>("Total");
        passesCompletedColumn.getColumns().addAll(addPassesColumn, removePassesColumn, totalPassesColumn);
        addPassesColumn.setCellValueFactory(new PropertyValueFactory<>("addPasses"));
        removePassesColumn.setCellValueFactory(new PropertyValueFactory<>("removePasses"));
        totalPassesColumn.setCellValueFactory(new PropertyValueFactory<>("totalPasses"));
        passesCompletedColumn.setMaxWidth(75);

        TableColumn<PlayerRow, String> touchesMadeColumn = new TableColumn<>("Touches Made");
        TableColumn<PlayerRow, String> addTouchesColumn = new TableColumn<>("Add");
        TableColumn<PlayerRow, String> removeTouchesColumn = new TableColumn<>("Remove");
        TableColumn<PlayerRow, String> totalTouchesColumn = new TableColumn<>("Total");
        touchesMadeColumn.getColumns().addAll(addTouchesColumn, removeTouchesColumn, totalTouchesColumn);
        addTouchesColumn.setCellValueFactory(new PropertyValueFactory<>("addTouches"));
        removeTouchesColumn.setCellValueFactory(new PropertyValueFactory<>("removeTouches"));
        totalTouchesColumn.setCellValueFactory(new PropertyValueFactory<>("totalTouches"));
        touchesMadeColumn.setMaxWidth(75);

        TableColumn<PlayerRow, String> tacklesSuccessfulColumn = new TableColumn<>("Tackles Successful");
        TableColumn<PlayerRow, String> addTacklesColumn = new TableColumn<>("Add");
        TableColumn<PlayerRow, String> removeTacklesColumn = new TableColumn<>("Remove");
        TableColumn<PlayerRow, String> totalTacklesColumn = new TableColumn<>("Total");
        tacklesSuccessfulColumn.getColumns().addAll(addTacklesColumn, removeTacklesColumn, totalTacklesColumn);
        addTacklesColumn.setCellValueFactory(new PropertyValueFactory<>("addTackles"));
        removeTacklesColumn.setCellValueFactory(new PropertyValueFactory<>("removeTackles"));
        totalTacklesColumn.setCellValueFactory(new PropertyValueFactory<>("totalTackles"));
        tacklesSuccessfulColumn.setMaxWidth(75);

        TableColumn<PlayerRow, Integer> totalStatisticsColumn = new TableColumn<>("Total Statistics");
        TableColumn<PlayerRow, String> resetStatisticsColumn = new TableColumn<>("Reset");
        TableColumn<PlayerRow, String> updateStatisticsColumn = new TableColumn<>("Update");
        TableColumn<PlayerRow, String> totalStatisticsLabelColumn = new TableColumn<>("Total");
        totalStatisticsColumn.getColumns().addAll(resetStatisticsColumn, updateStatisticsColumn, totalStatisticsLabelColumn);
        resetStatisticsColumn.setCellValueFactory(new PropertyValueFactory<>("reset"));
        updateStatisticsColumn.setCellValueFactory(new PropertyValueFactory<>("update"));
        totalStatisticsLabelColumn.setCellValueFactory(new PropertyValueFactory<>("statistics"));
        totalStatisticsColumn.setMaxWidth(75);

        //table view creation for the statistics tracker
        tablePlayers = new TableView<>();
        //process of getting all the rows created and combining them in one table
        tablePlayers.setItems(getPlayerRow());
        //selecting the order and which rows to put in the table
        tablePlayers.getColumns().addAll(firstNameColumn, lastNameColumn, numberColumn, goalsColumn, assistsColumn, shotsTakenColumn,
                crossesCompleteColumn, dribblesCompleteColumn, passesCompletedColumn, touchesMadeColumn,
                tacklesSuccessfulColumn, totalStatisticsColumn);

        firstNameInput = new TextField();
        firstNameInput.setPromptText("First Name");
        firstNameInput.setMinWidth(100);

        lastNameInput = new TextField();
        lastNameInput.setPromptText("Last Name");
        lastNameInput.setMinWidth(100);

        numberInput = new TextField();
        numberInput.setPromptText("Number");
        numberInput.setMinWidth(100);

        Button addRowBtn  = new Button("Add player");
        addRowBtn.setOnAction(e -> addRowBtnClicked());
        Button deleteRowBtn = new Button("Remove player");
        deleteRowBtn.setOnAction(e -> deleteRowBtnClicked());
        Button highlightRowBtn = new Button("Starting Player");
        highlightRowBtn.setOnAction(e -> highlightRowBtnClicked());
        Button backToMainMenuBtn = new Button("Back To Main Menu");
        backToMainMenuBtn.setOnAction(event -> window.setScene(mainMenu));
        Button startTrackingBtn = new Button("Submit");
        startTrackingBtn.setOnAction(event -> {
            ConfirmBox.confirmPopup("Confirm Window", "Are you sure you want to submit this game " +
                    "to the database? You cannot go back after this and change statistics.");
            if (ConfirmBox.response == true) {
                window.setScene(statsTrack);
            }
            else if (ConfirmBox.response == false){
                window.setScene(newGame);
            }

        });

        Button openDatabase = new Button("Open Database");
        GridPane.setConstraints(openDatabase, 5,10);
        GridPane.setConstraints(backToMenuBtn, 10,15);
        openDatabase.setOnAction(event -> {
            try {
                tablePlayers.getItems().addAll(sheetsDatabase.loadBoard());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }

            HBox border = new HBox();
            border.setPadding(new Insets(10,10,10,10));
            border.setSpacing(30);
            border.getChildren().addAll(firstNameInput, lastNameInput, numberInput, addRowBtn, deleteRowBtn, startTrackingBtn, backToMainMenuBtn);

            VBox trackOldGameLayout = new VBox();
            trackOldGameLayout.getChildren().addAll(tablePlayers, border);
            newGame = new Scene(trackOldGameLayout, 1400, 400);
            //Scene newGame = new Scene(vBox);
            //window.setScene(newGame);
            window.setScene(newGame);
        });

        oldMenu.getChildren().addAll(backToMenuBtn, openDatabase);
        oldMenu.setVgap(2);
        oldMenu.setHgap(2);
        oldGame = new Scene(oldMenu, 250, 150);


        HBox border = new HBox();
        border.setPadding(new Insets(10,10,10,10));
        border.setSpacing(30);
        border.getChildren().addAll(firstNameInput, lastNameInput, numberInput, addRowBtn, deleteRowBtn, startTrackingBtn, backToMainMenuBtn);

        HBox secondBorder = new HBox();
        secondBorder.setPadding(new Insets(10,10,10,10));
        secondBorder.setSpacing(30);
        secondBorder.getChildren().addAll();

        VBox trackNewGameLayout = new VBox();
        trackNewGameLayout.getChildren().addAll(tablePlayers, border);
        newGame = new Scene(trackNewGameLayout, 1400, 400);
        //Scene newGame = new Scene(vBox);
        //window.setScene(newGame);
        trackNewGame.setOnAction(event -> window.setScene(newGame));

        gameTitle = new TextField();
        gameTitle.setPromptText("Enter Game Title");
        gameTitle.setAlignment(Pos.CENTER_LEFT);

        Button endSubmitBtn = new Button("Save");
        endSubmitBtn.setAlignment(Pos.CENTER_RIGHT);
        endSubmitBtn.setOnAction(event -> {

            tablePlayers.getItems().stream()
                    .forEach(row -> {
                        ValueRange appendBody = new ValueRange()
                                .setValues(Arrays.asList(Arrays.asList(getStats(row))));

                        try {
                            sheetsDatabase.write(appendBody);

                        } catch (IOException e) {
                            e.printStackTrace();

                        } catch (GeneralSecurityException e) {
                            e.printStackTrace();
                        }


                    });

                });


///put landa expression in crit c



        HBox endScreenLayout = new HBox();
        endScreenLayout.setPadding(new Insets(20,20,20,20));
        endScreenLayout.setSpacing(40);
        endScreenLayout.getChildren().addAll(gameTitle, endSubmitBtn);
        statsTrack = new Scene(endScreenLayout, 400, 200);

    }

    public String[] getStats(PlayerRow row) {
        return new String[]{
                row.getFirstName(),
                row.getLastName(),
                String.valueOf(row.getNumber()),
                row.getTotalAssists().getText(),
                row.getTotalCrosses().getText(),
                row.getTotalDribbles().getText(),
                row.getTotalGoals().getText(),
                row.getTotalPasses().getText(),
                row.getTotalShots().getText(),
                row.getTotalTackles().getText(),
                row.getTotalTouches().getText(),
                String.valueOf(row.getTotalStatistics())
        };
    }


    public void openDatabaseBtnClicked(){


    }




    public void endSubmitBtnClicked(){}
/*
      ObservableList<Tab> playerRows;

        for (Tab tab : playerRows );
            //put write function here
        }

    }
*/

    public void addRowBtnClicked(){
        PlayerRow playerRow = new PlayerRow();
        playerRow.setFirstName(firstNameInput.getText());
        playerRow.setLastName(lastNameInput.getText());
        playerRow.setNumber(Integer.parseInt(numberInput.getText()));
        tablePlayers.getItems().add(playerRow);
        firstNameInput.clear();
        lastNameInput.clear();
        numberInput.clear();

    }


    public void deleteRowBtnClicked(){
        ObservableList<PlayerRow> playerRowSelected, allPlayerRows;
        allPlayerRows = tablePlayers.getItems();
        playerRowSelected = tablePlayers.getSelectionModel().getSelectedItems();

        playerRowSelected.forEach(allPlayerRows::remove);
    }

    public void highlightRowBtnClicked(){
        ObservableList<PlayerRow> playerRowSelected, allPlayerRows;
        allPlayerRows = tablePlayers.getItems();
        playerRowSelected = tablePlayers.getSelectionModel().getSelectedItems();

        //playerRowSelected.forEach();

    }



//get all of the player rows
//this will be where you can put the database info


    //creating and naming of the java ObservableList
    public ObservableList<PlayerRow> getPlayerRow() {
        //identifying changes in the table and storing of the player rows data in the list
        ObservableList<PlayerRow> playerRows = FXCollections.observableArrayList();
        //returning those stored values to the user for viewing
        return playerRows;
    }


}




