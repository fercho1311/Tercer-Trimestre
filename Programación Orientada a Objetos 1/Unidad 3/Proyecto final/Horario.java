public class Horario {

    private String dia;
    private String horaInicio;
    private String horaFin;

    public Horario(
            String dia,
            String horaInicio,
            String horaFin) {

        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getDia() {
        return dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    /*
     * Verifica si este horario entra en conflicto
     * con otro horario.
     */
    public boolean tieneConflicto(Horario otro) {

        if (!dia.equalsIgnoreCase(otro.dia)) {
            return false;
        }

        int inicio1 = convertirHora(horaInicio);
        int fin1 = convertirHora(horaFin);

        int inicio2 = convertirHora(otro.horaInicio);
        int fin2 = convertirHora(otro.horaFin);

        return inicio1 < fin2 && inicio2 < fin1;
    }

    private int convertirHora(String hora) {

        String[] partes = hora.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);

        return horas * 60 + minutos;
    }

    @Override
    public String toString() {

        return dia + " " + horaInicio + " - " + horaFin;
    }
}
