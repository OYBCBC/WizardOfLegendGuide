package com.oybc.wizardoflegendguide.service.entitiy;

import java.io.Serializable;

public class Arcana implements Serializable {

    private int id;
    private String kind;
    private String pic;
    private String name;
    private String nature;
    private String cd;
    private String dscrp;
    private String type;
    private String dmg;
    private String ehDmg;
    private String fendoff;
    private String duration;
    private String offset;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getDscrp() {
        return dscrp;
    }

    public void setDscrp(String dscrp) {
        this.dscrp = dscrp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDmg() {
        return dmg;
    }

    public void setDmg(String dmg) {
        this.dmg = dmg;
    }

    public String getEhDmg() {
        return ehDmg;
    }

    public void setEhDmg(String ehDmg) {
        this.ehDmg = ehDmg;
    }

    public String getFendoff() {
        return fendoff;
    }

    public void setFendoff(String fendoff) {
        this.fendoff = fendoff;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Arcana{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", pic='" + pic + '\'' +
                ", name='" + name + '\'' +
                ", nature='" + nature + '\'' +
                ", cd='" + cd + '\'' +
                ", dscrp='" + dscrp + '\'' +
                ", type='" + type + '\'' +
                ", dmg='" + dmg + '\'' +
                ", ehDmg='" + ehDmg + '\'' +
                ", fendoff=" + fendoff +
                ", duration='" + duration + '\'' +
                ", offset='" + offset + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
