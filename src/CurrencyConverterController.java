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

    // Conversion rates from USD to other currencies
    private static final double USD_TO_EGP = 30.85;
    private static final double USD_TO_YEN = 136.99;
    private static final double USD_TO_INR = 82.38;
    private static final double USD_TO_GBP = 0.80;
    private static final double USD_TO_EURO = 0.92;

    @FXML
    private void initialize() {
        // Populate the source and target currency combo boxes
        sourceCurrencyComboBox.getItems().addAll("USD", "EGP", "YEN", "INR", "GBP", "EURO");
        targetCurrencyComboBox.getItems().addAll("USD", "EGP", "YEN", "INR", "GBP", "EURO");
    }

    @FXML
    private void handleConvertButtonClicked() {
        // Get the selected source and target currencies
        String sourceCurrency = sourceCurrencyComboBox.getValue();
        String targetCurrency = targetCurrencyComboBox.getValue();

        if (sourceCurrency != null && targetCurrency != null) {
            // Parse the amount to be converted
            double amount = Double.parseDouble(amountTextField.getText());

            double convertedAmount;
            if (sourceCurrency.equals("USD")) {
                // Conversion from USD to non-USD currency
                convertedAmount = convertUSDtoNonUSD(amount, targetCurrency);
            } else if (targetCurrency.equals("USD")) {
                // Conversion from non-USD to USD currency
                convertedAmount = convertNonUSDToUSD(amount, sourceCurrency);
            } else {
                // Conversion between two non-USD currencies
                double amountInUSD = convertNonUSDToUSD(amount, sourceCurrency);
                convertedAmount = convertUSDtoNonUSD(amountInUSD, targetCurrency);
            }

            // Set the converted amount in the text field
            convertedAmountTextField.setText(String.valueOf(convertedAmount));
        }
    }

    // Convert amount from USD to the specified non-USD currency
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

    // Convert amount from the specified non-USD currency to USD
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
