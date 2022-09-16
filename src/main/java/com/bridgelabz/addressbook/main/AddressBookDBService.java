package com.bridgelabz.addressbook.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressBookDBService {
	static PreparedStatement pstmt;
	static Connection con;
	static ResultSet rs;

	public static void fetchContactPersonListByCity() throws Exception {

		int count = 0;

		String qry = " select count(*) from address_book where city = 'udaipur'; ";
		try {
			con = ConnectionDB.createCP();

			pstmt = con.prepareStatement(qry);

			rs = pstmt.executeQuery();

			rs.next();
			count = rs.getInt(1);
			System.out.println("Count of City is : " + count);

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

	}

	public static void fetchContactPersonListByState() throws Exception {

		int count = 0;

		String qry = " select count(*) from address_book where state = 'USA'; ";
		try {
			con = ConnectionDB.createCP();

			pstmt = con.prepareStatement(qry);

			rs = pstmt.executeQuery();

			rs.next();
			count = rs.getInt(1);
			System.out.println("Count of State is : " + count);

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

	}

	public static void main(String[] args) throws Exception {

		AddressBookDBService.fetchContactPersonListByCity();
		AddressBookDBService.fetchContactPersonListByState();
	}
}
