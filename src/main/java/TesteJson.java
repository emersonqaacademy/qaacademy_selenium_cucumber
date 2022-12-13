import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TesteJson {

    static Map<String, String> dadosTesteMap = new HashMap<>();//Criacao do MAP para abrigar o Json
    static Gson gson = new Gson();//Biblioteca do google para fazer a manipulacao do json
    static Reader reader; //Leitura de arquivos do sistema para o java

    public static void main(String[] args) throws IOException {
        leituraJson();
        escritaArquivoJson();
    }

    public static void leituraJson() throws FileNotFoundException {
        reader = new FileReader("src/main/resources/massaTeste.json");//Faz a leitura do conteudo do arquivo especificado no caminho
        dadosTesteMap = gson.fromJson(reader, Map.class);

        System.out.println(dadosTesteMap.get("url2"));
        System.out.println(dadosTesteMap.get("produto2"));
        System.out.println(dadosTesteMap.get("valor2"));
    }

    public  static void escritaArquivoJson() throws IOException {
        dadosTesteMap.put("email", "teste3@teste.com.br");
        dadosTesteMap.put("senha", "teste12345");

        FileWriter writer = new FileWriter("src/main/resources/copia_massaTeste.json");
        gson.toJson(dadosTesteMap, writer);
        writer.flush();
        writer.close();
    }


}
