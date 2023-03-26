package entities;

public class Mensage {
    private int idAgente;
    

    private String msg;

   
    public Mensage(int idAgente, String msg){
        this.idAgente = idAgente;
        this.msg = msg;
    }
    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
