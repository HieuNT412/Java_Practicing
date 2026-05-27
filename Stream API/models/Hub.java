package models;

import java.util.List;

public class Hub {
    private String region;
    private List<Package> packageList;

    public Hub(String region, List<Package> packageList) {
        this.region = region;
        this.packageList = packageList;
    }
    public String getRegion() { return region; }
    public List<Package> getPackageList() { return packageList; }
}
