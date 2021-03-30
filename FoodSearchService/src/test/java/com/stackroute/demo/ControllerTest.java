package com.stackroute.demo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.demo.controller.FoodSearchServiceController;
import com.stackroute.demo.model.Food;
import com.stackroute.demo.model.Foods;
import com.stackroute.demo.model.Nutrients;
import com.stackroute.demo.services.FoodSearchService;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

	@InjectMocks
	private FoodSearchServiceController foodSearchServiceController;
	
	@Mock
	private FoodSearchService foodSearchService;
	
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddFavFoodSuccess() throws JsonProcessingException,Exception {
		Nutrients nutri=new Nutrients("n001","protein","2.04");
		List<Nutrients> nutrilist=new ArrayList<Nutrients>();
		nutrilist.add(nutri);
		Food favfood1=new Food("fdc01","d1","i1",nutrilist);
		Food favfood2=new Food("fdc02","d2","i2",nutrilist);
		List<Food> foodlist=new ArrayList<Food>();
		foodlist.add(favfood1);
		foodlist.add(favfood2);
		Foods f1=new Foods(foodlist);
		
		when(foodSearchService.addSearch(any())).thenReturn(true); 
		mockMvc.perform(MockMvcRequestBuilders
					.post("/api/v1/search/d1")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(f1)))
					.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
