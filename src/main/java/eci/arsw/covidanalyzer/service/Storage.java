/**
 * 
 */
package eci.arsw.covidanalyzer.service;

import java.util.UUID;
import java.util.List;

/**
 * @author Lenovo User
 *
 */
public interface Storage <T>{
	
	void addElement(T elem);
	T getElementById(UUID id);
	List<T> getAll();

}
