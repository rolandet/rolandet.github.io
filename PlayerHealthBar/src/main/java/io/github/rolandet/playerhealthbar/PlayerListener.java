package io.github.rolandet.playerhealthbar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerListener implements Listener {
	   private final PlayerHealthBar plugin;

	    public PlayerListener(PlayerHealthBar instance) {
	        plugin = instance;
	    }

	    @EventHandler
	    public void onPlayerJoin(PlayerJoinEvent event) {
	    	ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();
			 
			Objective objective = board.registerNewObjective("showhealth", "health");
			objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
			objective.setDisplayName("/ 20");
			for(Player online : Bukkit.getOnlinePlayers()){
				  online.setScoreboard(board);
				  online.setHealth(online.getHealth()); //Update their health
			}
	        plugin.getLogger().info(event.getPlayer().getName() + " joined the server! :D");
	    }

}
