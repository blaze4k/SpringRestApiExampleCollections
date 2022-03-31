package de.vw.f73.springboot.exampleProject.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetingsController {

  private Greeting greeting = new Greeting("Hello");
  @Autowired private GreetingService greetingService;

  //  private Optional<Greeting> greetingOpt = Optional.empty();

  @GetMapping(path = "/greeting")
  private Greeting getTest() {
    return this.greetingService.appendTime(this.greeting);
  }

  @PostMapping(path = "/greeting")
  public void postTest(@RequestParam String greeting) {
    this.greeting = new Greeting(greeting);
  }

  //  @GetMapping(path = "/greettime")
  //  private Greeting getGreeting() {
  //    return this.greetingOpt.orElseGet(() -> new Greeting("Empty"));
  //  }
  //
  //  @PostMapping(path = "/greettime")
  //  private void setGreeting(@RequestParam String greeting) {
  //    this.greetingOpt = Optional.of(new Greeting(greeting));
  //  }
}
