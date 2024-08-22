import java.io.IOException;
import java.util.Collection;

public interface Agenda {
    void salvarDados() throws IOException;
    void recuperarDados();
    boolean cadastrarContato(String nome, int dia, int mes) throws ContatoInexistenteException;
    Collection<Contato> pesquisaAniversariante(int dia, int mes);
    boolean removeContato(String nome) throws ContatoInexistenteException;
}
