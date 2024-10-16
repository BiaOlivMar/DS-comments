package conectandoBanco; //declara em qual pacote a classe está localizada
import java.sql.*; //esse comando serve para importar todas as classe da biblioteca java.sql
import javax.swing.*; //esse comando serve para importar todas as classe da biblioteca swing
public class Consultafilmes { //declara uma classe pública chamada Consultafilmes
    public static void main(String[] args) { //este método serve como ponto de entrada principal para o início da execução do programa
        final String DRIVER = "com.mysql.jdbc.Driver"; //esse comando serve pra definir o driver do MySQL
        final String URL = "jdbc:mysql://localhost:3306/banco"; //esse comando serve para definir o URL de conexão ao banco de dados
        try{ //inicía um bloco try para pegar exessões que podem ocorrer
            Class.forName(DRIVER); //serve para chamar o driver usado para realizar a conexão

            Connection connection = DriverManager.getConnection(URL,"root","123456"); /* conecta com o banco de dados usando as informações 
            fornecidas: URL, senha e usuário */

            String sql = "SELECT codigo, titulo FROM Filmes WHERE codigo > ? AND codigo < ? ORDER BY codigo"; /* cria uma variávele onde ele 
            realiza uma consulta sql onde ele seleciona o código e título localizados na tabela filmes, e organiza eles pelo código */ 

            PreparedStatement statement = connection.prepareStatement(sql); //serve para preparar o comando sql para o executor

            statement.setString(1, "03120"); //serve para definir o primeiro parâmetro
            statement.setString(2, "03140"); //serve para definir o segundo parâmetro

            ResultSet resultSet = statement.executeQuery(); //executa a consulta e obtém os resultados

            System.out.println("CÓDIGO  TITULO"); //um título de cabeçalho para a hora da exibição dos resultados
            System.out.println("------  -----------------------------------------------"); /* umas linhas que servem para deixar a exibição 
            dos resultados mais bonita */

            while (resultSet.next()){ //
                String codigo = resultSet.getString("codigo"); //obtém o código do filme
                String titulo = resultSet.getString("titulo"); //obtém o título do filme

                System.out.println(codigo+"     "+titulo); //imprime na tela o código e o título do filme 

            }

            resultSet.close(); //fecha ResultSet, resultados
            statement.close(); //fecha o PreparedStatement, definições
            connection.close(); //fecha a conexão aberta anteriormente
        }catch (ClassNotFoundException erro){ //pega qualquer exceção que esteja relacionada a erros a ausência de classe
            JOptionPane.showMessageDialog(null, "Driver não encontrado:\n"
                    + erro.toString()); //exibe uma caixa de diálogo com a mensagem de exceção
        }catch (SQLException eerro){ //pega qualquer exceção que esteja relacionada a problemas na conexão com o banco de dados
            JOptionPane.showMessageDialog(null,"Problemas na conexão com a fonte de dados\n"
                    + eerro.toString()); //exibe uma caixa de diálogo com a mensagem de exceção
        }
    }
}
