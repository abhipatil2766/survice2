package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dbUtil.DbUtil;
import entity.Vehicle;



public class VehicleDao {
	private static Connection con;

	public VehicleDao() throws SQLException {
		this.con = DbUtil.getConnection();
	}
	
	
	public int addVehicle(int id, String name, String model) {
		String q5="insert into vehicle values(?,?,?)";
		int npa= 0;
		
		try {
			PreparedStatement pmt=con.prepareStatement(q5);
			pmt.setInt(1, id);
			pmt.setString(2, name);
			pmt.setString(3, model);
			npa=pmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return npa;
	}


	public void getAllVehicle(List<Vehicle> vehicleList) {
		String q5="select * from vehicle";
		try {
			PreparedStatement pmt= con.prepareStatement(q5);
			ResultSet rs=pmt.executeQuery();
			while(rs.next()) {
				Vehicle v=new Vehicle(rs.getInt("id"),rs.getString("name"),rs.getString("model"));
				vehicleList.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	public int editVehicle(int id, String name, String model) {
		String q4="update vehicle set name=?, model=? where id=?";
		int npu=0;
		try {
			PreparedStatement pmt=con.prepareStatement(q4);
			pmt.setInt(3, id);
			pmt.setString(1, name);
			pmt.setString(2, model);
			npu=pmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return npu;
	}


	public int removeVehicle(int id) {
		String q4="delete from vehicle where id=?";
		int npu=0;
		try {
			PreparedStatement pmt=con.prepareStatement(q4);
			pmt.setInt(1, id);
			npu=pmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return npu;
	}


	public static Vehicle getspecificVehicle(int id) {
		// TODO Auto-generated method stub
		String q2="SELECT c.id,c.name,cv.vehicle FROM customer c INNER JOIN customer_vehicles cv ON c.id=cv.customer_id;";
//		String q="select * from customer where mobile=?";
		try {
			PreparedStatement pmt=con.prepareStatement(q2);
			pmt.setInt(1, id);
			ResultSet rs=pmt.executeQuery();
			if(rs.next()) {
				Vehicle v=new Vehicle(rs.getInt("id"),rs.getString("name"),rs.getString("model"));
				return v;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public static boolean insertCustomerVehicle(String vehicle_number, int customer_id, int vehicle_id) {
		boolean f=false;
		String q2="Insert into customer_vehicles(vehicle_number, customer_id, vehicle_id) values (?,?,?);";
		try {
			PreparedStatement pmt=con.prepareStatement(q2);
			pmt.setString(1, vehicle_number);
			pmt.setInt(2, customer_id);
			pmt.setInt(3, vehicle_id);
			pmt.executeUpdate();
			f=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return f;
	}

}
