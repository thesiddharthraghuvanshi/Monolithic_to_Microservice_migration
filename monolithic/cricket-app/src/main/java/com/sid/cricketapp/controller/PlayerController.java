package com.sid.cricketapp.controller;

import com.sid.cricketapp.model.PlayerDto;
import com.sid.cricketapp.model.PlayerEto;
import com.sid.cricketapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<PlayerEto> getPlayer(@PathVariable Integer id){
        return playerService.getPlayer(id);
    }
}
