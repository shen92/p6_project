package application;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PrimaryGUI {
  public PrimaryGUI() {}

  public PrimaryGUI(Stage primaryStage) {
    // Start GUI of the program
    HBox startScene = new HBox();// structure of the main scene
    startScene.setPadding(new Insets(25.0, 40.0, 40.0, 40.0));
    startScene.setSpacing(40);

    Scene primaryGUI = new Scene(startScene, 1200, 800);
    primaryGUI.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    primaryStage.setScene(primaryGUI);
    primaryStage.setTitle("Quiz Generator");
    primaryStage.show();
    /* left part of the main scene */
    VBox leftVBox = new VBox();

    // 1) Top label of the left VBox
    Label questionListLabel = new Label("Question List");
    questionListLabel.setFont(Font.font(20));
    leftVBox.getChildren().add(questionListLabel);

    // 2) Mid table of the left VBox
    TableView questionListTable = new TableView<>();
    questionListTable.setEditable(true);
    // set table properties
    questionListTable.setPrefWidth(540);
    questionListTable.setPrefHeight(400);
    // add columns to the table
    TableColumn questionListSelectCol = new TableColumn<>("Select");
    questionListSelectCol.setPrefWidth(60);
    questionListSelectCol.setMinWidth(60);
    questionListSelectCol.setMaxWidth(60);
    TableColumn questionListTopicCol = new TableColumn<>("Topic");
    questionListTopicCol.setPrefWidth(100);
    TableColumn questionListContentCol = new TableColumn<>("Question");
    questionListContentCol.setPrefWidth(380);
    questionListTable.getColumns().addAll(questionListSelectCol, questionListTopicCol,
        questionListContentCol);
    leftVBox.getChildren().add(questionListTable);

    // 3) Mid Buttons of the left VBox
    HBox leftMidButtonHBox = new HBox();
    Button lb1 = new Button("Load Question");
    lb1.setPrefWidth(180);
    lb1.setPrefHeight(45);
    lb1.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent arg0) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
            new FileChooser.ExtensionFilter("JSON files (*.JSON)", "*.JSON");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        // TODO
      }
    });
    leftMidButtonHBox.getChildren().add(lb1);
    Button lb2 = new Button("Select All");
    // TODO
    lb2.setPrefWidth(180);
    lb2.setPrefHeight(45);
    leftMidButtonHBox.getChildren().add(lb2);
    Button lb3 = new Button("Add Selected");
    // TODO
    lb3.setPrefWidth(180);
    lb3.setPrefHeight(45);
    leftMidButtonHBox.getChildren().add(lb3);
    leftVBox.getChildren().add(leftMidButtonHBox);

    // 4) Filter by Topic
    VBox leftBottomVBox = new VBox();
    leftBottomVBox.setPadding(new Insets(40.0, 0.0, 0.0, 0.0));
    leftBottomVBox.setSpacing(10);
    HBox searchHBox = new HBox();
    searchHBox.setSpacing(30);
    Label searchOptionLabel = new Label("Search By Topic");
    searchOptionLabel.setFont(Font.font(20));
    leftBottomVBox.getChildren().add(searchOptionLabel);
    Label searchLabel = new Label();
    searchLabel.setText("Topic:");
    searchLabel.setFont(Font.font(18));
    searchHBox.getChildren().add(searchLabel);
    TextField topicTextField = new TextField();
    topicTextField.setPrefWidth(200);
    searchHBox.getChildren().add(topicTextField);
    leftBottomVBox.getChildren().add(searchHBox);
    Button applyTopicButton = new Button("Find Question");
    // TODO
    applyTopicButton.setPrefWidth(180);
    applyTopicButton.setPrefHeight(45);
    leftBottomVBox.getChildren().add(applyTopicButton);
    leftVBox.getChildren().add(leftBottomVBox);


    // 5) Add the left part to the scene
    startScene.getChildren().add(leftVBox);



    /* right part of the main scene */
    VBox rightVBox = new VBox();

    // 1) Top label of the right VBox
    Label quizListLabel = new Label("Quiz List");
    quizListLabel.setFont(Font.font(20));
    rightVBox.getChildren().add(quizListLabel);

    // 2) Mid table of the right VBox
    TableView quizListTable = new TableView<>();
    quizListTable.setEditable(true);
    // set table properties
    quizListTable.setPrefWidth(540);
    quizListTable.setPrefHeight(500);
    // add columns to the table
    TableColumn quizListSelectCol = new TableColumn<>("Select");
    quizListSelectCol.setPrefWidth(60);
    quizListSelectCol.setMinWidth(60);
    quizListSelectCol.setMaxWidth(60);
    TableColumn quizTopicSelectCol = new TableColumn<>("Topic");
    quizTopicSelectCol.setPrefWidth(100);
    TableColumn quizContentSelectCol = new TableColumn<>("Question");
    quizContentSelectCol.setPrefWidth(380);
    quizListTable.getColumns().addAll(quizListSelectCol, quizTopicSelectCol, quizContentSelectCol);
    rightVBox.getChildren().add(quizListTable);

    // 3) Mid Buttons of the left VBox
    HBox rightMidButtonHBox = new HBox();
    Button rb1 = new Button("Select All");
    // TODO
    rb1.setPrefWidth(280);
    rb1.setPrefHeight(45);
    rightMidButtonHBox.getChildren().add(rb1);
    Button rb2 = new Button("Remove Selected");
    // TODO
    rb2.setPrefWidth(280);
    rb2.setPrefHeight(45);
    rightMidButtonHBox.getChildren().add(rb2);
    rightVBox.getChildren().add(rightMidButtonHBox);

    // 4) Bottom controllers and start quiz
    HBox rightBottomHBox = new HBox();
    rightBottomHBox.setPadding(new Insets(40.0, 25.0, 40.0, 60.0));
    rightBottomHBox.setSpacing(100);
    Label quizQuestionCountLabel = new Label();
    int questionCount = 0;
    quizQuestionCountLabel.setText("Total Questions: " + questionCount);
    quizQuestionCountLabel.setFont(Font.font(18));
    rightBottomHBox.getChildren().add(quizQuestionCountLabel);
    Button startQuizButton = new Button("Start Quiz");
    // TODO
    startQuizButton.setPrefWidth(180);
    startQuizButton.setPrefHeight(45);
    rightBottomHBox.getChildren().add(startQuizButton);
    rightVBox.getChildren().add(rightBottomHBox);

    // 5) Add the right part to the scene
    startScene.getChildren().add(rightVBox);
  }
}
