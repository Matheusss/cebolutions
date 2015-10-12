/*package com.cebolutions.top.car.test.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.cebolutions.top.car.test.builders.PremioBuilder;
import com.cebolutions.top.car.test.init.AbstractControllerTest;
import com.cebolutions.top.car.test.init.ControllerBase;

@ControllerBase("/premio")
public class PremioControllerTest extends AbstractControllerTest  {

	@Before
	public void before() throws Exception {

	}

	@Test
	public void testFindById() throws Exception{
		PremioBuilder premioBuilder = PremioBuilder.premio().nome("premio");
		saveAll();
		
		MockHttpServletRequestBuilder mock = get("/{id}", premioBuilder.getId());
		MvcResult mvcResult = perform(mock, status().isOk());
		jsonAssert(mvcResult)
		.assertThat("$.id", equalTo(premioBuilder.getId().intValue()))
		.assertThat("$.nome", equalTo("premio"))
		.assertThat("$.valor", equalTo(10));
	}
	
	@Test
	public void testCreate() throws Exception{
		MockHttpServletRequestBuilder mock = post();
		mock.param("nome", "Premio");
		mock.param("valor", "2");
		
		MvcResult mvcResult = perform(mock, status().isCreated());
		jsonAssert(mvcResult);
	}

	@Test
	public void testUpdate() throws Exception{
		PremioBuilder premioBuilder = PremioBuilder.premio().nome("Ps4");
		saveAll();
		
		MockHttpServletRequestBuilder mock = put("/{id}", premioBuilder.getId());
		mock.param("nome", "Xbox");
		mock.param("valor", "20");
		
		MvcResult mvcResult = perform(mock, status().isOk());
		jsonAssert(mvcResult)
		.assertThat("$.nome", equalTo("Xbox"))
		.assertThat("$.valor", equalTo(20));
	}
	
	@Test
	public void testDelete() throws Exception{
		PremioBuilder premioBuilder = PremioBuilder.premio().nome("Premio");
		saveAll();
		
		MockHttpServletRequestBuilder mock = delete("/{id}", premioBuilder.getId());
		MvcResult mvcResult = perform(mock, status().isOk());
		jsonAssert(mvcResult)
		.assertThat("$.nome", equalTo("Premio"))
		.assertThat("$.valor", equalTo(10));
		
	}

}	*/