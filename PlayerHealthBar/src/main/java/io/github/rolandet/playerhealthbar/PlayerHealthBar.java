package io.github.rolandet.playerhealthbar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.DisplaySlot;

public final class PlayerHealthBar extends JavaPlugin {
	private final PlayerListener playerListener = new PlayerListener(this);

	@Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		 
		Objective objective = board.registerNewObjective("showhealth", "health");
		objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
		objective.setDisplayName("/ 20");
		PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
		for(Player online : Bukkit.getOnlinePlayers()){
			  online.setScoreboard(board);
			  online.setHealth(online.getHealth()); //Update their health
			}
		getLogger().info("PlayerHealthBar has been enabled!");
    }

	@Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    	getLogger().info("PlayerHealthBar has been disabled!");
    }
}
