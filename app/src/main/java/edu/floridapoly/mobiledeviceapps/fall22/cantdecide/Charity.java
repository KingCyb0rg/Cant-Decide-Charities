package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

public class Charity {
    private String id;
    private String name;
    private String mission;
    private String website;
    private String logoURL;

    public Charity(){}
    public Charity(String id, String name, String mission, String website, String logoURL) {
        this.id = id;
        this.name = name;
        this.mission = mission;
        this.website = website;
        this.logoURL = logoURL;
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

    public String getLogoURL() {
        return logoURL;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }
}
