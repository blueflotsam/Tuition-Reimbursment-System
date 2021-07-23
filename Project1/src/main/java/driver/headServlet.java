package driver;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Dao.EmployeeDao;
import Dao.HeadDao;
import obj.employee;
import obj.reimbursment;

//@WebServlet("*");
public class headServlet extends HttpServlet {
	private Gson gson=new Gson();
	String registerForm ="html/mainPage.html";
	//RequestDispatcher dispatcher = request.getRequestDispatcher(registerForm);
	//dispatcher.forward(request, response);

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");
		//String uri =request.getRequestURI();
		//System.out.println(uri);
		/*int i=Integer.parseInt(request.getParameter("num1"));
		int j=Integer.parseInt(request.getParameter("num2"));
		int k=i+j;
		response.setContentType("text/plain");
		PrintWriter out=response.getWriter();
		out.println("The sum is: " + k);
		//gson.*/
		//response.getWriter().append("it works but get?");
		String uri=request.getRequestURI();
		String id=request.getParameter("id");
		if(id.length()>0&&Character.isDigit(id.charAt(0))){
			int i=Integer.parseInt(id);
			HeadDao dao=new HeadDao();
			List<reimbursment> e=dao.getAll(i);
			for(reimbursment r: e) {
				response.getWriter().append(gson.toJson(r));
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");
		//response.setHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append("Post request");
		//response.getWriter().append("it works?");
		//gson.toJson
		//SONObject o=
		//response.getWriter().append(request.getSession().getAttribute("banana"));
		
	}
	
}
