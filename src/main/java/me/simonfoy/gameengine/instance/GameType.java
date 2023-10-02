package me.simonfoy.gameengine.instance;

import me.simonfoy.gameengine.GameEngine;
import me.simonfoy.gameengine.instance.game.BlocksVSZombiesGame.BlocksVSZombiesGame;
import me.simonfoy.gameengine.instance.game.GameTemplate;
import me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.HeroesOfSmashGame;
import me.simonfoy.gameengine.instance.game.TowerWarsGame.TowerWarsGame;
import me.simonfoy.gameengine.instance.game.CraftRoyaleGame.CraftRoyaleGame;

public enum GameType {
    TOWERWARS("world", 1),
    CRAFTROYALE("world", 1),
    BLOCKSVSZOMBIES("world", 1),
    HEROESOFSMASH("world", 1);

    private final String worldName;
    private final int requiredPlayers;

    GameType(String worldName, int requiredPlayers) {
        this.worldName = worldName;
        this.requiredPlayers = requiredPlayers;
    }

    public String getWorldName() {
        return worldName;
    }

    public int getRequiredPlayers() {
        return requiredPlayers;
    }

    public static GameType fromString(String name) {
        for (GameType type : values()) {
            if (type.name().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No game type found for name: " + name);
    }

    public GameTemplate createGameTemplate(GameEngine gameEngine, Game game) {
        switch (this) {
            case TOWERWARS:
                return new TowerWarsGame(gameEngine, game);
            case CRAFTROYALE:
                return new CraftRoyaleGame(gameEngine, game);
            case BLOCKSVSZOMBIES:
                return new BlocksVSZombiesGame(gameEngine, game);
            case HEROESOFSMASH:
                return new HeroesOfSmashGame(gameEngine, game);
            default:
                throw new IllegalArgumentException("Unknown game type: " + this);
        }
    }
}
