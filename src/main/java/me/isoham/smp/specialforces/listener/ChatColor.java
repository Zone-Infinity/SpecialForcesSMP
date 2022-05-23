package me.isoham.smp.specialforces.listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Event where chat color can be changed
 */
public class ChatColor implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        event.message(LegacyComponentSerializer.legacyAmpersand().deserialize(
                PlainTextComponentSerializer.plainText().serialize(event.message())));
    }

    @EventHandler
    public void onAnvilUse(PrepareAnvilEvent event) {
        String text = event.getInventory().getRenameText();
        if (text == null) return;

        ItemStack item = event.getResult();
        if (item == null) return;

        ItemMeta meta = item.getItemMeta();
        meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize(text));
        item.setItemMeta(meta);

        event.setResult(item);
    }
}
