package sample;

/**
 * Created by tysonmorris on 6/18/17.
 */
public class Location implements java.io.Serializable {

  private String name;
  private String streetAddress;
  private String city;
  private String state;
  private String zipCode;

  Location(String name, String streetAddress, String city, String state, String zipCode) {
    this.name = name;
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getName() {
    return this.name;
  }

  public String getStreetAddress() {
    return this.streetAddress;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public String getZipCode() {
    return this.zipCode;
  }

  public String toString() {
    return this.name + ", " + this.city;
  }

}
