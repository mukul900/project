package com.stackroute.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.demo.controller.FavFoodController;
import com.stackroute.demo.model.FavFood;
import com.stackroute.demo.model.Nutrients;
import com.stackroute.demo.service.FavFoodService;
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

	@InjectMocks
	private FavFoodController favFoodController;
	
	@Mock
	private FavFoodService favFoodService;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	private List<FavFood> favFoodList = new ArrayList<>();

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(favFoodController).build();
		Nutrients nutri=new Nutrients("n001","protein","2.04","u01");
		List<Nutrients> nutrilist=new ArrayList<Nutrients>();
		nutrilist.add(nutri);
		FavFood favfood1=new FavFood("fdc01","u001","d1","b1","i1","s1",nutrilist);
	}


	
	@Test
	public void testgetAllFavFoodSuccess() throws Exception {
		
		Nutrients nutri=new Nutrients("n001","protein","2.04","u01");
		List<Nutrients> nutrilist=new ArrayList<Nutrients>();
		nutrilist.add(nutri);
		FavFood favfood1=new FavFood("fdc01","u001","d1","b1","i1","s1",nutrilist);
		FavFood favfood2=new FavFood("fdc02","u001","d2","b2","i2","s2",nutrilist);
		favFoodList.add(favfood1);
		favFoodList.add(favfood2);
		when(favFoodService.getAllFavouriteFoods("u001")).thenReturn(favFoodList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/list/u001").contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testAddFavFoodSuccess() throws JsonProcessingException,Exception {
		Nutrients nutri=new Nutrients("n001","protein","2.04","u01");
		List<Nutrients> nutrilist=new ArrayList<Nutrients>();
		nutrilist.add(nutri);
		FavFood favfood1=new FavFood("fdc01","u001","d1","b1","i1","s1",nutrilist);
		when(favFoodService.addFood(any())).thenReturn(true);
		mockMvc.perform(MockMvcRequestBuilders
					.post("/api/v1/add/u001")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(favfood1)))
					.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	@Test
    public void deleteFavFoodSuccess() throws Exception {

        when(favFoodService.deleteFavFood("fdc01", "u001")).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/delete/fdc01/u001")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

	

}
