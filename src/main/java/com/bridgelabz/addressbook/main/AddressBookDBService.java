package com.bridgelabz.addressbook.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
	static PreparedStatement pstmt;
	static Connection con;
	static ResultSet rs;

	public static void updateData() throws Exception {
		String qry = "update address_book set city = 'Udaipur' where firstName ='Navya'";
		try {

			con = ConnectionDB.createCP();

			pstmt = con.prepareStatement(qry);
			System.out.println("Data Update");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<ContactPerson> fetchContactPersonList() throws Exception {

		List<ContactPerson> details = new ArrayList<>();

		String qry1 = "select * from address_book where firstName ='Navya';";
		try {
			con = ConnectionDB.createCP();

			pstmt = con.prepareStatement(qry1);

			rs = pstmt.executeQuery();

			System.err.println("firstName-> " + "lastName-> " + "type-> " + "address-> " + "    city-> " + "state-> "
					+ " zip-> " + "phoneNumber-> ");

			while (rs.next()) {
				ContactPerson info = new ContactPerson();

				String firstName = rs.getString(1);
				info.setFirstName(firstName);

				String lastName = rs.getString(2);
				info.setLastName(lastName);

				String type = rs.getString(3);
				info.setType(type);

				String address = rs.getString(4);
				info.setAddress(address);

				String city = rs.getNString(5);
				info.setCity(city);

				String state = rs.getString(6);
				info.setState(state);

				Double zip = rs.getDouble(7);
				info.setZip(zip);

				Double phoneNumber = rs.getDouble(8);
				info.setPhoneNumber(phoneNumber);

				details.add(info);
				System.out.println(info.toString());
				System.out.println();

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (pstmt != null) {
				try {
					pstmt.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			System.out.println("Closed All Resources");
		}
		return details;

	}

	public static void main(String[] args) throws Exception {

		AddressBookDBService.updateData();
		AddressBookDBService.fetchContactPersonList();
	}
}
