package com.example.currencyapp.MainActivity.Domain.Repository;

import com.example.currencyapp.MainActivity.Domain.Models.Currency;

import java.util.ArrayList;

public interface CurrencyRepository
{
    ArrayList<Currency> getCurrency();
}
