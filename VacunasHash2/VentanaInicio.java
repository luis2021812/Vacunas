import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame{
    private JPanel panel;
    private JTextField datosVacuna;
    private JList list1;
    private JButton buscarDtosButton;
    private JButton IngresarNuevo;

    DefaultListModel<String> model = new DefaultListModel<>();

    public VentanaInicio(){
        buscarDtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.setModel(model);
                model.removeAllElements();
                Vacunacovid sd = new Vacunacovid();
                String buscarCui = datosVacuna.getText();
                String resultado = sd.buscarVacunas(buscarCui);
                model.addElement("Registro del CUI: " + buscarCui);
                model.addElement(" " + resultado);
                datosVacuna.setText("");
            }
        });
        IngresarNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarNuevosDatos d = new AgregarNuevosDatos();
                d.iniciar();
            }
        });
    }
    public static void main(String[] args) {
        VentanaInicio f = new VentanaInicio();
        f.setContentPane(new VentanaInicio().panel);
        f.setBounds(100, 100, 800, 600); // Modificar los valores de ancho y alto
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
    }
}
