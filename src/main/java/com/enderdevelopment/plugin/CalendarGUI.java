package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CalendarGUI {

    private final Main plugin;

    public CalendarGUI(Main plugin) {
        this.plugin = plugin;
    }

    public void openCalendar(Player player) {
        Inventory calendar = Bukkit.createInventory(null, 54, "Christmas Calendar");

        // Add items to the calendar
        for (int i = 0; i < 24; i++) {
            ItemStack item = new ItemStack(Material.CHEST);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("Day " + (i + 1));
            meta.setLore(Arrays.asList("Click to open!"));
            item.setItemMeta(meta);
            calendar.setItem(i, item);
        }

        // Add close button
        ItemStack closeButton = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = closeButton.getItemMeta();
        closeMeta.setDisplayName("Close");
        closeButton.setItemMeta(closeMeta);
        calendar.setItem(49, closeButton);

        player.openInventory(calendar);
    }
}