package main;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        double nota = lerValorDouble("Informe a nota [0, 10]", 0, 10);
        JOptionPane.showMessageDialog(null, "Nota informada: " + nota);

        double salario = lerValorDouble("Informe o salário", 0, Double.MAX_VALUE);
        JOptionPane.showMessageDialog(null, "Salário informado: " + salario);

        String sexo = lerSexo();
        JOptionPane.showMessageDialog(null, "Sexo informado: " + sexo);

        int idade = lerValorInt("Informe a idade", 6, 150);
        JOptionPane.showMessageDialog(null, "Idade informada: " + idade);
    }

    private static double lerValorDouble(String mensagem, double min, double max) {
        String resp;
        double valor = 0;
        boolean repetir;

        do {
            resp = JOptionPane.showInputDialog(mensagem, 0);
            verificarCancelar(resp);
            try {
                valor = Double.parseDouble(resp);
                repetir = valor < min || valor > max;
            } catch (NumberFormatException e) {
                System.err.println("ERRO: número não identificado.");
                repetir = true;
            }
        } while (repetir);

        return valor;
    }

    private static int lerValorInt(String mensagem, int min, int max) {
        String resp;
        int valor = 0;
        boolean repetir;

        do {
            resp = JOptionPane.showInputDialog(mensagem, 0);
            verificarCancelar(resp);
            try {
                valor = Integer.parseInt(resp);
                repetir = valor < min || valor > max;
            } catch (NumberFormatException e) {
                System.err.println("ERRO: número não identificado.");
                repetir = true;
            }
        } while (repetir);

        return valor;
    }

    private static String lerSexo() {
        String sexo;
        boolean repetir;

        do {
            sexo = JOptionPane.showInputDialog("Informe o sexo");
            verificarCancelar(sexo);
            repetir = !(sexo.equalsIgnoreCase("f") || sexo.equalsIgnoreCase("m"));
            if (repetir) {
                System.err.println("ERRO: sexo não identificado.");
            }
        } while (repetir);

        return sexo;
    }

    private static void verificarCancelar(String resp) {
        if (resp == null) {
            System.err.println("Aviso: o botão \"cancelar\" foi pressionado.");
            System.exit(1);
        }
    }
}
