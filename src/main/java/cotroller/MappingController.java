package cotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mapping")
public class MappingController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/mapping/mapping.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //기차에 싣기
		dispatcher.forward(request, response); //기차 달리게 하기
		
	}
}
