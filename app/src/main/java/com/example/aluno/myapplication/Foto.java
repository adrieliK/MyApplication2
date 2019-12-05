package com.example.aluno.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Foto extends AppCompatActivity {
    private ImageView foto;

    public Foto() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        Button button1 = findViewById(R.id.button1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if pra pegar do campo e clicar no botão para salvar, se nulo volta, se erro volta
                startActivity(new Intent(Foto.this, Lista.class));
            }
        });
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }

        foto = findViewById(R.id.foto);
        findViewById(R.id.camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });
    }

    public void tirarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1) {
            Bundle extras = data.getExtras();
            assert extras != null;
            Bitmap imagem = (Bitmap) extras.get("data");
            foto.setImageBitmap(imagem);
        } else {
            Toast.makeText(this, "Houve um problema para tirar a foto, tente novamente!", Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);



    }
}
