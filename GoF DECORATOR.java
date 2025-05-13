public class Main {

    // Interface base
    interface Estacionamento {
        void registrar();
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
        private String horarioEntrada;

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
        private String horarioSaida;

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