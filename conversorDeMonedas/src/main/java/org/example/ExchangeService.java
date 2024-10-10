package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.DecimalFormat;

public class ExchangeService {


    public String getCurrencyChange(String option, Double currencyValue) throws IOException, InterruptedException {
        String result = null;
        if (option.equals("1")){
            result = conversionRateOperate("USD", "COP", currencyValue);
        } else if (option.equals("2")) {
            result = conversionRateOperate("COP", "USD", currencyValue);
        }else if (option.equals("4")) {
            result = conversionRateOperate("ARS", "USD", currencyValue);
        }else if (option.equals("3")) {
            result = conversionRateOperate("USD", "ARS", currencyValue);
        }else if (option.equals("5")) {
            result = conversionRateOperate("USD", "BRL", currencyValue);
        }else if (option.equals("6")) {
            result = conversionRateOperate("BRL", "USD", currencyValue);
        } else {
            result = "Elija una opcion valida";
        }
        return result;
    }

    public String conversionRateOperate(String fromCurrency, String toCurrency, Double currencyValue) throws IOException, InterruptedException {

        HttpService httpService = new HttpService();
        String jsonString = httpService.fetchExchangeRate(fromCurrency, toCurrency);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        ExchangeDTO exchangeDTO = gson.fromJson(jsonString, ExchangeDTO.class);

        DecimalFormat decimalFormat = new DecimalFormat("0.00000");

        return  "El valor de "+ currencyValue + " ["+fromCurrency+"]" + " corresponde al valor final de =>> "+
                decimalFormat.format(exchangeDTO.getConversionRate() * currencyValue) + " ["+toCurrency+"]";

    }


}
