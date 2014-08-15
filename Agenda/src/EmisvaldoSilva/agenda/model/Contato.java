/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EmisvaldoSilva.agenda.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Emisvaldo
 */
@Entity
@Table(name = "CONTATO")
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")})
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "NOME", nullable = false, length = 2147483647)
    private String nome;
    @Column(name = "MUNICIPIO", length = 120)
    private String municipio;
    @Column(name = "ESTADO", length = 2)
    private String estado;
    @Column(name = "EMAIL", length = 60)
    private String email;
    @Column(name = "EMPRESA", length = 120)
    private String empresa;
    @Column(name = "EMAILCOMERCIAL", length = 60)
    private String emailcomercial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contato")
    private List<Fone> foneList;
    @JoinColumn(name = "GRUPOCONTATO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Grupocontato grupocontato;

    public Contato() {
    }

    public Contato(Long id) {
        this.id = id;
    }

    public Contato(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmailcomercial() {
        return emailcomercial;
    }

    public void setEmailcomercial(String emailcomercial) {
        this.emailcomercial = emailcomercial;
    }

    public List<Fone> getFoneList() {
        return foneList;
    }

    public void setFoneList(List<Fone> foneList) {
        this.foneList = foneList;
    }

    public Grupocontato getGrupocontato() {
        return grupocontato;
    }

    public void setGrupocontato(Grupocontato grupocontato) {
        this.grupocontato = grupocontato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmisvaldoSilva.agenda.model.Contato[ id=" + id + " ]";
    }
    
}
