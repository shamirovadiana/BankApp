import java.util.Scanner;

public class AccountInteractions {

    public Accounts arePasswordAndLoginCorrect(){
        String password;
        String login;
        Accounts user = null;
        AccountsList users = new AccountsList();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter your login :");
            login = in.nextLine();
            if (users.getAccountsByLogin(login) != null){
                for (int j = 0; j < 3; j++){
                    System.out.println("Enter your password :");
                    password = in.nextLine();
                    if (users.getAccountsByLogin(login).getPassword().equals(password)){
                        user = users.getAccountsByLoginAndPassword(login, password);
                        System.out.println("You entered successfully!");
                        break;
                    } else {
                        System.out.println("You entered wrong password! Please, try again");
                    }
                }
                break;
            } else {
                System.out.println("Account with this login does not exist! Please, try again");
            }
        }
        if (user == null){
            System.out.println("Operation failed! Account with this password and login does not exist!");
            System.out.println("Do you want to try again? Enter 'y' if Yes or press any other key if No");
            String answer = in.nextLine();
            if (answer.equalsIgnoreCase("y")){
                arePasswordAndLoginCorrect();
            }
        }
        return user;
    }

    public void chooseOperation(Accounts user){
        if (user != null){
            WalletOperations walletOperations = new WalletOperations();
            AccountOperations accountOperations = new AccountOperations();
            Scanner in = new Scanner(System.in);
            String answer;
            String continueOrNot;
            do{
                System.out.println("Please, choose operation :");
                System.out.println("Enter 'c' if you want to convert or 't' if you want to transfer money");
                answer = in.nextLine();
                if (answer.equalsIgnoreCase("c")) {
                    walletOperations.convertCurrency(user);
                } else if (answer.equalsIgnoreCase("t")) {
                    accountOperations.transfer(user);
                } else {
                    System.out.println("You entered invalid operation! Please, try again");
                }
                System.out.println("Do you want to continue operation? Enter 'y' if you want or press any other key if you do not");
                continueOrNot = in.nextLine();
            } while (continueOrNot.equalsIgnoreCase("y"));
        } else {
            System.out.println("Operations to unregistered user are not available!");
        }
    }
}
