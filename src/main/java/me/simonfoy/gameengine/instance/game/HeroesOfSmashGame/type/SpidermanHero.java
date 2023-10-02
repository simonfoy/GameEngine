package me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.type;

import me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.hero.Hero;
import me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.hero.HeroType;

import java.util.UUID;

public class SpidermanHero extends Hero {
    public SpidermanHero(UUID uuid) {
        super(HeroType.SPIDERMAN, uuid);
    }

    @Override
    public void onStart() {

    }
}
