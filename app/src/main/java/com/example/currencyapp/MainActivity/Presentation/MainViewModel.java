package com.example.currencyapp.MainActivity.Presentation;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.currencyapp.MainActivity.Data.Repository.CurrencyRepositoryImpl;
import com.example.currencyapp.MainActivity.Domain.Models.Currency;
import com.example.currencyapp.MainActivity.Domain.UseCases.GetCurrencyUseCase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainViewModel extends ViewModel
{
    MutableLiveData<ArrayList<Currency>> mutableLiveData = new MutableLiveData<>();
    public void getCurrencyVM()
    {
        CurrencyRepositoryImpl currencyRepositoryImpl = new CurrencyRepositoryImpl();
        GetCurrencyUseCase getCurrencyUseCase = new GetCurrencyUseCase(currencyRepositoryImpl);


        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                ArrayList<Currency> currencyArrayList = getCurrencyUseCase.execute();
                mutableLiveData.postValue(currencyArrayList);
                Log.d("MyLog","LINE: " + currencyArrayList.get(8) +"\n");
            }
        };
        timer.scheduleAtFixedRate(timerTask,0, 30000);
        //mutableLiveData.setValue(currencyArrayList);
    }
}
