package cn.lttzz.minecraft.bukkit.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Flip implements Runnable{
	
	private Location location;

	public Flip() {
		// TODO Auto-generated constructor stub
	}
	
	public Flip(Location location) {
		this.location = location;
	}

	@Override
	public void run() {
		Block block = location.getWorld().getBlockAt(location);
		if (block.getType() == Material.GRASS || block.getType() == Material.STONE) {
			block.setType(Material.GOLD_BLOCK);
		}
		else {
			block.setType(Material.GRASS);
		}
	}
}
