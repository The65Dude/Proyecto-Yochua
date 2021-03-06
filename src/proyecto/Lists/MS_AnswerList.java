package proyecto.Lists;

import proyecto.sampleClasses.MS_Answers;
import proyecto.sampleClasses.MultipleSelection;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */
public class MS_AnswerList {

    private MS_Answers[] mS_Answerses;
    private int index = 0;
    private final int TAMANO = 4;

    public MS_AnswerList() {
        this.mS_Answerses = new MS_Answers[TAMANO];
    }

    public MS_AnswerList(MS_Answers[] answerVector) {
        if (answerVector == null) {
            this.mS_Answerses = new MS_Answers[TAMANO];
        } else {
            this.mS_Answerses = answerVector;
        }
    }

    public MS_AnswerList(int size) {
        if (size < 0) {
            mS_Answerses = new MS_Answers[TAMANO];
        } else {
            mS_Answerses = new MS_Answers[size];
        }
    }

    public String getVectorString() {
        String text = "";
        for (MS_Answers element : mS_Answerses) {
            if (element != null) {
                text += element + "-";
            }
        }
        return text;
    }

    public String mostrarRespuestas() {
        String result = "";
        int contador = 1;
        for (int i = 0; i < mS_Answerses.length; i++) {
            if (mS_Answerses[i] != null) {
                result += (contador) + ")" + mS_Answerses[i].mostrarDatos() + "\n";
                contador++;
            }
        }
        return result;
    }

    public void setMS_Answers(String answer, boolean correct) {
        mS_Answerses[index] = new MS_Answers(answer, correct);
        index++;
    }

    public String getSpecificAnswer(int i) {
        return mS_Answerses[i].getAnswer();
    }

    public void setSpecificAnswer(int i, String answer, boolean correct) {
        mS_Answerses[i].setAnswer(answer);
        mS_Answerses[i].setCorrect(correct);
    }

    public int getTAMANO() {
        return TAMANO;
    }
    
    public MS_Answers getElemento(int index) {
        return mS_Answerses[index];
    }

    public MS_Answers getElemento() {
        int elementoRandom = (int) (Math.random() * index);

        return mS_Answerses[elementoRandom]; // falta validaciones (null, etc.. )
    }

}
