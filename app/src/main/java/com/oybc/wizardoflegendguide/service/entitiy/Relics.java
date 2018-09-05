package com.oybc.wizardoflegendguide.service.entitiy;
 
public class Relics  implements java.io.Serializable{
    private int id;
    private String kind;//offense, defense, misc, curse
    private String name;
    private String pic;
    private String dscrp;

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
        return "Relics{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", dscrp='" + dscrp + '\'' +
                '}';
    }
}
