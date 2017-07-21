<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Contas</title>
</head>
<body>
<a href="listaContas">Lista Conta</a></br>
	<h3>Adicionar Contas</h3>
    <form action="alteraConta" method="post">
    	ID: <input type="text" name="id" readonly="readonly" value="${conta.id}"/><br/>
        Descrição: <br/>
        <textarea name="descricao" rows="5" cols="100">${conta.descricao}</textarea>
        <br/>
        Valor: <input type="text" name="valor" value="${conta.valor}"/></br>
        Tipo:
        <select name="tipo">
            <option value="ENTRADA" ${conta.tipo=='ENTRADA'?'selected':''}>Entrada</option>
            <option value="SAIDA"${conta.tipo=='SAIDA'?'selected':''}>Saída</option>
        </select></br>
        Pago? <input type="checkbox" name="paga" ${conta.paga?'checked':''}>
        </br>
        Data de Pagamento: <input type="text" name="dataPagamento" value="<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" />" />
        
        <br/><br/>
        <input type="submit" value="Alterar"/>
    </form>

</body>
</html>