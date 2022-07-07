package com.jay.prj.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jay.prj.MainCommand;

@WebServlet("*.do")	//~.do로 요청이 들어오면 무조건 여기서 실행
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Command> map = new HashMap<>();	//요청과 실행문을 매핑하기 위해
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		//초기화 하는 메소드(Mapping하는 부분을 작성)
		map.put("/main.do", new MainCommand());	//처음접속하는 페이지
		
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서비스(실행)하는 메소드
		request.setCharacterEncoding("utf-8");	//한글 깨짐 방지
		String uri = request.getRequestURI();	//요청된 URI를 확인한다.
		String contextPath = request.getContextPath(); //요청 URL로 부터 contextPath를 확인한다.
		String page = uri.substring(contextPath.length()); //실제로 요청된 것 (uri에서 contextPath의 길이만큼 빼면 실제 요청한것)
		
		Command command = map.get(page);	//실제 수행할 Command를 찾음  = new MainCommand();
		String viewPage = command.exec(request, response);	//요청 Command를 수행하고 결과를 받음
		
		//viewResolve
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
			viewPage = "/WEB-INF/views/"+ viewPage+".jsp";	//시스템에서 접근가능한 폴더를 더해주고 
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);	//원하는 페이지를 호출에서 전달함
		}else {
			response.sendRedirect(viewPage); // .do로 권한 위임 처리
		}
	}
}