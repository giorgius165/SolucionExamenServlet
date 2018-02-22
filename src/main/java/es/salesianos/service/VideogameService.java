package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.VideogameAssembler;
import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionVideogame;
import es.salesianos.model.Videogame;

public class VideogameService {

	VideogameAssembler assembler = new VideogameAssembler();
	private ConnectionVideogame manager = (ConnectionVideogame) new ConnectionH2();

	public void createNewVideogameFromRequest(HttpServletRequest req) {
		Videogame videogame = assembler.createVideogameFromRequest(req);

		if (!getManager().search(videogame).isPresent()) {
			getManager().insert(videogame);
		} else {
			getManager().update(videogame);
		}
	}

	public ConnectionVideogame getManager() {
		return manager;
	}
}
