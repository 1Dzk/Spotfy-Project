package com.spotfy.spotfyproject.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TBFUNCIONARIO")
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDFUNCIONARIO")
    private Integer cdFuncionario;
    @Column(name = "NMFUNCIONARIO", length = 50, nullable = false)
    private String nmFuncionario;
    @Column(name = "NUCPF", length = 50, nullable = false)
    private String nuCpf;
    @Column(name= "NMEMAILFUNCIONARIO",length = 100)
    private String nmEmailFuncionario;
    @Column(name = "NUTELEFONE")
    private String nutelefone;
    @Column(name = "NMSENHAFUNCIONARIO", length = 50, nullable = false)
    private String nmSenhaFun;
    @ManyToOne
    @JoinColumn(name = "CDEMPRESA")
    private EmpresaModel empresa;
    @ManyToOne
    @JoinColumn(name = "CDUSUARIO")
    private UsuarioModel usuario;
}
