package com.cibertec.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibertec.business.SubjectService;
import com.cibertec.business.impl.SubjectServiceImpl;
import com.cibertec.constant.Constante;
import com.cibertec.model.Subject;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectService service = new SubjectServiceImpl();
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getParameter("action");
		
		switch (action) {
		case Constante.LISTAR:listarSubject (request,response);break;
		case Constante.REGISTRAR:registrarSubjects(request,response); break;
		case Constante.ACTUALIZAR:actualizarSubject(request,response) ;break;
		case Constante.ELIMINAR:eliminarSubject(request,response);break;
		case Constante.DETALLE:detalleSubject(request,response);break;

		}
	}

	private void listarSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> lista = service.listarSubjects();
		request.setAttribute("data", lista);
		request.getRequestDispatcher("listadoObjeto.jsp").forward(request, response);
	}

	private void registrarSubjects (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String objeto =request.getParameter("txtObjeto");
		String credito = request.getParameter("txtCredito");
		Subject subject = new Subject(objeto,credito);
		

		int valor =service.registrarSubject(subject);
		if (valor==1) {
			request.setAttribute("msgOk","Se registró el objeto " + subject);
		}else {
			request.setAttribute("msjError", "No se registró el objeto.");
		}
		listarSubject(request, response);
	}

	private void detalleSubject(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		int id =Integer.parseInt(request.getParameter("id"));
		Subject detalleSubject = service.listarSubjectPorId(id);
		request.setAttribute("objeto", detalleSubject);
		request.getRequestDispatcher("actualizarObjeto.jsp").forward(request, response);
	}
	
	private void actualizarSubject (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("txtObjeto");
		String credito = request.getParameter("txtCredito");
		int id = Integer.parseInt(request.getParameter("txtId"));
		Subject subject =new Subject(id,nombre,credito);
		int valor = service.actualizarSubject(subject);
		if (valor==1) {
			request.setAttribute("msjOk","Se actualizó los datos del objeto" + nombre);
		} else {
			request.setAttribute("msjError","No se actualizó los datos del objeto");
		}
		listarSubject(request, response);
	}
	
	private void eliminarSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id =Integer.parseInt(request.getParameter("id"));
		int valor =service.eliminarSubjectPorId(id);
		if (valor==1) {
			request.setAttribute("msjOk", "Se eliminó el objeto con id: " + id);
		} else {
			request.setAttribute("msjError", "No se eliminó el objeto.");			
		}
		listarSubject(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
