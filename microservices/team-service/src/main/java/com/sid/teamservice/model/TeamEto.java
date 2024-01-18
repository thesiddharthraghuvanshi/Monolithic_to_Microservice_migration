package com.sid.teamservice.model;

import lombok.Data;

import java.util.List;

@Data
public class TeamEto {

    private Integer teamId;

    private TeamType teamType;

    private String teamName;

    private List<PlayerEto> players;
}
