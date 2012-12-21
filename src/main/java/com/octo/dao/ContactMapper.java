package com.octo.dao;


public interface ContactMapper {

	void insertContact(Contact contact);
	
	Contact selectContact(String string);

}
