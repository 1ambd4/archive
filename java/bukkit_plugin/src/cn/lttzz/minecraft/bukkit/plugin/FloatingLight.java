package cn.lttzz.minecraft.bukkit.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class FloatingLight implements Runnable {

	private Location location;
	private short num = 0;
	
	public FloatingLight() {
		// TODO Auto-generated constructor stub
	}
	
	public FloatingLight(Location location) {
		this.location = location;
	}

	@Override
	public void run() {
		if (num > 9) num = 0;
		else num++;
		
		for (int i = 0; i < 8; ++i) {
			Block block = location.getWorld().getBlockAt((int)location.getX() + i, (int)location.getY(), (int)location.getZ());
			if (i == num) {
				block.setType(Material.GOLD_BLOCK);
			}
			else {
				block.setType(Material.GLASS);
			}
		}
	}
}
