package CalculadoraVisual;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JFrame{
    //se crea una ventana
    public main(){
        setTitle("Calculadora Visual");
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(new panelito());
    }

    //se crea el panel
    public static void main(String[] args) {
        main m = new main();
        m.setVisible(true);
    }



}
