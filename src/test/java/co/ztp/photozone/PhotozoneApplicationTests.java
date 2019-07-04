package co.ztp.photozone;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.ztp.photozone.model.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PhotozoneApplicationTests {
	
	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;


	@Test
	public void usingEmptyDataShouldFail() throws Exception {
		
		
		UserDTO user = new UserDTO();
		user.setPassword("");
		user.setUsername("");
		
		ResultActions result = mockMvc
				.perform(MockMvcRequestBuilders.post("/api/v1/register").contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(user))).andExpect(status().is5xxServerError());

		//result.andDo(MockMvcResultHandlers.print());
		       
	}

}
