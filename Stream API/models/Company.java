package models;

import java.util.List;

public class Company {
    private List<Store> stores;

    public Company(List<Store> stores) {
        this.stores = stores;
    }
    public List<Store> getStores() { return stores; }
}
