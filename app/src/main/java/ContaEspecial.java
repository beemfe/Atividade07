public class ContaEspecial extends ContaBancaria {
    private float limite;

    public ContaEspecial(String cliente, int num_conta, float saldo, float limite) {
        super(cliente, num_conta, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(float valor) {
        if (saldo - valor >= -limite) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor do saque excede o limite disponível.");
        }
    }
}