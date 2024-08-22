import java.io.IOException;
import java.util.Collection;

public class Program {
    public static void main(String[]args) throws ContatoInexistenteException, IOException {
        AgendaAyla agenda = new AgendaAyla();
        GravadorDeDados gr = new GravadorDeDados();


        agenda.cadastrarContato("a",12,5);
        agenda.cadastrarContato("b",5,12);

        agenda.salvarDados();

        AgendaAyla agenda2 = new AgendaAyla();
        agenda2.recuperarDados();
        Collection<Contato> checagem = agenda2.pesquisaAniversariante(12,5);
        for(Contato c : checagem){
            System.out.println(c.toString());
        }
    }
}
