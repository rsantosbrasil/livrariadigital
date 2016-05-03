package livrariadigital.mvc.regradenegocio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RegraDeNegocio {
	String execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
}