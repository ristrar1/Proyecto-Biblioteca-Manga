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
import javax.swing.table.DefaultTableModel;
public class Listar extends JFrame implements ActionListener{
 //Atributos
    JPanel miLista;
    JLabel tituloT;
    DefaultTableModel modeloTabla;
    JTable tabla;
    JScrollPane scroll;
    String[] encabezado;
    Object[][] datos;
    JButton volverB;
    BackgroundPanel fondo;
    PreparedStatement sentencia;
    Connection miConexion;
    
    public Listar() throws SQLException{
        miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecamanga", "root", "");
        this.setTitle("CATÁLOGO MANGA");
        this.setSize(1100, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        miLista = new JPanel();
        miLista.setLayout(null);
        
        tituloT = new JLabel("  LISTA DE TÍTULOS EN EL CATÁLOGO");
        tituloT.setBounds(370, 15, 390, 30);
        tituloT.setFont(new Font("Fantasy", Font.BOLD, 20));
        tituloT.setForeground(Color.BLACK);
        tituloT.setOpaque(true);
        tituloT.setBackground(Color.WHITE);
        miLista.add(tituloT);
        
        encabezado = new String []{"ID MANGA","TÍTULO", "GÉNERO", "SINOPSIS", "AUTORES","NÚMERO DE TOMOS", "TIPO", "IMAGEN"};
        datos = new Object[0][8];
        modeloTabla = new DefaultTableModel(datos,encabezado);
        
        tabla = new JTable(modeloTabla);
        scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 100, 1020, 300);
        miLista.add(scroll);
        
        volverB = new JButton("VOLVER");
        volverB.setBounds(500, 420, 100, 30);
        miLista.add(volverB);
        volverB.addActionListener(this);
        
        ImageIcon img = new ImageIcon("imagenes/listar.jpg");
        fondo = new BackgroundPanel(img.getImage());
        fondo.setBounds(0, 0, 1200, 700);

        miLista.add(fondo);
        
        
        this.add(miLista);
        
        String sentenciaSQL = "SELECT * FROM mangas";
        sentencia = miConexion.prepareStatement(sentenciaSQL);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            int idmanga = resultado.getInt("idmanga");
            String titulo = resultado.getString("titulo");
            String genero = resultado.getString("genero");
            String sinopsis = resultado.getString("sinopsis");
            String autores = resultado.getString("autores");
            String numtomos = resultado.getString("numtomos");
            String tipo = resultado.getString("tipo");
            String imagen = resultado.getString("imagen");
            
            Object[] miManga = new Object[8];
            miManga[0] = idmanga;
            miManga[1] = titulo;
            miManga[2] = genero;
            miManga[3] = sinopsis;
            miManga[4] = autores;
            miManga[5] = numtomos;
            miManga[6] = tipo;
            miManga[7] = imagen;
            modeloTabla.addRow(miManga);
        }         
        
        //Terminar conexión con botón cerrar
        this.addWindowListener( new WindowAdapter() { 
        @Override
        public void windowClosing(WindowEvent evt ) { 
                System.out.println("CONEXIÓN TERMINADA");
                System.exit(0);
        }
        });
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == volverB){
            try {
                Interface miInterface = new Interface();
                miInterface.setVisible(true);
                this.setVisible(false);
                miConexion.close();
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
