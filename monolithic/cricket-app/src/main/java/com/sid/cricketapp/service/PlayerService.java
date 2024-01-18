package com.sid.cricketapp.service;

import com.sid.cricketapp.model.PlayerDto;
import com.sid.cricketapp.model.PlayerEto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PlayerService {
    ResponseEntity<String> addPlayer(PlayerDto playerDto);

    ResponseEntity<List<PlayerEto>> getAllPlayers();

    ResponseEntity<PlayerEto> getPlayer(Integer id);
}