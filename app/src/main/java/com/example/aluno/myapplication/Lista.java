package com.example.aluno.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import com.orm.query.Select;

import java.util.List;

import static android.R.layout.simple_list_item_checked;

public class Lista extends AppCompatActivity {

    Button listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listar = (Button) findViewById(R.id.listar);

        final List<Produto> produtos = Select.from(Produto.class).list();
        final ListView lista= (ListView) findViewById(R.id.lista);
        ArrayAdapter<Produto> arrayAdapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, (List<Produto>) produtos);
        lista.setAdapter(arrayAdapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Lista.this, Produto.class);
                Bundle b = new Bundle();
                b.putString("idPruduto", ""+produtos.get(position).getId());
                intent.putExtras(b);
//                startActivity(intent);
            }
        });




    }


}
