package school.sptech.model;

import jakarta.persistence.*;


@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "senha")
    private String senha;

    @Column(name = "sla_mttr")
    private Integer sla_mttr;

    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nome, String email, String cpf, String telefone, String senha, Integer sla_mttr) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.sla_mttr = sla_mttr;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getSla_mttr() {
        return sla_mttr;
    }

    public void setSla_mttr(Integer sla_mttr) {
        this.sla_mttr = sla_mttr;
    }
}
