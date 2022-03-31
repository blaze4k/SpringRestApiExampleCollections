package de.vw.f73.springboot.exampleProject.greeting;

import java.time.LocalDateTime;

public class Greeting {

  private String name;
  private LocalDateTime time;

  public Greeting() {}

  public Greeting(String name) {
    this.name = name;
    this.time = LocalDateTime.now();
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }
}
