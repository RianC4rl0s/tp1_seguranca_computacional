package algoritmos;

public abstract class Algoritmo {

  public Algoritmo() {}

  public abstract String encripta(String msg, String chave);

  public abstract String decripta(String msg, String chave);

  protected String preenchimento(String origem, int tamMsg) {
    String destino = origem;
    for (int i = origem.length(); i < tamMsg; i++) {
      destino += origem.charAt(i % origem.length());
    }
    return destino;
  }

  protected int chaveInt(char chave) {
    if (chave >= 97 && chave <= 122) {
      return chave - 97;
    } else if (chave >= 65 && chave <= 90) {
      return chave - 65;
    } else {
      return 0;
    }
  }
}
