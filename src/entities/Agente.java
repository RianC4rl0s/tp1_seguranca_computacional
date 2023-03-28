package entities;

import algoritmos.Algoritmo;

public class Agente {

  int id;
  private Algoritmo crypo;
  private String key;

  public Agente(int id, Algoritmo crypo, String key) {
    this.id = id;
    this.crypo = crypo;
    this.key = key;
  }

  public Mensage enviarMsg(String msg) {
    System.out.println();
    System.out.println("Agente " + id + " - encriptar msg >>>");
    System.out.println(msg);

    String msgCrypo = crypo.encripta(msg, key);

    System.out.println("Agente " + id + " - enviar msg >>>");
    System.out.println(msgCrypo);

    return new Mensage(id, msgCrypo);
  }

  public void receberMsg(Mensage m) {
    System.out.println();
    System.out.println(
      "Agente " + id + " - receber msg do Agente " + m.getIdAgente()
    );
    System.out.println("Agente " + id + " - receber msg >>>");
    System.out.println(m.getMsg());

    String msg = crypo.decripta(m.getMsg(), key);

    System.out.println("Agente " + id + " - descriptando msg >>>");
    System.out.println(msg);
    System.out.println();
  }
}
