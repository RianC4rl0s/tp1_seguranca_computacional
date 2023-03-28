package entities;

public class Mensage {

  private int idAgente;
  private String msg;

  public Mensage(int idAgente, String msg) {
    this.idAgente = idAgente;
    this.msg = msg;
  }

  public int getIdAgente() {
    return idAgente;
  }

  public String getMsg() {
    return msg;
  }
}
