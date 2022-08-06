package br.com.despesasproject.servlets;

import br.com.codandosimples.infra.ConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/primeiraServlet")
public class PrimeiraServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.print("<body>");
        writer.print("<h1>Primeira página gerada pela nossa Servlet!");
        writer.print("</body>");
        writer.println("</html>");

        ConnectionFactory.getConnection();
    }
}