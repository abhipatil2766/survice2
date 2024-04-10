package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import dbUtil.DBUtil;
import dbUtil.DbUtil;
import entity.Parts;
//import operations.models.Part;
//import operations.models.Part;

public class PartsDao {
	private static Connection con;

	public PartsDao() throws SQLException {
		this.con = DbUtil.getConnection();
	}

	public int addParts(int id, String name, String discription, double price) {
		// TODO Auto-generated method stub
		String q5="insert into parts values(?,?,?,?)";
		int npa= 0;
		try {
			PreparedStatement pmt = con.prepareStatement(q5);
			pmt.setInt(1, id);
			pmt.setString(2, name);
			pmt.setString(3, discription);
			pmt.setDouble(4, price);
			npa=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return npa;
	}

	public Parts getSpecificParts(int id) {
		// TODO Auto-generated method stub
		String q2="select * from parts where id=?";
		try {
			PreparedStatement pmt= con.prepareStatement(q2);
			pmt.setInt(1, id);
			ResultSet rs=pmt.executeQuery();
			if(rs.next()) {
				Parts p =new Parts(id,rs.getString("name"),rs.getString("discription"),rs.getDouble("price"));
				return p;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public int editParts(int id, String name, String discription, double price) {
		// TODO Auto-generated method stub
		String q4="update parts set name=? discription=? price=? where id=?";
		int npu=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q4);
			pmt.setInt(2, id);
			pmt.setString(1, name);
			pmt.setString(1, discription);
			pmt.setDouble(1, price);
			npu=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return npu;
	}

	public void getAllParts(List<Parts> partsList) {
		// TODO Auto-generated method stub
		String q1="select * from parts";
		try {
			PreparedStatement pmt = con.prepareStatement(q1);
			ResultSet rs = pmt.executeQuery();
			while(rs.next()) {
				Parts p = new Parts(rs.getInt("id"),rs.getString("name"),rs.getString("discription"),rs.getDouble("price"));
				partsList.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int removeThisParts(int id) {
		// TODO Auto-generated method stub
		String q3="delete from parts where id=?";
		int npr=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q3);
			pmt.setInt(1, id);
			npr=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return npr;
	}

}
