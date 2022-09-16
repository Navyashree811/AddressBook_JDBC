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

	public static List<ContactPerson> fetchContactPersonList() throws Exception {

		List<ContactPerson> details = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String qry = "select * from address_book where date between Cast('2020-01-01' as date) and date (now();)";
		try {
			con = ConnectionDB.createCP();

			pstmt = con.prepareStatement(qry);

			rs = pstmt.executeQuery();

			System.err.println("firstName-> " + "lastName-> " + "type" + "address-> " + "    city-> " + "state-> "
					+ " zip-> " + "phoneNumber-> " + "date -> ");

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

				long zip = rs.getLong(7);
				info.setZip(zip);

				long phoneNumber = rs.getLong(8);
				info.setPhoneNumber(phoneNumber);

				String date = rs.getString(9);
				info.setDate(date);

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
		AddressBookDBService.fetchContactPersonList();
	}
}
