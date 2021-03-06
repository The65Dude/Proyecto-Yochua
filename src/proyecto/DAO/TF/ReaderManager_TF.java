package proyecto.DAO.TF;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import proyecto.Lists.TrueOrFalseList;
import proyecto.ClasePrueba;
import proyecto.sampleClasses.TrueOrFalse;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */
public class ReaderManager_TF {

    private BufferedReader reader;
    TrueOrFalseList lista = ClasePrueba.lista_TFalseList; // atributo statico de la lista de preguntas

    public void open(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
    }

    public TrueOrFalse read() throws IOException {
        TrueOrFalse p = null;
        String line = reader.readLine(); //retorna null cuando no hay más registros
        String datos[];
        if (line != null) {
            p = new TrueOrFalse();
            datos = line.split("-"); // separa el String en un array
            p.setQuestion(datos[0]); // lee el enunciado
            p.setAnswer(Boolean.parseBoolean(datos[1]));
            p.setCategory(datos[2]);// lee la respuesta
        }
        return p;
    }

    public void readAll() throws IOException {
        TrueOrFalse newtf = read();
        while(newtf != null) {
            lista.agregar(newtf);
            newtf = read();
        }
    }

    public void close() throws IOException {
        reader.close();
    }
}
