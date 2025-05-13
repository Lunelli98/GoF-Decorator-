//Linha 12 a 18 classe horario de entrada == mudanca feita pos apresentacao
//Linha 21 a 29 classe horario de saida == mudanca feita pos apresentacao
//Mudancas de private class pra public feitas nas linhas 61 e 77 apos a apresentacao

public class Main {

    // Interface base
    interface Estacionamento {
        void registrar();
    }

    // Funcao entrada horario

    static class Estacionamento_entrada implements horarioEntrada {
            public String horarioEntrada;

            public horarioEntrada(string horarioEntrada){
                this.horarioEntrada = horarioEntrada;
            }
    }

    //Funcao saida horario

    static class Estacionamento_saida implements horarioSaida {
        public String horariosaida;

        public string horariosaida(string horariosaida){
            this.horariosaida = horariosaida;
        }
    }

    // Classe base concreta
    static class EstacionamentoBase implements Estacionamento {
        private String placaVeiculo;

        public EstacionamentoBase(String placaVeiculo) {
            this.placaVeiculo = placaVeiculo;
        }

        @Override
        public void registrar() {
            System.out.println("Veículo com placa " + placaVeiculo + " estacionado.");
        }
    }

    // Decorator abstrato
    static abstract class EstacionamentoDecorator implements Estacionamento {
        protected Estacionamento estacionamento;

        public EstacionamentoDecorator(Estacionamento estacionamento) {
            this.estacionamento = estacionamento;
        }

        @Override
        public void registrar() {
            estacionamento.registrar();
        }
    }

    // Decorator A - Horário de entrada
    static class DecoratorEntrada extends EstacionamentoDecorator {
        public String horarioEntrada;

        public DecoratorEntrada(Estacionamento estacionamento, String horarioEntrada) {
            super(estacionamento);
            this.horarioEntrada = horarioEntrada;
        }

        @Override
        public void registrar() {
            super.registrar();
            System.out.println("Horário de entrada: " + horarioEntrada);
        }
    }

    // Decorator B - Horário de saída
    static class DecoratorSaida extends EstacionamentoDecorator {
        public String horarioSaida;

        public DecoratorSaida(Estacionamento estacionamento, String horarioSaida) {
            super(estacionamento);
            this.horarioSaida = horarioSaida;
        }

        @Override
        public void registrar() {
            super.registrar();
            System.out.println("Horário de saída: " + horarioSaida);
        }
    }

    // Classe Principal
    public static void main(String[] args) {
        // Estacionamento simples
        Estacionamento estacionamento = new EstacionamentoBase("ABC-1234");

        // Adiciona horário de entrada
        estacionamento = new DecoratorEntrada(estacionamento, "08:30");

        // Adiciona horário de saída
        estacionamento = new DecoratorSaida(estacionamento, "17:45");

        // Executa tudo
        estacionamento.registrar();
    }

}