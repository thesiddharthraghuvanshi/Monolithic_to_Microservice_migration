package com.sid.cricketapp.serviceImpl;

import com.sid.cricketapp.model.*;
import com.sid.cricketapp.repository.PlayerRepository;
import com.sid.cricketapp.repository.TeamRepository;
import com.sid.cricketapp.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Override
    public ResponseEntity<String> addTeam(String teamName, Integer teamSize) {
        try{
            Team team = new Team();
            team.setTeamName(teamName);
            team.setTeamType(TeamType.T20);
            List<Player> players = playerRepository.findRadomPlayers(2);
            team.setPlayers(players);
            teamRepository.save(team);
            return new ResponseEntity<>("Team Created Sucessfully", HttpStatus.CREATED);
        } catch(Exception e) {
            System.out.println("Error at TeamServiceImpl : addTeam - " + e.getMessage());
        }

        return new ResponseEntity<>("Error in creating team", HttpStatus.GATEWAY_TIMEOUT);
    }

    @Override
    public ResponseEntity<TeamEto> getTeam(Integer id) {
        Team team = teamRepository.findById(id).get();
        TeamEto teamEto = new TeamEto();
        teamEto.setTeamName(team.getTeamName());
        teamEto.setTeamType(team.getTeamType());
        List<PlayerEto> playersEto = team.getPlayers().stream().map(player -> new PlayerEto(
                player.getPlayerId(),
                player.getPlayerName(),
                player.getAge(),
                player.getPlayerQualification()
        )).collect(Collectors.toList());
        teamEto.setPlayers(playersEto);
        return new ResponseEntity<>(teamEto, HttpStatus.OK);
    }
}
