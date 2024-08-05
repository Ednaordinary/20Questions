import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class Questions extends Application {
  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    VBox questionsBox = new VBox();
    VBox guessBox = new VBox();
    questionsBox.setSpacing(10);
    questionsBox.setAlignment(Pos.CENTER);
    guessBox.setSpacing(10);
    guessBox.setAlignment(Pos.CENTER);
    Label info = new Label("20 Questions");
    info.setTextFill(Color.color(1, 0, 0));
    CheckBox q1 = new CheckBox("Is it alive?");
    q1.setIndeterminate(false);
    CheckBox q2 = new CheckBox("Is it real?");
    q2.setIndeterminate(false);
    CheckBox q3 = new CheckBox("Can it bend without breaking?");
    q3.setIndeterminate(false);
    CheckBox q4 = new CheckBox("Does it move?");
    q4.setIndeterminate(false);
    CheckBox q5 = new CheckBox("Does it roll?");
    q5.setIndeterminate(false);
    CheckBox q6 = new CheckBox("Is it mechanical?");
    q6.setIndeterminate(false);
    CheckBox q7 = new CheckBox("Does it have a memory?");
    q7.setIndeterminate(false);
    CheckBox q8 = new CheckBox("Can you play games with it?");
    q8.setIndeterminate(false);
    CheckBox q9 = new CheckBox("Is it a concept?");
    q9.setIndeterminate(false);
    CheckBox q10 = new CheckBox("Does it weigh more than a duck?");
    q10.setIndeterminate(false);
    CheckBox q11 = new CheckBox("Do you need batteries to use it?");
    q11.setIndeterminate(false);
    CheckBox q12 = new CheckBox("Is it a mineral?");
    q12.setIndeterminate(false);
    CheckBox q13 = new CheckBox("Is it bright?");
    q13.setIndeterminate(false);
    CheckBox q14 = new CheckBox("Does it come in many varieties?");
    q14.setIndeterminate(false);
    CheckBox q15 = new CheckBox("Can it float?");
    q15.setIndeterminate(false);
    CheckBox q16 = new CheckBox("Does it have seeds?");
    q16.setIndeterminate(false);
    CheckBox q17 = new CheckBox("Can you order it at a restaurant?");
    q17.setIndeterminate(false);
    CheckBox q18 = new CheckBox("Would you give it as a gift?");
    q18.setIndeterminate(false);
    CheckBox q19 = new CheckBox("Is it comforting?");
    q19.setIndeterminate(false);
    CheckBox q20 = new CheckBox("Does it have writing on it?");
    q20.setIndeterminate(false);
    Button calculate = new Button("Submit");
    CheckBox[] boxes = {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20};
    File responses = new File("responses.txt");
    Map<String, int[]> thingmap = new HashMap<String, int[]>();
    int[] zeros = new int[20];
    int[] temp = new int[20];
    Arrays.fill(zeros, 0);
    if (responses.canRead()) {
      Scanner responsesScanner = new Scanner(responses);
      String nextline = "";
      while (responsesScanner.hasNextLine()) {
        nextline = responsesScanner.nextLine();
        String answers = nextline.substring(0, 20);
        String thing = nextline.substring(20).strip();
        if (thing != "") {
          if (!thingmap.containsKey(thing)) {
            thingmap.put(thing, zeros);
          }
          temp = thingmap.get(thing);
          for (int x = 0; x < answers.length(); x++) {
            if (answers.charAt(x) == '1') {
              temp[x] += 1;
            } else {
              temp[x] -= 1;
            }
          }
          thingmap.put(thing, temp);
        }
      }
      for (String thing : thingmap.keySet()) {
        temp = thingmap.get(thing);
        for (int y = 0; y < temp.length; y++) {
          if (temp[y] > 0) {
            temp[y] = 1;
          } else {
            temp[y] = 0;
          }
        }
        thingmap.put(thing, temp);
      }
      if (thingmap.size() == 0) {
        info.setText("Database is empty!");
      }
    } else {
      info.setText("Failed to read database!");
    }
    questionsBox.getChildren().addAll(info);
    Label guess = new Label("");
    Label percent = new Label("");
    Label prompt = new Label("What was it?");
    TextField correctthing = new TextField ();
    Button goback = new Button("Go back");
    guessBox.getChildren().addAll(guess, percent, prompt, correctthing, goback);
    for (int i = 0; i < boxes.length; i++) {
      questionsBox.getChildren().addAll(boxes[i]);
    };
    questionsBox.getChildren().addAll(calculate);
    BorderPane questionsPane = new BorderPane();
    questionsPane.setCenter(questionsBox);
    BorderPane guessPane = new BorderPane();
    guessPane.setCenter(guessBox);
    Scene questionsScene = new Scene(questionsPane, 300, 700);
    Scene guessScene = new Scene(guessPane, 300, 300);
    EventHandler<ActionEvent> submithandler = e -> {
      boolean[] checked = new boolean[20];
      Map<String, int> similarity = new HashMap<String, int>();
      Arrays.fill(checked, false);
      for (int i = 0; i < boxes.length; i++) {
        if (boxes[i].isSelected()) {
            checked[i] = true;
            System.out.println("true");
          } else {
            System.out.println("false");
          }
        }
      for (String thing : thingmap.keySet()) {
        temp = thingmap.get(thing);
        thissimilarity = 
        for (int y = 0; y < temp.length; y++) {
          if (temp[y] == checked[y]) {
            
          }
        }
        thingmap.put(thing, temp);
      }
      primaryStage.setScene(guessScene);
    };
    calculate.setOnAction(submithandler);
    primaryStage.setTitle("20 Questions");
    primaryStage.setScene(questionsScene);
    primaryStage.show();
  }
  public static void main(String[] args) {
  Application.launch(args);
  }
}
