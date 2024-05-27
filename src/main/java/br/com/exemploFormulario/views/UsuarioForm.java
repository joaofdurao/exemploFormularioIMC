package br.com.exemploFormulario.views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.exemploFormulario.controllers.UsuarioController;
import br.com.exemploFormulario.models.Usuario;
import br.com.exemploFormulario.utils.IMCUtils;

public class UsuarioForm extends JFrame {

    private JTextField nomeField;
    private JTextField pesoField;
    private JTextField alturaField;
    private JLabel resultadoLabel;

    private UsuarioController usuarioController;

    public UsuarioForm() {
        usuarioController = new UsuarioController();
        initUI();
    }

    private void initUI() {
        setTitle("Cadastro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        panel.add(nomeLabel);
        panel.add(nomeField);

        JLabel pesoLabel = new JLabel("Peso (kg):");
        pesoField = new JTextField();
        panel.add(pesoLabel);
        panel.add(pesoField);

        JLabel alturaLabel = new JLabel("Altura (m):");
        alturaField = new JTextField();
        panel.add(alturaLabel);
        panel.add(alturaField);

        JButton calcularButton = new JButton("Calcular IMC");
        calcularButton.addActionListener(new CalcularIMCActionListener());
        panel.add(calcularButton);

        resultadoLabel = new JLabel("");
        panel.add(resultadoLabel);

        add(panel);
    }

    private class CalcularIMCActionListener implements ActionListener {

        IMCUtils imcUtils = new IMCUtils();

        public CalcularIMCActionListener() {
            imcUtils = new IMCUtils();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            Float peso = Float.parseFloat(pesoField.getText().replace(",", "."));
            Float altura = Float.parseFloat(alturaField.getText().replace(",", "."));

            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setPeso(peso);
            usuario.setAltura(altura);

            if (usuarioController.saveUsuario(usuario)) {
                double imc = imcUtils.calcularIMC(peso, altura);
                String nivel = imcUtils.determinarNivelIMC(imc);
                resultadoLabel.setText("IMC: " + String.format("%.2f", imc) + " - " + nivel);
            } else {
                resultadoLabel.setText("Erro ao salvar usuário.");
            }
        }
    }

}