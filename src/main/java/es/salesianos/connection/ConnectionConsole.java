package es.salesianos.connection;

import java.util.List;
import java.util.Optional;
import es.salesianos.model.Console;

public interface ConnectionConsole {
	
	public void insert(Console console);
	public Optional<Console> search(Console console);
	public void update(Console Console);
	public void delete(Console Console);
	public List<Console> listAllConsoles();
	public List<Console> listAllOrderedConsoles();
}
