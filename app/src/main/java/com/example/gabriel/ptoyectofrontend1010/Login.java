package com.example.gabriel.ptoyectofrontend1010;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    TextView tvRegistrar;
    EditText etcorreo, etpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etcorreo = findViewById(R.id.correo);
        etpass = findViewById(R.id.pass);
        tvRegistrar = (TextView) findViewById(R.id.tv_registrar);
        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registrar.class);
                Login.this.startActivity(intent);
            }
        });
    }

    public void iniciarSesion(View view) {
        final String username = etcorreo.getText().toString();
        final String pass = etpass.getText().toString();
        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    Log.e("aqui",jsonResponse.getString("estado"));
                    /* boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setMessage("Error en el logueo").setNegativeButton("Retry", null).create().show();
                        String name = jsonResponse.getString("name");
                        String age = jsonResponse.getString("age");
                        Toast.makeText(getApplicationContext(), "Te has logueado", Toast.LENGTH_LONG).show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setMessage("Error en el logueo").setNegativeButton("Retry", null).create().show();
                    }*/
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        LoguinRequest loguinRequest = new LoguinRequest(username,pass,responseListener);

    }
}
