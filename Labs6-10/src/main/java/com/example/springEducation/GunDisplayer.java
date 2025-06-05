package com.example.springEducation;

import java.util.List;

public class GunDisplayer {
    private List<Gun> guns;

    public GunDisplayer(List<Gun> guns) {
        this.guns = guns;
    }

    public List<Gun> getGuns() {
        return guns;
    }

    public Gun getGunById(int id) {
        return guns.stream()
                .filter(gun -> gun.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
