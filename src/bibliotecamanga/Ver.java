package bibliotecamanga;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Ver extends JFrame implements ActionListener{
    //Atributos
    JPanel miPantalla;
    JLabel cabeceraT;
    JLabel idmangaT;
    JLabel idVerT;
    JLabel tituloT;
    JLabel tituloVerT;
    JLabel generoT;
    JLabel generoVerT;
    JLabel sinopsisT;
    JTextArea sinopsisVerTA;
    JScrollPane scroll;
    JLabel autoresT;
    JLabel autoresVerT;
    JLabel numtomosT;
    JLabel numtomosVerT;
    JLabel tipoT;
    JLabel tipoVerT;
    JLabel imagen;
    JLabel imgenVerT;
    JButton volverB;
    int idManga;
    String titulo;
    String genero;
    String sinopsis;
    String autores;
    String numtomos;
    String tipo;
    String imagenS;
    
    Connection miConexion;

    public Ver(int idManga, String titulo, String genero, String sinopsis,
            String autores, String numtomos, String tipo, String imagenS) throws SQLException{
        miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecamanga", "root", "");
        this.idManga = idManga;
        this.titulo = titulo;
        this.autores = autores;
        this.genero = genero;
        this.imagenS = imagenS;
        this.sinopsis = sinopsis;
        this.numtomos = numtomos;
        this.tipo = tipo;
        System.out.println(this.idManga);
        this.setTitle("PANTALLA DEL TÍTULO");
        this.setSize(900, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        miPantalla = new JPanel();
        miPantalla.setLayout(null);
        
        cabeceraT = new JLabel("  FICHA DEL TÍTULO");
        cabeceraT.setBounds(320, 30, 200, 30);
        cabeceraT.setFont(new Font("Fantasy", Font.BOLD, 20));
        cabeceraT.setForeground(Color.BLACK);
        cabeceraT.setOpaque(true);
        cabeceraT.setBackground(Color.WHITE);
        miPantalla.add(cabeceraT);
        
        
        idmangaT = new JLabel("ID MANGA:   "+this.idManga);
        idmangaT.setBounds(40, 100, 100, 30);
        miPantalla.add(idmangaT);
 
        tituloT = new JLabel("TÍTULO:  "+ this.titulo);
        tituloT.setBounds(40, 150, 300, 30);
        miPantalla.add(tituloT);
        
        generoT = new JLabel("GÉNERO:  "+this.genero);
        generoT.setBounds(40, 200, 300, 30);
        miPantalla.add(generoT);
        
        autoresT = new JLabel("AUTORES:  "+this.autores);
        autoresT.setBounds(40, 250, 300, 30);
        miPantalla.add(autoresT);
        
        numtomosT = new JLabel("Nº DE TOMOS:  "+this.numtomos);
        numtomosT.setBounds(40, 300, 200, 30);
        miPantalla.add(numtomosT);
        
        tipoT = new JLabel("TIPO:  "+this.tipo);
        tipoT.setBounds(40, 350, 200, 30);
        miPantalla.add(tipoT);
        
        sinopsisT = new JLabel("SINOPSIS: ");
        sinopsisT.setBounds(40, 400, 500, 30);
        miPantalla.add(sinopsisT);
        
        sinopsisVerTA = new JTextArea(this.sinopsis);
        sinopsisVerTA.setBounds(40, 440, 450, 100);
        sinopsisVerTA.setEditable(false);
        sinopsisVerTA.setLineWrap(true);
        sinopsisVerTA.setWrapStyleWord(true);
        scroll = new JScrollPane(sinopsisVerTA);
        scroll.setBounds(30, 310, 700, 80);
        miPantalla.add(sinopsisVerTA);
        
        imagen = new JLabel();
        imagen.setBounds(500, 100, 300, 400);
        Image foto = new ImageIcon(this.imagenS).getImage();
        ImageIcon img  =new ImageIcon(foto.getScaledInstance(300,400, Image.SCALE_SMOOTH));
        imagen.setIcon(img);
        miPantalla.add(imagen);
        
        volverB = new JButton("VOLVER");
        volverB.setBounds(600, 520, 110, 30);
        miPantalla.add(volverB);
        volverB.addActionListener(this);
        
        this.add(miPantalla);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==volverB){
            this.setVisible(false);
        }
    }
}
