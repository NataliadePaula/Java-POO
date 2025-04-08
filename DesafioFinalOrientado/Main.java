package ListasEColeçoes.DesafioFinalOrientado;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner limite = new Scanner(System.in);
        System.out.println("Digite o limite do cartão.");
        var cartao = new CartaoCredito(limite.nextInt());
        int escolha = 1;

        while (escolha!=0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Produto desejado:");
            String nome = scanner.nextLine();

            System.out.println("Valor do produto:");
            double valor = scanner.nextDouble();

            var compra = new Compra(nome, valor);
            boolean compraEfetivada = cartao.lancaCompra(compra);



            if(compraEfetivada){
                System.out.println("Compra realizada!");
                System.out.println("Digite 1 para nova compra ou 0 para sair");
                escolha = scanner.nextInt();
            }

        }
        System.out.println("********************");
        System.out.println("COMPRAS REALIZADAS \n");
        Collections.sort(cartao.getCompras());
        for(Compra item: cartao.getCompras()){
            System.out.println("Produto: "+item.getNomeProduto()+", valor: R$"+item.getValor());
        }
        System.out.println("Saldo restante: R$"+cartao.getSaldo());
    }


}
