import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CadastroNumeros cadastro = new CadastroNumeros();
        int op, num;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("Menu\n");
            System.out.println("1 - Inserir valores randomicamente | 2 - Consultar Posicao | 3 - Remover | 4 - Listar | 0 -Sair\n");
            System.out.println("Escolha o que vc deseja: ");
            op = scan.nextInt();

            switch (op){
                case 1:
                    for(int i = 0; i <= cadastro.pos; i++) {
                        cadastro.inserir(numRandomico());
                    }
                    break;
                case 2:
                    System.out.println("Informe o numero a ser consultado: ");
                    num = scan.nextInt();
                    System.out.println(cadastro.consultaPosicao(num));
                    break;
                case 3:
                    System.out.println("Informe o numero a ser removido: ");
                    num = scan.nextInt();
                    cadastro.remover(num);
                    break;
                case 4:
                    cadastro.listar();
                    System.out.println();
                    break;
            }
        }while(op != 0);

    }

    private static int numRandomico(){
        Random r = new Random();
        return r.nextInt(100);
    }


}
