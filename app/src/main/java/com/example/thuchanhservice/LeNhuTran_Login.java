package com.example.thuchanhservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;

import java.util.HashMap;
import java.util.Map;

public class LeNhuTran_Login extends AppCompatActivity {
    EditText User_name, Pass_word;
    Button btnlogin;
    String URL_LOGIN ="http://lenhutran1807-001-site1.htempurl.com/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lenhutran_login);

        btnlogin = findViewById(R.id.buttonLogin);
        User_name = findViewById(R.id.editTextuser);
        Pass_word = findViewById(R.id.editTextPass);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(URL_LOGIN);
            }
        });
    }

            private void Login(String URL) {
                //String URL ="http://lenhutran1807-001-site1.htempurl.com/login.php";
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.trim().equals("successful")){
                            Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "Login Unsuccessfull", Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Login Unsuccessfull", Toast.LENGTH_LONG).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();
                        params.put("UserName", User_name.getText().toString().trim());
                        params.put("PassWord", Pass_word.getText().toString().trim());

                        return params;
                    }
                };

                requestQueue.add(stringRequest);


    }
}