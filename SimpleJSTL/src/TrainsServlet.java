import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TrainsServlet")
public class TrainsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TrainsServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String column1 = request.getParameter("column1");
        String column2 = request.getParameter("column2");
        
        
        System.out.println(column1);

        request.setAttribute("column1", column1);
        request.setAttribute("column2", column2);

        request.getRequestDispatcher("/name.jsp").forward(request, response);
    }
}
