package com.jvanin.stream.domain;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void returnsTrueWhenOnlyIdsAreNotEqual() throws Exception {
        Game firstGame = new Game(1L, "Pokemon", 2013);
        Game secondGame = new Game(2L, "Pokemon", 2013);

        assertThat(firstGame.equals(secondGame), is(true));
    }

    @Test
    public void returnsFalseWhenComparingTwoDifferentGames() throws Exception {
        Game firstGame = new Game(1L, "Pokemon", 2013);
        Game secondGame = new Game(2L, "Pokemon2", 2014);

        assertThat(firstGame.equals(secondGame), is(false));
    }
}