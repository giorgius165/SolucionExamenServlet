package es.salesianos.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public class ConnectionH2 implements ConnectionConsole,ConnectionVideogame {

	private static final String INSERTVIDEOGAME = "INSERT INTO Videogame (title,age,reldate)" + "VALUES (?, ?,?)";
	private static final String INSERTCONSOLE = "INSERT INTO Console (name,company)" + "VALUES (?, ?)";
	private static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	public void insert(Console consoleForm) {
		Connection conn = open(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(INSERTCONSOLE);
			preparedStatement.setString(1, consoleForm.getName());
			preparedStatement.setString(2, consoleForm.getEnterprise());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
		close(preparedStatement);
	}
	
	public void insert(Videogame videogameForm) {
		Connection conn = open(JDBCURL);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(INSERTVIDEOGAME);
			preparedStatement.setString(1, videogameForm.getTitle());
			preparedStatement.setString(2, videogameForm.getRecommendedage());
			preparedStatement.setString(3, videogameForm.getReleasedate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
		close(preparedStatement);
	}

	public Connection open(String jdbcUrl) {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(jdbcUrl + ";INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'", "sa","");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;
	}

	public Optional<Console> search(Console console) {
		Console actualConsole = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		try {
			conn = open(JDBCURL);
			preparedStatement = conn.prepareStatement("SELECT * FROM Console WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				actualConsole = new Console();
				actualConsole.setName(resultSet.getString("name"));
				actualConsole.setEnterprise(resultSet.getString("enterprise"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
		return Optional.ofNullable(actualConsole);
	}

	public void update(Console console) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = open(JDBCURL);
			preparedStatement = conn.prepareStatement("UPDATE console SET " + "name = ?, enterprise = ? WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			preparedStatement.setString(2, console.getEnterprise());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
	}

	public List<Console> listAllConsoles() {
		List<Console> consoles = new ArrayList<Console>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			conn = open(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM console");
			while (resultSet.next()) {
				Console actualConsole = new Console();
				actualConsole.setName(resultSet.getString("name"));
				actualConsole.setEnterprise(resultSet.getString("enterprise"));
				consoles.add(actualConsole);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(statement);
		}
		return consoles;
	}

	@Override
	public Optional<Videogame> search(Videogame videogame) {
		Videogame actualVideogame = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection conn = null;

		try {
			conn = open(JDBCURL);
			preparedStatement = conn.prepareStatement("SELECT * FROM videogame WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				actualVideogame = new Videogame();
				actualVideogame.setTitle(resultSet.getString("title"));
				actualVideogame.setRecommendedage(resultSet.getString("recommendedage"));
				actualVideogame.setReleasedate(resultSet.getString("releasedate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
		return Optional.ofNullable(actualVideogame);
	}

	@Override
	public void update(Videogame videogame) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {

			conn = open(JDBCURL);
			preparedStatement = conn.prepareStatement("UPDATE videogame SET " + "title = ?, recommendedage = ?, releasedate=? WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.setString(2, videogame.getRecommendedage());
			preparedStatement.setString(3, videogame.getReleasedate());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
	}

	@Override
	public List<Videogame> listAllVideogames() {
		List<Videogame> videogames = new ArrayList<Videogame>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			conn = open(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM videogame");

			while (resultSet.next()) {
				Videogame thisVideogame = new Videogame();
				thisVideogame.setTitle(resultSet.getString("title"));
				thisVideogame.setRecommendedage(resultSet.getString("recommendedage"));
				thisVideogame.setReleasedate(resultSet.getString("releasedate"));
				videogames.add(thisVideogame);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(statement);
		}
		return videogames;
	}
	
	@Override
	public void delete(Videogame videogame) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = open(JDBCURL);
			preparedStatement = conn.prepareStatement("DELETE * FROM videogame  WHERE title = ?");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.executeUpdate();
			System.out.println("DELETE * FROM videogame  WHERE title = ?");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
	}

	@Override
	public List<Console> listAllOrderedConsoles() {
		List<Console> consoles = new ArrayList<Console>();
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			conn = open(JDBCURL);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM console order by name");
			while (resultSet.next()) {
				Console thisConsole = new Console();
				thisConsole.setName(resultSet.getString("name"));
				thisConsole.setEnterprise(resultSet.getString("enterprise"));
				consoles.add(thisConsole);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(statement);
		}
		return consoles;	
	}

	@Override
	public void delete(Console console) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = open(JDBCURL);
			preparedStatement = conn.prepareStatement("DELETE * FROM console  WHERE name = ?");
			preparedStatement.setString(1, console.getName());
			preparedStatement.executeUpdate();
			System.out.println("DELETE * FROM console  WHERE name = ?");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}
	}
	private void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private void close(PreparedStatement prepareStatement) {
		if (prepareStatement != null) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
