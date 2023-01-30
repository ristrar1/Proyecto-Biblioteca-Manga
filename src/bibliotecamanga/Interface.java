package bibliotecamanga;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class Interface extends JFrame implements ActionListener{
    //Atributos
    JPanel miCapa;
    JLabel tituloT;
    JButton anadirB;
    JButton listarB;
    JButton consultarB;
    BackgroundPanel fondo;
    
    public Interface(){
        this.setTitle("BIBLIOTECA MANGA");
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        miCapa = new JPanel();
        miCapa.setLayout(null);
        
        anadirB = new JButton("AÑADIR MANGA");
        anadirB.setBounds(900, 550, 200, 40);
        anadirB.setBackground(Color.getHSBColor(24, 91, 92));
        anadirB.setFont(new Font("Fantasy", Font.ITALIC, 16));
        anadirB.setFocusPainted(false);
        anadirB.setForeground(Color.BLACK);
        miCapa.add(anadirB);
        anadirB.addActionListener(this);
        
        consultarB = new JButton("CONSULTAR MANGA");
        consultarB.setBounds(550, 600, 200, 40);
        consultarB.setBackground(Color.getHSBColor(24, 91, 92));
        consultarB.setFont(new Font("Fantasy", Font.ITALIC, 16));
        consultarB.setFocusPainted(false);
        consultarB.setForeground(Color.BLACK);
        miCapa.add(consultarB);
        consultarB.addActionListener(this);
        
        listarB = new JButton("MOSTRAR LISTA");
        listarB.setBounds(200, 550, 200, 40);
        listarB.setBackground(Color.getHSBColor(24, 91, 92));
        listarB.setFont(new Font("Fantasy", Font.ITALIC, 16));
        listarB.setFocusPainted(false);
        listarB.setForeground(Color.BLACK);
        miCapa.add(listarB);
        listarB.addActionListener(this);
        
        ImageIcon titulo = new ImageIcon("imagenes/titulo.jpg");
        tituloT = new JLabel(titulo);
        tituloT.setBounds(250, 200, 800, 80);
        miCapa.add(tituloT);
        
        ImageIcon img = new ImageIcon("imagenes/fondo.jpg");
        fondo = new Interface.BackgroundPanel(img.getImage());
        fondo.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        miCapa.add(fondo);
        
        
        this.add(miCapa);
    }
    
     @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==anadirB){
            try {
                Anadir nuevo = new Anadir();
                nuevo.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
            }
        }
        if(e.getSource()==consultarB){
            try {
                Consultar miConsulta = new Consultar();
                miConsulta.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
            }
        }
        if(e.getSource()==listarB){
            try {
                Listar miLista = new Listar();
                miLista.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex) {
            }
        }   
    }  
    
    class BackgroundPanel extends JPanel {
        Image im;

        public BackgroundPanel(Image im) {
            this.im = im;
            this.setOpaque(true);
        }

        // mostramos el fondo del BackgroundPanel
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    } 
    
}


