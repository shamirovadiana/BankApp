public class Main {

    public static void main(String[] args){
        Accounts user1 = new Accounts("user1",12345,"pass1", "log1");
        Accounts user2 = new Accounts("user1", 12346,"pass2", "log2");
        Accounts user3 = new Accounts("user3", 12347,"pass3", "log3");
        Wallet wallet1 = new Wallet(100.0,700.0,3000.0,500.0,400.0,10000.0);
        user1.setWallet(wallet1);
        Wallet wallet2 = new Wallet(300.0,520.0,1200.0,350.0,470.0,23000.0);
        user2.setWallet(wallet2);
        Wallet wallet3 = new Wallet(350.0,750.0,3000.0,420.0,45600.0,50000.0);
        user3.setWallet(wallet3);
        AccountsList users = new AccountsList();
        users.setAccounts(user1);
        users.setAccounts(user2);
        users.setAccounts(user3);
        AccountInteractions accountInteractions = new AccountInteractions();
        Accounts user = accountInteractions.arePasswordAndLoginCorrect();
        accountInteractions.chooseOperation(user);

    }
}



