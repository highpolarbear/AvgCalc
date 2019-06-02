import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MoneyValueInput {

    HBox moneyValueEntry;
    TextField moneyValue;
    TextField interestValue;

    public MoneyValueInput(){
        moneyValue = new TextField();
        interestValue = new TextField();

        moneyValue.setPromptText("Amount of $");
        interestValue.setPromptText("% of Interest");

        moneyValueEntry = new HBox();
        moneyValueEntry.getChildren().addAll(moneyValue,interestValue);
    }

    public HBox getBox(){
        return moneyValueEntry;
    }

    public String getMoneyValue(){
        return moneyValue.getText();
    }

    public String getInterestValue(){
        return interestValue.getText();
    }

    public boolean checkNumber(){
        try {
            Double.parseDouble(getMoneyValue());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not a number");
            alert.setContentText(getMoneyValue() + " is not a number");
            alert.showAndWait();
            return false;
        }

        try {
            Double.parseDouble(getInterestValue());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not a number");
            alert.setContentText(getInterestValue() + " is not a number");
            alert.showAndWait();
            return false;
        }

        return true;
    }

    public MoneyEntry getMoneyEntry(){
        return new MoneyEntry (Double.parseDouble(getMoneyValue()), Double.parseDouble(getInterestValue()));
    }

}
