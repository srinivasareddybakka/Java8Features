package java8.optional;

import java.util.Optional;

public class Mobile {
    private long id;
    private String brand;
    private String name;
    private Optional<DisplayFeatures> displayFeatures;

    public Mobile(long id, String brand, String name, Optional<DisplayFeatures> displayFeatures) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.displayFeatures = displayFeatures;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<DisplayFeatures> getDisplayFeatures() {
        return displayFeatures;
    }

    public void setDisplayFeatures(Optional<DisplayFeatures> displayFeatures) {
        this.displayFeatures = displayFeatures;
    }
}
