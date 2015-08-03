package com.sciencie.datasource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sciencie.configuration.ClientRequestFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
public class DataSourceTest {
	
	@PersistenceContext
	EntityManager em;
	
	@BeforeClass
	public static void setUp() throws Exception{
		ClientRequestFactory.setClientRequest("cristian", "A");
	}
	
	@Test
	public void getDataSourceTest(){
		this.em.find(BeforeClass.class, 12);
	}
	
}
