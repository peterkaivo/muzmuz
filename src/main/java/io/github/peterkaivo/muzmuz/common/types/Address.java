package io.github.peterkaivo.muzmuz.common.types;


import java.util.Objects;

/**
 * Class representing a postal address
 */
public class Address {
    String address1;
    String address2;
    String city;
    String zip;
    String province;
    String country;

    public Address(String address1, String address2, String city, String zip, String province, String country) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.zip = zip;
        this.province = province;
        this.country = country;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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
        return Objects.equals(address1, address.address1) && Objects.equals(address2, address.address2) && Objects.equals(city, address.city) && Objects.equals(zip, address.zip) && Objects.equals(province, address.province) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address1, address2, city, zip, province, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
