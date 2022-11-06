package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

public class Charity {
    private long id;
    private String name;
    private String alias;
    private String mission;
    private String region;
    private Causes[] causes;
    private String url;

    public Charity(){}
    public Charity(long id, String name, String mission, String region, Causes[] causes, String url) {
        this.id = id;
        this.name = name;
        this.mission = mission;
        this.region = region;
        this.causes = causes;
        this.url = url;
    }

}
