package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

public class Charity {
    private long id;
    private String name;
    private String alias;
    private String mission;
    private String region;
    private String[] causes;
    private String website;

    public Charity(){}
    public Charity(long id, String name, String mission, String region, String[] causes, String website) {
        this.id = id;
        this.name = name;
        this.mission = mission;
        this.region = region;
        this.causes = causes;
        this.website = website;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String[] getCauses() {
        return causes;
    }

    public void setCauses(String[] causes) {
        this.causes = causes;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
