public class Node {
    private int chave;
    private Node proximo;

    public Node(int chave){
        this.chave = chave;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public Node getProximo() {        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
