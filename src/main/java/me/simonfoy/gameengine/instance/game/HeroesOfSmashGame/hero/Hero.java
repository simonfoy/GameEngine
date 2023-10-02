package me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.hero;

import org.bukkit.Bukkit;

import java.util.UUID;

public abstract class Hero {

    private HeroType type;
    private UUID uuid;

    public Hero(HeroType type, UUID uuid) {
        this.type = type;
        this.uuid = uuid;

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    public UUID getUUID() { return uuid; }
    public HeroType getType() { return type; }

    public abstract void onStart();
}
