package in.rcard.genson;

import com.owlike.genson.annotation.JsonCreator;
import com.owlike.genson.annotation.JsonProperty;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directors")
public class DirectorController {
  
  private final DirectorService service;
  
  public DirectorController(DirectorService service) {
    this.service = service;
  }
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public void addDirector(@RequestBody Director director) {
    service.addDirector(director);
  }
  
  public static class Director {
    private final String name;
    private final int yearOfBirth;
  
    @JsonCreator
    public Director(
        @JsonProperty("name") String name,
        @JsonProperty("yearOfBirth") int yearOfBirth) {
      this.name = name;
      this.yearOfBirth = yearOfBirth;
    }
  
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Director director = (Director) o;
      return yearOfBirth == director.yearOfBirth && Objects.equals(name, director.name);
    }
  
    @Override
    public int hashCode() {
      return Objects.hash(name, yearOfBirth);
    }
  
    @Override
    public String toString() {
      return "Director{" +
                 "name='" + name + '\'' +
                 ", yearOfBirth=" + yearOfBirth +
                 '}';
    }
  }
}
