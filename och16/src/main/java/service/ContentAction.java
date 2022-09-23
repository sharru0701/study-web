package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Board;
import dao.BoardDao;

public class ContentAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ContentActions Service start...");
		// 1. num , pageNum
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		try {
			// 2. BoardDao bd Instance
			BoardDao bd = BoardDao.getInstance();
			
			// 4. Board board = bd.select(num);
			Board board = bd.select(num); // hw
			
			// 5. request 객체에 num , pageNum , board
			request.setAttribute("num"     , num);
			request.setAttribute("pageNum" , pageNum);
			request.setAttribute("board"   , board);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//      view
		return "content.jsp";
	}

}
