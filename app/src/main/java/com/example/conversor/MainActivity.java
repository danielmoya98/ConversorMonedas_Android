package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MonedaViewModel monedaViewModel;
    private ArrayAdapter<String> adapter;
    private EditText editTextTasaCambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTasaCambio = findViewById(R.id.editTextTasaCambio);
        EditText editTextDolares = findViewById(R.id.editTextDolares);
        Button buttonConvertir = findViewById(R.id.buttonConvertir);
        Button buttonConvertir2 = findViewById(R.id.buttonConvertir2);
        ListView listViewResultado = findViewById(R.id.listViewResultado);

        monedaViewModel = new ViewModelProvider(this).get(MonedaViewModel.class);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listViewResultado.setAdapter(adapter);

        buttonConvertir.setOnClickListener(v -> {
            String cantidadString = editTextDolares.getText().toString();
            if (!cantidadString.isEmpty()) {
                double cantidad = Double.parseDouble(cantidadString);
                double tasa = obtenerTasa();
                monedaViewModel.convertirDolaresABolivianos(cantidad, tasa);
            }
        });

        buttonConvertir2.setOnClickListener(v -> {
            String cantidadString = editTextDolares.getText().toString();
            if (!cantidadString.isEmpty()) {
                double cantidad = Double.parseDouble(cantidadString);
                double tasa = obtenerTasa();
                monedaViewModel.convertirBolivianosADolares(cantidad, tasa);
            }
        });

        monedaViewModel.getListItems().observe(this, resultados -> {
            adapter.clear();
            adapter.addAll(resultados);
            adapter.notifyDataSetChanged();
        });
    }

    private double obtenerTasa() {
        String tasaString = editTextTasaCambio.getText().toString();
        double tasa = 7.40; // Valor por defecto
        if (!tasaString.isEmpty()) {
            tasa = Double.parseDouble(tasaString);
        }
        return tasa;
    }
}

