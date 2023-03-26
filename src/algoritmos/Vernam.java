package algoritmos;

public class Vernam extends Algoritmo {

  public String encripta(String msg, String chave) {
    return operacao(msg, chave);
  }

  public String decripta(String msg, String chave) {
    return operacao(msg, chave);
  }

  private String operacao(String msg, String chave) {
    if (chave.length() < msg.length()) {
      chave = preenchimento(chave, msg.length());
    }

    String novaMsg = "";

    for (int i = 0; i < msg.length(); i++) {
      char caractere = msg.charAt(i);
      char caractereChave = chave.charAt(i);

      novaMsg += (char) (caractere ^ caractereChave);
    }

    return novaMsg;
  }
}
