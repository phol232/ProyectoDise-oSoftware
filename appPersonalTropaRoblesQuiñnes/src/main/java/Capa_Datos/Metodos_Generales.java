package Capa_Datos;

import javax.swing.JLabel;
import javax.swing.JTable;

public class Metodos_Generales {

    public static String generarNumero(int num_ing) {

        String num = "";
//        if ((num_ing >= 10000000) || (num_ing < 100000000)) {
//            can = cont + num_ing;
//            num = "" + can;
//        }
//        if ((num_ing >= 1000000) || (num_ing < 10000000)) {
//            can = cont + num_ing;
//            num = "0" + can;
//        }
        if ((num_ing >= 100000) && (num_ing < 1000000)) {

            num = "T-00" + ++num_ing;
        }
        if ((num_ing >= 10000) && (num_ing < 100000)) {

            num = "T-000" + ++num_ing;
        }
        if ((num_ing >= 1000)&& (num_ing < 10000)) {

            num = "T-0000" + ++num_ing;
        }
        if ((num_ing >= 100) && (num_ing < 1000)) {

            num = "T-00000" + ++num_ing;
        }
        if ((num_ing >=9) && (num_ing < 100)) {

            num = "T-000000" + ++num_ing;
        }
        if (num_ing <9) {

            num = "T-0000000" + ++num_ing;
      
        }

        return num;

    }


}
