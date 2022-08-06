package br.com.despesasproject.acoes;

import br.com.codandosimples.dao.DespesaDAO;
import br.com.codandosimples.infra.ConnectionFactory;
import br.com.codandosimples.model.Categoria;
import br.com.codandosimples.model.Despesa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdicionaDespesa implements Acao{

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String descricaoStr =   req.getParameter("descricao");
        String dataStr =   req.getParameter("data");
        String valorStr =   req.getParameter("valor");
        String categoriaStr =   req.getParameter("categoria");

        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        double valor = Double.parseDouble(valorStr);
        Categoria categoria = Categoria.valueOf(categoriaStr); //convertendo Strings para seus respectivos formatos

        Despesa despesa= new Despesa(descricaoStr,data,valor,categoria);
        Connection connection = ConnectionFactory.getConnection();
        DespesaDAO desp = new DespesaDAO(connection);
        desp.save(despesa);

        return "/WEB-INF/despesa-adicionada.jsp";


    }
}
