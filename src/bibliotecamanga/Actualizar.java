package bibliotecamanga;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*; 
import javax.swing.*;
public class Actualizar extends JFrame implements ActionListener{
    //Atributos
    JPanel miModificacion;
    JLabel textoT;
    JLabel idmangaT;
    JTextField idmangaTF;
    JLabel tituloT;
    JTextField tituloTF;
    JLabel generoT;
    JTextField generoTF;
    BackgroundPanel fondo;
    JLabel autoresT;
    JTextField autoresTF;
    JLabel numTomosT;
    JTextField numTomosTF;
    JLabel tipoT;
    JTextField tipoTF;
    JLabel imagenT;
    JTextField imagenTF;
    JLabel sinopsisT;
    JTextArea sinopsisTA;
    JScrollPane scroll;
    JButton aceptarB;
    JButton volverB;
    int idManga;
    Connection miConexion;
    String sentenciaSQL;
    PreparedStatement sentencia;
    
    public Actualizar(int idManga) throws SQLException{
        miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecamanga", "root", "");
        this.idManga = idManga;
        this.setTitle("ACTUALIZAR MANGA");
        this.setSize(800, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        miModificacion = new JPanel();
        miModificacion.setLayout(null);
        
        //JLabels Y JTextFields
        textoT = new JLabel("  INSERTE LOS NUEVOS DATOS DEL MANGA");
        textoT.setBounds(200, 30, 440, 30);
        textoT.setFont(new Font("Fantasy", Font.BOLD, 20));
        textoT.setForeground(Color.BLACK);
        textoT.setOpaque(true);
        textoT.setBackground(Color.WHITE);
        miModificacion.add(textoT);
        
        idmangaT = new JLabel("  ID DEL MANGA: ");
        idmangaT.setBounds(30, 80, 100, 30);
        idmangaT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        idmangaT.setForeground(Color.BLACK);
        idmangaT.setOpaque(true);
        idmangaT.setBackground(Color.WHITE);
        miModificacion.add(idmangaT);
        
        idmangaTF = new JTextField(""+this.idManga);
        idmangaTF.setBounds(170, 80, 40, 30);
        idmangaTF.setEditable(false);
        miModificacion.add(idmangaTF);
  
        tituloT = new JLabel(" TÍTULO: ");
        tituloT.setBounds(390, 80, 70, 30);
        tituloT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        tituloT.setForeground(Color.BLACK);
        tituloT.setOpaque(true);
        tituloT.setBackground(Color.WHITE);
        miModificacion.add(tituloT);
        
        tituloTF = new JTextField("");
        tituloTF.setBounds(500, 80, 220, 30);
        miModificacion.add(tituloTF);
        
        generoT = new JLabel(" GÉNERO: ");
        generoT.setBounds(30, 130, 80, 30);
        generoT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        generoT.setForeground(Color.BLACK);
        generoT.setOpaque(true);
        generoT.setBackground(Color.WHITE);
        miModificacion.add(generoT);
        
        generoTF = new JTextField("");
        generoTF.setBounds(170, 130, 200, 30);
        miModificacion.add(generoTF);
        
        tipoT = new JLabel(" TIPO: ");
        tipoT.setBounds(390, 130, 70, 30);
        tipoT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        tipoT.setForeground(Color.BLACK);
        tipoT.setOpaque(true);
        tipoT.setBackground(Color.WHITE);
        miModificacion.add(tipoT);
        
        tipoTF = new JTextField("");
        tipoTF.setBounds(500, 130, 220, 30);
        miModificacion.add(tipoTF);
        
        numTomosT = new JLabel("NÚMERO DE TOMOS: ");
        numTomosT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        numTomosT.setForeground(Color.BLACK);
        numTomosT.setOpaque(true);
        numTomosT.setBackground(Color.WHITE);
        numTomosT.setBounds(30, 180, 130, 30);
        miModificacion.add(numTomosT);
        
        numTomosTF = new JTextField("");
        numTomosTF.setBounds(170, 180, 200, 30);
        miModificacion.add(numTomosTF);
        
        imagenT = new JLabel("IMAGEN (RUTA): ");
        imagenT.setBounds(390, 180, 100, 30);
        imagenT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        imagenT.setForeground(Color.BLACK);
        imagenT.setOpaque(true);
        imagenT.setBackground(Color.WHITE);
        miModificacion.add(imagenT);
        
        imagenTF = new JTextField("");
        imagenTF.setBounds(500, 180, 220, 30);
        miModificacion.add(imagenTF);
        
        autoresT = new JLabel(" AUTORES: ");
        autoresT.setBounds(30, 230, 80, 30);
        autoresT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        autoresT.setForeground(Color.BLACK);
        autoresT.setOpaque(true);
        autoresT.setBackground(Color.WHITE);
        miModificacion.add(autoresT);
        
        autoresTF = new JTextField("");
        autoresTF.setBounds(170, 230, 200, 30);
        miModificacion.add(autoresTF);
                
        sinopsisT = new JLabel("SINOPSIS: ");
        sinopsisT.setBounds(30, 270, 80, 30);
        sinopsisT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        sinopsisT.setForeground(Color.BLACK);
        sinopsisT.setOpaque(true);
        sinopsisT.setBackground(Color.WHITE);
        miModificacion.add(sinopsisT);
        
        sinopsisTA = new JTextArea();
        sinopsisTA.setLineWrap(true);
        sinopsisTA.setWrapStyleWord(true);
        scroll = new JScrollPane(sinopsisTA);
        scroll.setBounds(30, 310, 700, 80);
        miModificacion.add(scroll);
        
        aceptarB = new JButton("ACEPTAR");
        aceptarB.setBounds(200, 400, 130, 30);
        miModificacion.add(aceptarB);
        aceptarB.addActionListener(this);

        volverB = new JButton("VOLVER");
        volverB.setBounds(450, 400, 130, 30);
        miModificacion.add(volverB);
        volverB.addActionListener(this);
        
        ImageIcon img = new ImageIcon("imagenes/actualizar.jpeg");
        fondo = new BackgroundPanel(img.getImage());
        fondo.setBounds(0, 0, 800, 500);
        miModificacion.add(fondo);

        this.add(miModificacion); 
        
        //Terminar conexión con botón cerrar
        this.addWindowListener( new WindowAdapter() { 
        @Override
        public void windowClosing( WindowEvent evt ) { 
                System.out.println("CONEXIÓN TERMINADA");
                System.exit(0);
        }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==volverB){
            try {
                Interface miInterface = new Interface();
                miInterface.setVisible(true);
                this.setVisible(false);
                miConexion.close();
            } catch (SQLException ex) {
            }
        }
        if(e.getSource()==aceptarB){
            try {
                sentenciaSQL = "UPDATE mangas SET titulo = ?, genero = ?, "
                        + " sinopsis = ?, autores = ?, numtomos = ?, tipo = ?, imagen = ? WHERE idmanga = ?";
                sentencia = miConexion.prepareStatement(sentenciaSQL);
                sentencia.setString(1, tituloTF.getText());
                sentencia.setString(2, generoTF.getText());
                sentencia.setString(3, sinopsisTA.getText());
                sentencia.setString(4, autoresTF.getText());
                sentencia.setString(5, numTomosTF.getText());
                sentencia.setString(6, tipoTF.getText());
                sentencia.setString(7, imagenTF.getText());
                sentencia.setInt(8, this.idManga);

                sentencia.executeUpdate();
                
                tituloTF.setText("");
                generoTF.setText("");
                sinopsisTA.setText("");
                autoresTF.setText("");
                numTomosTF.setText("");
                tipoTF.setText("");
                imagenTF.setText("");
                                 
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
