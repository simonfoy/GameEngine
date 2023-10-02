package me.simonfoy.gameengine.instance.game.HeroesOfSmashGame.hero;

import org.bukkit.Material;

public enum HeroType {

    BATMAN("BatDude", Material.COAL, "This hero is based off Batman!"),
    SPIDERMAN("WebBro", Material.COBWEB, "This hero is based off Spiderman!");
//    MARIO("Merio", 3000),
//    SUPERMAN("CapedGuy"),
//    YOSHI("DinoChomp"),
//    HULK("Bulk"),
//    DARTH_VADER("SpaceBreather"),
//    GOKU("Goku"),
//    NARUTO("Naruto"),
//    LOKI("Lowkey"),
//    THOR("Snore"),
//    SPONGEBOB("SquarePantsy"),
//    SQUIDWARD("GrumpyTentacle"),
//    SASUKE("EdgyNinja"),
//    FRIEZA("ChillyTyrant"),
//    YODA("TinyWisdom");

    private String display, description;
    private Material material;

    HeroType(String display, Material material, String description) {
        this.display = display;
        this.material = material;
        this.description = description;

    }

    public String getDisplay() { return display; }
    public Material getMaterial() { return material; }
    public String getDescription() { return description; }
}
