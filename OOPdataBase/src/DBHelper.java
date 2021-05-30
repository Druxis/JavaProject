import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;


// import javax.swing.JComboBox;

public class DBHelper {
	static Connection conn = null;
	static PreparedStatement state = null;
	static ResultSet result = null;
	static MyModel model = null;
	
	static void fillCombo(JComboBox<String> combo, String variable, String tableName) {

		conn = getConnection();
		String sql = "select id, " + variable + " from " + tableName;
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			combo.removeAllItems();
			while (result.next()) {
				String item = result.getObject(1).toString() + " " + result.getObject(2).toString();
				combo.addItem(item);
			} // end while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void fillComboRegion(JComboBox<String> combo) {

		conn = getConnection();
		String sql = "select id, CONCAT(FNAME,' ', LNAME) AS NAME FROM RESPONSIBLE;";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			combo.removeAllItems();
			while (result.next()) {
				String item = result.getObject(1).toString() + " " + result.getObject(2).toString();
				combo.addItem(item);
			} // end while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	static MyModel getAllData(String tableName) {

		conn = getConnection();
		try {
			state = conn.prepareStatement("select * from " + tableName);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	static MyModel getAllDataRegion() {

		conn = getConnection();
		try {
			state = conn.prepareStatement("SELECT REGION.ID, REGION.NAME, REGION.AREA, REGION.POPULATION, RESPONSIBLE.FNAME, RESPONSIBLE.LNAME, WATER.NAME\r\n"
					+ "FROM REGION, RESPONSIBLE, WATER \r\n"
					+ "WHERE  REGION.ID_RESPONSIBLE = RESPONSIBLE.ID AND REGION.ID_WATER = WATER.ID");
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

	static MyModel getAllDataInfo() {

		conn = getConnection();
		try {
			state = conn.prepareStatement("SELECT R.ID, R.NAME, R.AREA, R.POPULATION, CONCAT (RES.FNAME,' ', RES.LNAME) AS NAME, W.NAME\r\n"
					+ " FROM REGION R, RESPONSIBLE RES, WATER W \r\n"
					+ "WHERE R.ID_RESPONSIBLE = RES.ID AND R.ID_WATER = W.ID");
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	
	public static Connection getConnection() {

	        try {
	            Class.forName("org.h2.Driver");
	            conn=DriverManager.getConnection("jdbc:h2:C:\\Users\\Druxis\\Desktop\\SIDB;AUTO_SERVER=TRUE","sa","si");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return conn;
	    }
}
