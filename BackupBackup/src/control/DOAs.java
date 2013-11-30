package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBmanager;
import model.MainModel;
import model.detailModel.AutoDetailModel;
import model.detailModel.KlantDetailModel;


public class DOAs {
	static DBmanager manager = DBmanager.getInstance("Garage");
	private static Connection con = manager.getConnection();
	private MainModel mainModel;

	public DOAs(MainModel model) {
		mainModel = model;
	}

	public Object[][] autoSearch(String param) {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select AutoID, Kenteken, Bouwjaar, PersoonID, Merknaam, Model from Auto natural join automerk where kenteken like ? group by autoID");
			pst.setString(1, "%" + param + "%");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Auto where kenteken like '%"
					+ param + "%'");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: autoSearch");
		} catch (Exception e) {
			System.out.println("DOAs: autoSearch");
		}

		return array;
	}

	public Object[][] reparatieSearch(String param) {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select * from Reparatie");// where
																	// kenteken
																	// like ?");
			// pst.setString(1, "%" + param + "%");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Reparatie");// where
																	// kenteken
																	// like '%"
//					+ param + "%'");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: reparatieSearch");
		} catch (Exception e) {
			System.out.println("DOAs: reparatieSearch");
		}

		return array;
	}

	public Object[][] klantSearch(String param) {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select PersoonID, Achternaam, Voornaam, Adres, Woonplaats, Postcode from Persoon where achternaam like ?");
			pst.setString(1, "%" + param + "%");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Persoon where achternaam like '%"
					+ param + "%'");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: klantSearch");
		} catch (Exception e) {
			System.out.println("DOAs: klantSearch");
		}

		return array;
	}

	public Object[][] monteurSearch(String param) {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select PersoonID, Achternaam, Voornaam, Adres, Woonplaats, Postcode, Uurloon from Persoon natural join Monteur where Achternaam like ?");
			 pst.setString(1, "%" + param + "%");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Persoon natural join Monteur where Achternaam like '%"
					+ param + "%'");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: monteurSearch");
		} catch (Exception e) {
			System.out.println("DOAs: monteurSearch");
		}

		return array;
	}

	public Object[][] roosterSearch(String param) {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select * from Persoon where achternaam like ?");
			pst.setString(1, "%" + param + "%");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Persoon where achternaam like '%"
					+ param + "%'");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: roosterSearch");
		} catch (Exception e) {
			System.out.println("DOAs: roosterSearch");
		}

		return array;
	}

	public Object[][] alleAutos() {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select AutoID, Kenteken, Bouwjaar, PersoonID, Merknaam, Model from Auto natural join automerk group by AutoID");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Auto");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: alleAutos");
		} catch (Exception e) {
			System.out.println("DOAs: alleAutos");
		}

		return array;
	}

	public Object[][] alleReparaties() {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select * from Reparatie");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Reparatie");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: alleReparaties");
		} catch (Exception e) {
			System.out.println("DOAs: alleReparaties");
		}

		return array;
	}

	public Object[][] alleKlanten() {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select PersoonID, Achternaam, Voornaam, Adres, Woonplaats, Postcode from Persoon");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Persoon");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: alleKlanten");
		} catch (Exception e) {
			System.out.println("DOAs: alleKlanten");
		}

		return array;
	}

	public Object[][] alleMonteurs() {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select PersoonID, Achternaam, Voornaam, Adres, Woonplaats, Postcode, Uurloon from Persoon natural join Monteur");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Persoon natural join Monteur");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: alleMonteurs");
		} catch (Exception e) {
			System.out.println("DOAs: alleMonteurs");
		}

		return array;
	}

	public Object[][] alleRoosters() {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select * from Persoon");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Persoon");

			array = create2DArray(result, size);

			result.close();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: alleRoosters");
		} catch (Exception e) {
			System.out.println("DOAs: alleRoosters");
		}

		return array;
	}

	public void retreiveKlantData(int klantNummer) {
		KlantDetailModel model = mainModel.getKlantDetail();

		model.setPersoonID(klantNummer);
		try {
			PreparedStatement pst = con
					.prepareStatement("select * from Persoon where PersoonID = ?");
			pst.setInt(1, klantNummer);

			ResultSet result = pst.executeQuery();
			result.next();

			model.setVoorNaam(result.getString("voornaam"));
			model.setAchterNaam(result.getString("achternaam"));
			model.setAdres(result.getString("adres"));
			model.setWoonplaats(result.getString("woonplaats"));
			model.setPostcode(result.getString("postcode"));

			String aantalQuerry = "select count(*) from auto where persoonID = "
					+ klantNummer;
			
			int aantalAutos = resultSize(aantalQuerry);
			model.setAantalAutos(aantalAutos);

			pst = con
					.prepareStatement("select AutoID, Kenteken, Bouwjaar, Merknaam, Model from Auto natural join automerk where persoonID = ?");
			pst.setInt(1, klantNummer);

			result = pst.executeQuery();

			model.setAutos(create2DArray(result, aantalAutos));

			result.close();

			model.dataChanged();
			mainModel.setPage("klantDetail");
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: retreiveKlantData");
		} catch (Exception e) {
			System.out.println("DOAs: retreiveKlantData");
		}
	}


	public void retreiveAutoData(int autoNummer) {
		AutoDetailModel model = mainModel.getAutoDetail();

		model.setAutoNummer(autoNummer);
		try {
			PreparedStatement pst = con
					.prepareStatement("select autoID, kenteken, bouwjaar, merknaam, model, persoonid, achternaam from auto natural join automerk natural join persoon where autoID = ?");
			pst.setInt(1, autoNummer);

			ResultSet result = pst.executeQuery();
			result.next();

			model.setAutoNummer(result.getInt("autoID"));
			model.setKenteken(result.getString("kenteken"));
			model.setBouwjaar(result.getInt("bouwjaar"));
			model.setMerk(result.getString("merknaam"));
			model.setModel(result.getString("model"));
			model.setKlantNummer(result.getInt("persoonid"));
			model.setKlantnaam(result.getString("achternaam"));

			String aantalQuerry = "select count(*) from reparatie where autoID = "
					+ autoNummer;

			int aantalReparaties = resultSize(aantalQuerry);
			// model.setAantalAutos(aantalAutos);

			pst = con
					.prepareStatement("select reparatieID, bezigheid, factuurverzonden, achternaam from reparatie natural join persoon natural join planning natural join bezigheid where autoID = ?");
			pst.setInt(1, autoNummer);

			result = pst.executeQuery();

			model.setReparatieData(create2DArray(result, aantalReparaties));

			result.close();

			model.dataChanged();
			mainModel.setPage("autoDetail");
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: retreiveAutoData");
		} catch (Exception e) {
			System.out.println("DOAs: retreiveAutoData");
		}
	}

	public Object[][] create2DArray(ResultSet rs, int rows) {
		Object[][] array = null;
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();

			array = new Object[rows][cols];

			int currentRow = 0;
			int columns = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 0; i < columns; i++)
					array[currentRow][i] = rs.getObject(i + 1);
				currentRow++;
			}
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("create2DArray");
		} catch (Exception e) {
			System.out.println("create2DArray");
		}
		return array;
	}
	
	public int resultSize(String query) {
		int size = 0;
		try {
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(query);

			result.next();
			size = result.getInt("count(*)");
		} catch (SQLException se) {
			printSQLException(se);
		} catch (Exception e) {
			System.out.println(e);
		}
		return size;
	}

	public static void printResults(ResultSet rs) {
		try {
			ResultSetMetaData md = rs.getMetaData();

			int col = md.getColumnCount();
			for (int i = 1; i <= col; i++) {
				System.out.print(md.getColumnName(i) + "\t");
			}
			System.out.println();

			while (rs.next()) {
				for (int i = 1; i <= col; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
		} catch (SQLException se) {
			printSQLException(se);
		}
	}

	private static void printSQLException(SQLException se) {
		while (se != null) {

			System.out.print("SQLException: State:   " + se.getSQLState());
			System.out.println(" Severity: " + se.getErrorCode());
			System.out.println(se.getMessage());

            se = se.getNextException();
		}
	}

}
