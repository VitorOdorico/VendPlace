package Controladores;

import Entidades.Cliente;
import Facade.ClienteFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Controlador responsável pelas operações de gerenciamento de clientes na aplicação.
 * 
 * Esta classe é um ManagedBean, o que significa que ela será gerenciada pelo JSF (JavaServer Faces),
 * permitindo a interação entre a interface de usuário (páginas JSF) e a lógica de negócios.
 * 
 * A anotação @SessionScoped indica que os dados do cliente serão mantidos durante toda a sessão do usuário,
 * ou seja, os dados persistem entre diferentes requisições HTTP durante a sessão.
 * 
 * O controlador utiliza a classe ClienteFacade, que centraliza as operações de persistência
 * e recuperação de dados relacionados à entidade Cliente. A injeção de dependência é feita
 * pela anotação @EJB, permitindo que o container gerencie a instanciação do `ClienteFacade`.
 * 
 * @author VCosta
 */
@ManagedBean
@SessionScoped
public class ClienteControle implements Serializable {
    
    private Cliente cliente;  // Instância de Cliente usada para manipular os dados na interface
    @EJB
    private ClienteFacade clienteFacade;  // Facade responsável pelas operações no banco de dados

    @PostConstruct
    public void init() {
        cliente = new Cliente();  // Inicializa o objeto cliente
    }
    
    
    /**
     * Método responsável por instanciar um novo objeto Cliente.
     * Este método é geralmente chamado quando o usuário deseja cadastrar um novo cliente.
     */
    public void novo() {
        cliente = new Cliente();
    }
    
     
     
  
    /**
     * Método para salvar um cliente no banco de dados.
     * Chama o método salvar da fachada ClienteFacade, e após salvar, reinicia o objeto Cliente.
     */
    public void salvar() {
        clienteFacade.salvar(cliente);  // Chama a fachada para persistir o cliente
        cliente = new Cliente();  // Reinicia o cliente após salvar
    }

    /**
     * Método responsável por excluir um cliente do banco de dados.
     * Recebe como parâmetro um objeto Cliente e solicita à fachada que o remova.
     * 
     * @param cli O cliente que será removido.
     */
    public void excluir(Cliente cli) {
        clienteFacade.remover(cli);  // Chama a fachada para remover o cliente
    }

    /**
     * Método responsável por editar um cliente existente.
     * Atribui o cliente passado como parâmetro ao atributo cliente para permitir
     * que seus dados sejam exibidos e alterados na interface.
     * 
     * @param cli O cliente a ser editado.
     */
    public void editar(Cliente cli) {
        this.cliente = cli;  // Atribui o cliente a ser editado ao atributo da classe
    }

 

    /**
     * Retorna o cliente atual.
     * @return O cliente que está sendo manipulado.
     */

    public Cliente  getCliente(){
        return cliente;
     }
    /**
     * Define o cliente atual.
     * @param cliente O cliente que será manipulado.
     */
      public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna uma lista de todos os clientes cadastrados.
     * 
     * Este método usa a fachada ClienteFacade para buscar e retornar todos os clientes
     * persistidos no banco de dados.
     * 
     * @return Uma lista de objetos Cliente.
     */
    public List<Cliente> getListaClientes() {
        return clienteFacade.listaTodos();  // Chama a fachada para obter a lista de clientes
    }
}
