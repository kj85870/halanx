package com.kajal.test.activity.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
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


public class Filter_house extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<String> house_type_list = new ArrayList<>();
    ArrayList<String> accomodation_type_list = new ArrayList<>();
    ArrayList<String> furnish_type_list = new ArrayList<>();
    Button FilterApplyButton;
    private ApiInterface apiService;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_house);
        accomodation_type_list.clear();
        house_type_list.clear();
        accomodation_type_list.clear();
        FilterApplyButton = findViewById(R.id.Applyfilter);
        FilterApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerView  = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

    }
//
//    private void house_filter_method(String housetype,String furnish_type,String acc_type) {
//
////                Call<MainPojo> call = apiService.getHouseDetails("","","",null);
////        call.enqueue(new Callback<MainPojo>() {
////            @Override
////            public void onResponse(Call<MainPojo> call,Response<MainPojo> response) {
////                if (response.isSuccessful()){
////                    ArrayList<ResultHouse> mainPojos = response.body().getResultHouses();
////                    recyclerView.setAdapter(new HouseAdapter(mainPojos, R.layout.list_item_house,getApplicationContext()));
////                }else{
////                    Toast.makeText(getApplicationContext(),"SOMETHING ERROR",Toast.LENGTH_SHORT).show();
////                }
////            }
////
////            @Override
////            public void onFailure(Call<MainPojo> call,Throwable t) {
////                Toast.makeText(getApplicationContext(),"On Failure called"+t.getMessage(),Toast.LENGTH_SHORT).show();
////            }
////        });
//
//        Toast.makeText(getApplicationContext(),"Message: ",Toast.LENGTH_SHORT).show();
//    }

    public void onCheckboxClicked(View view) {
        String house_answer = null;
        String Furnished_answer = null;
        String accomodation_type =null;
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkboxApartment:
                if (checked){
                    house_type_list.add("apartment");
                     house_answer = android.text.TextUtils.join(",", house_type_list);
                }
                break;
            case R.id.checkboxindependent:
                if (checked)
                {
                    house_type_list.add("independent");
                    house_answer = android.text.TextUtils.join(",", house_type_list);

                }
                break;
            case R.id.checkboxVilla:
                if (checked)
                {
                    house_type_list.add("villa");
                     house_answer = android.text.TextUtils.join(",", house_type_list);

                }
                break;
            case R.id.checkboxFull:
                if (checked){
                    furnish_type_list.add("full");
                    Furnished_answer = android.text.TextUtils.join(",",furnish_type_list);
                }
                break;
            case R.id.checkboxSemi:
                if (checked){
                    furnish_type_list.add("semi");
                    Furnished_answer = android.text.TextUtils.join(",",furnish_type_list);
                }
                break;
            case R.id.checkboxFlat:
                if (checked){
                    accomodation_type_list.add("flat");
                    accomodation_type = android.text.TextUtils.join(",",accomodation_type_list);
                }
                break;
            case R.id.checkboxShared:
                if (checked){
                    accomodation_type_list.add("shared");
                    accomodation_type = android.text.TextUtils.join(",",accomodation_type_list);
                }
                break;
            case R.id.checkboxPrivate:
                if (checked){
                    accomodation_type_list.add("private");
                    accomodation_type = android.text.TextUtils.join(",",accomodation_type_list);
                }
                break;
            default:
                accomodation_type_list.clear();
                house_type_list.clear();
                accomodation_type_list.clear();

        }
        Call<MainPojo> call = apiService.getHouseDetails(house_answer,Furnished_answer,accomodation_type,null);
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
