package com.example.atividadespraticasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inptGasolina;
    EditText inptEtanol;
    TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcularResultado();

    }


    private void calcularResultado(){
        {
            txtResultado = findViewById(R.id.txt_resultado);
            Button button = findViewById(R.id.bt_calcular);
            final String[] resultado = {null};

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inptGasolina = findViewById(R.id.inptGasolina);
                    inptEtanol = findViewById(R.id.inptEtanol);
                    if((inptEtanol.getText().toString().matches("") ) || (inptGasolina.getText().toString().matches(""))){
                        txtResultado.setText(R.string.txt_Warning);
                        return;
                    }
                    final double gasolina = Double.parseDouble(inptGasolina.getText().toString());
                    final double etanol = Double.parseDouble(inptEtanol.getText().toString());
                    if((gasolina*0.7)<etanol){
                        resultado[0] = getResources().getString(R.string.txt_resultadoGas);
                        txtResultado.setText(resultado[0]);
                    }
                    else{
                        resultado[0] = getResources().getString(R.string.txt_resultadoEtanol);
                        txtResultado.setText(resultado[0]);
                    }
                }
            });
        }
    }
}
