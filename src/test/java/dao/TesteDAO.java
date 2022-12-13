package dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDAO {

    static Connection connection;
    static Statement stmt;

    @BeforeClass
    public static void setupBeforeClass() throws SQLException {
        System.out.println("Iniciando conexao com o Banco de Dados");
        connection = ConnectionFactory.getConnection();
        System.out.println("Conexao executada com sucesso");
        stmt = connection.createStatement();
        connection.setAutoCommit(false);
    }

    @Test
    public void testRetornoSelect() throws SQLException {
        String comandoSql = "SELECT dt.MASSA_TESTE from DADOS_TESTE dt WHERE ID_CASO_TESTE = 1"; //Criando um comando SQL
        ResultSet resultSet = stmt.executeQuery(comandoSql); //Faz a consulta e retorna em um resultSet
        resultSet.next(); //Por padrao o codigo entende a primeira posicao da tabela, onde ela pode ser um indice e nao conter o real valor que esta sendo procurado.
        String jsonMassaTeste = resultSet.getString(1);
        System.out.println(jsonMassaTeste);
        Assert.assertTrue("Informacoes nao retornaram no SELECT", jsonMassaTeste.contains("https://amazon.com.br"));
    }

    @After
    public void afterCloseConnection() throws SQLException {
        stmt.close(); //Fechar query SQL executada
        connection.close(); //Fechar conexao com o banco
        System.out.println("Conexao finalizada com o banco");
    }


}
