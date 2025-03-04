package cotroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

@SuppressWarnings("serial")
@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//req, resp 약자 쓰지 말것 - 실무에서 다 길게 씀
		BoardDao dao = new BoardDao();
		
		List<BoardVo> vos = dao.getBoardList(); 
		
		request.setAttribute("vos", vos);
		
		
		String viewPage = "/WEB-INF/boardTest/boardList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //기차에 싣기
		dispatcher.forward(request, response); //기차 달리게 하기
		
	}
	
	
}
