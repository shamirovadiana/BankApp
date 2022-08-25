public class Accounts{
    private String name;
    public String getName(){return name;}
    public void setName(String newName){name = newName;}
    private Integer number;
    public Integer getNumber(){return number;}
    public void setNumber(Integer newNumber){number = newNumber;}
    private String login;
    public String getLogin(){return login;}
    public void setLogin(String newLogin){login = newLogin;}
    private String password;
    public String getPassword(){return password;}
    public void setPassword(String newPassword){password = newPassword;}
    private Wallet wallet;
    public Wallet getWallet(){
        return wallet;
    }

    public Double getWallet(String currency){
        if (currency.equalsIgnoreCase("usd")){
            if (wallet.getUsd() == null){return 0.0;}
            return wallet.getUsd();
        } else if (currency.equalsIgnoreCase("eur")) {
            if (wallet.getEur() == null){return 0.0;}
            return wallet.getEur();
        } else if(currency.equalsIgnoreCase("rub")) {
            if (wallet.getRub() == null){return 0.0;}
            return wallet.getRub();
        } else if (currency.equalsIgnoreCase("uah")) {
            if (wallet.getUah() == null){return 0.0;}
            return wallet.getUah();
        } else if (currency.equalsIgnoreCase("jpy")) {
            if (wallet.getJpy() == null){return 0.0;}
            return wallet.getJpy();
        } else if (currency.equalsIgnoreCase("uzs")) {
            if (wallet.getUzs() == null){return 0.0;}
            return wallet.getUzs();
        } else {
            throw new NullPointerException();
        }
    }
    public void setWallet(String currency, Double value){
        if (currency.equalsIgnoreCase("usd")){
            wallet.setUsd(value);
        } else if (currency.equalsIgnoreCase("eur")) {
            wallet.setEur(value);
        } else if(currency.equalsIgnoreCase("rub")) {
            wallet.setRub(value);
        } else if (currency.equalsIgnoreCase("uah")) {
            wallet.setUah(value);
        } else if (currency.equalsIgnoreCase("jpy")) {
            wallet.setJpy(value);
        } else if (currency.equalsIgnoreCase("uzs")) {
            wallet.setUzs(value);
        }
    }
    public void setWallet(Wallet wallet){
        this.wallet = wallet;
    }

    public Accounts(String name, Integer number, String password, String login,Wallet wallet){
        this.name = name;
        this.number = number;
        this.password = password;
        this.login = login;
        this.wallet = wallet;
    }
    public Accounts(String name, Integer number, String password, String login){
        this.name = name;
        this.number = number;
        this.password = password;
        this.login = login;
    }
    public Accounts(){

    }

}
