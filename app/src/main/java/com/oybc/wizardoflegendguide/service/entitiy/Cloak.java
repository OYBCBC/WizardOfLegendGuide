package com.oybc.wizardoflegendguide.service.entitiy;

public class Cloak implements java.io.Serializable {

    private int id;
    private String name;
    private String pic;

    private String maxHealth;
    private String runSpeed;
    private String criticalChance;
    private String damage;
    private String envadeChance;
    private String armor;

    public String getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(String maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getRunSpeed() {
        return runSpeed;
    }

    public void setRunSpeed(String runSpeed) {
        this.runSpeed = runSpeed;
    }

    public String getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(String criticalChance) {
        this.criticalChance = criticalChance;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getEnvadeChance() {
        return envadeChance;
    }

    public void setEnvadeChance(String envadeChance) {
        this.envadeChance = envadeChance;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(String criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    private String cd;
    private String defense;
    private String criticalDamage;
    private String dscrp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDscrp() {
        return dscrp;
    }

    public void setDscrp(String dscrp) {
        this.dscrp = dscrp;
    }

    @Override
    public String toString() {
        return "Cloak{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", maxHealth='" + maxHealth + '\'' +
                ", runSpeed='" + runSpeed + '\'' +
                ", criticalChance='" + criticalChance + '\'' +
                ", damage='" + damage + '\'' +
                ", envadeChance='" + envadeChance + '\'' +
                ", armor='" + armor + '\'' +
                ", cd='" + cd + '\'' +
                ", defense='" + defense + '\'' +
                ", criticalDamage='" + criticalDamage + '\'' +
                ", dscrp='" + dscrp + '\'' +
                '}';
    }
}

