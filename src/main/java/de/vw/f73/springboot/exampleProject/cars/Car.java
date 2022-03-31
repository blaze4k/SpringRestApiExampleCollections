package de.vw.f73.springboot.exampleProject.cars;

import java.util.List;
import java.util.UUID;

public class Car {

  private UUID uuid;
  private String type;
  private int weight;
  private int modelYear;
  private int doors;

  public Car() {}

  public Car(List<String> attributes) {
    this.type = attributes.get(0);
    this.weight = Integer.parseInt(attributes.get(1));
    this.modelYear = Integer.parseInt(attributes.get(2));
    this.doors = Integer.parseInt(attributes.get(3));
    this.uuid = generateUUID();
  }

  public Car(String type, int weight, int modelYear, int doors) {
    this.type = type;
    this.weight = weight;
    this.modelYear = modelYear;
    this.doors = doors;
  }

  private UUID generateUUID() {
    return UUID.nameUUIDFromBytes(toString().getBytes());
  }

  public String getType() {
    return type;
  }

  public int getWeight() {
    return weight;
  }

  public int getModelYear() {
    return modelYear;
  }

  public int getDoors() {
    return doors;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID randomUUID) {
    this.uuid = randomUUID;
  }

  @Override
  public String toString() {
    return "Attributes: \n ["
        + this.uuid
        + "] \n"
        + " ["
        + this.type
        + "] \n"
        + " ["
        + this.weight
        + "] \n"
        + " ["
        + this.modelYear
        + "] \n"
        + " ["
        + this.doors
        + "] \n";
  }
}
