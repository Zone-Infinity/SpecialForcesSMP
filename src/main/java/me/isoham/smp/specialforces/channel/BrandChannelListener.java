package me.isoham.smp.specialforces.channel;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;

public class BrandChannelListener implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, byte @NotNull [] message) {
        TextComponent msg = Component.text(player.getName() + "'s client brand : ")
                .append(Component.text(
                        new String(message, StandardCharsets.UTF_8).substring(1),
                        Style.style(NamedTextColor.AQUA, TextDecoration.BOLD)
                ));
        Bukkit.broadcast(msg);
    }
}
