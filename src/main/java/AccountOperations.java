
import java.util.Scanner;
import java.util.Set;

public class AccountOperations {

    private final static double COMMISSION = 0.05;

    private Boolean isAccountNull(Accounts account){
        if (account == null){
            return true;
        }
        return false;
    }
    private Boolean isCurrencyAvailable(String currency){
        USDExchangeRates usdRates = new USDExchangeRates();
        Set<String> currencySet = usdRates.getUsdMap();
        if (currencySet.contains(currency)){
            return true;
        }
        return false;
    }
    private Boolean isEnoughMoneyInWallet(Accounts account, String currency, Double sum){
        if (sum * (1 + COMMISSION) <= account.getWallet(currency)) {
            return true;
        }
        return false;
    }
    private Boolean areAllWalletsEmpty(Accounts account){
        USDExchangeRates usdRates = new USDExchangeRates();
        Set<String> currencySet = usdRates.getUsdMap();
        Boolean val = true;
        for(String currency : currencySet){
            val = val && ((account.getWallet(currency) == 0));
        }
        return val;
    }
    public Boolean isWalletExist(Accounts account, String currency){
        try {
            account.getWallet(currency);

        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    public void transfer(Accounts account){
        Integer number;
        String currency = "";
        Double sum;
        Double output;
        Double input;
        Accounts anotherAccount = null;

        Scanner in = new Scanner(System.in);
        AccountsList accounts = new AccountsList();
        WalletOperations walletOperations = new WalletOperations();

        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Enter the number of account you want to transfer to :");
                number = Integer.parseInt(in.nextLine());
                anotherAccount = accounts.getAccountsByNumber(number);
                if (isAccountNull(anotherAccount)) {
                    System.out.println("Account with this number does not exist!");
                } else {
                    for (int j = 0; j < 3; j++) {
                        System.out.println("Enter the currency of your money :");
                        System.out.println("Available currencies : USD, EUR, RUB, UAH, JPY, UZS");
                        currency = in.nextLine();
                        if (!isCurrencyAvailable(currency)) {
                            System.out.println("Entered currency is not available!");
                        } else {
                            System.out.println("Enter the sum you want to convert to :");
                            System.out.println("On your account you have : ");
                            System.out.println(account.getWallet("usd") + " USD | " + account.getWallet("eur") + " EUR | " + account.getWallet("rub") + " RUB | " + account.getWallet("uah") + " UAH | " + account.getWallet("jpy") + " JPY | " + account.getWallet("uzs") + " UZS");
                            sum = Double.parseDouble(in.nextLine());
                            if (!isEnoughMoneyInWallet(account, currency, sum)) {
                                System.out.println("You do not have enough money to transfer this sum!");
                                System.out.println("Do you want to convert money from other wallets, enter smaller sum or complete operation?\nEnter 'c' if you want convert, 's' if you want to enter smaller sum or 'n' if you want to complete operation");
                                String answer = in.nextLine();
                                if (areAllWalletsEmpty(account)) {
                                    System.out.println("Your wallet is entirely empty! Please, replenish your account!");
                                } else if (answer.equals("c")) {
                                    walletOperations.convertCurrency(account);
                                    transfer(account);
                                }else if (answer.equalsIgnoreCase("s")){

                                } else if (answer.equals("n")) {
                                    System.out.println("You completed current operation!");
                                }
                            } else {
                                System.out.println("Entered");
                                output = account.getWallet(currency) - sum * (1 + COMMISSION);
                                System.out.println(anotherAccount.getWallet(currency));
                                input = anotherAccount.getWallet(currency) + sum;
                                System.out.println("Before | " + currency + " wallet : " + account.getWallet(currency));
                                account.setWallet(currency, output);
                                System.out.println("After | " + currency + " wallet : " + output);
                                anotherAccount.setWallet(currency, input);
                            }
                            break;
                        }
                    }
                    if (!isCurrencyAvailable(currency)){
                        System.out.println("All of the entered currencies are not available!");
                    }
                    break;
                }
            }catch(NumberFormatException ex){
                System.out.println("You entered incorrect chars!");
            }
        }
        if (isAccountNull(anotherAccount)){
            System.out.println("Entered number does not exist! Make sure you entered correct number");
            System.out.println("Do you want to try again? Enter 'y' if you want to try again or press any other key if you do not");
            String answer = in.nextLine();
            if (answer.equalsIgnoreCase("y")){
                transfer(account);
            }
        }

    }
}