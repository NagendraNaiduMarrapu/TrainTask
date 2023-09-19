package com.jstl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Trains extends TagSupport {

	private String column1;
	private String column2;

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public int doStartTag() throws JspException {

		try {

			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres",
					"postgres", "1234");
			Statement st = connection.createStatement();
			System.out.println(column1 + column2);
			String query = "SELECT trn_name, trn_number FROM mystations WHERE trn_start = '" + column1 + "' AND trn_end = '"
					+ column2 + "'";

			ResultSet resultSet = st.executeQuery(query);

			JspWriter out = pageContext.getOut();
			out.print("<select>");
			while (resultSet.next()) {
				String optionValue = resultSet.getString(1);
				String optionText = resultSet.getString(2);
				out.print("<option value=\"" + optionValue + "\">" + optionValue + optionText + "</option>");
			}
			out.print("</select>");

			resultSet.close();
			st.close();
			connection.close();
		} catch (Exception e) {
			throw new JspException(e);
		}
		return SKIP_BODY;

	}
}
