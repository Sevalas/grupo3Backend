package grupo3.adopcionPF.DTO;

import java.util.Objects;

public class FotosMascotasDTO {
    private int idFotosMascotas;
    private int mascota;
    private String foto1;
    private String foto2;
    private String foto3;
    private String foto4;
    private String foto5;

    public FotosMascotasDTO(int idFotosMascotas, int mascota, String foto1, String foto2, String foto3, String foto4, String foto5) {
        this.idFotosMascotas = idFotosMascotas;
        this.mascota = mascota;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
        this.foto5 = foto5;
    }

    public int getIdFotosMascotas() {
        return idFotosMascotas;
    }

    public void setIdFotosMascotas(int id) {
        this.idFotosMascotas = idFotosMascotas;
    }

    public int getMascota() {
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public String getFoto4() {
        return foto4;
    }

    public void setFoto4(String foto4) {
        this.foto4 = foto4;
    }

    public String getFoto5() {
        return foto5;
    }

    public void setFoto5(String foto5) {
        this.foto5 = foto5;
    }

}
