package com.jvanin.stream.controllers;

import com.jvanin.stream.domain.Game;
import com.jvanin.stream.rest.GameController;
import com.jvanin.stream.services.GameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    @Mock
    GameService gameService;

    @InjectMocks
    GameController gameController;

    @Before
    public void setUp() throws Exception {
        when(gameService.getAll()).thenReturn(fakeGames());
    }

    @Test
    public void callsResourceAndReturnGames() throws Exception {
        List<Game> games = gameController.getAllGames();

        verify(gameService).getAll();

        assertThat(games.isEmpty(), is(not(true)));
    }

    private List<Game> fakeGames(){
        List<Game> games = new ArrayList<>();
        games.add(new Game(1L, "Metal Gear", 2015));
        games.add(new Game(2L, "Dragon Age", 2014));
        return games;
    }
}