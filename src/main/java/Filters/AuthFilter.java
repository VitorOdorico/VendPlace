package Filters;

import Entities.Config.Usuario;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "/login.xhtml";

        boolean isLoginPage = req.getRequestURI().equals(loginURI);
        boolean isResource = req.getRequestURI().startsWith(req.getContextPath() + "/javax.faces.resource/");
        boolean isImage = req.getRequestURI().contains("/img/");
        boolean isCSS = req.getRequestURI().contains("/css/");
        boolean isJS = req.getRequestURI().contains("/js/");

        Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuario") : null;

        if (usuario != null || isLoginPage || isResource || isImage || isCSS || isJS) {
            // Usuário logado ou página pública → permite continuar
            chain.doFilter(request, response);
        } else {
            // Redireciona para login.xhtml
            res.sendRedirect(loginURI);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }
}
