package erikbissell.com.WebChess;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/hello")


public class HelloController {
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public String sayHello(){
        return "Hello from SpringBoot";
    }
    
}
