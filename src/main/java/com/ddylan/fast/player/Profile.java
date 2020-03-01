package com.ddylan.fast.player;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class Profile {

    private UUID uniqueId;
    @Setter private String name;
    @Setter private long lastLogin;
    @Setter private long lastLogout;

    public Profile(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Profile(UUID uniqueId, String name) {
        this(uniqueId);
        this.name = name;
    }


    // idk if this math is right but im sure this is better than using a player object
    public boolean isOnline() {
        return lastLogin > lastLogout;
    }

}
