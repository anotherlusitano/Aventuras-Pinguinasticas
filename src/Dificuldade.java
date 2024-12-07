/**
 * Serve para medir qual a dificuldade de uma dada classe, por exemplo: <br>
 * Se a {@link Ilha} tiver uma dificuldade <i>FACIL</i>, a {@link Missao} e as {@link Opcao}s tambem vao ter. <br>
 * O que vai fazer que gaste menos e ganhe mais {@link Recursos} ao fazer a missao.
 */
public enum Dificuldade {
    /// Faz que gaste mais e receba menos {@link Recursos}
    DIFICIL,
    /// Faz que gaste e receba {@link Recursos} moderadamente
    MEDIO,
    /// Faz que gaste menos e receba mais {@link Recursos}
    FACIL
}
