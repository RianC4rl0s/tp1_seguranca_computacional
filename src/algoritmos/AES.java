package algoritmos;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES extends Algoritmo {

  private KeyGenerator keyGenerator;
  private SecretKey chave;
  private IvParameterSpec vi;
  private String mensagem;
  private String mensagemCifrada;

  public String keyGen(int size) {
    try {
      keyGenerator = KeyGenerator.getInstance("AES");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    keyGenerator.init(size);
    chave = keyGenerator.generateKey();
    return Base64.getEncoder().encodeToString(chave.getEncoded());
    // return chave;
  }

  public String encripta(String msg, String key) {
    byte[] decodedKey = Base64.getDecoder().decode(key);
    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

    //byte[] bytesVI;
    byte[] bytesMensagemCifrada;
    Cipher cifrador;

    mensagem = msg;
    try {
      cifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");
      /*bytesVI = keyGenerator
          .generateKey()
          .getEncoded();*/
      //vi = new IvParameterSpec(bytesVI);
      vi = gerarVI();
      cifrador.init(Cipher.ENCRYPT_MODE, originalKey, vi);
      bytesMensagemCifrada = cifrador.doFinal(mensagem.getBytes());
      mensagemCifrada = codificar(bytesMensagemCifrada);
      System.out.println(
          ">> Mensagem cifrada = " + mensagemCifrada);
    } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
      e.printStackTrace();
    } catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException | BadPaddingException e) {
      e.printStackTrace();
    }
    return mensagemCifrada;
  }
  public String decripta(String msg, String key) {
    byte[] decodedKey = Base64.getDecoder().decode(key);
    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

    byte[] bytesMensagemCifrada = decodificar(msg);
    Cipher decriptador;
    try {
      decriptador = Cipher.getInstance("AES/CBC/PKCS5Padding");
      decriptador
          .init(Cipher.DECRYPT_MODE, originalKey, vi);
      byte[] bytesMensagemDecifrada = decriptador.doFinal(bytesMensagemCifrada);
      String mensagemDecifrada = new String(bytesMensagemDecifrada);
      mensagem = mensagemDecifrada;

    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
        | InvalidAlgorithmParameterException e) {
      e.printStackTrace();
    } catch (IllegalBlockSizeException e) {
      e.printStackTrace();
    } catch (BadPaddingException e) {
      e.printStackTrace();
    }
    return mensagem;
  }

  private String codificar(byte[] bytesCifrados) {
    String mensagemCodificada = Base64
        .getEncoder()
        .encodeToString(bytesCifrados);
    return mensagemCodificada;
  }

  private byte[] decodificar(String mensagemCodificada) {
    byte[] bytesCifrados = Base64
        .getDecoder()
        .decode(mensagemCodificada);
    return bytesCifrados;
  }
  public static IvParameterSpec gerarVI() {
    byte[] vi = new byte[16];
    new SecureRandom().nextBytes(vi);
    return new IvParameterSpec(vi);
   
   }
}
