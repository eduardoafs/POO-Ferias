package poo.restaurante.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestPrato {

    public static void main(String[] args) {
        // Popular o banco dos pratos a partir do arquivo
        Scanner s = new Scanner(System.in);
        String name;
        Double preco;
        List<String> list;
        Prato p;
        PratoDAO dao = PratoDAO.getInstance();
        while(true) {
            name = s.next();
            if (name.compareTo("-1")==0) break;
            preco = Double.valueOf(s.next());
            p = new Prato(name, preco);
            dao.save(p);
        }

        System.out.println("Cardapio");
        for(Prato pr : dao.cardapio())
            System.out.println(pr.getId() + " " + pr.getNome()+ " " + pr.getPreco());
    }
}
