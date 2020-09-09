package be.hevelaska.pdm.services;

import java.util.List;

import be.hevelaska.pdm.model.Monster;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IBackend {
    @GET("/hevelaska/dungeon_and_dragon_monster/master/monsters.json")
    Call<List<Monster>> listMonsters();
}
