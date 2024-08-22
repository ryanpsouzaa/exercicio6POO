import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class AgendaAyla implements Agenda, Serializable {
    private Map<String, Contato> contatos;

    GravadorDeDados gravador = new GravadorDeDados();

    public AgendaAyla(){
        this.contatos = new HashMap<>();
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.salvarContatos(this.contatos);

    }

    @Override
    public void recuperarDados() {
        this.contatos = gravador.recuperarContatos();

    }

    @Override
    public boolean cadastrarContato(String nome, int dia, int mes) throws ContatoInexistenteException {
        Contato contatoElemento = new Contato(nome, dia, mes);
        if(this.contatos.containsValue(contatoElemento.getNome())){
            throw new ContatoInexistenteException("Contato já se encontra registrado.");
        }
        this.contatos.put(nome,contatoElemento);
        return true;
    }

    @Override
    public Collection<Contato> pesquisaAniversariante(int dia, int mes) {
        Collection<Contato> contatosPesquisados = new ArrayList<>();
        for(String key : this.contatos.keySet()){
            if(this.contatos.get(key).getDiaAniversario() == dia && this.contatos.get(key).getMesAniversario() == mes){
                contatosPesquisados.add(this.contatos.get(key));
            }
        }
        return contatosPesquisados;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        for(String key : this.contatos.keySet()){
            if(this.contatos.get(key).getNome() == nome){
                this.contatos.remove(this.contatos.get(key));
                return true;
            }
        }
        throw new ContatoInexistenteException("Contato não encontrado.");
    }
}
