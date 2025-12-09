
package controle;

import java.util.List;
import modelo.AgendaDAO;
import modelo.ModeloAgenda;

public class ControleAgenda {

  private AgendaDAO dao = new AgendaDAO();

  
    public boolean cadastrarCliente(String nome, String cpf, int idade) {
     
        if (nome == null || nome.trim().isEmpty() || cpf == null || cpf.trim().isEmpty()) {
            System.err.println("Erro: Nome e CPF não podem ser vazios.");
            return false;
        }
        
        // cria o objeto ModelCliente
        ModeloAgenda novoCliente = new ModeloAgenda(nome, cpf, idade);
        
        // delega a persistência ao DAO
        dao.salvar(novoCliente);
        return true;
    }
    
 
    public ModeloAgenda buscarClientePorCpf(String cpf) {
        List<ModeloAgenda> clientes = dao.listarTodos();
        
        // busca o cliente na lista
        for (ModeloAgenda cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente; // Cliente encontrado
            }
        }
        return null; // cliente nao encontrado
    }
 
    public boolean atualizarCliente(String nome, String cpf, int novaIdade) {
        // cpf é a chave
        ModeloAgenda clienteAtualizado = new ModeloAgenda(nome, cpf, novaIdade);
        
        // delega a persistência ao DAO
        return dao.atualizar(clienteAtualizado);
    }

   
    public boolean deletarCliente(String cpf) {
        // delega a deleção ao DAO
        return dao.deletar(cpf);
    }
}

