package com.example.conversor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
public class MonedaViewModel extends ViewModel {
    private MutableLiveData<List<String>> listItems;
    private MutableLiveData<Double> tasaCambio;

    public MonedaViewModel() {
        listItems = new MutableLiveData<>();
        listItems.setValue(new ArrayList<>());
        tasaCambio = new MutableLiveData<>();
        tasaCambio.setValue(7.40); // Valor por defecto
    }

    public LiveData<List<String>> getListItems() {
        return listItems;
    }

    public LiveData<Double> getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(double tasa) {
        tasaCambio.setValue(tasa);
    }

    public void convertirDolaresABolivianos(double cantidad, double tasa) {
       double resultado = cantidad * tasa;

        List<String> currentList = listItems.getValue();
        if (currentList != null) {
            currentList.add("Resultado: " + resultado + " Bolivianos");
            listItems.setValue(currentList);
        }
    }

    public void convertirBolivianosADolares(double cantidad , double tasa) {
        double resultado = cantidad / tasa;

        List<String> currentList = listItems.getValue();
        if (currentList != null) {
            currentList.add("Resultado: " + resultado + " Dolares");
            listItems.setValue(currentList);
        }
    }
}
