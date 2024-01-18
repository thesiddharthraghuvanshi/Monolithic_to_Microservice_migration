package com.sid.teamservice.serviceImpl;

import com.sid.teamservice.model.PlayerEto;
import com.sid.teamservice.model.Team;
import com.sid.teamservice.model.TeamEto;
import com.sid.teamservice.model.TeamType;
import com.sid.teamservice.repository.TeamRepository;
import com.sid.teamservice.service.PlayerService;
import com.sid.teamservice.service.TeamService;
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
    PlayerService playerService;

    @Override
    public ResponseEntity<String> addTeam(String teamName, Integer teamSize) {
        try{
            Team team = new Team();
            team.setTeamName(teamName);
            team.setTeamType(TeamType.T20);
            ResponseEntity<List<Integer>> playerIds = playerService.getPlayersForTeam(teamSize);
            team.setPlayers(playerIds.getBody());
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
        teamEto.setTeamId(team.getTeamId());
        teamEto.setTeamName(team.getTeamName());
        teamEto.setTeamType(team.getTeamType());
        ResponseEntity<List<PlayerEto>> playersEto = playerService.getPlayersFromPlayerIds(team.getPlayers());
        teamEto.setPlayers(playersEto.getBody());
        return new ResponseEntity<>(teamEto, HttpStatus.OK);
    }
}
