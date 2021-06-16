import java.time.LocalDate;

public class Veiculo {

    private final TipoDeVeiculo tipoDeVeiculo;
    private final Motor motor;
    private Motorista motoristaAtual;

    public Veiculo(TipoDeVeiculo tipoDeVeiculo, Motor motor) {
        if (tipoDeVeiculo == null)
            throw new NullPointerException("Precisa passar um tipo de veiculo!!");
        this.tipoDeVeiculo = tipoDeVeiculo;
        this.motor = motor;
    }

    public TipoDeVeiculo getTipoDeVeiculo() {
        return tipoDeVeiculo;
    }

    public Motor getMotor() {
        return motor;
    }

    public Motorista getMotoristaAtual() {
        return motoristaAtual;
    }

    public void dirigir(Motorista motorista) /*Code smell conditional statements, a sequencia de If poderia ser trocado por polimorfismo */ {
        if (motorista == null) {
            throw new NullPointerException("Um carro não se dirige sozinho... motorista é nulo!");
        }

        motoristaAtual = motorista;


/* Princípio Aberto-Fechado. A sequencia de If quebra o principio pois se um novo veiculo sem motor for adicionado, o codigo precisa ser modificado */
        if (tipoDeVeiculo == TipoDeVeiculo.BICICLETA) {
            System.out.println("bicicleta sendo pilotada pelo " + motorista.getNome());
        } else {
            LocalDate vencimentoCNH = motorista.getVencimentoCNH();
            if (vencimentoCNH.isBefore(LocalDate.now())) {
                throw new InfracaoException(motorista.getNome() + " com CNH vencida!");
            }

            motor.ligar();
            System.out.println(tipoDeVeiculo + " sendo dirigido pelo " + motorista.getNome());
        }
    }

    public void estacionar() {
        motor.desligar();
        motoristaAtual = null;
        System.out.println(tipoDeVeiculo + " estacionado");
    }

}