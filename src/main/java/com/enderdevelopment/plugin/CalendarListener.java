package com.enderdevelopment.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;

public class CalendarListener implements Listener {

    private final Main plugin;

    public CalendarListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Christmas Calendar")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.CHEST) {
                // Handle chest click
                player.sendMessage("You clicked on a chest!");
            } else if (event.getCurrentItem() != null && event.getCurrentItem().getType() == Material.BARRIER) {
                // Handle close button click
                player.closeInventory();
                player.sendMessage("Calendar closed.");
            }
        }
    }
}