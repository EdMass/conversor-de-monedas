package org.example;

import com.google.gson.annotations.SerializedName;

public class ExchangeDTO {

    @SerializedName("base_code")
    private String fromCurrency;
    @SerializedName("target_code")
    private String toCurrency;
    @SerializedName("conversion_rate")
    private Double conversionRate;

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public ExchangeDTO(String fromCurrency, String toCurrency, Double conversionRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }
}
