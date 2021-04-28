package UserServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.PrintUtil;

import Entity.product;
import Entity.user;
import UserService.UserServices;
import UserService.UserServlceImpl;

@WebServlet("/XiuGaiCP")
public class XiuGaiCP extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiuGaiCP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		UserServices qs=new UserServlceImpl();
		String idd =request.getParameter("id"); 
		Integer id=Integer.valueOf(idd);
        String ptname=request.getParameter("ptname");
       
       product ys=new product();
       ys.setId(id);
       ys.setPtname(ptname);
      
       int num=-1;
       if (qs.upchanpins(ys)){
    	   num=1;
    	   System.out.println("dd"+num);
	   }
      
       PrintUtil.write(num, response);
       }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
