package be.hevelaska.pdm.services;

import java.util.List;

import be.hevelaska.pdm.model.Monster;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class BackendService {

    private static BackendService singleton;

    private IBackend backend;


    private BackendService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        backend = retrofit.create(IBackend.class);
    }

    public Call<List<Monster>> getMonsterList(){
        return backend.listMonsters();
    }


    public static BackendService getInstance(){
        if(singleton == null){
            singleton = new BackendService();
        }
        return singleton;
    }
}
