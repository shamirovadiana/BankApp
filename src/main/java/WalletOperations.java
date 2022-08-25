import java.util.Scanner;
import java.util.Set;

public class WalletOperations{

    private final static double COMMISSION = 0.01;

    private Boolean isCurrencyAvailable(String currency){
        USDExchangeRates usdRates = new USDExchangeRates();
        Set<String> currencySet = usdRates.getUsdMap();
        if (currencySet.contains(currency)){
            return true;
        }
        return false;
    }
    private Boolean isEnoughMoneyInWallet(Accounts account, String currency, Double sum){
        if ((1 + COMMISSION) * sum <= account.getWallet(currency)) {
            return true;
        }
        return false;
    }

    public void convertCurrency(Accounts account){
        String currentCurrency;
        String convertCurrency;
        Double sum;
        Double output;
        Double input;
        USDExchangeRates usdRates = new USDExchangeRates();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the currency of your money:");
        System.out.println("Available currencies : USD, EUR, RUB, UAH, JPY, UZS");
        currentCurrency = in.nextLine();
        if(!isCurrencyAvailable(currentCurrency)){
            System.out.println("Entered currency is not available!");
        } else {
            System.out.println("Enter the currency you want to convert to:");
            System.out.println("Available currencies : USD, EUR, RUB, UAH, JPY, UZS");
            convertCurrency = in.nextLine();
            if (!isCurrencyAvailable(convertCurrency)) {
                System.out.println("Entered currency is not available!");
            } else {
                System.out.println("Enter the sum you want to convert:");
                System.out.println("On your account you have : ");
                System.out.println(account.getWallet("usd") + " USD | " + account.getWallet("eur") + " EUR | " + account.getWallet("rub") + " RUB | " + account.getWallet("uah") + " UAH | " + account.getWallet("jpy") + " JPY | " + account.getWallet("uzs") + " UZS");
                sum = Double.parseDouble(in.nextLine());
                if (!isEnoughMoneyInWallet(account, currentCurrency, sum)) {
                    System.out.println("You do not have enough money to convert!");
                } else {
                    System.out.println(">>Entered");
                    output = account.getWallet(currentCurrency) - sum * (1 + COMMISSION);
                    account.setWallet(currentCurrency, output);
                    input = sum * (1 / (usdRates.getUsdMap(currentCurrency))) * usdRates.getUsdMap(convertCurrency) + account.getWallet(convertCurrency);
                    account.setWallet(convertCurrency, input);

                    System.out.println(currentCurrency + " wallet : " + output);
                    System.out.println(convertCurrency + " wallet : " + input);

                }
            }
        }
    }
}