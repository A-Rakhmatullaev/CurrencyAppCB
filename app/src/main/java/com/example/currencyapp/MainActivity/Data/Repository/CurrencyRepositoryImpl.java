package com.example.currencyapp.MainActivity.Data.Repository;

import android.util.Log;

import com.example.currencyapp.MainActivity.Data.Web.AsyncGet;
import com.example.currencyapp.MainActivity.Domain.Models.Currency;
import com.example.currencyapp.MainActivity.Domain.Repository.CurrencyRepository;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CurrencyRepositoryImpl implements CurrencyRepository
{
    @Override
    public ArrayList<Currency> getCurrency()
    {
        ArrayList<Currency> currencyArrayList= new ArrayList<>();
        AsyncGet asyncGet = new AsyncGet();
        try
        {
            currencyArrayList = asyncGet.execute().get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            e.printStackTrace();
        }

        return currencyArrayList;
    }
}
