package grupo3.adopcionPF.DTO;

import java.util.Objects;

public class MascotasDTO {
    private int idMascota;
    private String nombre;
    private int cuidador;
    private String especie;
    private String raza;
    private int edad;
    private String infoAdicional;
    private int fechaDePublicacion;

    public MascotasDTO(int idMAscota, String nombre, int cuidador, String especie, String raza, int edad, String infoAdicional, int fechaDePublicacion) {
        this.idMascota = idMAscota;
        this.nombre = nombre;
        this.cuidador = cuidador;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.infoAdicional = infoAdicional;
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuidador() {
        return cuidador;
    }

    public void setCuidador(int cuidador) {
        this.cuidador = cuidador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public int getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(int fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

}
