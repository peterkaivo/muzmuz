package io.github.peterkaivo.muzmuz.view.model;


import java.util.Objects;

/**
 * View class representing a postal address
 */
public class Address {
    private Long id;
    private String street1;
    private String street2;
    private String city;
    private String zip;
    private String province;
    private String country;

    public Address() {
    }

    public Address(Long id, String street1, String street2, String city, String zip, String province,
                   String country) {
        this.id = id;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.zip = zip;
        this.province = province;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id)
                && Objects.equals(street1, address.street1)
                && Objects.equals(street2, address.street2)
                && Objects.equals(city, address.city)
                && Objects.equals(zip, address.zip)
                && Objects.equals(province, address.province)
                && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street1, street2, city, zip, province, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address1='" + street1 + '\'' +
                ", address2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
