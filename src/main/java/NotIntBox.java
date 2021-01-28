import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class NotIntBox {


    public static void BoxPopUp(String title1, String question1){
        Stage alertBox = new Stage();
        alertBox.initModality(Modality.APPLICATION_MODAL);
        alertBox.setTitle(title1);
        alertBox.setMinWidth(250);
        Label message = new Label();
        message.setText(question1);

        Button okBtn = new Button("Ok");

        okBtn.setOnAction(event -> {
            alertBox.close();
        });


        VBox alertLayout = new VBox(10);
        alertLayout.getChildren().addAll(message, okBtn);
        alertLayout.setAlignment(Pos.CENTER);
        Scene confirmScene = new Scene(alertLayout);
        alertBox.setScene(confirmScene);
        alertBox.showAndWait();

    }
}
