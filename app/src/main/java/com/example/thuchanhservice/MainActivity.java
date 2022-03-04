package com.example.thuchanhservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String urlRequest = "http://lenhutran1807-001-site1.htempurl.com/jsongv.php";
    ListView lvNhanVien;
    ArrayList<LeNhuTran_GiaoVien> arrayListNV;
    LeNhuTran_AdapterGV adapter;
    EditText edtSerch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNhanVien = (ListView) findViewById(R.id.listViewGiaoVien);
        edtSerch = findViewById(R.id.edtSerch);
        edtSerch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });


        arrayListNV = new ArrayList<>();

        adapter = new LeNhuTran_AdapterGV(this, R.layout.lenhutran_item_giaovien, arrayListNV);
        lvNhanVien.setAdapter(adapter);
        GetData(urlRequest);


    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                arrayListNV.clear();
                // Goi GetData o fuction deleteNhanVien nen no tu update lai
                // Su dung clear de xoa
                for (int i = 0 ; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        arrayListNV.add(new LeNhuTran_GiaoVien(
                                jsonObject.getInt("Id"),
                                jsonObject.getString("Tengv"),
                                jsonObject.getString("Gt"),
                                jsonObject.getString("Diachi"),
                                jsonObject.getString("Sdt")

                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Loi", Toast.LENGTH_SHORT).show();
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }
    // Tim kiem
    public void filter(String text) {
        ArrayList<LeNhuTran_GiaoVien> filterList = new ArrayList<>();
        for(LeNhuTran_GiaoVien GV: arrayListNV){
            if (GV.getTenGV().toLowerCase().contains(text.toLowerCase())) {
                filterList.add(GV);
            }else if (GV.getDiachi().toLowerCase().contains(text.toLowerCase())){
                filterList.add(GV);
            }

        }
        adapter.filterSP(filterList);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.themgv,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //startActivity(new Intent(MainActivity.this,InsertActivity.class));
        return super.onOptionsItemSelected(item);
    }

}