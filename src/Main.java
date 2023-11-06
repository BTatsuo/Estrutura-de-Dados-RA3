public class Main {
    public static void main(String[] args) {
        //Parte 1 teste de inserção
        int seed = 81; //{24,33,12,50,81}
        int tamanho = 200_000;//{10_000,25_000,50_000;100_000,200_000}
        int[] conjuntos = {20_000,100_000,500_000,1_000_000,5_000_000};

        for(int conj:conjuntos){
            System.out.println("\nTamanho: "+tamanho+" Conjunto: "+conj+" seed: "+seed);
            Tabela tabela1 = new Tabela(tamanho,conj,1,seed);
            Tabela tabela2 = new Tabela(tamanho,conj,2,seed);
            Tabela tabela3 = new Tabela(tamanho,conj,3,seed);
        }
        //Parte 2 teste de busca
        Tabela tabela1 = new Tabela(tamanho,5_000_000,1,seed);
        Tabela tabela2 = new Tabela(tamanho,5_000_000,2,seed);
        Tabela tabela3 = new Tabela(tamanho,5_000_000,3,seed);

        tabela1.buscar(345396281);
        tabela1.buscar(987765423);
        tabela1.buscar(117321717);
        tabela1.buscar(618692254);
        tabela1.buscar(10899880);
        System.out.println();
        tabela2.buscar(345396281);
        tabela2.buscar(987765423);
        tabela2.buscar(117321717);
        tabela2.buscar(618692254);
        tabela2.buscar(10899880);
        System.out.println();
        tabela3.buscar(345396281);
        tabela3.buscar(987765423);
        tabela3.buscar(117321717);
        tabela3.buscar(618692254);
        tabela3.buscar(10899880);

        }
}
