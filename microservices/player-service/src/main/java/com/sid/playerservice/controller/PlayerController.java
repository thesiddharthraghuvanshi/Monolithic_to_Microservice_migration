package com.sid.playerservice.controller;

import com.sid.playerservice.model.PlayerDto;
import com.sid.playerservice.model.PlayerEto;
import com.sid.playerservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("add")
    public ResponseEntity<String> addPlayer(@RequestBody PlayerDto playerDto) {
        return playerService.addPlayer(playerDto);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<PlayerEto>> getAllPlayers() {

        return playerService.getAllPlayers();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<PlayerEto> getPlayer(@PathVariable Integer id) {
        return playerService.getPlayer(id);
    }

    @GetMapping("get/players")
    public ResponseEntity<List<Integer>> getPlayersForTeam(@RequestParam Integer playersCount) {
        return playerService.getPlayersForTeam(playersCount);
    }

    @PostMapping("get/players")
    public ResponseEntity<List<PlayerEto>> getPlayersFromPlayerIds(@RequestBody List<Integer> playerIds) {
        return playerService.getPlayersFromPlayerIds(playerIds);
    }
}
