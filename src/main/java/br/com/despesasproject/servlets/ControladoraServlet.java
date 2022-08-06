package br.com.despesasproject.servlets;

import br.com.despesasproject.acoes.Acao;
import br.com.despesasproject.acoes.AdicionaDespesa;
import br.com.despesasproject.acoes.ListaDespesas;
import br.com.despesasproject.acoes.RemoveDespesa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("controladora")
    public class ControladoraServlet extends HttpServlet {

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            try {
                String acaoNome = req.getParameter("acao");

                System.out.println("A ação executada foi: "+acaoNome);

                String pacote = "br.com.despesasproject.acoes.";

                Class classe = Class.forName(pacote+acaoNome);
                Acao acao = (Acao) classe.newInstance();

                String resultado = acao.executa(req, resp);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher(resultado);
                requestDispatcher.forward(req,resp);

                //           if(acao.equals("ListaDespesas")){
                //               new ListaDespesas().executa(req, resp);
                //           } else if (acao.equals("AdicionaDespesa")){
                //               new AdicionaDespesa().executa(req, resp);
                //           } else if (acao.equals("RemoveDespesa")){
                //               new RemoveDespesa().executa(req, resp);
                //           }

            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }
