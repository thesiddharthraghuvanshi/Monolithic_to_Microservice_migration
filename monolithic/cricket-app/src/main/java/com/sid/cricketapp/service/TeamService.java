package com.sid.cricketapp.service;

import com.sid.cricketapp.model.TeamEto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface TeamService {
    ResponseEntity<String> addTeam(String teamName, Integer teamSize);

    ResponseEntity<TeamEto> getTeam(Integer id);
}