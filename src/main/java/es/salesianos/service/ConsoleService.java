package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;
import es.salesianos.assembler.ConsoleAssembler;
import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionConsole;
import es.salesianos.model.Console;

public class ConsoleService {

	ConsoleAssembler assembler = new ConsoleAssembler();
	private ConnectionConsole manager = (ConnectionConsole) new ConnectionH2();

	public void createNewConsoleFromRequest(HttpServletRequest req) {

		Console console = assembler.createConsoleFromRequest(req);

		if (!getManager().search(console).isPresent()) {
			getManager().insert(console);
		} else {
			getManager().update(console);
		}
	}
	
	public ConnectionConsole getManager() {
		return manager;
	}
}
