package models;

import java.util.List;

public class LogisticsNetwork {
    private List<Hub> hubs;

    public LogisticsNetwork(List<Hub> hubs) {
        this.hubs = hubs;
    }
    public List<Hub> getHubs() { return hubs; }
}
