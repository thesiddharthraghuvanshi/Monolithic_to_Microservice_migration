package com.sid.cricketapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerEto {

    private Integer playerId;

    private String playerName;

    private Integer age;

    private String playerQualification;
}
