package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

public class Charity {
    private String id;
    private String name;
    private String mission;
    private String website;

    public Charity(){}
    public Charity(String id, String name, String mission, String website) {
        this.id = id;
        this.name = name;
        this.mission = mission;
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
