package org.example.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.Models.Enums.PlayerType;

@AllArgsConstructor
@Getter
@Setter
public class Player {
    private String name;
    private Character symbol;
    private PlayerType playerType;
}
