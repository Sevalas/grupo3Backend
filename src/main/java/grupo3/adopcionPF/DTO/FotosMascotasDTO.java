package grupo3.adopcionPF.DTO;

import java.util.Objects;

public class FotosMascotasDTO {
    private int idFotosMascotas;
    private int mascota;
    private String foto;

    public FotosMascotasDTO(int idFotosMascotas, int mascota, String foto) {
        this.idFotosMascotas = idFotosMascotas;
        this.mascota = mascota;
        this.foto = foto;
    }

    public int getIdFotosMascotas() {
        return idFotosMascotas;
    }

    public void setIdFotosMascotas(int idFotosMascotas) {
        this.idFotosMascotas = idFotosMascotas;
    }

    public int getMascota() {
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
