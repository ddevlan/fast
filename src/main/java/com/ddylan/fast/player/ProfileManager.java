package com.ddylan.fast.player;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ProfileManager {

    private ProfileContainer container;

    public ProfileManager(ProfileContainer container) {
        this.container = container;
    }

    public Profile getProfile(UUID uuid) {
        if (this.container.getProfiles().containsKey(uuid)) {
            return this.container.getProfiles().get(uuid);
        }
        return null;
    }

    public Profile getProfile(String name) {
        for (Profile profile : this.container.getProfiles().values()) {
            if (profile.getName().equals(name)) {
                return profile;
            }
        }
        return null;
    }

    public boolean profileExists(UUID uuid) {
        return this.container.getProfiles().containsKey(uuid);
    }

    public boolean profileExists(String name) {
        for (Profile profile : this.container.getProfiles().values()) {
            if (profile.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
