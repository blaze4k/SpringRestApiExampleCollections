package de.vw.f73.springboot.exampleProject.cosuming;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/consume")
public class CosumeController {

  @GetMapping("/dogimage")
  public DogPics getDogImage() throws IOException {
    String url = "https://dog.ceo/api/breeds/image/random";
    return new RestTemplate().getForObject(url, DogPics.class);
  }

  @GetMapping("/insult/")
  public Insult getInsult() throws IOException {
    String url = "https://evilinsult.com/generate_insult.php?lang=en&type=json";
    return new RestTemplate().getForObject(url, Insult.class);
  }
}
