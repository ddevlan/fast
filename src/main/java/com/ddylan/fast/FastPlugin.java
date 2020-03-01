package com.ddylan.fast;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class FastPlugin extends JavaPlugin {

    @Getter
    private FastPlugin instance;

    @Override
    public void onEnable() {
        this.instance = this;
    }

    @Override
    public void onDisable() {
        this.instance = null;
    }

}
