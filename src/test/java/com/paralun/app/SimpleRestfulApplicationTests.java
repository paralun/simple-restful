package com.paralun.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SimpleRestfulApplicationTests {

	@Test
	void contextLoads() {
		Optional<String> opt = Optional.of("Baba");
		Assertions.assertTrue(opt.isPresent());
	}

}
