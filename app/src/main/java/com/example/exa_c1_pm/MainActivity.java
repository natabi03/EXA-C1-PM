package com.example.exa_c1_pm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etBase, etAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etBase = findViewById(R.id.etBase);
        etAltura = findViewById(R.id.etAltura);
        Button btnLimpiar = findViewById(R.id.btnlim);
        Button btnSalir = findViewById(R.id.btnsalir);
        Button btnSiguiente = findViewById(R.id.btnsig);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNombre.setText("");
                etBase.setText("");
                etAltura.setText("");
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String baseStr = etBase.getText().toString();
                String alturaStr = etAltura.getText().toString();

                if (nombre.isEmpty() || baseStr.isEmpty() || alturaStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        float base = Float.parseFloat(baseStr);
                        float altura = Float.parseFloat(alturaStr);

                        Intent intent = new Intent(MainActivity.this, RectanguloActivity.class);
                        intent.putExtra("nombre", nombre);
                        intent.putExtra("base", base);
                        intent.putExtra("altura", altura);
                        startActivity(intent);
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Ingrese valores numéricos válidos para base y altura", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
