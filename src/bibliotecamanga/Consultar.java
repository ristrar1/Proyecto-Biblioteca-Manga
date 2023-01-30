package bibliotecamanga;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Consultar extends JFrame implements ActionListener, KeyListener{
    //Atributos
    JPanel miConsulta;
    JLabel textoT;
    JLabel tituloBuscaT;
    JTextField tituloBuscaTF;
    JButton buscarB;
    JButton eliminarB;
    JButton actualizarB;
    JButton volverB;
    JButton consultarB;
    JLabel eliminadoT;
    DefaultTableModel modeloTabla;
    JTable tabla;
    JScrollPane scroll;
    String[] encabezado;
    Object[][] datos;
    Connection miConexion;
    BackgroundPanel fondo;
    PreparedStatement sentencia;
    Object[] test; 
    
    public Consultar() throws SQLException{
        miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotecamanga", "root", "");
        this.setTitle("CONSULTA DE TÍTULOS");
        this.setSize(900, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        miConsulta = new JPanel();
        miConsulta.setLayout(null);
        
        textoT = new JLabel("  INTRODUZCA EL TÍTULO DEL MANGA QUE DESEA CONSULTAR");
        textoT.setBounds(100, 10, 650, 30);
        textoT.setFont(new Font("Fantasy", Font.BOLD, 20));
        textoT.setForeground(Color.BLACK);
        textoT.setOpaque(true);
        textoT.setBackground(Color.WHITE);
        miConsulta.add(textoT);
        
        tituloBuscaT = new JLabel("  TÍTULO: ");
        tituloBuscaT.setBounds(100, 70, 65, 30);
        tituloBuscaT.setFont(new Font("Fantasy", Font.ITALIC, 12));
        tituloBuscaT.setOpaque(true);
        tituloBuscaT.setBackground(Color.WHITE);
        miConsulta.add(tituloBuscaT);
        
        tituloBuscaTF = new JTextField();
        tituloBuscaTF.setBounds(170, 70, 350, 30);
        miConsulta.add(tituloBuscaTF);
        tituloBuscaTF.addKeyListener(this);
        
        buscarB = new JButton("BUSCAR");
        buscarB.setBounds(550,70,200,30);
        miConsulta.add(buscarB);
        buscarB.addActionListener(this);
        
        encabezado = new String []{"ID MANGA","TÍTULO", "GÉNERO", "SINOPSIS", "AUTORES", "Nº TOMOS", "TIPO", "IMAGEN"};
        datos = new Object[0][8];
        modeloTabla = new DefaultTableModel(datos,encabezado);
        
        tabla = new JTable(modeloTabla);
        scroll = new JScrollPane(tabla);
        scroll.setBounds(40, 120, 800, 250);
        miConsulta.add(scroll);
        
        consultarB = new JButton("CONSULTAR");
        consultarB.setBounds(150,400,110,30);
        miConsulta.add(consultarB);
        consultarB.addActionListener(this);
        
        actualizarB = new JButton("ACTUALIZAR");
        actualizarB.setBounds(300,400,110,30);
        miConsulta.add(actualizarB);
        actualizarB.addActionListener(this);

        eliminarB = new JButton("ELIMINAR");
        eliminarB.setBounds(450,400,110,30);
        miConsulta.add(eliminarB);
        eliminarB.addActionListener(this);
 
        eliminadoT = new JLabel("TÍTULO ELIMINADO CORRECTAMENTE");
        eliminadoT.setBounds(330, 450, 300, 30);
        eliminadoT.setVisible(false);
        miConsulta.add(eliminadoT);

        volverB = new JButton("VOLVER");
        volverB.setBounds(600, 400, 110, 30);
        miConsulta.add(volverB);
        volverB.addActionListener(this);
        
        ImageIcon img = new ImageIcon("imagenes/consulta.jpg");
        fondo = new BackgroundPanel(img.getImage());
        fondo.setBounds(0, 0, 900, 550);
        miConsulta.add(fondo);
        
  
        this.add(miConsulta);
        
         //Terminar conexión con botón cerrar
        this.addWindowListener( new WindowAdapter() { 
        @Override
        public void windowClosing( WindowEvent evt ) { 
                System.out.println("Salimos de la aplicación");
                System.exit(0);
        }
        });
    }
    
    public void executeBuscar(){
        modeloTabla.setRowCount(0);
        try {
                String sentenciaSQL = "SELECT * FROM mangas WHERE titulo LIKE ?";
                sentencia = miConexion.prepareStatement(sentenciaSQL);
                sentencia.setString(1, "%" + tituloBuscaTF.getText() + "%");
                ResultSet resultado = sentencia.executeQuery();
                while(resultado.next()){
                    String idmanga = resultado.getString("idmanga");
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
            } catch (SQLException ex) {
            }  
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == volverB){
            Interface miInterface = new Interface();
            miInterface.setVisible(true);
            this.setVisible(false);
            try {
                miConexion.close();
            } catch (SQLException ex) {
            }
        }
        if(e.getSource()==buscarB){
            executeBuscar();
        }
        if(e.getSource()==eliminarB){
            try {
                String sentenciaSQL = "DELETE FROM mangas WHERE titulo LIKE ?";
                sentencia = miConexion.prepareStatement(sentenciaSQL);
                sentencia.setString(1, "%" + tituloBuscaTF.getText() + "%");
                sentencia.executeUpdate();
                //Obtenemos el número de fila seleccionado
                int numFila = tabla.getSelectedRow();
                //Eliminamos la fila seleccionada
                modeloTabla.removeRow(numFila);
                eliminadoT.setVisible(true);
                tituloBuscaTF.setText("");
            } catch (SQLException ex) {
            }  
        }
        if(e.getSource()== consultarB){
            try {
                int numFila = tabla.getSelectedRow();
                String result = (String) tabla.getModel().getValueAt(numFila, 0);
                int dato = Integer.parseInt(result);
                String result2 = (String) tabla.getModel().getValueAt(numFila, 1);
                String result3 = (String) tabla.getModel().getValueAt(numFila, 2);
                String result4 = (String) tabla.getModel().getValueAt(numFila, 3);
                String result5 = (String) tabla.getModel().getValueAt(numFila, 4);
                String result6 = (String) tabla.getModel().getValueAt(numFila, 5);
                String result7 = (String) tabla.getModel().getValueAt(numFila, 6);
                String result8 = (String) tabla.getModel().getValueAt(numFila, 7);
                Ver miPantalla = new Ver(dato,result2,result3,result4,result5,result6,result7,result8);
                miPantalla.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Consultar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(e.getSource()==actualizarB){
            try {
                int numFila = tabla.getSelectedRow();
                String result = (String) tabla.getModel().getValueAt(numFila, 0);
                int dato = Integer.parseInt(result);
                Actualizar miModificacion = new Actualizar(dato);
                miModificacion.setVisible(true);
            } catch (SQLException ex) {
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            executeBuscar();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
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
