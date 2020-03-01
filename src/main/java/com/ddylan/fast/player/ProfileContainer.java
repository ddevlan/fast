package com.ddylan.fast.player;

import com.ddylan.fast.FastPlugin;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class ProfileContainer {

    private Map<UUID, Profile> profiles;

    /*
        save methods.
        container = folder/files
     */

    protected File file;

    public ProfileContainer(FastPlugin plugin) {
        this.file = new File(plugin.getDataFolder() + "/profiles/");

        this.profiles = new HashMap<>();

        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public Profile createProfile(UUID uuid, String name) {
        if (!profiles.values().contains(uuid)) {
            profiles.put(uuid, new Profile(uuid, name));
        }
        File close = new File(file + uuid.toString() + ".yml");

        if (!close.exists()) {
            try {
                close.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            /*
                load from yaml config
             */
        }
        return profiles.get(uuid);
    }

    public void deleteProfile(UUID uuid) {
        profiles.put(uuid, null);

        File close = new File(file + uuid.toString() + ".yml");

        if (close.exists()) {
            close.delete();
        }
    }



}
