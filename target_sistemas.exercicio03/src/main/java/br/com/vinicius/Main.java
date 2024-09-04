package br.com.vinicius;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String filePath = "C:\\Users\\vinip\\OneDrive\\Área de Trabalho\\ExerciciosTargetSistemas\\target_sistemas.exercicio03\\dados.json";
            File file = new File(filePath);

            if (!file.exists()) {
                System.err.println("Arquivo não encontrado: " + filePath);
            }

            List<Faturamento> faturamentoList = objectMapper.readValue(file, new TypeReference<>() {});

            double maiorValorFaturamento = 0.0;
            double menorValorFaturamento = Double.MAX_VALUE;;
            double mediaMensal = 0.0;
            double somaMensal = 0.0;
            int diasUteis = 0;
            int diaMesFaturamentoSuperiorMediaMensal = 0;

            List<Integer> diasAcimaDaMedia = new ArrayList<>();
            for (Faturamento faturamento : faturamentoList){
                if (faturamento.getValor() > 0){
                    diasUteis++;
                    somaMensal += faturamento.getValor();

                    if (faturamento.getValor() > maiorValorFaturamento){
                        maiorValorFaturamento = faturamento.getValor();
                    }

                    if (faturamento.getValor() < menorValorFaturamento){
                        menorValorFaturamento = faturamento.getValor();
                    }
                }
            }

            mediaMensal = somaMensal/diasUteis;

            for (Faturamento faturamento : faturamentoList) {
                if (faturamento.getValor() > mediaMensal) {
                    diasAcimaDaMedia.add(faturamento.getDia());
                }
            }

            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.println("MAIOR valor de faturamento ocorrido em um dia do mes: " + maiorValorFaturamento);
            System.out.println("MENOR valor de faturamento ocorrido em um dia do mes: " + menorValorFaturamento);
            System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " + diasAcimaDaMedia.size());
            System.out.println("Nos dias: " + diasAcimaDaMedia);
            System.out.println("---------------------------------------------------------------------------------------------------------------------");

        } catch (IOException e) {
            System.err.println("ERRO AO LER AQUIVO JSON: VERIFIQUE O PATH" + e.getMessage());
        }
    }
}