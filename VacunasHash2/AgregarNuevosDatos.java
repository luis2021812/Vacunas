import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarNuevosDatos extends JFrame{
    private JButton ingboton;
    private JTextField CuiNuev;
    private JPanel Ventapanel;
    private JTextField ingrfecha;
    private JTextField Dosisnueva;
    private JLabel Dosis;
    private JLabel ingfecha;
    private JLabel ingcui;

    public AgregarNuevosDatos(){
        ingboton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vacunacovid vacuna = new Vacunacovid();
                String cui = CuiNuev.getText();
                String datos = "Dosis " + Dosisnueva.getText() + ", Fecha " + ingrfecha.getText();
                vacuna.guardararchivo(cui, datos);
                CuiNuev.setText("");
                Dosisnueva.setText("");
                ingrfecha.setText("");

                // Muestra una ventana emergente para confirmar que se ha agregado la información correctamente
                JOptionPane.showMessageDialog(null, "La información ha sido agregada correctamente.");

                JOptionPane.showMessageDialog(null, "Datos ingresados para el CUI " + cui);
            }
        });
    }

    public void iniciar(){
        AgregarNuevosDatos f = new AgregarNuevosDatos();
        f.setContentPane(new AgregarNuevosDatos().Ventapanel);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.pack();
    }
}