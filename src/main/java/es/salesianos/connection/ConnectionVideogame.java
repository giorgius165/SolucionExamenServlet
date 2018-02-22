package es.salesianos.connection;

import java.util.List;
import java.util.Optional;

import es.salesianos.model.Videogame;

public interface ConnectionVideogame {
	
	public void insert(Videogame videogame);
	public Optional<Videogame> search(Videogame videogame);
	public void update(Videogame videogame);
	public void delete(Videogame videogame);
	public List<Videogame> listAllVideogames();
}
