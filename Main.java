package ex6;

package com.meuapp;

import com.meuapp.veiculoeletrico.VeiculoEletrico;
import com.meuapp.uf.UF;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VeiculoEletrico veiculo = new VeiculoEletrico("Model S", "Tesla", 600, 250, 80000);
        UF uf = new UF("São Paulo", "SP", "São Paulo", "(23.5505, 46.6333)", 12300000, 248209.426, 495.39, new String[]{"São Paulo", "Guarulhos", "Campinas"});

        System.out.print("Escolha o formato de saída (XML, JSON ou YAML): ");
        String formatoSaida = scanner.nextLine().toLowerCase();

        
        String resultado = "";
        if ("xml".equals(formatoSaida)) {
            resultado = serializarXml(veiculo, "VeiculoEletrico") + "\n" + serializarXml(uf, "UF");
        } else if ("json".equals(formatoSaida)) {
            resultado = serializarJson(veiculo) + "\n" + serializarJson(uf);
        } else if ("yaml".equals(formatoSaida)) {
            resultado = serializarYaml(veiculo) + "\n" + serializarYaml(uf);
        } else {
            resultado = "Formato de saída inválido.";
        }

        System.out.println(resultado);
    }

    // Função para serializar objetos em XML
    private static String serializarXml(Object objeto, String nomeElemento) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(objeto.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(objeto, writer);
        return writer.toString();
    }

    // Função para serializar objetos em JSON
    private static String serializarJson(Object objeto) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
    }

    private static String serializarYaml(Object objeto) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory().disable(DumperOptions.Feature.USE_NATIVE_TYPE_ID));
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
