package CalculadoraVisual;
import javax.swing.*;

public class panelito  extends JPanel{
//se crea el panel
    public panelito(){
        setLayout(null);
        //se crean dos botones, uno que dice "calculadora normal" el otro "calculadora cientifica"
        JButton normal = new JButton("Calculadora Normal");
        JButton cientifica = new JButton("Calculadora Cientifica");
        //se les da tamaño y posicion
        normal.setBounds(50, 50, 200, 50);
        cientifica.setBounds(50, 150, 200, 50);
        //se añaden al panel
        add(normal);
        add(cientifica);

        //se crea un evento para el boton "normal"
        normal.addActionListener(e -> {
            CalculadoraNormal calculadoraNormal = new CalculadoraNormal();
            calculadoraNormal.setVisible(true);
        });


        //se crea un evento para el boton "cientifica"



    }

}
