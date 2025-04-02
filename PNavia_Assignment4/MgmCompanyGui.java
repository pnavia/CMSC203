package application;

import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Class: CMSC203
 * Instructor: Tarek, Ahmed
 * Description: GUI class for Property Management system using JavaFX.
 * Due: 04/04/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Paulo Navia
 */

public class MgmCompanyGui extends Application {

    private static final int NUM_PIX = 15;
    private static final int SCALE_FACTOR = 40;
    private static final String MGMT_COMPANY = "Management Company";

    private TextField mgmNameText, mgmIdText, mgmFeeText;
    private TextField propNameText, propCityText, propRentText, propOwnerText;
    private TextField propPlotXText, propPlotYText, propPlotWidthText, propPlotDepthText;

    private Label mgmNameLabel, mgmIdLabel, mgmFeeLabel;
    private Label propNameLabel, propCityLabel, propRentLabel, propOwnerLabel;
    private Label propXLabel, propYLabel, propWidthLabel, propDepthLabel;

    private Button newMgmBtn, addPropertyBtn, maxRentBtn, totalRentBtn, propListBtn, exitBtn;
    private Group plotFrame = new Group();
    private ManagementCompany mgmCompany;

    private void createManagementCompanyLabels() {
        mgmNameLabel = new Label("Name:");
        mgmIdLabel = new Label("Tax Id:");
        mgmFeeLabel = new Label("Fee %:");
    }

    private void createManagementCompanyTextFields() {
        mgmNameText = new TextField();
        mgmNameText.setMaxWidth(100);

        mgmIdText = new TextField();
        mgmIdText.setMaxWidth(80);

        mgmFeeText = new TextField();
        mgmFeeText.setMaxWidth(40);
    }

    private void buildManagementCompanyComponents() {
        createManagementCompanyLabels();
        createManagementCompanyTextFields();
    }

    private void addMgmtComponentsToMainPane(VBox mgmPane) {
        HBox mgmtComponentsPane = new HBox(5);
        mgmtComponentsPane.getChildren().addAll(mgmNameLabel, mgmNameText);
        mgmtComponentsPane.getChildren().addAll(mgmIdLabel, mgmIdText);
        mgmtComponentsPane.getChildren().addAll(mgmFeeLabel, mgmFeeText);
        mgmPane.getChildren().addAll(mgmtComponentsPane);
    }

    private void configureMgmtTitlePane(TitledPane mgmTitlePane) {
        mgmTitlePane.setCollapsible(false);
        mgmTitlePane.setMaxWidth(450);
        mgmTitlePane.setPadding(new Insets(20, 10, 5, 10));
    }
    private void createPropertyLabels() {
        propNameLabel = new Label("Name:");
        propCityLabel = new Label("City:");
        propRentLabel = new Label("Rent:");
        propOwnerLabel = new Label("Owner:");
        propXLabel = new Label("X:");
        propYLabel = new Label("Y:");
        propWidthLabel = new Label("Width:");
        propDepthLabel = new Label("Depth:");
    }

    private void createPropertyTextFields() {
        propNameText = new TextField();
        propNameText.setMaxWidth(120);

        propCityText = new TextField();
        propCityText.setMaxWidth(100);

        propRentText = new TextField();
        propRentText.setMaxWidth(80);

        propOwnerText = new TextField();
        propOwnerText.setMaxWidth(120);

        propPlotXText = new TextField();
        propPlotXText.setMaxWidth(40);

        propPlotYText = new TextField();
        propPlotYText.setMaxWidth(40);

        propPlotWidthText = new TextField();
        propPlotWidthText.setMaxWidth(40);

        propPlotDepthText = new TextField();
        propPlotDepthText.setMaxWidth(40);
    }

