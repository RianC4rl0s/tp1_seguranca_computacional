package entities;
import java.util.List;

public class Mensageiro {
    private List<Agente> agentes;

    public Mensageiro(){
        //Agente.setMensageiro(this);
    }
    public void setAgentes(List<Agente> agentes) {
        this.agentes = agentes;
    }

    public void sendTo(int idEmissor,int idReceptor, String msg){
        agentes.forEach(e ->{
            if(e.id == idReceptor){
                e.setMsg(msg);
                e.getRecebidas().add(new Mensage(idEmissor, msg));
            }
            if(e.id == idEmissor){
                e.getEnviadas().add(new Mensage(idReceptor, msg));
            }
        });
    }
    public void sendAll(int idEmissor,String msg){
        agentes.forEach(e->{
            if(e.id != idEmissor){
                e.setMsg(msg);
                e.getRecebidas().add(new Mensage(idEmissor, msg));
            }else if(e.id == idEmissor){
                e.getEnviadas().add(new Mensage( -1, msg));
            }
            
        });
    }
}
