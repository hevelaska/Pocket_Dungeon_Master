package be.hevelaska.pdm.services;

import java.util.List;

import be.hevelaska.pdm.model.cypher.Cypher;
import be.hevelaska.pdm.model.monster.Monster;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IBackend {
    @GET("/hevelaska/dungeon_and_dragon_monster/master/monsters.json")
    Call<List<Monster>> listMonsters();
    @GET("/hevelaska/Pocket_Dungeon_Master/master/Cyphers.json")
    Call<List<Cypher>> listCyphers();

}
