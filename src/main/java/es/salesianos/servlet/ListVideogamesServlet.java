package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionVideogame;
import es.salesianos.model.Videogame;

public class ListVideogamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionVideogame manager = new ConnectionH2();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Videogame> listAllVideogames = manager.listAllVideogames();
		req.getSession().setAttribute("videogame", listAllVideogames);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VideogameList.jsp");
		dispatcher.forward(req, resp);
	}
}
