package cotroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVo;

@SuppressWarnings("serial")
@WebServlet({ "/boardInput", "/bi" })
public class BoardInputController extends HttpServlet {
	 //private static final long serialVersionUID = 1L; //길이를 한줄로

	 /*
	 //서비스객체, 제일 먼저 실행됨
	 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	 }
	 */
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아래3줄 서비스객체에 넣어도 실행됨
		String viewPage = "/WEB-INF/boardTest/boardInput.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("123123123");
		String name = request.getParameter("name")==null ? "":request.getParameter("name"); //null 예외처리
		String title= request.getParameter("title")==null ? "":request.getParameter("title"); //null 예외처리
		String content= request.getParameter("content")==null ? "":request.getParameter("content"); //null 예외처리
//		String hostIp= request.getParameter("hostIp")==null ? "":request.getParameter("hostIp"); //null 예외처리, hostIp는 null일수가 없어서 굳이 필요X
		String hostIp = request.getRemoteAddr();
		BoardVo vo = new BoardVo();
//		vo.setName(request.getParameter("name")==null ? "":request.getParameter("name"));
			vo.setName(name);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setHostIp(hostIp);
			
			BoardDao dao = new BoardDao();
			int res = dao.setBoardInput(vo);
			
			
			PrintWriter out = response.getWriter();
			System.out.println("dddddd");
			if(res != 0) {
				out.println("<script>");
				out.println("alert('게시글이 등록되었습니다.');");
				out.println("location.href='boardList';");
				out.println("</script>");
			}
			else {
				out.println("<script>");
				out.println("alert('게시글이 등록 실패.');");
				out.println("location.href='boardInput';");
				out.println("</script>");
			}
	}

}
