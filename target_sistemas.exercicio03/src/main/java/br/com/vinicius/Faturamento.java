package br.com.vinicius;

public class Faturamento {
    int dia;
    double valor;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Faturamento{" +
                "dia=" + dia +
                ", valor=" + valor +
                '}';
    }
}
