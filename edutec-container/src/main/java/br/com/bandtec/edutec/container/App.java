/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.edutec.container;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;

/**
 *
 * @author rrpae
 */
public class App {
    public static String byteCountConvert(long bytes) {
        long absB = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
        if (absB < 1024) {
            return bytes + " B";
        }
        long value = absB;
        CharacterIterator ci = new StringCharacterIterator("KMGTPE");
        for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
            value >>= 10;
            ci.next();
        }
        value *= Long.signum(bytes);
        return String.format("%.1f %ciB", value / 1024.0, ci.current());
    }

    public static void main(String[] args) {
        Looca looca = new Looca();
    
        
     
                
        System.out.println("Processador: " + looca.getProcessador().getNome() );
        System.out.println("Uso de processador: " + looca.getProcessador().getUso());
        System.out.println("Sistema Operacional: " + looca.getSistema().getSistemaOperacional());
        System.out.println("Memoria Ram Disponivel: " +    (String.valueOf(byteCountConvert(looca.getMemoria().getDisponivel())))  );
        System.out.println("Memoria Ram em Uso: " +(String.valueOf(byteCountConvert(looca.getMemoria().getEmUso())))  );
        System.out.println("Memoria Ram Total: " + (String.valueOf(byteCountConvert(looca.getMemoria().getTotal()))) );
        //Criação do gerenciador
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();

//Obtendo lista de discos a partir do getter
        List<Disco> discos = grupoDeDiscos.getDiscos();
        for (Disco disco : discos) {
            System.out.println( String.format("\nNome " + disco.getNome() + "\nModelo: " + disco.getModelo() + "\nTamanho: " + byteCountConvert(disco.getTamanho()) + "\n"));
        }
        

    }
}
