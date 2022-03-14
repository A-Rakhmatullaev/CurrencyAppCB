package com.example.currencyapp.MainActivity.Presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.currencyapp.MainActivity.Data.Repository.CurrencyRepositoryImpl;
import com.example.currencyapp.MainActivity.Domain.Models.Currency;
import com.example.currencyapp.MainActivity.Domain.UseCases.GetCurrencyUseCase;

import java.util.ArrayList;

public class MainViewModel extends ViewModel
{
    MutableLiveData<ArrayList<Currency>> mutableLiveData = new MutableLiveData<>();
    public void getCurrencyVM()
    {
        CurrencyRepositoryImpl currencyRepositoryImpl = new CurrencyRepositoryImpl();
        GetCurrencyUseCase getCurrencyUseCase = new GetCurrencyUseCase(currencyRepositoryImpl);
        ArrayList<Currency> currencyArrayList = getCurrencyUseCase.execute();

        mutableLiveData.setValue(currencyArrayList);

        currencyArrayList.forEach(currency1 -> {
            Log.d("MyLog","LINE: "+ currency1.getNumCode()+ "\n");
        });

    }
}
