import java.util.Set;
import java.util.HashMap;

public class USDExchangeRates {
    private HashMap<String, Double> usdMap = new HashMap<>();{
        usdMap.put("usd",1.0);
        usdMap.put("eur", 0.98);
        usdMap.put("rub", 58.13);
        usdMap.put("uah",6.75);
        usdMap.put("jpy",136.18);
        usdMap.put("uzs", 10874.33);
    }
    public Set<String> getUsdMap(){
        return usdMap.keySet();
    }
    public Double getUsdMap(String currency){
        return usdMap.get(currency);
    }
}
