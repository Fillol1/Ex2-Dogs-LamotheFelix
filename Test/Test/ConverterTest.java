package Test;

import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Mock.IDogRepositoryMock;
import Spy.DogRepositorySpy;
import dogs.DataSeeder;
import dogs.controller.DogController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;
import dogs.model.DogConverter;
import dogs.view.IDogController;

public class ConverterTest {
	DogConverter converter;
	IDogRepositoryMock repository;
	
	@BeforeEach 
	public void initEach() 
	{
		repository = new DogRepositorySpy();
		new DataSeeder(repository);
		converter = new DogConverter(repository.getList());
	}
		
	@Test 
	public void canGetSize() {
		int size = converter.getSize();
		
		assertTrue(size == 5);
	}
}
