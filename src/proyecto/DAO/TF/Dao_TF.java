package proyecto.DAO.TF;

import java.io.IOException;
import proyecto.Lists.TrueOrFalseList;
import proyecto.sampleClasses.TrueOrFalse;
import proyecto.ClasePrueba;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */
public class Dao_TF {

    TrueOrFalseList lista = ClasePrueba.lista_TFalseList; // atributo statico de la lista de preguntas
    WriterManager_TF writer = new WriterManager_TF();
    ReaderManager_TF reader = new ReaderManager_TF();

    public static final String FILE_NAME = "preguntasTFFile.txt";

    public boolean insertar(TrueOrFalse p) {
        lista.agregar(p);
        guardarLista(p);
        return true;
    }
    
    public boolean eliminar(int i) {
        TrueOrFalse t = lista.eliminar(i--);
        guardarLista(t);
        return true;
    }

    public TrueOrFalse generarPreguntaRandom() {
        TrueOrFalse p = lista.getElemento();
        return p;
    }

    public void cargarDatosPrueba() { // se agregar datos de prueba     
        try {
            reader.open(FILE_NAME);
            reader.readAll();
            reader.close(); //importante cerrar el archivo
            System.out.println("Lectura exitosa");
        } catch (IOException ex) {
            System.err.println("error de archivo");
            System.err.println(ex.getMessage());
        }
    }

    public void guardarLista(TrueOrFalse p) { // se agregar datos de prueba            
        try {
            writer.open(FILE_NAME);
            writer.writeAll();
            writer.close(); //importante cerrar el archivo 
            System.out.println("Escritura exitosa");
        } catch (IOException ex) {
            System.err.println("error de archivo");
            System.err.println(ex.getMessage());
        }
    }

    public void edit(int i, String question, String category, boolean answer) {
        lista.edit(i, question, category, answer);
        TrueOrFalse s = lista.getElemento(i);
        guardarLista(s);
    }
    
    public TrueOrFalseList getLista() {
        return lista;
    }
}
