package me.simonfoy.gameengine.instance;

import me.simonfoy.gameengine.GameEngine;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {

    private GameEngine gameEngine;
    private Game game;

    private int timerSeconds;

    public Timer(GameEngine gameEngine, Game game) {
        this.gameEngine = gameEngine;
        this.game = game;
        this.timerSeconds = 240;
    }

    public void startTimer() {
        runTaskTimer(gameEngine, 0, 20);
    }

    @Override
    public void run() {
        if (timerSeconds == 0) {
            cancel();
            game.end();
            return;
        }

        if (timerSeconds <= 10) {
            game.sendMessage(ChatColor.GREEN + "Game will end in " + timerSeconds + " second" + (timerSeconds == 1 ? "" : "s") + ".");
        }

        game.sendTitle(ChatColor.GREEN.toString() + timerSeconds + " second" + (timerSeconds == 1 ? "" : "s"), ChatColor.GRAY + "until game starts");

        timerSeconds--;
    }

    public int getTimerSeconds() { return timerSeconds; }
}
