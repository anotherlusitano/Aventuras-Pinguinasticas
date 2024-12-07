/**
 * Esta e a classe que implementa toda a logica dos Recursos.
 * <br> <br>
 * Esta classe implementa os seguintes atributos: <br>
 * {@link Recursos#energia} - e a energia que o {@link Barco} precisa para andar <br>
 * {@link Recursos#peixe} - e a comida que os tripulantes do {@link Barco} vao comer <br>
 * {@link Recursos#moral} - e a moral que os tripulantes do {@link Barco} tem para continuar <br>
 * {@link Recursos#moral} - e a vida dos tripulantes do {@link Barco}
 */
public class Recursos {
    /** E a energia que faz os jogadores poderem se mover no barco */
    private int energia;

    /** E os suprimentos, aquilo que faz a tripulacao ficar viva */
    private int peixe;

    /** E a moral da tripulacao, faz que ela nao te abandone */
    private int moral;

    /** E a vida da tripulacao */
    private int vida_da_tripulacao;

    public Recursos(int energia, int peixe, int moral, int vida_da_tripulacao) {
        this.energia = energia;
        this.peixe = peixe;
        this.moral = moral;
        this.vida_da_tripulacao = vida_da_tripulacao;
    }

    /// Vai substrair com os {@link Recursos} que receber
    public void subtrair(Recursos recursos_para_subtrair) {
        this.energia -= recursos_para_subtrair.getEnergia();
        this.peixe -= recursos_para_subtrair.getPeixe();
        this.moral -= recursos_para_subtrair.getMoral();
        this.vida_da_tripulacao -= recursos_para_subtrair.getVida_da_tripulacao();
    }

    /// Vai somar com os {@link Recursos} que receber
    public void somar(Recursos recursos_para_somar) {
        this.energia = Math.min(this.energia + recursos_para_somar.getEnergia(), 100);
        this.peixe = Math.min(this.peixe + recursos_para_somar.getPeixe(), 100);
        this.moral = Math.min(this.moral + recursos_para_somar.getMoral(), 100);
        this.vida_da_tripulacao = Math.min(this.vida_da_tripulacao + recursos_para_somar.getVida_da_tripulacao(), 100);
    }

    @Override
    public String toString() {
        return "Energia: " + this.energia + "\nPeixe: " + this.peixe + "\nMoral:" + this.moral + "\nVida da Tripulaçao: "+ this.vida_da_tripulacao;
    }

    public int getPeixe() {
        return peixe;
    }

    public void setPeixe(int peixe) {
        this.peixe = peixe;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public int getVida_da_tripulacao() {
        return vida_da_tripulacao;
    }

    public void setVida_da_tripulacao(int vida_da_tripulacao) {
        this.vida_da_tripulacao = vida_da_tripulacao;
    }
}
