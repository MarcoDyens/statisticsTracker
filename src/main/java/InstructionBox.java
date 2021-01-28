import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


//new class created for the instruction box
public class InstructionBox {
    //parameters set for the box
    public static void popup(String title, String instructions){
        //new stage created
        Stage instructionWindow = new Stage();
        //values inputed for the parameters
        instructionWindow.setTitle(title);
        instructionWindow.setMinWidth(400);
        //instructions label set
        Label instructionsText = new Label("Instructions ");
        instructionsText.setText(instructions);
        Button exitPopup = new Button("Close Instructions");
        exitPopup.setOnAction(event -> instructionWindow.close());
        //size formatting of the box
        VBox layoutPopup = new VBox(10);
        layoutPopup.getChildren().addAll(instructionsText, exitPopup);
        layoutPopup.setAlignment(Pos.CENTER);
        //instructions to when it should pop up
        Scene popUp = new Scene(layoutPopup);
        instructionWindow.setScene(popUp);
        instructionWindow.showAndWait();



    }

}
