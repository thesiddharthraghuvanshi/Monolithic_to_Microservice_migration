package com.sid.cricketapp.repository;

import com.sid.cricketapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "SELECT * FROM player ORDER BY RAND() LIMIT :number", nativeQuery = true)
    List<Player> findRadomPlayers(int number);
}