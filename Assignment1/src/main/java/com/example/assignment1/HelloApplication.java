package com.example.assignment1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private Scene homeScene, imageScene;
    private ImageView fullSizeImageView;
    private List<String> images = new ArrayList<>();
    private int currentIndex = 0;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        loadImages();
        createHomeScene();
        createImageScene();

        primaryStage.setTitle("Image Gallery");
        primaryStage.setScene(homeScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void createHomeScene() {
        VBox mainLayout = new VBox(10);
        mainLayout.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Image Gallery");
        titleLabel.getStyleClass().add("title-label");

        GridPane homeGrid = new GridPane();
        homeGrid.setHgap(10);
        homeGrid.setVgap(10);
        homeGrid.getStyleClass().add("grid-pane");

        int row = 0, col = 0;
        for (int i = 0; i < images.size(); i++) {
            Image img = new Image(images.get(i));
            ImageView thumbnail = new ImageView(img);
            thumbnail.setFitWidth(120);
            thumbnail.setFitHeight(120);
            thumbnail.getStyleClass().add("image-view");

            // Hover Effect
            thumbnail.setOnMouseEntered(event -> thumbnail.setScaleX(1.1));
            thumbnail.setOnMouseEntered(event -> thumbnail.setScaleY(1.1));
            thumbnail.setOnMouseExited(event -> thumbnail.setScaleX(1));
            thumbnail.setOnMouseExited(event -> thumbnail.setScaleY(1));

            int index = i;
            thumbnail.setOnMouseClicked(event -> {
                showImage(index);
                primaryStage.setScene(imageScene);
            });

            homeGrid.add(thumbnail, col, row);
            col++;
            if (col >= 4) {
                col = 0;
                row++;
            }
        }

        ScrollPane scrollPane = new ScrollPane(homeGrid);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(550);

        mainLayout.getChildren().addAll(titleLabel, scrollPane);

        Scene scene = new Scene(mainLayout, 600, 600);
        loadStyleSheet(scene);
        homeScene = scene;
    }

    private void createImageScene() {
        BorderPane root = new BorderPane();

        fullSizeImageView = new ImageView();
        fullSizeImageView.setPreserveRatio(true);
        fullSizeImageView.setFitWidth(500);
        fullSizeImageView.setFitHeight(400);
        fullSizeImageView.getStyleClass().add("full-size-image");

        fullSizeImageView.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = event.getDeltaY() > 0 ? 1.1 : 0.9;
            fullSizeImageView.setScaleX(fullSizeImageView.getScaleX() * zoomFactor);
            fullSizeImageView.setScaleY(fullSizeImageView.getScaleY() * zoomFactor);
        });

        Button prevButton = new Button("Previous");
        Button nextButton = new Button("Next");
        Button cancelButton = new Button("Cancel");
        Button homeButton = new Button("Home");

        prevButton.setOnAction(event -> showPreviousImage());
        nextButton.setOnAction(event -> showNextImage());
        cancelButton.setOnAction(event -> primaryStage.close());
        homeButton.setOnAction(event -> primaryStage.setScene(homeScene));

        prevButton.getStyleClass().add("button");
        nextButton.getStyleClass().add("button");
        cancelButton.getStyleClass().add("cancel-button");
        homeButton.getStyleClass().add("home-button");

        HBox buttonBox = new HBox(10, prevButton, nextButton, homeButton, cancelButton);
        buttonBox.getStyleClass().add("button-box");

        root.setCenter(fullSizeImageView);
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, 600, 600);
        loadStyleSheet(scene);
        imageScene = scene;
    }

    private void showImage(int index) {
        if (index >= 0 && index < images.size()) {
            currentIndex = index;
            fullSizeImageView.setImage(new Image(images.get(index)));
        }
    }

    private void showPreviousImage() {
        if (currentIndex > 0) {
            showImage(--currentIndex);
        }
    }

    private void showNextImage() {
        if (currentIndex < images.size() - 1) {
            showImage(++currentIndex);
        }
    }

    private void loadImages() {
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image1.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image2.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image3.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image4.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image5.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image6.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image7.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image8.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image9.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image10.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image11.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image12.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image13.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image14.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image15.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image16.jpeg");
        images.add("file:/C:/Users/emmy/IdeaProjects/Assignment1/src/main/resources/com/example/assignment1/images/image17.jpeg");
    }

    private void loadStyleSheet(Scene scene) {
        String cssPath = Objects.requireNonNull(getClass().getResource("/com/example/assignment1/style.css")).toExternalForm();
        scene.getStylesheets().add(cssPath);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
