import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

        final Stage mainStage = new Stage();
        final Main main = new Main();
        main.start(mainStage);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox inputBox = new VBox();

        inputBox.setPadding(new Insets(5,5,5,5));

        ArrayList<MoneyValueInput> inputs = new ArrayList<>();
        MoneyValueInput defaultFirst = new MoneyValueInput();
        inputs.add(defaultFirst);


        Button addMoreInput = new Button("+");
        addMoreInput.setOnAction(e -> {
            MoneyValueInput thisInput = createNewInput();
            inputs.add(thisInput);
            inputBox.getChildren().add(thisInput.getBox());
            primaryStage.setHeight(primaryStage.getHeight() +  27);

        });

        Button removeInput = new Button("-");
        removeInput.setOnAction(e -> {
            if(inputs.size() > 0) {
                MoneyValueInput tempInput = inputs.remove(inputs.size() - 1);
                inputBox.getChildren().remove(tempInput.getBox());
                primaryStage.setHeight(primaryStage.getHeight() -  27);
            }
        });

        Button calculateMoney = new Button("Calculate");
        calculateMoney.setOnAction(e -> {
            //double finalResult = calculate(inputs);

            NumberStatePair finalResult = calculate(inputs);

            if (finalResult.getState() != false) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Total");
                alert.setHeaderText(null);
                alert.setContentText("The Sum after Interest is : " + finalResult.getNumber());
                alert.showAndWait();
            }
        });

        HBox operations = new HBox();
        operations.getChildren().addAll(addMoreInput,removeInput, calculateMoney);
        operations.setSpacing(1);

        Button exit = new Button("Quit");
        exit.setOnAction(e -> System.exit(0));

        BorderPane topBar = new BorderPane();
        topBar.setLeft(operations);
        topBar.setRight(exit);
        topBar.setPadding( new Insets(5,5,5,5));

        inputBox.getChildren().addAll(defaultFirst.getBox());

        VBox mainBox = new VBox();
        mainBox.getChildren().addAll(topBar, inputBox);
        mainBox.setSpacing(5);


        primaryStage.setTitle("AvgCalc");

        Scene scene = new Scene(mainBox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public MoneyValueInput createNewInput(){
        MoneyValueInput input = new MoneyValueInput();
        return input;
    }

    public NumberStatePair calculate(ArrayList<MoneyValueInput> listOfNumbers){

        double total = 0;
        NumberStatePair returnTotal = new NumberStatePair(0, true);

        for(MoneyValueInput inputEntry : listOfNumbers){
            boolean check = inputEntry.checkNumber();

            if ( !check ){
                returnTotal.setState(false);
                break;
            }

            total += inputEntry.getMoneyEntry().getMoneyAfterInterest();
            returnTotal.setNumber(total);
        }

        return returnTotal;
    }


}
