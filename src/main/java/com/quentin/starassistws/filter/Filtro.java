package com.quentin.starassistws.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class Filtro implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.addHeader("X-XSS-Protection", "1; mode=block");
        res.addHeader("X-Content-Type-Options", "nosniff");
        res.addHeader("X-Frame-Options", "SAMEORIGIN");
        res.addHeader("Server", "Servidor web");
        
        
        /*
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        */
        
        res.addHeader("Access-Control-Allow-Headers", "accept, content-type");
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
        
        /**
         * Activar para obtener la URL
         */
        if(req.getRequestURL().toString().contains(".js")){
            res.setContentType("text/javascript");
        }
        else if(req.getRequestURL().toString().contains(".css")){
            res.setContentType("text/css");
        }

        filterChain.doFilter(req, res);
    }

    public void destroy() {

    }
}
