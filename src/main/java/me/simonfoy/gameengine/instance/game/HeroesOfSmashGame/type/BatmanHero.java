package me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.type;

import me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.hero.Hero;
import me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.hero.HeroType;

import java.util.UUID;

public class BatmanHero extends Hero {
    public BatmanHero(UUID uuid) {
        super(HeroType.BATMAN, uuid);
    }

    @Override
    public void onStart() {

    }
}
