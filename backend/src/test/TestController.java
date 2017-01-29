package Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
/**
 * Created by flatch on 22/01/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestController.class)
public class TestController {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(this.context).build();
	}

	@Test
	public void testController() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string("<H2>Spring boot in action at 01/10/2013</H2>"));
	}



	@After
	public  void downUp(){
		this.mockMvc = null;
	}
}
