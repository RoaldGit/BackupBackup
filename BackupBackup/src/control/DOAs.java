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
import model.detailModel.MonteurDetailModel;
import model.detailModel.ReparatieDetailModel;

/**
 * De class die alle doas bevat om informatie te wijzigen en op te halen van de database. Bij het toevoegen of wijzigen wordt de data opgehaald
 * uit de modellen.
 * @author Stef en Roald
 * @since 28-11-2013
 * @version 2.0
 */
public class DOAs {
	static DBmanager manager = DBmanager.getInstance("Garage");
	private static Connection con = manager.getConnection();
	private MainModel mainModel;

	/**
	 * De constructor van de class
	 * @param model Het mainmodel die over het gehele project gebruikt wordt.
	 */
	public DOAs(MainModel model) {
		mainModel = model;
	}

	/**
	 * De method om een auto te zoeken in de database en dit returned het in een 2D-array
	 * @param param Een string die de auto bevat die opgezocht moet worden.
	 * @return Returned een 2D array met daarin de gezochte auto of autos.
	 */
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

	/**
	 * De method om een reparatie te zoeken in de database en dit returned het in een 2D-array
	 * @param param Een string die de reparatie bevat die opgezocht moet worden.
	 * @return Returned een 2D array met daarin de gezochte reparatie of reparaties.
	 */
	public Object[][] reparatieSearch(String param) {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select ReparatieID, AutoID, Opmerkingen, Klaar, FactuurVerzonden, FactuurBetaald from Reparatie order by reparatieid desc");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Reparatie");

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

	/**
	 * De method om een klant te zoeken in de database en dit returned het in een 2D-array
	 * @param param Een string die de klant bevat die opgezocht moet worden.
	 * @return Returned een 2D array met daarin de gezochte klant of klanten.
	 */
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

	/**
	 * De method om een monteur te zoeken in de database en dit returned het in een 2D-array
	 * @param param Een string die de monteur bevat die opgezocht moet worden.
	 * @return Returned een 2D array met daarin de gezochte monteur of monteurs.
	 */
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

	/**
	 * De method om planningen uit het rooster te zoeken in de database en dit returned het in een 2D-array
	 * @param param Een string die de planning bevat die opgezocht moet worden.
	 * @return Returned een 2D array met daarin de gezochte planning of planningen.
	 */
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

	/**
	 * De methode om alle autos op te halen.
	 * @return Returned een 2D array met daarin alle autos.
	 */
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

