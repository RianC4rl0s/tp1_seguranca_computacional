package entities;

import java.util.List;

public class Mensageiro {

  private List<Agente> agentes;

  public Mensageiro(List<Agente> agentes) {
    this.agentes = agentes;
  }

  public void sendTo(Agente emissor, Agente receptor, String msg) {
    Mensage m = emissor.enviarMsg(msg);
    receptor.receberMsg(m);
  }

  public void sendAll(Agente emissor, String msg) {
    Mensage m = emissor.enviarMsg(msg);
    agentes.forEach(ag -> {
      if (ag.id != emissor.id) {
        ag.receberMsg(m);
      }
    });
  }
}
