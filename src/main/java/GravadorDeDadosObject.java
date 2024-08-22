import java.io.*;
import java.util.List;

public class GravadorDeDadosObject {
    public List<Contato> leContatos() throws IOException{
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream("contatos.dat"));
            return (List<Contato>) in.readObject();
        } catch(FileNotFoundException e) {
            throw new IOException("Não foi encontrado o arquivo");
        } catch(IOException e){
            throw e;
        } catch (ClassNotFoundException e){
            throw new IOException("Classe dos objetos gravados no arquivo não existe", e);
        } finally {
            if(in != null){
                in.close();
            }
        }
    }
    public void gravaContatos(List<Contato> contatos) throws IOException{
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream("contatos.dat"));
            out.writeObject(contatos);
        } catch(FileNotFoundException e){
            throw new IOException("Não foi encontrado o arquivo");
        } catch(IOException e){
            throw e;
        } finally {
            if(out != null){
                out.close();
            }
        }
    }
}
