import javax.swing.*;
import java.awt.*;

public class CalculadoraGUI extends JFrame {
    private JTextField num1Field, num2Field, resultadoField;

    public CalculadoraGUI() {
        setTitle("Calculadora Científica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setResizable(false);

        GridBagConstraints gbc = new GridBagConstraints();

        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultadoField = new JTextField(20);
        resultadoField.setEditable(false);

        JButton limparBtn = new JButton("Limpar");
        JButton sairBtn = new JButton("Sair");

        Calculadora calc = new Calculadora();

        JButton[] operacaoBtns = {
                new JButton("+"), new JButton("-"), new JButton("*"),
                new JButton("/"), new JButton("sen"), new JButton("cos"),
                new JButton("tan"), new JButton("log"), new JButton("sqrt"),
                new JButton("pow")
        };

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(num1Field, gbc);

        gbc.gridy = 1;
        add(num2Field, gbc);

        gbc.gridy = 2;
        add(resultadoField, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 3;
        for (JButton btn : operacaoBtns) {
            add(btn, gbc);
            gbc.gridx++;
            if (gbc.gridx % 5 == 0) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
            String operacao = btn.getText();
            btn.addActionListener(e -> calcular(operacao, calc));
        }

        gbc.gridx = 0;
        gbc.gridy++;
        add(limparBtn, gbc);
        limparBtn.addActionListener(e -> {
            num1Field.setText("");
            num2Field.setText("");
            resultadoField.setText("");
        });

        gbc.gridx++;
        add(sairBtn, gbc);
        sairBtn.addActionListener(e -> System.exit(0));
    }

    private void calcular(String operacao, Calculadora calc) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double resultado;

            switch (operacao) {
                case "+":
                    resultado = calc.somar(num1, num2);
                    break;
                case "-":
                    resultado = calc.subtrair(num1, num2);
                    break;
                case "*":
                    resultado = calc.multiplicar(num1, num2);
                    break;
                case "/":
                    resultado = calc.dividir(num1, num2);
                    break;
                case "sen":
                    resultado = calc.seno(num1);
                    break;
                case "cos":
                    resultado = calc.cosseno(num1);
                    break;
                case "tan":
                    resultado = calc.tangente(num1);
                    break;
                case "log":
                    resultado = calc.logaritmo(num1);
                    break;
                case "sqrt":
                    resultado = calc.raizQuadrada(num1);
                    break;
                case "pow":
                    resultado = calc.potencia(num1, num2);
                    break;
                default:
                    resultado = 0;
            }

            resultadoField.setText(String.format("%.4f", resultado));
        } catch (NumberFormatException e) {
            resultadoField.setText("Entrada inválida");
        } catch (IllegalArgumentException e) {
            resultadoField.setText(e.getMessage());
        }
    }
}
