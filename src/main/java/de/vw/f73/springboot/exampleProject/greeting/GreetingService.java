package de.vw.f73.springboot.exampleProject.greeting;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GreetingService {

  public Greeting appendTime(Greeting greeting) {
    greeting.setTime(LocalDateTime.now());
    return greeting;
  }
}
