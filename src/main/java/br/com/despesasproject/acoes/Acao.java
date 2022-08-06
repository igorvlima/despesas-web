package br.com.despesasproject.acoes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Acao {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
