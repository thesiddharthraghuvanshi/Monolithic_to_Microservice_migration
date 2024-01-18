package com.sid.teamservice.service;

import com.sid.teamservice.model.TeamEto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface TeamService {
    ResponseEntity<String> addTeam(String teamName, Integer teamSize);

    ResponseEntity<TeamEto> getTeam(Integer id);
}