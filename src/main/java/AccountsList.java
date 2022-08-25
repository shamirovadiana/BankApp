import java.util.ArrayList;
import java.util.List;

public class AccountsList {
    private static List<Accounts> accounts = new ArrayList<>();
    public  Accounts getAccountsByNumber(Integer number){
        for(Accounts account : accounts){
            if(account.getNumber().equals(number)){
                return account;
            }
        }
        return null;
    }
    public Accounts getAccountsByPassword(String password){
        for(Accounts account : accounts){
            if (account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }
    public Accounts getAccountsByLogin(String login){
        for(Accounts account : accounts){
            if (account.getLogin().equals(login)){
                return account;
            }
        }
        return null;
    }
    public Accounts getAccountsByLoginAndPassword(String login, String password){
        for (Accounts account : accounts){
            if (account.getLogin().equals(login) && account.getPassword().equals(password)){
                return account;
            }
        }
        return null;
    }
    public void setAccounts(Accounts account){
        accounts.add(account);
    }
}