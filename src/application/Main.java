package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Layout TAREA");

        BorderPane root = new BorderPane();

        ListView<StackPane> leftListView = new ListView<>(); //un listview)
        leftListView.setItems(FXCollections.observableArrayList(
             
        ));
        leftListView.setPrefSize(250, 400);

        // un text field para almacenar lo escrito con el array list de arriba
        TextField leftTextField = new TextField();
        leftTextField.setPromptText("Escriba un nombre y  dos apellidos..");
        leftTextField.setOnAction(event -> {
            String text = leftTextField.getText().trim();
            if (!text.isEmpty()) {
                leftListView.getItems().add(createLabeledBox(text));
                leftTextField.clear();
            }
        });

        BorderPane leftPane = new BorderPane();
        leftPane.setCenter(leftListView);
        leftPane.setTop(leftTextField);

        ListView<String> blackListView = new ListView<>();
        blackListView.setItems(FXCollections.observableArrayList("Item 1", "Item 2", "Item 3"));
        blackListView.setStyle("-fx-background-color: black; -fx-text-fill: white;");
        blackListView.setPrefSize(190, 350);

        TextField blueTextField = new TextField();
        blueTextField.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        blueTextField.setPrefSize(50, 100);

        BorderPane rightPane = new BorderPane();
        rightPane.setTop(blackListView);
        rightPane.setBottom(blueTextField);

        root.setLeft(leftPane);
        root.setRight(rightPane);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private StackPane createLabeledBox(String labelText) {
        Label label = new Label(labelText);
        label.setTranslateX(0); // Ajustar la posición del texto

        Rectangle innerBorder = new Rectangle(20, 20);
        innerBorder.setFill(null);
        innerBorder.setStroke(Color.BLACK);
        innerBorder.setTranslateX(-100); // Ajustar la posición del cuadrado para la imagen

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(innerBorder, label);
        return stackPane;
    }
}