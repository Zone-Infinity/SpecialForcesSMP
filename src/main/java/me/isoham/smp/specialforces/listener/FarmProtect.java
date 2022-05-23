package me.isoham.smp.specialforces.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

@SuppressWarnings("ConstantConditions")
public class FarmProtect implements Listener {
    @EventHandler
    public void onPlayerCropDestroy(PlayerInteractEvent event) {
        if (event.getAction() != Action.PHYSICAL) return;
        if (event.getClickedBlock().getType() == Material.FARMLAND)
            event.setCancelled(true);
    }
}
