package livrariadigital.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import livrariadigital.mvc.regradenegocio.RegraDeNegocio;

@SuppressWarnings("serial")
@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String regra = req.getParameter("regraDeNegocio");
		String classeRegra = "livrariadigital.mvc.regradenegocio." + regra;
		try {
			@SuppressWarnings("rawtypes")
			Class classeRegraDeNegocio = Class.forName(classeRegra);
			RegraDeNegocio regraDeNegocio = (RegraDeNegocio) classeRegraDeNegocio.newInstance();
			String paginaRetorno = regraDeNegocio.execute(req, res);
			req.getRequestDispatcher(paginaRetorno).forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Exceção causada pela execução da regra de negócios");
		}

	}
}