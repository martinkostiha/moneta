package cz.moneta;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TextControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamReturnEmptyString() throws Exception {

        this.mockMvc.perform(get("/text/transform"))
        	.andDo(print())
        	.andExpect(status().isOk())
            .andExpect(jsonPath("$.text").value(""));
    }

    @Test
    public void anyParamReturnTransformedText() throws Exception {

        this.mockMvc.perform(get("/text/transform").param("text", "Je mi fajn."))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value(".NjaF iM ej"));
    }

}