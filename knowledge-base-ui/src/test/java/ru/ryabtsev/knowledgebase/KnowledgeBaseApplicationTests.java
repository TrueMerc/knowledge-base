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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=KnowledgeBaseApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class KnowledgeBaseApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testIndexPage() throws Exception {
		mvc.perform(get("/").contentType(MediaType.TEXT_HTML))
				.andExpect(status().isOk()); /* Redirection to login page: code 302 */
	}

	@Test
	public void testLoginPage() throws Exception {
		mvc.perform(get("/login").contentType(MediaType.TEXT_HTML))
				.andExpect(status().isOk());
	}

	@Test
	public void testUserListPage() throws Exception {
		mvc.perform(get("/users/list").contentType(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("allUsers"));
	}
}
