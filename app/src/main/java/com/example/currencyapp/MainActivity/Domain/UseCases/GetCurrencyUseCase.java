package com.example.currencyapp.MainActivity.Domain.UseCases;

import android.util.Log;

import com.example.currencyapp.MainActivity.Domain.Models.Currency;
import com.example.currencyapp.MainActivity.Domain.Repository.CurrencyRepository;

import java.util.ArrayList;

public class GetCurrencyUseCase
{
    private CurrencyRepository currencyRepository;

    public GetCurrencyUseCase(CurrencyRepository currencyRepository)
    {
        this.currencyRepository = currencyRepository;
    }

    public ArrayList<Currency> execute()
    {
       ArrayList<Currency> arrayList = currencyRepository.getCurrency();
       return arrayList;
    }



}
