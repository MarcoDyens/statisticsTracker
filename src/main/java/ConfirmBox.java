import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

//new class created for the confirmation box
public class ConfirmBox {
    //variable defined
    public static boolean response;
    //parameters set for the box
    public static boolean confirmPopup(String title, String question){
        //creation of the stage and size of the box and values for the parameters
        Stage confirmWindow = new Stage();
        confirmWindow.initModality(Modality.APPLICATION_MODAL);
        confirmWindow.setTitle(title);
        confirmWindow.setMinWidth(250);
        Label message = new Label();
        message.setText(question);
        //buttons added for the user to choose from
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        //actions the buttons will carry out
        yesBtn.setOnAction(event -> {
            response = true;
            confirmWindow.close();

        });

        noBtn.setOnAction(event -> {
            response = false;
            confirmWindow.close();
        });

        //stage details defined
        VBox confirmLayout = new VBox(10);
        confirmLayout.getChildren().addAll(message, yesBtn, noBtn);
        confirmLayout.setAlignment(Pos.CENTER);
        Scene confirmScene = new Scene(confirmLayout);
        confirmWindow.setScene(confirmScene);
        confirmWindow.showAndWait();


        return response;
    }

    public static boolean isResponse() {
        return response;
    }

    public static void setResponse(boolean response) {
        ConfirmBox.response = response;
    }
}
