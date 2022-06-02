package Sprint1.model;

public class Brands {
    Long id;
    String name;
    String country;

    public Brands(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Brands() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
