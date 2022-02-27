package io.github.macaylamarvelous81.nexus1;

import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class EventListener implements Listener {

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent event) {
        if (event.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Nexus1.getInstance(), "itemid"), PersistentDataType.INTEGER)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        World world = player.getWorld();

        if (
                (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
                // && event.getHand() == EquipmentSlot.HAND (Allow use of offhand)
                && event.hasItem()
                && item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Nexus1.getInstance(), "itemid"), PersistentDataType.INTEGER)
        ) {
            CustomItem id = CustomItem.toItem(item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Nexus1.getInstance(), "itemid"), PersistentDataType.INTEGER));

            // TODO: Every custom item gets it's own handler(s)
            switch(id) {
                case CUPCAKE:
                    world.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EAT, 1f, 1f);
                    player.setFoodLevel(player.getFoodLevel() + 1);
                    item.setAmount(item.getAmount() - 1);
                    break;
                case PORTABLE_CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // TODO: Teach all recipes if configuration allows it
        RecipeRegistry.learnAllRecipes(event.getPlayer());
    }

}
