/**
 * 
 */
package eci.arsw.covidanalyzer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Lenovo User
 *
 */
public class StorageImpl <T> implements Storage <T>{

	private List<T> storage;
	
	public StorageImpl(){
		storage = new ArrayList<T>();
	}

	@Override
	public void addElement(T elem) {
		storage.add(elem);
	}

	@Override
	public T getElementById(UUID id) {
		T elem = null;
		for (T aux: storage) {
			if (aux.equals(id)) elem = aux;
		}
		return elem;
	}

	@Override
	public List<T> getAll() {
		return storage;
	}
	
	
}
