package Section3;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import bean.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
ProductDAO dao = new ProductDAO();
List<Product> list = dao.findAll();
request.setAttribute("list", list);
RequestDispatcher rd = request.getRequestDispatcher("./product-search.jsp");
rd.forward(request, response);

	}
}
