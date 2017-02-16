package com.example.vrungel.exchangerates.model.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ExchangeEntity {

  @SerializedName("date") @Expose private String date;
  @SerializedName("bank") @Expose private String bank;
  @SerializedName("baseCurrency") @Expose private Integer baseCurrency;
  @SerializedName("baseCurrencyLit") @Expose private String baseCurrencyLit;
  @SerializedName("exchangeRate") @Expose private List<ExchangeRate> exchangeRate = null;

  /**
   * No args constructor for use in serialization
   */
  public ExchangeEntity() {
  }

  /**
   *
   * @param exchangeRate
   * @param baseCurrencyLit
   * @param baseCurrency
   * @param bank
   * @param date
   */
  public ExchangeEntity(String date, String bank, Integer baseCurrency, String baseCurrencyLit,
      List<ExchangeRate> exchangeRate) {
    super();
    this.date = date;
    this.bank = bank;
    this.baseCurrency = baseCurrency;
    this.baseCurrencyLit = baseCurrencyLit;
    this.exchangeRate = exchangeRate;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public Integer getBaseCurrency() {
    return baseCurrency;
  }

  public void setBaseCurrency(Integer baseCurrency) {
    this.baseCurrency = baseCurrency;
  }

  public String getBaseCurrencyLit() {
    return baseCurrencyLit;
  }

  public void setBaseCurrencyLit(String baseCurrencyLit) {
    this.baseCurrencyLit = baseCurrencyLit;
  }

  public List<ExchangeRate> getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(List<ExchangeRate> exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  @Override public String toString() {
    return "Date : "
        + getDate()
        + "Bank : "
        + getBank()
        + "Base Currency Lit : "
        + getBaseCurrencyLit()
        + "ExchangeRate : "
        + getExchangeRate().toString();
  }
}
