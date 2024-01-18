package com.sid.cricketapp.serviceImpl;

import com.sid.cricketapp.model.Player;
import com.sid.cricketapp.model.PlayerDto;
import com.sid.cricketapp.model.PlayerEto;
import com.sid.cricketapp.repository.PlayerRepository;
import com.sid.cricketapp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public ResponseEntity<String> addPlayer(PlayerDto playerDto) {
        try{
            Player player = new Player();
            player.setPlayerName(playerDto.getPlayerName());
            player.setAge(playerDto.getAge());
            player.setPlayerQualification(playerDto.getPlayerQualification());
            playerRepository.save(player);
            return new ResponseEntity<>("Player added Sucessfully", HttpStatus.CREATED);
        } catch(Exception e) {
            System.out.println("Error at PlayerServiceImpl : addPlayer - " + e.getMessage());
        }
        return new ResponseEntity<>("Error adding player", HttpStatus.GATEWAY_TIMEOUT);
    }

    @Override
    public ResponseEntity<List<PlayerEto>> getAllPlayers() {

        List<Player> players = playerRepository.findAll();
        List<PlayerEto> playersEto = players.stream().map(player -> new PlayerEto(
                player.getPlayerId(),
                player.getPlayerName(),
                player.getAge(),
                player.getPlayerQualification()
        )).collect(Collectors.toList());

        return new ResponseEntity<>(playersEto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PlayerEto> getPlayer(Integer id) {

        Player player = playerRepository.findById(id).get();
        PlayerEto playerEto = new PlayerEto(player.getPlayerId(),
                player.getPlayerName(),
                player.getAge(),
                player.getPlayerQualification());
        return new ResponseEntity<>(playerEto, HttpStatus.OK);
    }
}
