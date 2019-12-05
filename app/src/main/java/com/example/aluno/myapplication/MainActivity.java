package com.example.aluno.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    private EditText editNome;
    private EditText editQuantidade;
    private EditText editDTVal;
    private EditText editPreco;
    private Button btnCadastrar;
    private ImageButton btnFoto;
    private Button buttonListar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        File - Settings - "instant" - desativar instatnt run

//        SugarContext.init(getApplicationContext());
//        SchemaGenerator schemaGenerator = new SchemaGenerator(this);
//        schemaGenerator.createDatabase(new SugarDb(this).getDB());


        editNome = findViewById(R.id.editNome);
        editQuantidade = findViewById(R.id.editQuantidade);
        editDTVal = findViewById(R.id.editDTVal);
        editPreco = findViewById(R.id.editPreco);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnFoto = findViewById(R.id.btnFoto);
        buttonListar = findViewById(R.id.buttonListar);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Foto.class));
            }
        });

        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Lista.class));
            }
        });



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = editNome.getText().toString();
                String quantidade = editQuantidade.getText().toString();
                int x = Integer.parseInt(quantidade);
                String data = editDTVal.getText().toString();
                String preco = editPreco.getText().toString();
                Double y = Double.parseDouble(preco);

                try {
                    Produto p = new Produto();
                    p.setNome(nome);
                    p.setQuantidade(x);
                    p.setData(data);
                    p.setPreco(y);

                    p.save();

                    makeText(MainActivity.this, "Produto salvo com sucesso!", LENGTH_SHORT).show();

                    // limpar campos
                    editNome.setText("");

                    startActivity(new Intent(MainActivity.this, Lista.class));

                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Erro ao salvar...", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }






}

