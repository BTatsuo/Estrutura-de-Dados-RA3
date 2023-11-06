import java.util.Random;
public class Tabela {
    private Node[] tabela;
    private int tamanho;
    private int hash;
    private int colissao;

    public Tabela(int tamanho,int conj,int hash,int seed){
        this.tabela = new Node[tamanho];
        this.tamanho = tamanho;
        this.hash = hash;
        this.colissao = 0;
        Random rd = new Random(seed);
        long start = System.nanoTime();
        for(int i= 0 ;i<conj;i++){
            inserir(rd.nextInt(999_999_999));
        }
        long end = System.nanoTime();
//        imprimir();
        System.out.println("Tempo Decorrido: "+(end-start)+" Nanosegundos");
        System.out.println("Número de Colisões: "+ getColissao());

    }
    public int getColissao(){
        return colissao;
    }

    public void inserir(int chave){
        inserir(chave,this.hash);
    }
    private void inserir(int chave,int hash){
        int i=-1;
        if (hash==1){
            i =h(chave);
        }else if(hash==2) {
            i = h2(chave);
        } else if(hash==3) {
            i = h3(chave);
        }
        Node novoNo = new Node(chave);
        if (tabela[i]!=null){
            Node temp = tabela[i];
            colissao++;
            while (true){

                if(temp.getProximo()==null){
                    temp.setProximo(novoNo);
                    break;
                }else{
                    if (chave<temp.getProximo().getChave()){
                        novoNo.setProximo(temp.getProximo());
                        temp.setProximo(novoNo);
                        break;
                    } else{
                      temp=temp.getProximo();
                      colissao++;
                    }
                }
            }
        } else{
            tabela[i]=novoNo;
        }
    }
    public void buscar(int chave){
        buscar(chave,this.hash);
    }

    private void buscar(int chave,int hash){
        String msg="";
        int comparacao=0;
        long start2 = System.nanoTime();
        int i=-1;
        if(hash==1){
            i = h(chave);
        } else if(hash==2) {
            i = h2(chave);
        } else if(hash==3) {
            i = h3(chave);
        }
        Node temp=tabela[i];
        while (temp!=null){
            if(temp.getChave()==chave){
                msg ="Encontrado";
                break;
            }else{
                temp=temp.getProximo();
                comparacao++;
            }
        }
        if(temp==null) {
            msg ="Não Encontrado";
        }
        long end2 = System.nanoTime();
        System.out.printf("\n%d %s! Tempo decorrido: "+ (end2- start2)+" Nanosegundos, Número de Comparações: %d" ,chave,msg,comparacao);
    }

    private int h(int chave){
        return chave%tamanho;
    }
    private int h2(int chave){
        int a = chave/100_000;
        chave = chave%100_000;
        int c =chave;
        return (a+c)%tamanho;
    }
    private int h3(int chave){
        double a = ((0.63274838*chave)%1)*tamanho;
        return (int) a;
    }


    public void imprimir(){
        System.out.println("Posição |   Chave   |  Proximo");
        for(int i = 0;i< tamanho;i++){
            if(tabela[i]==null){
                System.out.printf(" %6d | %9s\n",i,"Vazio");
            }else{
                String msg = String.format(" %6d | %09d",i,tabela[i].getChave());
                Node temp = tabela[i];
                while(temp.getProximo()!=null){
                    temp=temp.getProximo();
                    msg += String.format(" -> %09d",temp.getChave());
                }
                System.out.println(msg);
            }
        }
        System.out.println("Nuúmero de Colissões: "+colissao);
    }

}
