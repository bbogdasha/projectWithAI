package com.bogdan.projectWithAI;

import com.bogdan.projectWithAI.controller.CountriesController;
import com.bogdan.projectWithAI.service.CountriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProjectWithAiApplicationTests {

	@Autowired
	private CountriesController controller;

	@Autowired
	private CountriesService service;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
	}

}
