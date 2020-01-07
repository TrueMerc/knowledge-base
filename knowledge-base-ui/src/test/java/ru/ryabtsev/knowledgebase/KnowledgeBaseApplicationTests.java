package ru.ryabtsev.knowledgebase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=KnowledgeBaseApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class KnowledgeBaseApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {}

	@Test
	public void testIndexToLoginPageRedirection() throws Exception {
		mvc.perform(get("/").contentType(MediaType.TEXT_HTML))
				.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("http://localhost/login"));
	}

	@WithMockUser(value = "admin", password = "admin", roles={"ADMIN"})
	@Test
	public void testIndexPage() throws Exception {
		mvc.perform(get("/").contentType(MediaType.TEXT_HTML))
				.andExpect(status().isOk());
	}
}
