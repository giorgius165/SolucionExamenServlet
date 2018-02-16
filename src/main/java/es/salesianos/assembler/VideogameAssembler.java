package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Videogame;

public class VideogameAssembler {
	public Videogame createVideogameFromRequest(HttpServletRequest request) {
		Videogame videogame = new Videogame();
		videogame.setTitle(request.getParameter("title"));
		videogame.setRecommendedage(request.getParameter("recommendedage"));
		videogame.setReleasedate(request.getParameter("releasedate"));
		return videogame;
	}
}
