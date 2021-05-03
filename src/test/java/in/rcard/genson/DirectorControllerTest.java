package in.rcard.genson;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import in.rcard.genson.DirectorController.Director;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DirectorController.class)
class DirectorControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private DirectorService service;
  
  @Test
  void addDirectorShouldAddANewDirector() throws Exception {
    mockMvc.perform(
        post("/directors")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"Zack Snyder\", \"yearOfBirth\": 1966}")
    ).andExpect(status().is2xxSuccessful());
  
    final Director zackSnyder = new Director("Zack Snyder", 1966);
    Mockito.verify(service, Mockito.times(1)).addDirector(zackSnyder);
  }
}