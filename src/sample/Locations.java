package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tysonmorris on 6/18/17.
 */
public class Locations implements java.io.Serializable {

  ArrayList<Location> locations;
  String file;

  Locations(int size, String file) {
    this.locations = new ArrayList<>(size);
    this.file = file;
  }
  Locations(String file) {
    this.file = file;
    try {
      ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(file));
      locations = (ArrayList<Location>) fileIn.readObject();
      fileIn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void add(String name, String streetAddress, String city, String state, String zipCode) {
    locations.add(new Location(name, streetAddress, city, state, zipCode));
  }

  public void remove(String name) {
    for (int i = 0; i < locations.size(); i++) {
      if (locations.get(i).getName().compareTo(name) == 0)
        locations.remove(i);
    }
  }

  public ArrayList<Location> getLocations() {
    return this.locations;
  }

  public void saveLocations() {
    try {
      ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(file));
      fileOut.writeObject(this.locations);
      fileOut.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<Location> getChurches() {
    Locations temp = new Locations("churches.dat");
    return temp.getLocations();
  }

  public static ArrayList<Location> getCemeteries() {
    Locations temp = new Locations("cemeterys.dat");
    return temp.getLocations();
  }

  public static void main(String[] args) {
    //Locations churches = new Locations("churches.dat");
    Locations cemeterys = new Locations("cemeterys.dat");
    ArrayList<Location> churches = getChurches();

    //churches.add("St. John Vianney", "420 Inman Ave", "Colonia", "NJ", "07067");
    //cemeterys.add("St. Gertrude's Cemetery", "53 Inman Ave", "Colonia", "NJ", "07067");

    //churches.saveLocations();
    //cemeterys.saveLocations();

    System.out.println(churches.get(0).getName());
    System.out.println(cemeterys.locations.get(0).getName());
  }

}
