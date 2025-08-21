package Projeto-PPS.Modelos;

import java.sql.Date;

public class Medico {
    private String idMedico;
    private String nomeMedico;
    private String crm;
    private String especialidade;
    private Date dataNasc;
    private String cpf;
    private String email;
    private String endereco;

    // Construtor com parâmetros
    public Medico(String idMedico, String nomeMedico, String crm, String especialidade, Date dataNasc,
                  String cpf, String email, String endereco) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.crm = crm;
        this.especialidade = especialidade;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public Medico() {}

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "idMedico='" + idMedico + '\'' +
                ", nomeMedico='" + nomeMedico + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", dataNasc=" + dataNasc +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}

