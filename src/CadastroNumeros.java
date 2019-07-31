import java.util.Random;

public class CadastroNumeros {
    int []vet;
    int pos = 0;

    public CadastroNumeros(){
        this.vet = new int[20];
    }
    public void inserir(int num){
        if(!verificaArrayCheio()){
            if(vet[0] == 0){
                vet[0] = num;
                pos++;
            }else if(consultaPosicao(num) == -1){
                if(num < vet[0]){ // Caso seja menor que todos os outros numeros
                    for(int i = pos; i > 0; i--){
                        vet[i] = vet[i-1];
                    }
                    vet[0] = num;
                }else if(num > vet[pos-1]) { // Caso seja maior que todos os outros numeros
                    vet[pos] = num;
                }else if(localizaPosInsercao(num) != -1) { // Caso seja no meio
                    int x = localizaPosInsercao(num);
                    for(int i = pos; i > x; i--){
                        vet[i] = vet[i-1];
                    }
                    vet[x] = num;
                }
                pos++;
            }else{
                System.out.println("Numero ja existe");
                inserir(num+1);
            }
        }else{
            System.out.println("Array cheio");
        }

    }

    public int consultaPosicao(int num) {
        for(int i = 0; i < pos; i++){
            if(num == vet[i]){
                return i;
            }
        }

        return -1;
    }

    public int localizaPosInsercao(int num){
        int posi = -1;
        for(int i = 1; i < pos; i++){
            if(num < vet[i]){
               posi = i;
               break;
            }
        }
        return posi;
    }

    public void listar(){
        for(int i = 0; i < pos; i++){
            System.out.print(vet[i] + " ");
        }
    }

    public void remover(int num){
        int posicao = consultaPosicao(num);
        if(posicao != -1) {
            for (int i = posicao; i < pos; i++) {
                vet[i] = vet[i + 1];
            }
            pos--;
        }else{
            System.out.println("Esse nome nao esta inserido");
        }
    }

    private boolean verificaArrayCheio(){
        if(pos == 20){
            return true;
        }
        return false;
    }


}
