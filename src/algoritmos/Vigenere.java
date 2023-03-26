package algoritmos;

public class Vigenere extends Algoritmo {

  public String encripta(String msg, String chave) {
    if (chave.length() < msg.length()) {
      chave = preenchimento(chave, msg.length());
    }

    String novaMsg = "";

    for (int i = 0; i < msg.length(); i++) {
      char letra = msg.charAt(i);
      char novaLetra;

      if (letra >= 97 && letra <= 122) {
        novaLetra = (char) ((letra - 97 + chaveInt(chave.charAt(i))) % 26 + 97);
      } else if (letra >= 65 && letra <= 90) {
        novaLetra = (char) ((letra - 65 + chaveInt(chave.charAt(i))) % 26 + 65);
      } else {
        novaLetra = letra;
      }

      novaMsg += novaLetra;
    }

    return novaMsg;
  }

  public String decripta(String msg, String chave) {
    if (chave.length() < msg.length()) {
      chave = preenchimento(chave, msg.length());
    }

    String novaMsg = "";

    for (int i = 0; i < msg.length(); i++) {
      char letra = msg.charAt(i);
      char novaLetra;

      if (letra >= 97 && letra <= 122) {
        novaLetra =
          (char) ((letra - 97 + (26 - chaveInt(chave.charAt(i)))) % 26 + 97);
      } else if (letra >= 65 && letra <= 90) {
        novaLetra =
          (char) ((letra - 65 + (26 - chaveInt(chave.charAt(i)))) % 26 + 65);
      } else {
        novaLetra = letra;
      }

      novaMsg += novaLetra;
    }

    return novaMsg;
  }
}
