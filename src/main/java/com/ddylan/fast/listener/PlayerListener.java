package com.ddylan.fast.listener;

import com.ddylan.fast.FastPlugin;
import com.ddylan.fast.player.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        String name = player.getName();
        UUID uuid = player.getUniqueId();

        Profile profile = FastPlugin.getInstance().getProfileManager().getContainer().createProfile(uuid, name);

        profile.setLastLogin(System.currentTimeMillis());
        profile.setName(player.getName());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        UUID uuid = player.getUniqueId();

        Profile profile = FastPlugin.getInstance().getProfileManager().getProfile(uuid);

        profile.setLastLogout(System.currentTimeMillis());
    }

}
