package com.kajal.test.activity.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import com.kajal.test.R;
import com.kajal.test.activity.activity.adapter.HouseAdapter;
import com.kajal.test.activity.activity.model.MainPojo;
import com.kajal.test.activity.activity.model.ResultHouse;
import com.kajal.test.activity.activity.rest.ApiClient;
import com.kajal.test.activity.activity.rest.ApiInterface;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button filterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        filterButton = findViewById(R.id.ButtonFilter);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Filter_house.class));
            }
        });

        Call<MainPojo> call = apiService.getHouseDetails("","","",null);
        call.enqueue(new Callback<MainPojo>() {
            @Override
            public void onResponse(Call<MainPojo> call,Response<MainPojo> response) {
                if (response.isSuccessful()){
                    ArrayList<ResultHouse> mainPojos = response.body().getResultHouses();
                    recyclerView.setAdapter(new HouseAdapter(mainPojos, R.layout.list_item_house,getApplicationContext()));
                }else{
                    Toast.makeText(getApplicationContext(),"SOMETHING ERROR",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<MainPojo> call,Throwable t) {
                Toast.makeText(getApplicationContext(),"On Failure called"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent,View view,int position,long id) {
        parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
