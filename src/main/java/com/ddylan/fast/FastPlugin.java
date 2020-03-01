package com.ddylan.fast;

import com.ddylan.fast.listener.PlayerListener;
import com.ddylan.fast.player.ProfileContainer;
import com.ddylan.fast.player.ProfileManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
@Getter
public class FastPlugin extends JavaPlugin {

    @Getter
    private static FastPlugin instance;
    private ProfileManager profileManager;

    @Override
    public void onEnable() {
        instance = this;

        /*
            this can be changed later when database support is added so i can have it all hosted on ovh :)
         */
        this.profileManager = new ProfileManager(new ProfileContainer(this));

        registerListeners();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), instance);
    }

}
