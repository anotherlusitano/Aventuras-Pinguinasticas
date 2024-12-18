/**
 * Esta é a classe que implementa toda a lógica dos Recursos.
 */
public class Recursos extends RecursosAbstratos {
    public Recursos(int energia, int peixe, int moral, int vida_da_tripulacao) {
        super(energia, peixe, moral, vida_da_tripulacao);
    }

    /// Vai subtrair com os {@link Recursos} que receber
    @Override
    public void subtrair(Recursos recursos_para_subtrair) {
        setEnergia(getEnergia() - recursos_para_subtrair.getEnergia());
        setPeixe(getPeixe() - recursos_para_subtrair.getPeixe());
        setMoral(getMoral() - recursos_para_subtrair.getMoral());
        setVida_da_tripulacao(getVida_da_tripulacao() - recursos_para_subtrair.getVida_da_tripulacao());
    }

    /// Vai somar com os {@link Recursos} que receber
    @Override
    public void somar(Recursos recursos_para_somar) {
        setEnergia(Math.min(getEnergia() + recursos_para_somar.getEnergia(), 100));
        setPeixe(Math.min(getPeixe() + recursos_para_somar.getPeixe(), 100));
        setMoral(Math.min(getMoral() + recursos_para_somar.getMoral(), 100));
        setVida_da_tripulacao(Math.min(getVida_da_tripulacao() + recursos_para_somar.getVida_da_tripulacao(), 100));
    }

    @Override
    public String toString() {
        return "Energia: " + getEnergia() + "\nPeixe: " + getPeixe() + "\nMoral:" + getMoral() + "\nVida da Tripulação: "+ getVida_da_tripulacao();
    }
}
