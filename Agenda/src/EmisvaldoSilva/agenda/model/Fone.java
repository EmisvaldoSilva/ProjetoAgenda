/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EmisvaldoSilva.agenda.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Emisvaldo
 */
@Entity
@Table(name = "FONE")
@NamedQueries({
    @NamedQuery(name = "Fone.findAll", query = "SELECT f FROM Fone f")})
public class Fone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "NUMERO", nullable = false, length = 20)
    private String numero;
    @Column(name = "OPERADORA", length = 60)
    private String operadora;
    @Basic(optional = false)
    @Column(name = "COMERCIAL", nullable = false)
    private Boolean comercial;
    @JoinColumn(name = "CONTATO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Contato contato;

    public Fone() {
    }

    public Fone(Long id) {
        this.id = id;
    }

    public Fone(Long id, String numero, Boolean comercial) {
        this.id = id;
        this.numero = numero;
        this.comercial = comercial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public Boolean getComercial() {
        return comercial;
    }

    public void setComercial(Boolean comercial) {
        this.comercial = comercial;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
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
        if (!(object instanceof Fone)) {
            return false;
        }
        Fone other = (Fone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmisvaldoSilva.agenda.model.Fone[ id=" + id + " ]";
    }
    
}
