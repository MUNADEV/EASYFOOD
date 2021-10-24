package Interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Guardado {

    private static String directorio;
    private static File carpetaBoletas;
    private static File carpetaDeHoy;

    public Guardado() {

        try {
            getDirectorioDesdeArchivo();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    }

    private static void carpetasDatos() {
        Guardado.carpetaBoletas = new File(directorio + "Boletas");

        if (carpetaBoletas.exists()) {

        } else {
            carpetaBoletas.mkdirs();
            System.out.println("Carperta Creada");
        }

    }

    private static void carpetaDiaria() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-YYYY");
        String nombreCarpeta = formatoFecha.format(fecha);
        carpetaDeHoy = new File(carpetaBoletas + File.separator + nombreCarpeta);
        if (carpetaDeHoy.exists()) {

        } else {
            carpetaDeHoy.mkdir();

        }
    }

    public static void init(String datos) {//es base a un objeto del tipo String genera un archivo del tipo txt el cual contendra todo lo que viene en el String

        carpetasDatos();
        carpetaDiaria();
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH-mm-ss");//se crea un tipo de formato para la fecha (hora,minutos,segundos)
        String nombreArchivo = formatoFecha.format(fecha);// nombre archivo resive la fecha con el formato previamente designado
        try {
            FileWriter boletaActual = new FileWriter(carpetaDeHoy + File.separator + nombreArchivo + ".txt");//se crea la nueva boleta (Archivo del tipo nota) (se deve colocar el directorio mas el nombre y su devida extencion (.txt)
            boletaActual.write(datos);//en el archivo del tipo nota se ingresa lo que esta contenido el el objeto datos del tipo String
            boletaActual.close();//se cierra el archivo del tipo nota
        } catch (IOException ex) {
            System.out.println("Error");
        }

    }

    public static void setDirectorio() { //Cambia el directorio donde se guardan las boletas ademas lo guarda en Data/Directorio.txt
        File carpetaData = new File("Data");//se crea el directorio De la carpeta data (contenida en la carpeta del proyecto)
        if (carpetaData.exists()) {

        } else {
            carpetaData.mkdir();//la carpeta es creada
        }
        JOptionPane.showMessageDialog(null, "Bienvenido a EasyFood!\nEsperamos que su experiencia sea agradable");
        String nuevoDirectorio = JOptionPane.showInputDialog("Ingrese el directorio donde se guardarán las boletas\nPor ejemplo: C:\\Users\\Public");
        File ruta = new File(nuevoDirectorio);
        if (ruta.isDirectory()) {//si existe el directorio se settea por el ingresado por el usuario (se le agrega File.separator  en caso de que al usuario se le olvide el agregar el ultimo separador del directorio)
            Guardado.directorio = nuevoDirectorio + File.separator;

            try {

                FileWriter nota = new FileWriter("Data" + File.separator + "Directorio.txt");//se crea dentro de la carpeta Data el archivo de texto el cual contendra el direcctorio
                nota.write(directorio);
                nota.close();//se cierra el archivo
            } catch (IOException ex) {
                System.out.println("Error");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Ingrese un directorio Valido");
            setDirectorio();

        }
    }

    private static void getDirectorioDesdeArchivo() throws IOException { //metodo utilizado para en caso de que exista el archivo con el directorio se lea se compruebe y se utilice
        File archivoConDirectorio = new File("Data" + File.separator + "Directorio.txt");//se crea objeto File para verificar la existencia del archivo que contiene el directorio
        if (archivoConDirectorio.exists()) {//si existe
            FileReader archivo = new FileReader("Data" + File.separator + "Directorio.txt");//se toma el archivo que contiene el directorio como archivo de lectura
            BufferedReader buffer = new BufferedReader(archivo);//clase usada para leer el archivo
            String rutaEnArchivo = buffer.readLine();//se el String se  guarda lo leido en la primera linea
            File posibleRuta = new File(rutaEnArchivo);//Lo leido se vuelve un File para poder asegurar su existecia
            if (posibleRuta.isDirectory()) {//en caso de que sea un directorio valido el que se obtubo del archivo
                Guardado.directorio = rutaEnArchivo;//se settea como directorio para guardat las Boletas
            } else {// en caso de no ser valido el directorio 
                setDirectorio();//se recurre al metodo para agregarlo
            }
        } else {//en caso de no existir el archivo se recurre al metodo para agregarlo
            setDirectorio();
        }
    }
}
