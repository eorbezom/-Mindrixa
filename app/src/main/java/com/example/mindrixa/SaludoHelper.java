package com.example.mindrixa;

import android.content.Context;
import android.widget.Toast;

import java.util.Calendar;

public class SaludoHelper {

    // Variable estática para almacenar el saludo
    public static String saludo = "";

    // Método para generar el saludo dinámico
    public static String obtenerSaludoPersonalizado(String userName, Context context) {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);

        if (userName == null || userName.isEmpty()) {
            // Si no se pasa el nombre del usuario, mostrar un saludo por defecto
            saludo = "¡Hola!";
        } else {
            if (hora >= 5 && hora < 12) {
                saludo = "¡Buenos días, " + userName + "!";
            } else if (hora >= 12 && hora < 18) {
                saludo = "¡Buenas tardes, " + userName + "!";
            } else {
                saludo = "¡Buenas noches, " + userName + "!";
            }
        }

        // Si no se recibe un nombre válido, mostrar mensaje de advertencia
        if (userName == null || userName.isEmpty()) {
            Toast.makeText(context, "El nombre de usuario no se recibió correctamente.", Toast.LENGTH_LONG).show();
        }

        return saludo;
    }
}
