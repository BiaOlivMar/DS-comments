package conectandoBanco; //declara em qual pacote a classe está localizada
import java.sql .*; //esse comando serve para importar todas as classe da biblioteca java.sql
import javax.swing.*; //esse comando serve para importar todas as classe da biblioteca swing
public class Conecta { //declara uma classe pública chamada Conecta
    public static void main(String[] args) { //este método serve como ponto de entrada principal para o início da execução do programa
        final String DRIVER = "com.mysql.jdbc.Driver"; //esse comando serve pra definir o driver do MySQL
        final String URL = "jdbc:mysql://localhost:3306/mysql"; //esse comando serve para definir o URL de conexão ao banco de dados
        try { //inicía um bloco try para pegar exessões que podem ocorrer
            Class.forName(DRIVER); //serve para chamar o driver usado para realizar a conexão
            Connection connection = DriverManager.getConnection(URL, "root", "123456"); // conecta com o banco de dados usando as informações fornecidas: URL, senha e usuário
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso"); //exibe uma caixa de diálogo com a mensagem avisando que a conexão foi realizada com sucesso
            connection.close(); //fecha a conexão aberta anteriormente
        } catch (ClassNotFoundException erro) { //pega qualquer exceção que esteja relacionada a erros a ausência de classe
            JOptionPane.showMessageDialog(null, "Driver não encotrado!\n"  + erro.toString()); //exibe uma caixa de diálogo com a mensagem de exceção

        } catch (SQLException erro){  //pega qualquer exceção que esteja relacionada a problemas na conexão com o banco de dados
            JOptionPane.showMessageDialog(null, "prrblemas no conexão com a fonte de dado!/n"
                    + erro.toString()); //exibe uma caixa de diálogo com a mensagem de exceção

        }
    }
}