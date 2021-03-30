package com.stackroute.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.demo.controller.FoodRecommendationController;
import com.stackroute.demo.model.Food;
import com.stackroute.demo.model.Foods;
import com.stackroute.demo.model.Nutrients;
import com.stackroute.demo.service.FoodRecommendationService;
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

	@InjectMocks
	private FoodRecommendationController foodRecommendationController;
	
	@Mock
	private FoodRecommendationService foodRecommendationService;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	private List<Foods> favFoodList = new ArrayList<>();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(foodRecommendationController).build();
	}
	
	@Test
	public void testgetAllFavFoodSuccess() throws Exception {
		
		Nutrients nutri=new Nutrients("n001","protein","2.04");
		List<Nutrients> nutrilist=new ArrayList<Nutrients>();
		nutrilist.add(nutri);
		Food favfood1=new Food("fdc01","d1","i1",nutrilist);
		Food favfood2=new Food("fdc02","d2","i2",nutrilist);
		List<Food> foodlist=new ArrayList<Food>();
		foodlist.add(favfood1);
		foodlist.add(favfood2);
		Foods f1=new Foods(foodlist);
		favFoodList.add(f1);
		when(foodRecommendationService.getRecommendation()).thenReturn(favFoodList);      
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/recommendation").contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	

}
