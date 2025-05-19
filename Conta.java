public abstract class Conta {
    protected String numero;
    protected String titular;
    protected double saldo;

    public Conta(String numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public abstract void sacar(double valor);

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }
}

// Subclasses das contas
class ContaCorrente extends Conta {
    public ContaCorrente(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }
}

class ContaSalario extends Conta {
    public ContaSalario(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }
}

class ContaInvestimento extends Conta {
    public ContaInvestimento(String numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }
}

public class BancoMain {
    public static void main(String[] args) {
        Conta cc = new ContaCorrente("001", "João", 100);
        Conta cp = new ContaPoupanca("002", "Maria", 50);

        cc.sacar(150); // Deve acionar o aspecto
        cp.sacar(30);  // Não aciona o aspecto
    }
}

aspect VerificacaoSaldoAspect {
    pointcut saque(): execution(void Conta+.sacar(double));

    before(): saque() {
        Conta conta = (Conta) thisJoinPoint.getTarget();
        Object[] args = thisJoinPoint.getArgs();
        double valor = (double) args[0];

        if (conta.getSaldo() < valor) {
            System.out.println("[LOG] SALDO INSUFICIENTE: Tentativa de saque de R$" + valor +
                " na conta " + conta.getNumero() + " de " + conta.getTitular());
        }
    }
}
