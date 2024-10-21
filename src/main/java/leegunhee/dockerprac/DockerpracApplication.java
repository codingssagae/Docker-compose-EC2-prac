package leegunhee.dockerprac;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class DockerpracApplication {

	private final UserRepository userRepository;

	@RequestMapping("/")
	String Home(){
		userRepository.save(new User());
		return "Hello Worddddld";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerpracApplication.class, args);
	}
}
