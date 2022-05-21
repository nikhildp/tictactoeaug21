package com.scaler.tictactoe.models;

import com.scaler.tictactoe.exceptions.MultipleBotsException;
import com.scaler.tictactoe.strategies.gamewinningstrategies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        private List<Player> players;
        private Board board;
        private List<Move> moves;
        private List<GameWinningStrategy> gameWinningStrategies;
        private int lastMovedPlayerIndex;
        private GameStatus gameStatus;
        private Player winner;

        Builder() {
            this.players = new ArrayList<>();
            this.gameWinningStrategies = new ArrayList<>();
        }

//        public Builder setPlayers(List<Player> players) {
//            this.players = players;
//        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder addPlayers(List<Player> players) {
            this.players.addAll(players);

            return this;
        }

        public Builder withBoard(Board board) {
            this.board = board;
            return this;
        }

//        public Builder setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
//            this.gameWinningStrategies = gameWinningStrategies;
//        }

        public Builder addGameWinningStrategy(GameWinningStrategy strategy) {
            this.gameWinningStrategies.add(strategy);
            return this;
        }

        private boolean checkIfSingleBotMax() {
            int count = 0;

            for (Player player: players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    count += 1;
                }
            }

            return count <= 1;
        }
        public Game build() throws MultipleBotsException {
            if (!checkIfSingleBotMax()) {
                throw new MultipleBotsException();
            }

            return null;
        }
    }
}
