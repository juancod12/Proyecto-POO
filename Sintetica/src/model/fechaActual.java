package model;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class fechaActual {
    
    public String dia;
    public String mes;
    public String year;
    public LocalTime hora;
    public String diaSemana;


    public fechaActual(String dia, String mes, String year, LocalTime hora, String diaSemana) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
        this.hora = hora;
        this.diaSemana = diaSemana;
    }
    public static fechaActual obtenerFechaActual(){
        LocalTime hora = LocalTime.now();
        LocalDate fecha = LocalDate.now();
        DayOfWeek dia = fecha.getDayOfWeek();
        int Numero_dia = dia.getValue();

        String Dia = String.valueOf(fecha.getDayOfMonth());
        String mes = String.valueOf(fecha.getMonth());
        String year= String.valueOf(fecha.getYear());
        String diaSemana= "";

        switch(Numero_dia){
            case 1:
                diaSemana = "lunes";
            break;
            case 2:
                diaSemana = "martes";
            break;
            case 3:
                diaSemana = "miercoles";
            break;
            case 4:
                diaSemana = "jueves";
            break;
            case 5:
                diaSemana = "viernes";
            break;
            case 6:
                diaSemana = "sabado";
            break;
            case 7:
                diaSemana = "domingo";
            break;
        }
         fechaActual fechaHoy= new fechaActual(Dia, mes, year, hora,diaSemana);
         return fechaHoy;

      

    }
    @Override
    public String toString() {
        return "fechaActual: " + dia + mes + year +   hora + diaSemana ;
    }
    public String getDia() {
        return dia; }

    public String getMes() {
        return mes;
    }

    public String getYear() {
        return year;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getDiaSemana() {
        return diaSemana;
    }
    
}
