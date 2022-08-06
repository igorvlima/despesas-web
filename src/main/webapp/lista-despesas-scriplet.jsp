<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection,br.com.codandosimples.infra.ConnectionFactory, br.com.codandosimples.dao.*, br.com.codandosimples.model.*, java.util.*"%>
<!DOCTYPE html>
<html lang="pt">
<style>
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
</style>
<body>
        <table>
            <tr>
                 <th>Descrição</th>
                 <th>Data</th>
                 <th>Categoria</th>
            </tr>

            <%
                Connection connection = ConnectionFactory.getConnection();
                 DespesaDAO desp = new DespesaDAO(connection);
                 List <Despesa> despesas = desp.findAll();

                 for(Despesa despesa : despesas){
            %>
            <tr>
                <td><%= despesa.getDescricao() %></td>
                <td><%= despesa.getData() %></td>
                <td><%= despesa.getCategoria() %></td>
            </tr>
            <%
            }
            %>
        </table>
</body>
</html>