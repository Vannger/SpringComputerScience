package com.weapon;

public class WeaponDisplay {
    private Weapon weapon;

    public WeaponDisplay(Weapon weapon) {
        this.weapon = weapon;
    }

    public void show() {
        System.out.println("Displaying weapon: " + weapon.getType());
    }
}
