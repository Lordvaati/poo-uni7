import java.time.LocalDate;

public class Motorista {

    private final String nome;
    private LocalDate vencimentoCNH;
    private Veiculo veiculoAtual;

    public Motorista(String nome, LocalDate vencimentoCNH) {
        this.nome = nome;
        this.vencimentoCNH = vencimentoCNH;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getVencimentoCNH() {
        return vencimentoCNH;
    }

    public void renovarCNH()/*Princípio da Responsabilidade Única- poderia se criar uma nova Classe chama Detran que ficaria responsabilizada por renovar a CNH quando o morista precisar */ {
        vencimentoCNH = vencimentoCNH.plusYears(5);
    }

    public void dirigir(Veiculo veiculo) {
        veiculo.dirigir(this);
        veiculoAtual = veiculo;
    }

    public void estacionar() {
        if (veiculoAtual == null)
            throw new NullPointerException("não tem veiculo pra estacionar pq não estava dirigindo...");
        veiculoAtual.estacionar();
        veiculoAtual = null;
    }

    public void melhorarMotor()/*Princípio da Responsabilidade Única- poderia se criar uma nova Classe chamada Mecanico que ficaria responsabilizado por melhorar o motor quando o morista precisar */ {
        if (veiculoAtual == null)
            throw new NullPointerException("não tem veiculo pra melhorar o motor...");

        Motor motor = veiculoAtual.getMotor();
        int producaoDeCarbono = motor.getProducaoDeCarbono();
        producaoDeCarbono = producaoDeCarbono - 2;
        motor.setProducaoDeCarbono(producaoDeCarbono);
    }

}