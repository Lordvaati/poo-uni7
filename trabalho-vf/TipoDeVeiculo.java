public enum TipoDeVeiculo {
/* Princípio da Segregação da Interface — Da maneira que está implementada bicleta é obrigada a chamar motor, mesmo que a maioria das bicicletas não tem motor, então cada Tipo de viculo deve ser classes unicas */
/* Princípio Aberto-Fechado - toda vez que um novo veiculo for adicionado a classe vai ser mudada*/
  CARRO, 
  CARRO_ELETRICO,
  BICICLETA

}