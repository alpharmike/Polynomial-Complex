package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupView {
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.setMinWidth(400);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMaximized(true);
        window.setTitle(title);

        Label label = new Label(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(actionEvent -> window.close());
        closeButton.setStyle("-fx-background-color: linear-gradient(to top, #e52d27, #b31217); ");
        closeButton.setPrefWidth(300);
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        window.showAndWait();

    }
}
