package com.example.ejercicios1api23;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etUser, etPass, etPassC;
    Button btnEnviar;
    RadioGroup radioGroup,radioGroup2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=findViewById(R.id.etNombre);
        etUser=findViewById(R.id.etUser);
        etPass=findViewById(R.id.etPass);
        etPassC=findViewById(R.id.etPassC);
        btnEnviar=findViewById(R.id.btnEnviar);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup2=findViewById(R.id.radioGroup2);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId1;
                int selectedId2;
                String nom = etNombre.getText().toString();
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();
                String passC = etPassC.getText().toString();


                selectedId1 = radioGroup.getCheckedRadioButtonId();
                selectedId2 = radioGroup2.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) findViewById(selectedId1);
                RadioButton radioButton2 = (RadioButton) findViewById(selectedId2);

                Intent intent = new Intent(MainActivity.this,MostrarActivity.class);
                if(nom.equals("")){
                    Toast.makeText(MainActivity.this,"Ingresar Nombre",Toast.LENGTH_SHORT).show();
                }else if(user.equals("")){
                    Toast.makeText(MainActivity.this,"Ingresar Usuario",Toast.LENGTH_SHORT).show();
                }else if(pass.equals("")){
                    Toast.makeText(MainActivity.this,"Ingresar Contraseña",Toast.LENGTH_SHORT).show();
                }else if(selectedId1==-1){
                    Toast.makeText(MainActivity.this,"Seleccione su género",Toast.LENGTH_SHORT).show();
                }else if(selectedId2==-1){
                    Toast.makeText(MainActivity.this,"Seleccione su categoría",Toast.LENGTH_SHORT).show();
                } else if(pass.equals(passC)){
                    intent.putExtra("nombre", etNombre.getText().toString());
                    intent.putExtra("user", etUser.getText().toString());
                    intent.putExtra("sexo", radioButton.getText().toString());
                    intent.putExtra("categoria", radioButton2.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
