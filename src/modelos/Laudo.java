package modelos;

import exame.Exame;

import java.time.LocalDate;

public class Laudo {
    private int numeroLaudo;            // Número sequencial do exame
    private Paciente paciente;             // Paciente associado
    private String convenio;               // Convênio do paciente
    private Medico medicoSolicitante;      // Médico solicitante
    private LocalDate dataEmissao;         // Data de emissão
    private Exame tipoExame;              // Tipo do exame (sanguíneo, raio-x, etc.)
    private String descricao;              // Corpo do laudo (diagnóstico, resultado)
    private Medico medicoResponsavel;      // Nome do médico responsável pelo laudo

    public Laudo(int numeroLaudo, Paciente paciente, String convenio,
                 Medico medicoSolicitante, Exame tipoExame,
                 String descricao, Medico medicoResponsavel) {
        this.numeroLaudo = numeroLaudo;
        this.paciente = paciente;
        this.convenio = convenio;
        this.medicoSolicitante = medicoSolicitante;
        this.dataEmissao = LocalDate.now();
        this.tipoExame = tipoExame;
        this.descricao = descricao;
        this.medicoResponsavel = medicoResponsavel;
    }

    public int getNumeroLaudo() {
        return numeroLaudo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getConvenio() {
        return convenio;
    }

    public Medico getMedicoSolicitante() {
        return medicoSolicitante;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public Exame getTipoExame() {
        return tipoExame;
    }

    public String getDescricao() {
        return descricao;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    @Override
    public String toString() {
        return "Laudo{" +
                "numeroLaudo='" + numeroLaudo + '\'' +
                ", paciente=" + paciente.getNomePaciente() +
                ", convenio='" + convenio + '\'' +
                ", medicoSolicitante='" + medicoSolicitante + '\'' +
                ", dataEmissao=" + dataEmissao +
                ", tipoExame='" + tipoExame + '\'' +
                ", descricao='" + descricao + '\'' +
                ", medicoResponsavel='" + medicoResponsavel + '\'' +
                '}';
    }
}
