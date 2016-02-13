package com.jvanin.stream.controllers;

import com.jvanin.stream.domain.Game;
import com.jvanin.stream.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @RequestMapping ( value = "/games", method =RequestMethod.GET)
    public List<Game> getAllGames(){
        return gameService.getAll();
    }
}
