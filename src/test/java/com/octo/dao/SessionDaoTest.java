package com.octo.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.octo.dao.Contact;
import com.octo.dao.ContactMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SessionDaoTest.H2Config.class)
public class SessionDaoTest {

	@Autowired
	private ContactMapper contactMapper;
	
	@Test
	public void shouldInsertAndRetrieveContact() {
		//Given
		Contact contact = new Contact("mathieu","gandin");
		
		//When
		contactMapper.insertContact(contact);
		
		//Then
		Contact contactRetrieved = contactMapper.selectContact("mathieu");
		Assert.assertEquals(contact,contactRetrieved);
	}
	
	@Configuration
	@ImportResource(value = "/spring/mybatis-context.xml")
	public static class H2Config extends AbstractH2DataSourceConfig {
	  @Override
	  protected List<String> getSqlScripts() {
	    List<String> sqlScripts = new ArrayList<String>();
	    sqlScripts.add("classpath:sql/ddl-table.sql");
	    return sqlScripts;
	  }
	}

}


