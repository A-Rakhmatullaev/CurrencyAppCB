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
        //TODO
        //1. Connect to Site and get JSON - Done
        //2. Parse obtained JSON - Done
        //3. Put into class parsed JSON [or mb into array/list of the class] - Done
        //4. return array/list into ViewModel
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
