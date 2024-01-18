package com.sid.playerservice.service;


import com.sid.playerservice.model.PlayerDto;
import com.sid.playerservice.model.PlayerEto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlayerService {
    ResponseEntity<String> addPlayer(PlayerDto playerDto);

    ResponseEntity<List<PlayerEto>> getAllPlayers();

    ResponseEntity<PlayerEto> getPlayer(Integer id);

    ResponseEntity<List<Integer>> getPlayersForTeam(Integer playersCount);

    ResponseEntity<List<PlayerEto>> getPlayersFromPlayerIds(List<Integer> playerIds);
}