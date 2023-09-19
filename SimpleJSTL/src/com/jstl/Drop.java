package com.jstl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Drop extends TagSupport {
    private String tableName;
    private String column;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public int doStartTag() throws JspException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "1234");
            Statement st = connection.createStatement();
            String query = "SELECT distinct " + column + " FROM " + tableName;
            ResultSet resultSet = st.executeQuery(query);

            JspWriter out = pageContext.getOut();

            String selectId = "dropdown_" + column;

            out.print("<select id=\"" + selectId + "\">");
            while (resultSet.next()) {
                String optionValue = resultSet.getString(1);
                String optionText = resultSet.getString(1);
                out.print("<option value=\"" + optionValue + "\">" + optionText + "</option>");
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
