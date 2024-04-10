package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dbUtil.DbUtil;
import entity.Customer;

public class CustomerDao {
	
	private static Connection con;

	public CustomerDao() throws SQLException {
		this.con = DbUtil.getConnection();
	}

	public int addCustomer(int id, String name, String mobile, String email, String address) {
		String q5="insert into customer values(?,?,?,?,?)";
		int nca=0;
		
		try {
			PreparedStatement pmt =con.prepareStatement(q5);
			pmt.setInt(1, id);
//			System.out.println("added");
			pmt.setString(2, name);
			pmt.setString(3, mobile);
			pmt.setString(4, email);
			pmt.setString(5, address);
			nca=pmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nca;
	}

	public static Customer getSpecificCustomer(String mobile) {
		String q2="select * from customer where mobile=?";
		try {
			PreparedStatement pmt=con.prepareStatement(q2);
			pmt.setString(1, mobile);
			ResultSet rs=pmt.executeQuery();
			if(rs.next()) {
				Customer c= new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("mobile"),rs.getString("email"),rs.getString("address"));
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		}

	public int editCustomer(int id, String name, String mobile, String email, String address) {
		String q4="update customer set name=?, mobile=?, email=?, address=? where id=?";
		int ncu=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q4);
			pmt.setInt(5, id);
			pmt.setString(1, name);
			pmt.setString(2, mobile);
			pmt.setString(3, email);
			pmt.setString(4, address);
			ncu=pmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ncu;
		
	}

	public int deletCustomer(int id) {
		String q3="delete from customer where id=?";
		int ncr=0;
		try {
			PreparedStatement pmt =con.prepareStatement(q3);
			pmt.setInt(1, id);
			ncr=pmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ncr;
	}

	public void getAllCustomers(List<Customer> customerList) {
		String q1="select * from customer";
		try {
			PreparedStatement pmt=con.prepareStatement(q1);
			ResultSet rs=pmt.executeQuery();
			while(rs.next()) {
				Customer c= new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("mobile"),rs.getString("email"),rs.getString("address"));
				customerList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	

}
