import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class Questions extends Application {
  @Override
  public void start(Stage primaryStage) {
    VBox questionsBox = new VBox();
    questionsBox.setSpacing(10);
    questionsBox.setAlignment(Pos.CENTER);
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
    calculate.setOnAction(e -> calculateQuestions())
    questionsBox.getChildren().addAll(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20, calculate);
    //Pane questionsPane = new Pane();
    //questionsPane.getChildren().addAll(questionsBox);
    BorderPane questionsPane = new BorderPane();
    questionsPane.setCenter(questionsBox);
    Scene questionsScene = new Scene(questionsPane, 300, 600);
    primaryStage.setTitle("20 Questions");
    primaryStage.setScene(questionsScene);
    primaryStage.show();
  }
  private void calculateQuestions() {
    
  }
  public static void main(String[] args) {
  Application.launch(args);
  }
}
