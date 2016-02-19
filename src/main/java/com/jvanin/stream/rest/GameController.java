package com.jvanin.stream.rest;

import com.jvanin.stream.domain.Game;
import com.jvanin.stream.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long save(@RequestBody Game game) {
        return gameService.save(game);
    }

    @RequestMapping(value = "/{gameId}")
    public Game getById(@PathVariable Long gameId) {
        return gameService.getById(gameId);
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long gameId){
        gameService.delete(gameId);
    }

}
