package dogs;

import Repository.IDogRepository;
import dogs.model.Dog;

public class DataSeeder {
	
	private IDogRepository repository;
	public DataSeeder(IDogRepository repository) {
		this.repository = repository;
		this.seed();
	}
	
	public void seed() {
		repository.add(new Dog("Raoul", "Bolder", 0));
		repository.add(new Dog("Pierre", "Husky", 1));
		repository.add(new Dog("George", "Neige", 2));
		repository.add(new Dog("Jean-Luc", "Jaune", 3));
		repository.add(new Dog("Bertrant", "Batard", 4));
	}
}
