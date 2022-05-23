package me.isoham.smp.specialforces;

import me.isoham.smp.specialforces.channel.BrandChannelListener;
import me.isoham.smp.specialforces.command.ShowItem;
import me.isoham.smp.specialforces.listener.ChatColor;
import me.isoham.smp.specialforces.listener.FarmProtect;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("ConstantConditions")
public final class SpecialForces extends JavaPlugin {

    @Override
    public void onEnable() {
        registerEvent(new ChatColor());
        registerEvent(new FarmProtect());
        getCommand("showitem").setExecutor(new ShowItem());

        Bukkit.getMessenger().registerIncomingPluginChannel(this, "minecraft:brand", new BrandChannelListener());

        getLogger().info("Special Forces enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Special Forces disabled!");
    }

    private void registerEvent(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }
}
