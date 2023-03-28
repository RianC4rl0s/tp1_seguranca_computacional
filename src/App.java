import algoritmos.AES;
import algoritmos.Algoritmo;
import algoritmos.Vernam;
import algoritmos.Vigenere;
import entities.Agente;
import entities.Mensageiro;
import java.util.Arrays;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in, "CP850");

    // ============ Instanciação ===================

    // ------------- Algoritmos --------------------
    //Algoritmo crypo = new Vernam();
    //Algoritmo crypo = new Vigenere();
    Algoritmo crypo = new AES();

    // ------------- Chave -------------------------
    // String chave = "casasamarelas";
    String chave = AES.keyGen(256);

    // ------------- Agentes -----------------------
    Agente agente1 = new Agente(0, crypo, chave);
    Agente agente2 = new Agente(1, crypo, chave);
    Agente agente3 = new Agente(2, crypo, chave);

    // ------------- Mensageiro --------------------
    Mensageiro mensageiro = new Mensageiro(
      Arrays.asList(agente1, agente2, agente3)
    );

    // =============================================

    // ============ Execução =======================

    // ------------ Envio 1 ------------------------
    String msg = s.nextLine();
    mensageiro.sendTo(agente1, agente2, msg);

    // ------------ Envio 2 ------------------------
    msg = s.nextLine();
    mensageiro.sendTo(agente1, agente3, msg);

    // ------------ Envio 3 ------------------------
    msg = s.nextLine();
    mensageiro.sendAll(agente3, msg);

    // =============================================

    s.close();
  }
}
