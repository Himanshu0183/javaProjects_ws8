/**********************************************
 Workshop 8
 Course: JAC 444 - Summer 2022
 Last Name: Himanshu
 First Name: Himanshu
 ID: 146109202
 Section: ZBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature  Himanshu
 Date: 08/01/2022
 **********************************************/

package com.himanshu.workshop8;
import java.awt.image.BufferedImage;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TravelDiary extends Application {

    private static final double ELEMENT_SIZE = 100;
    private static final double GAP = ELEMENT_SIZE / 10;


    private ComboBox<String> countries_combo_box;
    private Button getAll;
    private Button getRecord;
    private Button getCountryRecord;
    private Button getAllIndicatorRecord;
    private Button reset;
    private Label display;


    private Label label;


    private TilePane tilePane = new TilePane();;


    private AnchorPane myAnchor;

    private int nRows = 3;
    private int nCols = 3;


    public void addContries(ArrayList<Country> countries) {
        countries_combo_box = new ComboBox<String>();
        countries_combo_box.getItems().add("Select country");
        for (Country emp : countries) {

            ObservableList<String> items = countries_combo_box.getItems();

            if (!items.contains(emp.getName())) {
                countries_combo_box.getItems().add(emp.getName());
            }

        }
        countries_combo_box.getSelectionModel().selectFirst();
    }

    public VBox createPage(Country country) {

        ImageView imageView = new ImageView();

        File file = new File(country.getName().trim()+".jpg");
          try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
            imageView.setFitWidth(ELEMENT_SIZE);
            imageView.setFitHeight(ELEMENT_SIZE);
            // imageView.setPreserveRatio(true);

            imageView.setSmooth(true);
            imageView.setCache(true);
        } catch (IOException ex) {

        }
        Label display = new Label(country.getName());
        VBox pageBox = new VBox();
        pageBox.getChildren().add(imageView);
        pageBox.getChildren().add(display);
        pageBox.setStyle("-fx-border-color: orange;");
        pageBox.setPadding(new Insets(5, 5, 5, 5));
        return pageBox;
    }

    @Override
    public void start(Stage stage) {

        Data data = new Data();
        data.pupulateCountries("countries.csv");

        getRecord = new Button("All Countries");
        getAll = new Button("Visited countries");
        getCountryRecord = new Button("visited (specific country)");
        getAllIndicatorRecord = new Button("Add Visited country");
        reset = new Button("add visited City");
        reset.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        display = new Label("Not recorded");


        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);

        getAll.setFont(font);
        getCountryRecord.setFont(font);
        getAllIndicatorRecord.setFont(font);
        getRecord.setFont(font);
        reset.setFont(font);
        display.setFont(font);
        display.setPadding(new Insets(5, 5, 5, 5));

        HBox hBox = new HBox();
        hBox.getChildren().addAll(getRecord,getAll,  getCountryRecord, getAllIndicatorRecord,  reset);
        hBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(30);

        tilePane.setPrefColumns(nCols);
        tilePane.setPrefRows(nRows);
        tilePane.setHgap(GAP);
        tilePane.setVgap(GAP);
        for (Country c : data.getCountries()) {
            tilePane.getChildren().add(createPage(c));
        }

        tilePane.setPadding(new Insets(5, 5, 5, 5));;
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, display, tilePane);
        Scene scene = new Scene(vBox, 860, 540);
        stage.setTitle("Travel Diary");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}