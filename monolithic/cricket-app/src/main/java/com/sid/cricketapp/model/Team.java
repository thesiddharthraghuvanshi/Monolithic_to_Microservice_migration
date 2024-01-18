package com.sid.cricketapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;

    private TeamType teamType;

    private String teamName;

    @ManyToMany
    private List<Player> players;
}