    private VBox buildPropertyEntryBox() {
        VBox propEntryBox = new VBox(5);
        HBox nameRow = new HBox(5, propNameLabel, propNameText);
        HBox cityRow = new HBox(5, propCityLabel, propCityText);
        HBox rentRow = new HBox(5, propRentLabel, propRentText);
        HBox ownerRow = new HBox(5, propOwnerLabel, propOwnerText);

        HBox plotRow = new HBox(5);
        plotRow.getChildren().addAll(propXLabel, propPlotXText,
                                     propYLabel, propPlotYText,
                                     propWidthLabel, propPlotWidthText,
                                     propDepthLabel, propPlotDepthText);

        propEntryBox.getChildren().addAll(nameRow, cityRow, rentRow, ownerRow, plotRow);
        return propEntryBox;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void createButtons() {
        newMgmBtn = new Button("Create Management Co");
        addPropertyBtn = new Button("Add Property");
        maxRentBtn = new Button("Max Rent");
        totalRentBtn = new Button("Total Rent");
        propListBtn = new Button("Property List");
        exitBtn = new Button("Exit");
    }

    private VBox buildButtonBox() {
        VBox buttonBox = new VBox(10);
        buttonBox.getChildren().addAll(newMgmBtn, addPropertyBtn, maxRentBtn, totalRentBtn, propListBtn, exitBtn);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.setPadding(new Insets(10));
        return buttonBox;
    }

    private void setEventHandlers() {
        newMgmBtn.setOnAction(e -> {
            try {
                String name = mgmNameText.getText();
                String id = mgmIdText.getText();
                double fee = Double.parseDouble(mgmFeeText.getText());

                mgmCompany = new ManagementCompany(name, id, fee);

                showAlert("Management company created!");
            } catch (NumberFormatException ex) {
                showAlert("Invalid management fee.");
            }
        });

        addPropertyBtn.setOnAction(e -> {
            try {
                String name = propNameText.getText();
                String city = propCityText.getText();
                double rent = Double.parseDouble(propRentText.getText());
                String owner = propOwnerText.getText();

                int x = Integer.parseInt(propPlotXText.getText());
                int y = Integer.parseInt(propPlotYText.getText());
                int width = Integer.parseInt(propPlotWidthText.getText());
                int depth = Integer.parseInt(propPlotDepthText.getText());

                Property p = new Property(name, city, rent, owner, x, y, width, depth);
                int result = mgmCompany.addProperty(p);

                if (result >= 0) {
                    showAlert("Property added successfully.");
                    drawPlot(p.getPlot(), name);
                } else {
                    showAlert("Failed to add property. Code: " + result);
                }

            } catch (Exception ex) {
                showAlert("Invalid property input.");
            }
        });

        maxRentBtn.setOnAction(e -> {
            if (mgmCompany != null && mgmCompany.getPropertiesCount() > 0) {
                Property max = mgmCompany.getHighestRentProperty();
                showAlert("Highest rent property:\n" + max.toString());
            } else {
                showAlert("No properties available.");
            }
        });

        totalRentBtn.setOnAction(e -> {
            if (mgmCompany != null) {
                double total = mgmCompany.getTotalRent();
                showAlert("Total rent: $" + total);
            }
        });

        propListBtn.setOnAction(e -> {
            if (mgmCompany != null) {
                showAlert(mgmCompany.toString());
            }
        });

        exitBtn.setOnAction(e -> {
            System.exit(0);
        });
    }
    private void drawPlot(Plot plot, String name) {
        int x = plot.getX() * SCALE_FACTOR;
        int y = plot.getY() * SCALE_FACTOR;
        int width = plot.getWidth() * SCALE_FACTOR;
        int depth = plot.getDepth() * SCALE_FACTOR;

        // Try to load an image that matches the property name
        String fileName = "/images/" + name.replaceAll(" ", "") + ".jpg";

        try {
            System.out.println("Attempting to load: " + fileName);
            javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream(fileName));
            javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(image);

            imageView.setFitWidth(width);
            imageView.setFitHeight(depth);
            imageView.setX(x);
            imageView.setY(y);

            plotFrame.getChildren().add(imageView);
        } catch (Exception e) {
            // Fallback if image not found
            System.out.println("Failed to load image for: " + name);
            javafx.scene.shape.Rectangle rect = new javafx.scene.shape.Rectangle(x, y, width, depth);
            rect.setFill(javafx.scene.paint.Color.LIGHTGRAY);
            rect.setStroke(javafx.scene.paint.Color.RED);
            javafx.scene.control.Label label = new javafx.scene.control.Label(name);
            label.setLayoutX(x + 4);
            label.setLayoutY(y + 4);

            plotFrame.getChildren().addAll(rect, label);
        }
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Property Management GUI");

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Management Company Pane
        VBox mgmPane = new VBox(10);
        buildManagementCompanyComponents();
        addMgmtComponentsToMainPane(mgmPane);
        TitledPane mgmTitlePane = new TitledPane("Management Company Info", mgmPane);
        configureMgmtTitlePane(mgmTitlePane);

        // Property Entry Pane
        createPropertyLabels();
        createPropertyTextFields();
        VBox propEntryPane = buildPropertyEntryBox();
        TitledPane propTitlePane = new TitledPane("Property Information", propEntryPane);
        propTitlePane.setCollapsible(false);
        propTitlePane.setMaxWidth(450);
        propTitlePane.setPadding(new Insets(10, 10, 10, 10));

        // Buttons Pane
        createButtons();
        VBox buttonBox = buildButtonBox();
        setEventHandlers();

        HBox mainContent = new HBox(20);
        mainContent.getChildren().addAll(buttonBox, plotFrame);

        root.getChildren().addAll(mgmTitlePane, propTitlePane, mainContent);

        Scene scene = new Scene(root, 900, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


