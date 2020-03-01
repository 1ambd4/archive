package cn.lttzz.minecraft.bukkit.plugin;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class DigitalDisplay implements Runnable {
	
	private Location location;
	private short num = 0;
	private Block blocks[][] = new Block[9][5];

	public DigitalDisplay() {
		// TODO Auto-generated constructor stub
	}
	
	public DigitalDisplay(Location location) {
		this.location = location;
	}

	@Override
	public void run() {
		if (num > 9) num = 0;
		else num++;
		
		for (int j = 0; j < 5; ++j) {
			for (int i = 0; i < 9; ++i) {
				blocks[i][j] = location.getWorld().getBlockAt((int)location.getX() + j , (int)location.getY() + 2 + i, (int)location.getZ());
				blocks[i][j].setType(Material.IRON_BLOCK);
			}
		}
		
		turnOnLight(num);
	}
	
	public void turnOnLight(int number) {
		int [][] table = new int [][] {{1,1,1,1,1,1,0}, {0,1,1,0,0,0,0}, {1,1,0,1,1,0,1}, {1,1,1,1,0,0,1}, {0,1,1,0,0,1,1}, 
												{1,0,1,1,0,1,1}, {1,0,1,1,1,1,1}, {1,1,1,0,0,0,0},{1,1,1,1,1,1,1},{1,1,1,1,0,1,1}};
		for (int i = 0; i < 7; ++i) {
			if (table[number][i] == 1) {
				turnOnSegment(i);
			}
		}
		
		turnOnLight(num);
	}
	
	public void turnOnSegment(int index) {
		switch (index) {
		case 0:
			blocks[8][1].setType(Material.GOLD_BLOCK); 
			blocks[8][2].setType(Material.GOLD_BLOCK); 
			blocks[8][3].setType(Material.GOLD_BLOCK);
			break;
		case 1:
			blocks[5][4].setType(Material.GOLD_BLOCK); 
			blocks[6][4].setType(Material.GOLD_BLOCK); 
			blocks[7][4].setType(Material.GOLD_BLOCK); 
			break;
		case 2:
			blocks[1][4].setType(Material.GOLD_BLOCK); 
			blocks[2][4].setType(Material.GOLD_BLOCK); 
			blocks[3][4].setType(Material.GOLD_BLOCK);
			break;
		case 3:
			blocks[0][1].setType(Material.GOLD_BLOCK); 
			blocks[0][2].setType(Material.GOLD_BLOCK); 
			blocks[0][3].setType(Material.GOLD_BLOCK);
			break;
		case 4:
			blocks[1][0].setType(Material.GOLD_BLOCK); 
			blocks[2][0].setType(Material.GOLD_BLOCK); 
			blocks[3][0].setType(Material.GOLD_BLOCK);
			break;
		case 5:
			blocks[5][0].setType(Material.GOLD_BLOCK); 
			blocks[6][0].setType(Material.GOLD_BLOCK); 
			blocks[7][0].setType(Material.GOLD_BLOCK);
			break;
		case 6:
			blocks[4][1].setType(Material.GOLD_BLOCK); 
			blocks[4][2].setType(Material.GOLD_BLOCK); 
			blocks[4][3].setType(Material.GOLD_BLOCK);
			break;
		default:
			break;
		}
	}
}
