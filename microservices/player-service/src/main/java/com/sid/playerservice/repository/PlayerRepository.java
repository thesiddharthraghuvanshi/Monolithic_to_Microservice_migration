package com.sid.playerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sid.playerservice.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    @Query(value = "SELECT p.player_id FROM player p ORDER BY RAND() LIMIT :number", nativeQuery = true)
    List<Integer> findRadomPlayers(int number);
}