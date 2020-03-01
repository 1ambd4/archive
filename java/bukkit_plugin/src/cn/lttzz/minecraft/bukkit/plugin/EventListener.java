package cn.lttzz.minecraft.bukkit.plugin;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftWolf;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

public class EventListener implements Listener{

	public EventListener() {
		// TODO Auto-generated constructor stub
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		// send message to player while joined the world.
		event.setJoinMessage(player.getName() + ", welcome to the world, have fun!");
		
		// give necessary items to player
		// but note that should clear player's inventory
		PlayerInventory playerInventory = player.getInventory();
		playerInventory.clear();
		playerInventory.addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
		playerInventory.addItem(new ItemStack(Material.STICK, 1));
		playerInventory.addItem(new ItemStack(Material.APPLE, 1));
		playerInventory.addItem(new ItemStack(Material.DIAMOND, 1));
		playerInventory.addItem(new ItemStack(Material.WOOD_SWORD, 1));
		playerInventory.addItem(new ItemStack(Material.BONE, 1));
		playerInventory.addItem(new ItemStack(Material.GOLD_AXE, 1));
		
		// spawn a sheep while joined the world
		Location location = player.getLocation();
		World world = player.getWorld();
		Sheep sheep = world.spawn(location, Sheep.class);
		sheep.setColor(DyeColor.PINK);
		
		// show log
		player.getServer().getLogger().info(player.getName() + " joined the world.");
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		
		// send message to player if player have moved
		// Player player = event.getPlayer();
		// player.sendMessage("you have moved.");
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		// spawn a random color sheep if right click a stick on air
		// and spawn a wolf if left click a stick on air
		if (event.getMaterial() == Material.STICK) {
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
				player.getWorld().spawn(player.getLocation(), Sheep.class).setColor(DyeColor.values()[new Random().nextInt(16)]);
			}
			if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
				player.getWorld().spawn(player.getLocation(), Wolf.class).setCustomName("a sheep or a wolf");
			}
		}
		
		// right click to turn block into gold, may be you must hold a diamond sword
		if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				event.getClickedBlock().setType(Material.GOLD_BLOCK);
			}
		}
		
		// flip effect
		if (event.getMaterial() == Material.APPLE) {
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				Flip flip = new Flip(event.getClickedBlock().getLocation());
				Plugin plugin = player.getServer().getPluginManager().getPlugin("bukkit_plugin");
				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, flip, 10, 5);
			}
		}
		
		// floating light
		if (event.getMaterial() == Material.DIAMOND) {
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				FloatingLight floatingLight = new FloatingLight(event.getClickedBlock().getLocation());
				Plugin plugin = player.getServer().getPluginManager().getPlugin("bukkit_plugin");
				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, floatingLight, 10, 5);
			}
		}
		
		// digital display
		if (event.getMaterial() == Material.WOOD_SWORD) {
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				DigitalDisplay digitalDisplay = new DigitalDisplay(event.getClickedBlock().getLocation());
				Plugin plugin = player.getServer().getPluginManager().getPlugin("bukkit_plugin");
				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, digitalDisplay, 10, 20);
			}
		}
		
		// time set 0
		if (event.getMaterial() == Material.BONE) {
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
				player.getWorld().setTime(0);
				player.getWorld().setThundering(true);
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		
		// remove wolf if right clicked it with a golden axe in hand
		if (player.getItemInHand().getType() == Material.GOLD_AXE) {
			if (event.getRightClicked().getClass() == CraftWolf.class) {
				event.getRightClicked().remove();
				Sheep sheep = player.getWorld().spawn(event.getRightClicked().getLocation(), Sheep.class);
				sheep.setColor(DyeColor.GRAY);
				sheep.setCustomName("May be I was a walf");
			}
		}
	}
}
