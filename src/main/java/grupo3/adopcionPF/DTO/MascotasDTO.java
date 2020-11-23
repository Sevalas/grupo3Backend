package grupo3.adopcionPF.DTO;

import java.sql.Date;
import java.util.Objects;

public class MascotasDTO {
    private int idMascota;
    private String nombre;
    private int cuidador;
    private String especie;
    private String raza;
    private int edad;
    private String requisitos;
    private Date fechaDePublicacion;
    private char sexo;

    public MascotasDTO(int idMascota, String nombre, int cuidador, String especie, String raza, int edad, String requisitos, Date fechaDePublicacion, char sexo) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.cuidador = cuidador;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.requisitos = requisitos;
        this.fechaDePublicacion = fechaDePublicacion;
        this.sexo = sexo;
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

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Date getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(Date fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MascotasDTO that = (MascotasDTO) o;
        return idMascota == that.idMascota &&
                cuidador == that.cuidador &&
                edad == that.edad &&
                sexo == that.sexo &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(especie, that.especie) &&
                Objects.equals(raza, that.raza) &&
                Objects.equals(requisitos, that.requisitos) &&
                Objects.equals(fechaDePublicacion, that.fechaDePublicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMascota, nombre, cuidador, especie, raza, edad, requisitos, fechaDePublicacion, sexo);
    }

    @Override
    public String toString() {
        return "MascotasDTO{" +
                "idMascota=" + idMascota +
                ", nombre='" + nombre + '\'' +
                ", cuidador=" + cuidador +
                ", especie='" + especie + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", requisitos='" + requisitos + '\'' +
                ", fechaDePublicacion=" + fechaDePublicacion +
                ", sexo=" + sexo +
                '}';
    }
}