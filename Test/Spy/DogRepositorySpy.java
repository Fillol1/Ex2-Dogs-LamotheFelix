package Spy;
import java.util.Collection;

import Mock.IDogRepositoryMock;
import Repository.DogMemoryRepository;
import dogs.model.Dog;

public class DogRepositorySpy extends DogMemoryRepository implements IDogRepositoryMock{

	private boolean hasBeenAdded = false;
	
	@Override
	public void add(Dog dog) {
		super.add(dog);
		hasBeenAdded = true;
	}

	@Override
	public Collection<Dog> getList() {
		// TODO Auto-generated method stub
		return super.getList();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return super.size();
	}

	@Override
	public Dog searchedById(int id) {
		// TODO Auto-generated method stub
		return super.searchedById(id);
	}

	public boolean hasBeenCalled() {
		return this.hasBeenAdded;
	}
	
	public void setHasBeenCalledFalse() {
		this.hasBeenAdded = false;	}
}
