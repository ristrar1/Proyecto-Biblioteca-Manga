package bibliotecamanga;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;
public class Anadir extends JFrame implements ActionListener{
//Atributos
    JPanel miManga;
    JLabel cabeceraT;
    JLabel idmangaT;
    JTextField idmangaTF;
    JLabel tituloT;
    JTextField tituloTF;
    JLabel generoT;
    JTextField generoTF;
    JTextArea sinopsisTA;
    JLabel sinopsisT;
    JLabel autoresT;
    JTextField autoresTF;
    JLabel numTomosT;
    JTextField numTomosTF;
    JLabel tipoT;
    JTextField tipoTF;
    JLabel imagenT;
    JTextField imagenTF;
    JButton aceptarB;
    JButton volverB;
    JScrollPane scroll;
    JButton examinarB;
    JLabel exitoT;
    BackgroundPanel fondo;
    PreparedStatement sentencia;
    String sentenciaSQL;
    Connection miConexion;
    
    public Anadir() throws SQLException{
        miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecamanga", "root", "");
        this.setTitle("AÑADIR MANGA");
        this.setSize(800, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        miManga = new JPanel();
        miManga.setLayout(null);
        
        //JLabels Y JTextFields
        cabeceraT = new JLabel(" INSERTE DATOS DEL MANGA");
        cabeceraT.setBounds(250, 30, 300, 30);
        cabeceraT.setFont(new Font("Fantasy", Font.BOLD, 20));
        cabeceraT.setForeground(Color.BLACK);
        cabeceraT.setOpaque(true);
        cabeceraT.setBackground(Color.WHITE);
        miManga.add(cabeceraT);
        
        idmangaT = new JLabel("  ID DEL MANGA: ");
        idmangaT.setBounds(30, 80, 100, 30);
        idmangaT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        idmangaT.setForeground(Color.BLACK);
        idmangaT.setOpaque(true);
        idmangaT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(idmangaT);

        idmangaTF = new JTextField("");
        idmangaTF.setBounds(170, 80, 200, 30);
        miManga.add(idmangaTF);
        
        tituloT = new JLabel("  TÍTULO: ");
        tituloT.setBounds(380, 80, 80, 30);
        tituloT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        tituloT.setForeground(Color.BLACK);
        tituloT.setOpaque(true);
        tituloT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(tituloT);

        tituloTF = new JTextField("");
        tituloTF.setBounds(490, 80, 250, 30);
        miManga.add(tituloTF);
        
        generoT = new JLabel("  GÉNERO: ");
        generoT.setBounds(30, 130, 100, 30);
        generoT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        generoT.setForeground(Color.BLACK);
        generoT.setOpaque(true);
        generoT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(generoT);
        
        generoTF = new JTextField("");
        generoTF.setBounds(170, 130, 200, 30);
        miManga.add(generoTF);
        
        tipoT = new JLabel("  TIPO: ");
        tipoT.setBounds(380, 130, 80, 30);
        tipoT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        tipoT.setForeground(Color.BLACK);
        tipoT.setOpaque(true);
        tipoT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(tipoT);
        
        tipoTF = new JTextField("");
        tipoTF.setBounds(490, 130, 250, 30);
        miManga.add(tipoTF);
        
        numTomosT = new JLabel(" NÚMERO DE TOMOS: ");
        numTomosT.setBounds(30, 180, 130, 30);
        numTomosT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        numTomosT.setForeground(Color.BLACK);
        numTomosT.setOpaque(true);
        numTomosT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(numTomosT);

        numTomosTF = new JTextField("");
        numTomosTF.setBounds(170, 180, 200, 30);
        miManga.add(numTomosTF);
        
        imagenT = new JLabel(" IMAGEN (RUTA): ");
        imagenT.setBounds(380, 180, 100, 30);
        imagenT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        imagenT.setForeground(Color.BLACK);
        imagenT.setOpaque(true);
        imagenT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(imagenT);
        
        imagenTF = new JTextField("");
        imagenTF.setBounds(490, 180, 250, 30);
        miManga.add(imagenTF);
        
        examinarB = new JButton("EXAMINAR");
        examinarB.setBounds(530, 230, 100,30);
        miManga.add(examinarB);
        examinarB.addActionListener(this);
        
        autoresT = new JLabel("  AUTORES: ");
        autoresT.setBounds(30, 230, 100, 30);
        autoresT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        autoresT.setForeground(Color.BLACK);
        autoresT.setOpaque(true);
        autoresT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(autoresT);
        
        autoresTF = new JTextField("");
        autoresTF.setBounds(170, 230, 200, 30);
        miManga.add(autoresTF);
                
        sinopsisT = new JLabel("  SINOPSIS: ");
        sinopsisT.setBounds(30, 270, 100, 30);
        sinopsisT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        sinopsisT.setForeground(Color.BLACK);
        sinopsisT.setOpaque(true);
        sinopsisT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(sinopsisT);
        
        sinopsisTA = new JTextArea();
        sinopsisTA.setLineWrap(true);
        sinopsisTA.setWrapStyleWord(true);
        scroll = new JScrollPane(sinopsisTA);
        scroll.setBounds(30, 310, 700, 80);
        miManga.add(scroll);
      
        exitoT = new JLabel("  MANGA AÑADIDO CORRECTAMENTE");
        exitoT.setBounds(260, 435, 230, 30);
        exitoT.setVisible(false);
        exitoT.setFont(new Font("Fantasy",Font.ITALIC, 12));
        exitoT.setForeground(Color.BLACK);
        exitoT.setOpaque(true);
        exitoT.setBackground(Color.getHSBColor(24, 91, 92));
        miManga.add(exitoT);
        
        aceptarB = new JButton("ACEPTAR");
        aceptarB.setBounds(200, 400, 130, 30);
        aceptarB.setBackground(Color.getHSBColor(24, 91, 92));
        aceptarB.setFont(new Font("Fantasy", Font.ITALIC, 16));
        aceptarB.setForeground(Color.BLACK);
        aceptarB.addActionListener(this);
        miManga.add(aceptarB);

        volverB = new JButton("VOLVER");
        volverB.setBounds(450, 400, 130, 30);
        volverB.setBackground(Color.getHSBColor(24, 91, 92));
        volverB.setFont(new Font("Fantasy", Font.ITALIC, 16));
        volverB.setForeground(Color.BLACK);
        miManga.add(volverB);
        volverB.addActionListener(this);
        
        ImageIcon img = new ImageIcon("imagenes/anadir.jpg");
        fondo = new BackgroundPanel(img.getImage());
        fondo.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        miManga.add(fondo);

        this.add(miManga); 
        
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
        if(e.getSource()==examinarB){
            // Using this process to invoke the constructor,
            // JFileChooser points to user's default directory
            JFileChooser j = new JFileChooser();
            // Open the save dialog
            if (j.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                // set the label to the path of the selected file
                imagenTF.setText(j.getSelectedFile().getAbsolutePath());
            }
        }
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
                sentenciaSQL = "INSERT INTO mangas VALUES(?,?,?,?,?,?,?,?)";
                sentencia = miConexion.prepareStatement(sentenciaSQL);
                int idmanga = Integer.parseInt(idmangaTF.getText());
                sentencia.setInt(1, idmanga);
                sentencia.setString(2, tituloTF.getText());
                sentencia.setString(3, generoTF.getText());
                sentencia.setString(4, sinopsisTA.getText());
                sentencia.setString(5, autoresTF.getText());
                sentencia.setString(6, numTomosTF.getText());
                sentencia.setString(7, tipoTF.getText());
                sentencia.setString(8, imagenTF.getText());
                
                sentencia.executeUpdate();

                idmangaTF.setText("");
                tituloTF.setText("");
                generoTF.setText("");
                sinopsisTA.setText("");
                autoresTF.setText("");
                numTomosTF.setText("");
                tipoTF.setText("");
                imagenTF.setText("");
                
                exitoT.setVisible(true);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
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
