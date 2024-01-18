package com.sid.teamservice.controller;


import com.sid.teamservice.model.TeamEto;
import com.sid.teamservice.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("team")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping("add")
    public ResponseEntity<String> addTeam(@RequestParam String teamName, @RequestParam Integer teamSize) {
        return teamService.addTeam(teamName, teamSize);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<TeamEto> getTeam(@PathVariable Integer id) {
        return teamService.getTeam(id);
    }
}
