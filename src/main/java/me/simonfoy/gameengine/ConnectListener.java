package me.simonfoy.gameengine;

import me.simonfoy.gameengine.instance.Game;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class ConnectListener implements Listener {

    private GameEngine gameEngine;

    public ConnectListener(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent event) {
        handlePlayerJoin(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onQuit(PlayerQuitEvent event) {
        handlePlayerQuit(event.getPlayer());
    }

    public void handlePlayerJoin(Player player) {
        Game game = gameEngine.getGame();
        game.addPlayer(player);
        setLobbyInventory(player);
        sendWelcomeMessage(player);
        playJoinSound(player);
    }

    public void handlePlayerQuit(Player player) {
        Game game = gameEngine.getGame();
        if (game != null) {
            game.removePlayer(player);
        }
    }

    private void setLobbyInventory(Player player) {
        player.getInventory().clear();
        ItemStack compass = new ItemStack(Material.COMPASS);
        player.getInventory().setItem(4, compass);
    }

    private void sendWelcomeMessage(Player player) {
        player.sendMessage(ChatColor.GREEN + "Welcome to our server!");
    }

    private void playJoinSound(Player player) {
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
    }
}
