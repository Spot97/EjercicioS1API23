package com.example.ejercicios1api23;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MostrarActivity extends AppCompatActivity {
    TextView etMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        etMensaje=findViewById(R.id.etMensaje);

        Bundle bundle = getIntent().getExtras();
        String nom = bundle.getString("nombre");
        String user = bundle.getString("user");
        String cat = bundle.getString("categoria");
        String gen = bundle.getString("sexo");
        String saludo = "";
        if (gen.equals("Masculino")){
            saludo="Bienvenido";
        }else{
            saludo="Bienvenida";
        }

        etMensaje.append(saludo+" "+nom+" "+", usted se ha registrado con el usuario: "+user+" y con la categoría "+cat);

    }
}
