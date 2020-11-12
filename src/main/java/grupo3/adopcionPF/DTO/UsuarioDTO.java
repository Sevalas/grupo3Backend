package grupo3.adopcionPF.DTO;

import java.sql.Date;
import java.util.Objects;

public class UsuarioDTO {
    private int idUsuario;
    private String nickname;
    private String password;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String email;
    private int fono;
    private String region;
    private String comuna;
    private String fotoPerfilUrl;

    public UsuarioDTO(int idUsuario, String nickname, String password, String nombres, String apellidos,
                      Date fechaNacimiento, String email, int fono, String region, String comuna,
                      String fotoPerfilUrl) {
        this.idUsuario = idUsuario;
        this.nickname = nickname;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.fono = fono;
        this.region = region;
        this.comuna = comuna;
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return idUsuario == that.idUsuario &&
                fono == that.fono &&
                nickname.equals(that.nickname) &&
                password.equals(that.password) &&
                nombres.equals(that.nombres) &&
                apellidos.equals(that.apellidos) &&
                fechaNacimiento.equals(that.fechaNacimiento) &&
                email.equals(that.email) &&
                region.equals(that.region) &&
                comuna.equals(that.comuna) &&
                fotoPerfilUrl.equals(that.fotoPerfilUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nickname, password, nombres, apellidos, fechaNacimiento, email, fono, region, comuna, fotoPerfilUrl);
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "idUsuario=" + idUsuario +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", email='" + email + '\'' +
                ", fono=" + fono +
                ", region='" + region + '\'' +
                ", comuna='" + comuna + '\'' +
                ", fotoPerfilUrl='" + fotoPerfilUrl + '\'' +
                '}';
    }
}