	/**
	 * De methode om alle reparaties op te halen.
	 * @return Returned een 2D array met daarin alle reparaties.
	 */
	public Object[][] alleReparaties() {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select ReparatieID, AutoID, Opmerkingen, Klaar, FactuurVerzonden, FactuurBetaald from Reparatie order by reparatieid desc");

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

	/**
	 * De methode om alle klanten op te halen.
	 * @return Returned een 2D array met daarin alle klanten.
	 */
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

	/**
	 * De methode om alle monteurs op te halen.
	 * @return Returned een 2D array met daarin alle monteurs.
	 */
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

	/**
	 * De methode om alle planningen op te halen.
	 * @return Returned een 2D array met daarin alle planningen.
	 */
	public Object[][] alleRoosters() {
		Object[][] array = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("select starttijd,eindtijd,bezigheid, reparatieid, achternaam from Planning natural join bezigheid natural join persoon");

			ResultSet result = pst.executeQuery();

			int size = resultSize("select count(*) from Planning");

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

	/**
	 * De methode om alle onderdelen op te halen.
	 * @return Returned een 2D array met daarin alle onderdelen.
	 */
	public String[] alleOnderdelen() {
		String[] onderdelen = null;
		
		try {
			PreparedStatement pst = con.prepareStatement("select onderdeelnaam from onderdeel");
			ResultSet result = pst.executeQuery();
			
			String aantalQuery = "select count(*) from onderdeel";
			int aantalOnderdelen = resultSize(aantalQuery);

			onderdelen = new String[aantalOnderdelen];

			for (int i = 0; i < aantalOnderdelen; i++) {
				result.next();
				onderdelen[i] = result.getString("onderdeelnaam");
			}
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: alleRoosters");
		} catch (Exception e) {
			System.out.println("DOAs: alleRoosters");
		}
		return onderdelen;
	}

	/**
	 * De methode om klantdata op te halen.
	 */
	public void retreiveKlantData() {
		KlantDetailModel model = mainModel.getKlantDetail();
		int klantNummer = model.getPersoonID();
		retreiveKlantData(klantNummer);
	}

	/**
	 * De methode om een klant op te halen met het klantnummer.
	 * @param klantNummer Het klantnummer van de gewenste klant
	 */
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

			String aantalQuery = "select count(*) from auto where persoonID = "
					+ klantNummer;
			
			int aantalAutos = resultSize(aantalQuery);
			model.setAantalAutos(aantalAutos);

			pst = con
					.prepareStatement("select AutoID, Kenteken, Bouwjaar, Merknaam, Model from Auto natural join automerk where persoonID = ?");
			pst.setInt(1, klantNummer);

			result = pst.executeQuery();

			model.setAutos(create2DArray(result, aantalAutos));

			aantalQuery = "select count(*) from planning where reparatieID in (select reparatieID from reparatie natural join auto where persoonID = "
					+ klantNummer
					+ ") and starttijd >= curdate() - interval 1 day";
			int aantalPlanningen = resultSize(aantalQuery);
			pst = con
					.prepareStatement("select starttijd, eindtijd, bezigheid, autoID, achternaam from planning natural join bezigheid natural join reparatie natural join persoon where autoID in (select autoid from auto where persoonid = ?) and starttijd >= curdate() - interval 1 day");
			pst.setInt(1, klantNummer);

			result = pst.executeQuery();

			model.setGeplandeAfspraken(create2DArray(result, aantalPlanningen));
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

	/**
	 * Reparaties ophalen van een auto met het autonummer.
	 * @param autoNummer Het nummer van de auto waarvan de reparaties moeten worden opgehaald.
	 */
	public void retreiveReparatiesAuto(int autoNummer) {
		KlantDetailModel model = mainModel.getKlantDetail();
		// TODO remove if not used
		try {
			PreparedStatement pst = con
					.prepareStatement("select reparatieid, opmerkingen, autoid, klaar, factuurverzonden, factuur betaald from reparatie natural join auto natural join persoon where persoonid = ?");
			pst.setInt(1, autoNummer);

		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: retreiveReparatiesAuto");
		} catch (Exception e) {
			System.out.println("DOAs: retreiveReparatiesAuto");
		}
	}

	/**
	 * De methode om een auto op te halen met het autonummer.
	 * @param autoNummer Het autonummer van de gewenste auto.
	 */
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

			String aantalQuery = "select count(*) from reparatie where autoID = "
					+ autoNummer;

			int aantalReparaties = resultSize(aantalQuery);

			pst = con
					.prepareStatement("select reparatieID, klaar, factuurverzonden, factuurbetaald from reparatie where autoID = ? order by reparatieid desc");
			pst.setInt(1, autoNummer);

			result = pst.executeQuery();

			model.setReparatieData(create2DArray(result, aantalReparaties));
			
			aantalQuery = "select count(*) from planning natural join reparatie where autoid = "
					+ autoNummer
					+ " and starttijd >= curdate() - interval 1 day";

			int aantalPlanningen = resultSize(aantalQuery);

			pst = con
					.prepareStatement("select starttijd, eindtijd, bezigheid, reparatieid, achternaam from planning natural join bezigheid natural join reparatie natural join persoon where autoid = ? and starttijd >= curdate() - interval 1 day");
			pst.setInt(1, autoNummer);

			result = pst.executeQuery();

			model.setAfspraakData(create2DArray(result, aantalPlanningen));

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

	/**
	 * De methode om reparatiedata op te halen.
	 */
	public void retreiveReparatieData() {
		ReparatieDetailModel model = mainModel.getReparatieDetail();

		int reparatieNummer = model.getReparatieID();
		retreiveReparatieData(reparatieNummer);
	}

	/**
	 * De methode om reparatie data op te halen via het reparatienummer.
	 * @param reparatieNummer Het nummer van de reparatie.
	 */
	public void retreiveReparatieData(int reparatieNummer) {
		ReparatieDetailModel model = mainModel.getReparatieDetail();

		model.setReparatieID(reparatieNummer);
		try {
			PreparedStatement pst = con
					.prepareStatement("select persoonid, autoid, kenteken, opmerkingen from reparatie natural join auto where reparatieid = ?");
			pst.setInt(1, reparatieNummer);

			ResultSet result = pst.executeQuery();
			result.next();

			model.setKlantID(result.getInt("persoonid"));
			model.setAutoID(result.getInt("autoid"));
			model.setKenteken(result.getString("kenteken"));
			model.setOpmerking(result.getString("opmerkingen"));
			
			String aantalQuery = "select count(*) from planning where reparatieid = "
					+ reparatieNummer
					+ " and starttijd >= curdate() - interval 1 day";
			int aantalPlanningen = resultSize(aantalQuery);
			
			pst = con
					.prepareStatement("select starttijd,eindtijd,bezigheid,achternaam from planning natural join bezigheid natural join persoon where reparatieid = ?");
			pst.setInt(1, reparatieNummer);

			result = pst.executeQuery();

			model.setGeplandeAfspraken(create2DArray(result, aantalPlanningen));

			aantalQuery = "select count(*) from factuurregel where reparatieid = "
					+ reparatieNummer;
			int aantalOnderdelen = resultSize(aantalQuery);

			pst = con
					.prepareStatement("select onderdeelid, onderdeelnaam, leverancier, prijs, aantal, prijs*aantal as totaal from onderdeel natural join factuurregel where reparatieid = ?");
			pst.setInt(1, reparatieNummer);

			result = pst.executeQuery();

			model.setOnderdelen(create2DArray(result, aantalOnderdelen));

			setReparatieStatus(reparatieNummer);

			model.setOnderdelen(alleOnderdelen());

			model.dataChanged();
			mainModel.setPage("reparatieDetail");
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: retreiveAutoData");
		} catch (Exception e) {
			System.out.println("DOAs: retreiveAutoData");
		}
	}

	/**
	 * De methode om monteur data op te halen
	 * @param persoonID Het personeelsnummer van de monteur.
	 */
	public void retreiveMonteurData(int persoonID) {
		// TODO retreive table data. Waarschijnlijk planning en beschikbaarheid.
		// Beschikbaarheid niet tabel maar overview met wijzigingen
		MonteurDetailModel model = mainModel.getMonteurDetail();

		model.setPersoonID(persoonID);
		try {
			PreparedStatement pst = con
					.prepareStatement("select * from Persoon natural join monteur where PersoonID = ?");
			pst.setInt(1, persoonID);

			ResultSet result = pst.executeQuery();
			result.next();

			model.setVoorNaam(result.getString("voornaam"));
			model.setAchterNaam(result.getString("achternaam"));
			model.setAdres(result.getString("adres"));
			model.setWoonplaats(result.getString("woonplaats"));
			model.setPostcode(result.getString("postcode"));
			model.setUurLoon(result.getDouble("uurloon"));

			result.close();

			model.dataChanged();
			mainModel.setPage("monteurDetail");
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: retreiveKlantData");
		} catch (Exception e) {
			System.out.println("DOAs: retreiveKlantData");
		}
	}

	/**
	 * De methode om klantdata te wijzigen.
	 */
	public void changeKlantData() {
		KlantDetailModel detailModel = mainModel.getKlantDetail();
		int klantNummer = detailModel.getPersoonID();
		String[] data = detailModel.getKlantData();

		try {
			PreparedStatement pst = con
					.prepareStatement("update persoon set voornaam = ?, achternaam = ?, adres = ?, woonplaats = ?, postcode = ? where persoonid = ?");
			pst.setString(1, data[0]);
			pst.setString(2, data[1]);
			pst.setString(3, data[2]);
			pst.setString(4, data[3]);
			pst.setString(5, data[4]);
			pst.setInt(6, klantNummer);

			pst.execute();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: changeKlantData");
		} catch (Exception e) {
			System.out.println("DOAs: changeKlantData");
		}
	}

	/**
	 * De methode om monteurdata te wijzigen.
	 */
	public void changeMonteurData() {
		MonteurDetailModel detailModel = mainModel.getMonteurDetail();
		int persoonID = detailModel.getPersoonID();
		String[] data = detailModel.getTextFieldData();

		try {
			PreparedStatement pst = con
					.prepareStatement("update persoon set voornaam = ?, achternaam = ?, adres = ?, woonplaats = ?, postcode = ? where persoonid = ?");
			pst.setString(1, data[0]);
			pst.setString(2, data[1]);
			pst.setString(3, data[2]);
			pst.setString(4, data[3]);
			pst.setString(5, data[4]);
			pst.setInt(6, persoonID);

			pst.execute();

			pst = con
					.prepareStatement("update monteur set uurloon = ? where persoonid = ?");
			pst.setDouble(1, Double.parseDouble(data[5]));
			pst.setInt(2, persoonID);

			pst.execute();

			detailModel.setUurLoon(Double.parseDouble(data[5]));

		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: changeMonteurData");
		} catch (Exception e) {
			System.out.println("DOAs: changeMonteurData");
		}
	}

	/**
	 * De methode om autodata te wijzigen.
	 */
	public void changeAutoData() {
		AutoDetailModel detailModel = mainModel.getAutoDetail();
		int autoNummer = detailModel.getAutoNummer();
		String[] data = detailModel.getAutoData();
		int merkid = getMerkID(data[2]);

		try {
			PreparedStatement pst = con
					.prepareStatement("update auto set kenteken = ?, bouwjaar = ?, merkid = ?, model = ? where autoid = ?");
			pst.setString(1, data[0]);
			pst.setString(2, data[1]);
			pst.setInt(3, merkid);
			pst.setString(4, data[3]);
			pst.setInt(5, autoNummer);

			pst.execute();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: changeKlantData");
		} catch (Exception e) {
			System.out.println("DOAs: changeKlantData");
		}
	}

	/**
	 * De methode om reparatiedata te wijzigen.
	 */
	public void changeReparatieData() {
		ReparatieDetailModel detailModel = mainModel.getReparatieDetail();
		int reparatieNummer = detailModel.getReparatieID();
		String[] data = detailModel.getData();
		try {
			PreparedStatement pst = con
					.prepareStatement("update reparatie set klaar = ?, factuurverzonden = ?, factuurbetaald = ?, opmerkingen = ? where reparatieid = ?");

			switch (data[0]) {
			case "0":
				pst.setInt(1, 1);
				pst.setInt(2, 1);
				pst.setInt(3, 1);
				break;
			case "1":
				pst.setInt(1, 2);
				pst.setInt(2, 1);
				pst.setInt(3, 1);
				break;
			case "2":
				pst.setInt(1, 2);
				pst.setInt(2, 2);
				pst.setInt(3, 1);
				break;
			case "3":
				pst.setInt(1, 2);
				pst.setInt(2, 2);
				pst.setInt(3, 2);
				break;
			}

			pst.setString(4, data[1]);
			pst.setInt(5, reparatieNummer);

			pst.execute();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: changeReparatieData");
		} catch (Exception e) {
			System.out.println("DOAs: changeReparatieData");
		}
	}

	/**
	 * De methode om een auto toe te voegen.
	 */
	public void voegAutoToe() {
		// TODO return succes
		KlantDetailModel detailModel = mainModel.getKlantDetail();
		int klantNummer = detailModel.getPersoonID();
		String[] data = detailModel.getNieuweAutoData();
		int merkid = getMerkID(data[2]);

		try {
			PreparedStatement pst = con
					.prepareStatement("insert into auto(kenteken,bouwjaar,persoonid,merkid,model) values(?,?,?,?,?)");
			pst.setString(1, data[0]);
			pst.setInt(2, Integer.parseInt(data[1]));
			pst.setInt(3, klantNummer);
			pst.setInt(4, merkid);
			pst.setString(5, data[3]);

			pst.execute();
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: voegAutoToe");
		} catch (Exception e) {
			System.out.println("DOAs: voegAutoToe");
		}
	}

	/**
	 * De methode om een onderdeel toe te voegen.
	 */
	public void voegOnderdeelToe() {
		ReparatieDetailModel detailModel = mainModel.getReparatieDetail();
		String[] data = detailModel.getOnderdeelData();
		int reparatieID = detailModel.getReparatieID();
		int onderdeelID = getOnderdeelID(data[0]);
		int aantal = Integer.parseInt(data[1]);
		
		// TODO voorraad bijwerken
		String onderdeelCheck = "select count(*) from factuurregel where onderdeelid = " + onderdeelID + " and reparatieid = " + reparatieID;

		boolean alreadyUsed = false;
		if (resultSize(onderdeelCheck) > 0)
			alreadyUsed = true;
		try {
			PreparedStatement pst = null;
			if(alreadyUsed) {
				pst = con
						.prepareStatement("update factuurregel set aantal = aantal + ? where onderdeelid = ? and reparatieid = ?");
				pst.setInt(1, aantal);
				pst.setInt(2, onderdeelID);
				pst.setInt(3, reparatieID);

				pst.execute();
			} else {
				pst = con
						.prepareStatement("insert into factuurregel(onderdeelid, reparatieid, aantal) values (?,?,?)");
				pst.setInt(1, onderdeelID);
				pst.setInt(2, reparatieID);
				pst.setInt(3, aantal);

				pst.execute();
			}
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: nieuweReparatie");
		} catch (Exception e) {
			System.out.println("DOAs: nieuweReparatie");
		}

	}

	/**
	 * De methode om een nieuwe reparatie toe te voegen.
	 */
	public void nieuweReparatie() {
		AutoDetailModel detailModel = mainModel.getAutoDetail();

		int autoNummer = detailModel.getAutoNummer();
		try {
			PreparedStatement pst = con
					.prepareStatement("insert into reparatie(autoid) values(?)");
			pst.setInt(1, autoNummer);

			pst.execute();

			pst = con
					.prepareStatement("select reparatieid from reparatie where autoid = 3 order by reparatieid desc limit 1");
			ResultSet result = pst.executeQuery();
			result.next();

			int nieuweReparatie = result.getInt("reparatieid");

			retreiveReparatieData(nieuweReparatie);

			mainModel.getReparatieDetail().wijzigInfo();

		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: nieuweReparatie");
		} catch (Exception e) {
			System.out.println("DOAs: nieuweReparatie");
		}
	}

	/**
	 * De methode om een nieuwe klant toe te voegen.
	 */
	public void nieuweKlant() {
		try {
			PreparedStatement pst = con
					.prepareStatement("insert into persoon(voornaam, achternaam, adres, woonplaats, postcode) values('','','','','')");
			pst.execute();

			pst = con
					.prepareStatement("select persoonid from persoon order by persoonid desc limit 1");
			ResultSet result = pst.executeQuery();
			result.next();

			int nieuweKlant = result.getInt("persoonid");

			retreiveKlantData(nieuweKlant);

			mainModel.getKlantDetail().wijzigInfo();

		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: nieuweReparatie");
		} catch (Exception e) {
			System.out.println("DOAs: nieuweReparatie");
		}
	}

	/**
	 * De methode om de status van een reparatie te setten.
	 * @param reparatieNummer Het nummer van de reparatie waarvan de status geset moet worden.
	 */
	public void setReparatieStatus(int reparatieNummer) {
		ReparatieDetailModel detailModel = mainModel.getReparatieDetail();
		int status = 0;

		try {
			PreparedStatement pst = con
					.prepareStatement("select klaar, factuurverzonden, factuurbetaald from reparatie where reparatieid = ?");
			pst.setInt(1, reparatieNummer);

			ResultSet result = pst.executeQuery();

			result.next();

			if (result.getString("klaar").equals("Ja"))
				status = 1;
			if (result.getString("factuurverzonden").equals("Ja"))
				status = 2;
			if (result.getString("factuurbetaald").equals("Ja"))
				status = 3;

			detailModel.setStatus(status);
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: setReparatieStatus");
		} catch (Exception e) {
			System.out.println("DOAs: setReparatieStatus");
		}
	}

	/** 
	 * De methode om een ID van een onderdeel op te halen.
	 * @param onderdeelNaam De naam van het onderdeel.
	 * @return Returned een int met het ID van het gewenste onderdeel.
	 */
	public int getOnderdeelID(String onderdeelNaam) {
		int id = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement("select onderdeelid from onderdeel where onderdeelnaam = ?");
			pst.setString(1, onderdeelNaam);

			ResultSet result = pst.executeQuery();
			result.next();

			id = result.getInt("onderdeelid");
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: getOnderdeelID");
		} catch (Exception e) {
			System.out.println("DOAs: getOnderdeelID");
		}
		return id;
	}

	/** 
	 * De methode om een ID van een Merk op te halen.
	 * @param merkNaam De naam van het onderdeel.
	 * @return Returned een int met het ID van het gewenste onderdeel.
	 */
	public int getMerkID(String merkNaam) {
		int id = 0;
		try {
			PreparedStatement pst = con
					.prepareStatement("select merkid from automerk where merknaam = ?");
			pst.setString(1, merkNaam);

			ResultSet result = pst.executeQuery();

			result.next();

			id = result.getInt("merkid");
		} catch (SQLException se) {
			printSQLException(se);
			System.out.println("DOAs: getMerkID");
		} catch (Exception e) {
			System.out.println("DOAs: getMerkID");
		}
		return id;
	}

	/**
	 * De methode om een 2D-array te maken van de data.
	 * @param result De resultset die uit de database is opgehaald.
	 * @param rows Het aantal rijen.
	 * @return Een 2D-array met daarin de gegevens van de resultset.
	 */
	public Object[][] create2DArray(ResultSet result, int rows) {
		Object[][] array = null;
		try {
			ResultSetMetaData rsmd = result.getMetaData();
			int cols = rsmd.getColumnCount();

			array = new Object[rows][cols];

			int currentRow = 0;
			int columns = rsmd.getColumnCount();
			while (result.next()) {
				for (int i = 0; i < columns; i++)
					array[currentRow][i] = result.getObject(i + 1);
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
	
	/**
	 * De methode om de size van een resultset op te halen.
	 * @param query De query.
	 * @return Returned een int met daarin de size van de resultset.
	 */
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

	/**
	 * De methode om de resultset uit te printen.
	 * @param rs De resultset die geprint moet worden.
	 */
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

	/**
	 * De methode om een SQLexception te printen
	 * @param se De exception.
	 */
	private static void printSQLException(SQLException se) {
		while (se != null) {

			System.out.print("SQLException: State:   " + se.getSQLState());
			System.out.println(" Severity: " + se.getErrorCode());
			System.out.println(se.getMessage());

            se = se.getNextException();
		}
	}
}
