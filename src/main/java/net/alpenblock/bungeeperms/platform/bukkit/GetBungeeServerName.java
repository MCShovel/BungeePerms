package net.alpenblock.bungeeperms.platform.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class GetBungeeServerName implements Runnable {
	private final BukkitPlugin plugin;
	private final Player player;
	public GetBungeeServerName(BukkitPlugin plugin, Player player) {
		this.plugin = plugin;
		this.player = player;
	}
	
	@Override
	public void run() {
		if (!player.isOnline()) return;
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("GetServer");
        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
	}
	
	public void runAfter(int serverTicks) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, this, serverTicks);
	}
}
