package leegunhee.dockerprac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DockerpracApplicationTests {

	@Autowired UserRepository userRepository;
	@Test
	@Transactional
	void contextLoads() {
		User user = new User();
		userRepository.save(user);
	}

}
