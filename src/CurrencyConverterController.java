import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CurrencyConverterController {

    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox<String> sourceCurrencyComboBox;
    @FXML
    private ComboBox<String> targetCurrencyComboBox;
    @FXML
    private Button convertButton;
    @FXML
    private TextField convertedAmountTextField;

    private static final double USD_TO_EGP = 30.85;
    private static final double USD_TO_YEN = 136.99;
    private static final double USD_TO_INR = 82.38;
    private static final double USD_TO_GBP = 0.80;
    private static final double USD_TO_EURO = 0.92;

    @FXML
    private void initialize() {
        sourceCurrencyComboBox.getItems().addAll("USD", "EGP", "YEN", "INR", "GBP", "EURO");
        targetCurrencyComboBox.getItems().addAll("USD", "EGP", "YEN", "INR", "GBP", "EURO");
    }

    @FXML
    private void handleConvertButtonClicked() {
        String sourceCurrency = sourceCurrencyComboBox.getValue();
        String targetCurrency = targetCurrencyComboBox.getValue();

        if (sourceCurrency != null && targetCurrency != null) {
            double amount = Double.parseDouble(amountTextField.getText());

            double convertedAmount;
            if (sourceCurrency.equals("USD")) {
                convertedAmount = convertUSDtoNonUSD(amount, targetCurrency);
            } else if (targetCurrency.equals("USD")) {
                convertedAmount = convertNonUSDToUSD(amount, sourceCurrency);
            } else {
                double amountInUSD = convertNonUSDToUSD(amount, sourceCurrency);
                convertedAmount = convertUSDtoNonUSD(amountInUSD, targetCurrency);
            }

            convertedAmountTextField.setText(String.valueOf(convertedAmount));
        }
    }

    private double convertUSDtoNonUSD(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "EGP":
                return amount * USD_TO_EGP;
            case "YEN":
                return amount * USD_TO_YEN;
            case "INR":
                return amount * USD_TO_INR;
            case "GBP":
                return amount * USD_TO_GBP;
            case "EURO":
                return amount * USD_TO_EURO;
            default:
                return amount;
        }
    }

    private double convertNonUSDToUSD(double amount, String sourceCurrency) {
        switch (sourceCurrency) {
            case "EGP":
                return amount / USD_TO_EGP;
            case "YEN":
                return amount / USD_TO_YEN;
            case "INR":
                return amount / USD_TO_INR;
            case "GBP":
                return amount / USD_TO_GBP;
            case "EURO":
                return amount / USD_TO_EURO;
            default:
                return amount;
        }
    }
}
