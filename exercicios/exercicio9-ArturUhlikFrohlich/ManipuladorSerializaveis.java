/*
Programa: Classe ManipuladorSerializaveis
Objetivo: Cria uma classe capa\ de serializar e deserializar objetos
Entrada: N/A
Saída: N/A
Nome: Artur Uhlik Frohlich
Data: 12/04/2022
 */
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class ManipuladorSerializaveis {

    /* Métodos */

    public static void serializa(String nomeArquivo, Object objeto){
        try{
            FileOutputStream fos = new FileOutputStream(nomeArquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(objeto);

            oos.close();
            fos.close();
        }catch (IOException e){
            System.out.println("Não foi possível serrializar o objeto"+objeto);
        }
    }

    public static Object desserializar(String nomeArquivo){
        Object objeto = null;
        try{
            FileInputStream fis = new FileInputStream(nomeArquivo);
            ObjectInputStream ois = new ObjectInputStream(fis);

            objeto = ois.readObject();

            ois.close();
            fis.close();

        }catch (IOException e){
            System.out.print(e.getMessage());
            System.out.println("\nNão foi possível desserializar o objeto dentro do arquivo "+nomeArquivo);
        }catch (ClassNotFoundException e){
            System.out.println("Classe não encontrada no arquivo "+nomeArquivo);
        }
        return objeto;
    }


}
