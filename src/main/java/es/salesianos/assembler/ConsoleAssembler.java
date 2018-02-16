package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.model.Console;

public class ConsoleAssembler {
	public Console createConsoleFromRequest(HttpServletRequest request) {
		Console console = new Console();
		console.setName(request.getParameter("name"));
		console.setEnterprise(request.getParameter("enterprise"));
		return console;
	}
}
