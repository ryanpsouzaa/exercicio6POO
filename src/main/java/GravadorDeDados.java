import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//chave/key do map é o nome do contato
//implementar o novo metodo de persistencia - serializable

public class GravadorDeDados {
    String ARQUIVO_CONTATOS = "contatos.dat";

    public HashMap<String, Contato> recuperarContatos(){
        HashMap<String, Contato> listaRecuperada = new HashMap<>();
        try(BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_CONTATOS))){
            String linhaTexto = leitor.readLine();
            while(linhaTexto != null){
                String[] texto = linhaTexto.split(",");

                String nome = texto[0];
                int dia = Integer.parseInt(texto[1]);
                int mes = Integer.parseInt(texto[2]);

                Contato contatoElemento = new Contato(nome, dia, mes);
                /*String tamanho = String.valueOf(listaRecuperada.size() + 1);
                listaRecuperada.put(tamanho, contatoElemento);*/

                listaRecuperada.put(nome, contatoElemento);

                linhaTexto = leitor.readLine();
            }
        }catch (IOException e){
            throw new RuntimeException();
        }
        return listaRecuperada;
    }

    public void salvarContatos(Map<String, Contato> agenda) throws IOException {
        BufferedWriter gravador = null;
        try{
            gravador = new BufferedWriter(new FileWriter(ARQUIVO_CONTATOS));
            for (String key : agenda.keySet()){
                String linha = agenda.get(key).getNome() + "," + agenda.get(key).getDiaAniversario() + "," + agenda.get(key).getMesAniversario();
                gravador.write(linha + "\n");
            }
        } finally {
            if(gravador != null){
                gravador.close();
            }
        }
    }


    //esboço do leitor de arquivo, determinar o retorno da lista (Map<String, Contato>)
    public void lerDados(){
        Collection<Contato> lista = new ArrayList<>();
        try(BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_CONTATOS))){
            String linhaTexto = leitor.readLine();
            while(linhaTexto != null){
                String[] texto = linhaTexto.split(",");
                String nome = texto[0];
                int dia = Integer.parseInt(texto[1]);
                int mes = Integer.parseInt(texto[2]);
                Contato contatoElemento = new Contato(nome, dia, mes);
                lista.add(contatoElemento);

                linhaTexto = leitor.readLine();
            }
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
    //fim do esboço

    //novo gravaodr

}
