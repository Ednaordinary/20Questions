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
import java.util.Set;
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
    System.out.println("1");
    String thing;
    if (responses.canRead()) {
      Scanner responsesScanner = new Scanner(responses);
      String nextline = "";
      while (responsesScanner.hasNextLine()) {
        nextline = responsesScanner.nextLine();
        if (nextline.strip() != "") {
          String answers = nextline.substring(0, 20);
          thing = nextline.substring(20).strip();
          if (thing != "") {
            if (!thingmap.containsKey(thing)) {
              thingmap.remove(thing);
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
            thingmap.remove(thing);
            thingmap.put(thing, temp);
            System.out.println("2");
          }
        }
      System.out.println("3");
      }
      responsesScanner.close();
      int keysize = thingmap.keySet().size();
      Set<String> keymap = thingmap.keySet();
      String[] keymaparray = keymap.toArray(new String[keysize]);
      System.out.println("3-2");
      String thisthing;
      for (int h = 0; h < keymaparray.length; h++) {
        System.out.println("4");
        thisthing = keymaparray[h];
        System.out.println("5-1");
        temp = thingmap.get(thisthing);
        for (int y = 0; y < temp.length; y++) {
          System.out.print("y");
          System.out.println(y);
          if (temp[y] > 0) {
            temp[y] = 1;
          } else {
            temp[y] = 0;
          }
        }
        System.out.println("5");
        thingmap.remove(thisthing);
        System.out.println("6");
        thingmap.put(thisthing, temp);
        System.out.println("7");
      }
      System.out.println("8");
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
    Button goback = new Button("Done");
    Label guesserror = new Label("");
    guessBox.getChildren().addAll(guess, percent, prompt, correctthing, goback, guesserror);
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
    boolean[] checked = new boolean[20];
    Arrays.fill(checked, false);
    EventHandler<ActionEvent> submithandler = e -> {
      Map<String, Integer> similarity = new HashMap<String, Integer>();
      for (int i = 0; i < boxes.length; i++) {
        if (boxes[i].isSelected()) {
            checked[i] = true;
          } else {
          }
        }
      int thissimilarity;
      int keysize = thingmap.keySet().size();
      Set<String> keymap = thingmap.keySet();
      String[] keymaparray = keymap.toArray(new String[keysize]);
      for (String simthing : keymaparray) {
        final int[] tempsim = thingmap.get(simthing);
        thissimilarity = 0;
        for (int y = 0; y < tempsim.length; y++) {
          if ((tempsim[y] != 0) == checked[y]) {
            thissimilarity += 1;
          }
        }
        thingmap.remove(simthing);
        thingmap.put(simthing, tempsim);
        similarity.put(simthing, thissimilarity);
      }
      String maxthing = "";
      int maxsim = 0;
      keysize = similarity.keySet().size();
      keymap = similarity.keySet();
      keymaparray = keymap.toArray(new String[keysize]);
      for (String thingmax : keymaparray) {
        if (similarity.get(thingmax) > maxsim) {
          maxthing = thingmax;
          maxsim = similarity.get(thingmax);
        }
      }
      guess.setText(maxthing);
      percent.setText(Integer.toString(maxsim*5) + "%");
      primaryStage.setScene(guessScene);
    };
    EventHandler<ActionEvent> backhandler = e -> {
      try {
        FileWriter responsewriter = new FileWriter(responses, true);
        responsewriter.write("\n");
        String correctthingtext = correctthing.getText().strip();
        if (correctthingtext != "") {
          for (int n = 0; n < checked.length; n++) {
            if (checked[n] == true) {
              responsewriter.write("1");
            } else {
              responsewriter.write("0");
            }
          }
          responsewriter.write(correctthingtext);
          responsewriter.close();
          primaryStage.close();
        } else {
          guesserror.setText("Text input should not be blank.");
        }
        } catch(IOException ex) {
          guesserror.setText(ex.toString());
        }
      };
      goback.setOnAction(backhandler);
      calculate.setOnAction(submithandler);
      primaryStage.setTitle("20 Questions");
      primaryStage.setScene(questionsScene);
      primaryStage.show();
  }
  public static void main(String[] args) {
  Application.launch(args);
  }
}
