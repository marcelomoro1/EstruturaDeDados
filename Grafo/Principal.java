import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String args[]){
        ArrayList<String> cidades = new ArrayList<>();
        ArrayList<String[]> conexoes = new ArrayList<>();

        File arquivo = new File("cidades.txt");
        if (!arquivo.exists()) { //Verificar caso o arquivo não exista
            System.err.println("Arquivo cidades.txt não encontrado.");
            return;
        }

        try {
            Scanner teclado = new Scanner(arquivo);
            while (teclado.hasNextLine()) { //Le todas as linhas do arquivo
                String linha = teclado.nextLine();
                String[] partes = linha.split("@"); //Separa pelos @
                if (partes.length == 2) { //Caso a linha tenha 2 partes, separa
                    String origem = partes[0].trim(); 
                    String destino = partes[1].trim();

                    if (!cidades.contains(origem)) {
                        cidades.add(origem); 
                    }
                    if (!cidades.contains(destino)) {
                        cidades.add(destino); 
                    }
                    conexoes.add(partes); 
                }
            }
            teclado.close();
        } catch (Exception e) {
            System.out.println("O arquivo não pôde ser lido: " + e.getMessage());
            return;
        }
        cidades.sort(null); 
        
        Grafo grafo_rs = new Grafo(cidades);

        for (String[] aresta : conexoes) { //Insere as conexoes entre as cidades
            grafo_rs.inserirArestaSimetrica(aresta[0], aresta[1]);
        }

        grafo_rs.show();

        String cidade = "Agudo";
        System.out.println("Grau da cidade de " + cidade + ": " + grafo_rs.mostrarGrau(cidade));
    }
}