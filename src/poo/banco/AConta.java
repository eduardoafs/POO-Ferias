package poo.banco;

public abstract class AConta {
    private String titular;

    public abstract boolean saque(Integer valor);
    public abstract Integer saldo();
    public abstract boolean transferencia(Integer idd, Integer valor);
    public abstract boolean deposito(Integer valor);

    protected void setTitular(String nome) {
        this.titular = nome;
    }

    public String titular() {
        return this.titular;
    }
}
