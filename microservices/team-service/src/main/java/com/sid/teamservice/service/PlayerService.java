package com.sid.teamservice.service;

import com.sid.teamservice.model.PlayerEto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("PLAYER-SERVICE")
public interface PlayerService {

    @GetMapping("player/get/players")
    public ResponseEntity<List<Integer>> getPlayersForTeam(@RequestParam Integer playersCount);

    @PostMapping("player/get/players")
    public ResponseEntity<List<PlayerEto>> getPlayersFromPlayerIds(@RequestBody List<Integer> playerIds);

}
