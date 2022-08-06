<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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

                <c:forEach var="despesa" items="${despesas}">
                    <tr>
                        <td>${despesa.getDescricao()}</td>
                        <td>${despesa.getData()}</td>
                        <td>${despesa.getCategoria()}</td>
                        <td><a href="controladora?acao=RemoveDespesa&id=${despesa.id}">Remover</a></td>
                    </tr>
                </c:forEach>
        </table>
</body>
</html>