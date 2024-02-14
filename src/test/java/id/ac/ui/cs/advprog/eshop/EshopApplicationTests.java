package id.ac.ui.cs.advprog.eshop;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {

	@Test
	void contextLoads() {
		assertNotNull(EshopApplication.class);
	}

	@Test
	void TestMain() {
		EshopApplication.main(new String[] {});
	}

}
