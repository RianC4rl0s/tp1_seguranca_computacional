import java.util.Arrays;
import java.util.Scanner;

import algoritmos.Algoritmo;
import algoritmos.Vigenere;
import entities.Agente;
import entities.Mensageiro;
import algoritmos.AES;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in, "CP850");

    // mensageiro
    Mensageiro mensageiro = new Mensageiro();

    // Agente emissor = new Agente(0);
    // Agente receptor = new Agente(1);

    Agente agente1 = new Agente(0);
    Agente agente2 = new Agente(1);
    Agente agente3 = new Agente(2);

    Agente.setMensageiro(mensageiro);
    mensageiro.setAgentes(Arrays.asList(agente1, agente2, agente3));

    // Algoritmo algoritmo = new Vigenere();
    // Algoritmo algoritmo = new Vernam();
    AES algoritmo = new AES();
    // String chave = "CasaAzul";
    String chave = algoritmo.keyGen(256);

    System.out.print("envio >> ");
    String msg = s.nextLine();
    System.out.println(msg);
    // emissor.setMsg(msg);

    /*------- Envio  --------------- */

    agente1.sendTo(1, msg);
    agente1.sendToAll("enviado para todos pelos 0");
    agente3.sendToAll("Emitido para todos pelo 2");
    // String msgEncriptada = algoritmo.encripta(emissor.getMsg(), chave);
    // System.out.println("msg encriptada >> " + msgEncriptada);

    /*------------------------------ */
    System.out.println("\n\n");
    System.out.println("===============================================");
    /*-------- Recebimento  -------- */
    // System.out.println(agente2.getMsg());
    System.out.println("Envidas pelo agente id = 0 \n");
    agente1.getEnviadas().forEach(e -> {
      System.out.println("Enviado para >>> " + e.getIdAgente() + " mensagem: " + e.getMsg());
    });
    System.out.println("===============================================");
    System.out.println("Envidas pelo agente id = 2 \n");
    agente3.getEnviadas().forEach(e -> {
      System.out.println("Enviado para >>> " + e.getIdAgente() + " mensagem: " + e.getMsg());
    });
    System.out.println("===============================================");
    System.out.println("Recebidas id agente = 0 \n");
    agente1.getRecebidas().forEach(e -> {
      System.out.println("Recebidas de >>> " + e.getIdAgente() + " mensagem: " + e.getMsg());
    });
    System.out.println("===============================================");
    System.out.println("Recebidas id agente = 1 \n");
    agente2.getRecebidas().forEach(e -> {
      System.out.println("Recebidas de >>> " + e.getIdAgente() + " mensagem: " + e.getMsg());
    });
    System.out.println("===============================================");
    System.out.println("Recebidas  id agente = 2 \n");
    agente3.getRecebidas().forEach(e -> {
      System.out.println("Recebidas de >>> " + e.getIdAgente() + " mensagem: " + e.getMsg());
    });
    // String msgDecriptada = algoritmo.decripta(msgEncriptada, chave);
    // receptor.setMsg(msgDecriptada);

    /*------------------------------ */

    // System.out.println("recebimento >> " + receptor.getMsg());

    s.close();
  }
}
