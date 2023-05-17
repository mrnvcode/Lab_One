
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

    private static final double USD_TO_EGP = 0.23;
    private static final double USD_TO_YEN = 0.20;
    private static final double USD_TO_INR = 75.25;
    private static final double USD_TO_GBP = 0.71;
    private static final double USD_TO_EURO = 0.82;

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
                if (targetCurrency.equals("EGP")) {
                    convertedAmount = amount * USD_TO_EGP;
                } else if (targetCurrency.equals("YEN")) {
                    convertedAmount = amount * USD_TO_YEN;
                } else if (targetCurrency.equals("INR")) {
                    convertedAmount = amount * USD_TO_INR;
                } else if (targetCurrency.equals("GBP")) {
                    convertedAmount = amount * USD_TO_GBP;
                } else if (targetCurrency.equals("EURO")) {
                    convertedAmount = amount * USD_TO_EURO;
                } else {
                    convertedAmount = amount;
                }
            } else if (targetCurrency.equals("USD")) {
                if (sourceCurrency.equals("EGP")) {
                    convertedAmount = amount / USD_TO_EGP;
                } else if (sourceCurrency.equals("YEN")) {
                    convertedAmount = amount / USD_TO_YEN;
                } else if (sourceCurrency.equals("INR")) {
                    convertedAmount = amount / USD_TO_INR;
                } else if (sourceCurrency.equals("GBP")) {
                    convertedAmount = amount / USD_TO_GBP;
                } else if (sourceCurrency.equals("EURO")) {
                    convertedAmount = amount / USD_TO_EURO;
                } else {
                    convertedAmount = amount;
                }
            } else {
                // Conversion between non-USD currencies is not supported in this example
                convertedAmount = 0;
            }

            convertedAmountTextField.setText(String.valueOf(convertedAmount));
        }
    }
}