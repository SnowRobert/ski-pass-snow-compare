package snow.pass.resorts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.PathVariable;


@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /demo (after Application path)
public class ResortController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private ResortRepository resortRepository;

  @GetMapping(path="/")
  public @ResponseBody String getAPI() {
      return "Welcome to the Api";
  }

  @GetMapping(path="/resorts")
  public @ResponseBody Iterable<Resort> getAllResorts() {
    // This returns a JSON or XML with the users
    return resortRepository.findAll();
  }

  @GetMapping("/resorts/{id}")
  public @ResponseBody Resort getResort(@PathVariable String id) {
    return resortRepository.findById(id)
      .orElseThrow(() -> new ResortNotFoundException(id));
    
  }

}

