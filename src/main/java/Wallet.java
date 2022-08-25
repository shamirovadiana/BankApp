public class Wallet{
    private Double usd;
    public Double getUsd(){
        if(usd == null){
            return 0.0;
        }
        return usd;
    }
    public void setUsd(Double usdValue){usd = usdValue;}
    private Double eur;
    public Double getEur(){
        if(eur == null){
            return 0.0;
        }
        return eur;
    }
    public void setEur(Double eurValue){eur = eurValue;}
    private Double rub;
    public Double getRub(){
        if(rub == null){
            return 0.0;
        }
        return rub;
    }
    public void setRub(Double rubValue){rub = rubValue;}
    private Double uah;
    public Double getUah(){
        if(uah == null){
            return 0.0;
        }
        return uah;
    }
    public void setUah(Double uahValue){uah = uahValue;}
    private Double jpy;
    public Double getJpy(){
        if(jpy == null){
            return 0.0;
        }
        return jpy;
    }
    public void setJpy(Double jpyValue){jpy = jpyValue;}
    private Double uzs;
    public Double getUzs(){
        if(uzs == null){
            return 0.0;
        }
        return uzs;
    }
    public void setUzs(Double uzsValue){uzs = uzsValue;}


    public Wallet(){

    }

    public Wallet(Double usd, Double eur, Double rub, Double uah, Double jpy, Double uzs){
        this.usd = usd;
        this.eur = eur;
        this.rub = rub;
        this.uah = uah;
        this.jpy = jpy;
        this.uzs = uzs;
    }

}