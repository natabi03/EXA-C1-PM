package com.example.exa_c1_pm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RectanguloActivity extends AppCompatActivity {
    private TextView txtNombre, txtBase, txtAltura, txtResultado;
    private Button btnRegresar, btnCalcular;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        txtNombre = findViewById(R.id.txtNombre);
        txtBase = findViewById(R.id.txtBase);
        txtAltura = findViewById(R.id.txtAltura);
        txtResultado = findViewById(R.id.txtResultado);
        radioGroup = findViewById(R.id.radioGroup);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnCalcular = findViewById(R.id.btnCalcular);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nombre") && intent.hasExtra("base") && intent.hasExtra("altura")) {
            String nombre = intent.getStringExtra("nombre");
            float base = intent.getFloatExtra("base", 0);
            float altura = intent.getFloatExtra("altura", 0);

            txtNombre.setText("Nombre: " + nombre);
            txtBase.setText("Base: " + base);
            txtAltura.setText("Altura: " + altura);
        }

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Obtener los valores de base y altura desde los TextView
                    String baseText = txtBase.getText().toString();
                    String alturaText = txtAltura.getText().toString();

                    // Verificar que el texto tenga el formato esperado "Base: " y "Altura: "
                    if (baseText.startsWith("Base: ") && alturaText.startsWith("Altura: ")) {
                        float base = Float.parseFloat(baseText.split(": ")[1]);
                        float altura = Float.parseFloat(alturaText.split(": ")[1]);

                        // Crear el objeto Rectangulo
                        Rectangulo rectangulo = new Rectangulo(base, altura);

                        // Obtener la operación seleccionada
                        int selectedOperation = radioGroup.getCheckedRadioButtonId();

                        if (selectedOperation == R.id.rdbArea) {
                            // Calcular el área y mostrar el resultado
                            float area = rectangulo.calcularArea();
                            txtResultado.setText("Área: " + area);
                        } else if (selectedOperation == R.id.rdbPerimetro) {
                            // Calcular el perímetro y mostrar el resultado
                            float perimetro = rectangulo.calcularPerimetro();
                            txtResultado.setText("Perímetro: " + perimetro);
                        } else {
                            Toast.makeText(view.getContext(), "Por favor, seleccione una operación", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(view.getContext(), "Formato de base o altura incorrecto", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(view.getContext(), "Error al convertir base o altura a número", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
