package grupo3.adopcionPF.DTO;

public class PostulacionesDTO {
    private int idPostulaciones;
    private int usuario;
    private String pregunta1;
    private String pregunta2;
    private String descripcion;
    private String fotoRefUrl;
    private int mascota;
    private boolean estado;

    public PostulacionesDTO(int idPostulaciones, int usuario, String pregunta1, String pregunta2, String descripcion, String fotoRefUrl, int mascota, boolean estado) {
        this.idPostulaciones = idPostulaciones;
        this.usuario = usuario;
        this.pregunta1 = pregunta1;
        this.pregunta2 = pregunta2;
        this.descripcion = descripcion;
        this.fotoRefUrl = fotoRefUrl;
        this.mascota = mascota;
        this.estado = estado;
    }

    public int getIdPostulaciones() {
        return idPostulaciones;
    }

    public void setIdPostulaciones(int id) {
        this.idPostulaciones = idPostulaciones;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(String pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public String getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(String pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoRefUrl() {
        return fotoRefUrl;
    }

    public void setFotoRefUrl(String fotoRefUrl) {
        this.fotoRefUrl = fotoRefUrl;
    }

    public int getMascota() {
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
