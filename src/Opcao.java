/**
 * Esta e a classe que implementa toda a logica das Opcoes das {@link Missao}s.
 */
public class Opcao extends OpcaoAbstrata {

    public Opcao(String texto, Recursos custo, Recursos ganho) {
        super(texto, custo, ganho);
    }

    @Override
    public String toString() {
        String vai_gastar = "Vai gastar: " + getCusto().getEnergia() + " energia; " + getCusto().getPeixe() + " peixe; " + getCusto().getMoral() + " moral; "+ getCusto().getVida_da_tripulacao() + " vida da tripulaçao; ";
        String vai_receber = "Vai receber: " + getGanho().getEnergia() + " energia; " + getGanho().getPeixe() + " peixe; " + getCusto().getMoral() + " moral; "+ getGanho().getVida_da_tripulacao() + " vida da tripulaçao; ";

        return "<html>" + vai_gastar + "<br>" + vai_receber + "</html>";
    }
}
