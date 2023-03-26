package entities;

import java.util.ArrayList;
import java.util.List;

public class Agente {
    int id;
    String msg;

    private static Mensageiro mensageiro;

    private List<Mensage> eviadas;
    private List<Mensage> recebidas;

    public Agente(int id) {
        this.id = id;
        this.eviadas = new ArrayList<>();
        this.recebidas = new ArrayList<>();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static void setMensageiro(Mensageiro mensageiro) {
        Agente.mensageiro = mensageiro;
    }
    public Mensageiro getMensageiro(){
        return mensageiro;
    }
    public void sendTo(int idReceptor,String sendMsg){
        mensageiro.sendTo(this.id,idReceptor, sendMsg);

    }
    public void sendToAll( String sendMsg){
        Agente.mensageiro.sendAll(this.id,sendMsg);
    }
    public List<Mensage> getEnviadas(){
        return eviadas;
    }
    public List<Mensage> getRecebidas(){
        return recebidas;
    }
}