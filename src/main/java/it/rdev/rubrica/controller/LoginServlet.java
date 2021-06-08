package it.rdev.rubrica.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rdev.rubrica.dto.User;
import it.rdev.rubrica.model.ContactDao;
import it.rdev.rubrica.model.entities.Contact;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int val=0;
		if(request.getAttribute("valore")!=null) {
		 val=(int) request.getAttribute("valore");
		}
		
		
		String action = request.getParameter("action");
		if(action != null && action.equals("insert") || val==1  ) {
			Contact c = new Contact();
			if(request.getParameter("id")!= null && request.getParameter("nome")!= null || request.getParameter("cognome")!= null) {
			Integer id =Integer.parseInt(request.getParameter("id"));	
			String nome =request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			c.setId(id);
			c.setName(nome);
			c.setSurname(cognome);			
			ContactDao.insert(c);
			}
			
			List<Contact> cont = ContactDao.findAllNamedQuery();
			request.setAttribute("contatti", cont);
			request.getRequestDispatcher("Inserisci.jsp").forward(request, response);
		}
		else if(action != null && action.equals("update") || val==2  )
		{
			Contact c = new Contact();
			if(request.getParameter("id")!= null && request.getParameter("nome")!= null && request.getParameter("cognome")!= null) {
			Integer id =Integer.parseInt(request.getParameter("id"));	
			String nome =request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			c.setId(id);
			c.setName(nome);
			c.setSurname(cognome);
			ContactDao.update(c);		
			}
			List<Contact> cont2 = ContactDao.findAllNamedQuery();
			request.setAttribute("contatti", cont2);
			request.getRequestDispatcher("Update.jsp").forward(request, response);
		}
		else if(action != null && action.equals("delete")|| val==3 )
		{
			Contact c = new Contact();
			if(request.getParameter("delid")!=null) {
			Integer id3 =Integer.parseInt(request.getParameter("delid"));
			c.setId(id3);			
			ContactDao.delete(c);	
			}
			List<Contact> cont3 = ContactDao.findAllNamedQuery();
			request.setAttribute("contatti", cont3);
			request.getRequestDispatcher("Delete.jsp").forward(request, response);
		}
		else 
		{		
		request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
