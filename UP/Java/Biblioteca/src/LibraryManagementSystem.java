import java.util.*;
public class LibraryManagementSystem {

    public static void main(String[] args) {
        
        System.out.println("Livraria");
        System.out.println("Estoque de Livros: ");
        Stock stock = new Stock();
        stock.stock();
        System.out.println("Digite 1 para emprestar algo ou 2 para devolver o livro");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        if (a == 1){
            System.out.println("Escolha o item para emprestar (1-Livro, 2-Revista, 3-Mídia Digital): ");
            int itemChoice = sc.nextInt();
            stock.borrowItem(itemChoice);
        }
        else if(a == 2){
            System.out.println("Escolha o item para devolver (1-Livro, 2-Revista, 3-Mídia Digital): ");
            int itemChoice = sc.nextInt();
            stock.returnItem(itemChoice);
        }

        sc.close();
    }
}
