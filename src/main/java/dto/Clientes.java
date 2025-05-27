/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Hakur
 */
@Entity
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCodiClie", query = "SELECT c FROM Clientes c WHERE c.codiClie = :codiClie"),
    @NamedQuery(name = "Clientes.findByNdniClie", query = "SELECT c FROM Clientes c WHERE c.ndniClie = :ndniClie"),
    @NamedQuery(name = "Clientes.findByAppaClie", query = "SELECT c FROM Clientes c WHERE c.appaClie = :appaClie"),
    @NamedQuery(name = "Clientes.findByApmaClie", query = "SELECT c FROM Clientes c WHERE c.apmaClie = :apmaClie"),
    @NamedQuery(name = "Clientes.findByNombClie", query = "SELECT c FROM Clientes c WHERE c.nombClie = :nombClie"),
    @NamedQuery(name = "Clientes.findByFechNaciClie", query = "SELECT c FROM Clientes c WHERE c.fechNaciClie = :fechNaciClie"),
    @NamedQuery(name = "Clientes.findByLogiClie", query = "SELECT c FROM Clientes c WHERE c.logiClie = :logiClie"),
    @NamedQuery(name = "Clientes.findByPassClie", query = "SELECT c FROM Clientes c WHERE c.passClie = :passClie")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codiClie")
    private Integer codiClie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ndniClie")
    private String ndniClie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "appaClie")
    private String appaClie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apmaClie")
    private String apmaClie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombClie")
    private String nombClie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechNaciClie")
    @Temporal(TemporalType.DATE)
    private Date fechNaciClie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "logiClie")
    private String logiClie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "passClie")
    private String passClie;

    public Clientes() {
    }

    public Clientes(Integer codiClie) {
        this.codiClie = codiClie;
    }

    public Clientes(Integer codiClie, String ndniClie, String appaClie, String apmaClie, String nombClie, Date fechNaciClie, String logiClie, String passClie) {
        this.codiClie = codiClie;
        this.ndniClie = ndniClie;
        this.appaClie = appaClie;
        this.apmaClie = apmaClie;
        this.nombClie = nombClie;
        this.fechNaciClie = fechNaciClie;
        this.logiClie = logiClie;
        this.passClie = passClie;
    }

    public Integer getCodiClie() {
        return codiClie;
    }

    public void setCodiClie(Integer codiClie) {
        this.codiClie = codiClie;
    }

    public String getNdniClie() {
        return ndniClie;
    }

    public void setNdniClie(String ndniClie) {
        this.ndniClie = ndniClie;
    }

    public String getAppaClie() {
        return appaClie;
    }

    public void setAppaClie(String appaClie) {
        this.appaClie = appaClie;
    }

    public String getApmaClie() {
        return apmaClie;
    }

    public void setApmaClie(String apmaClie) {
        this.apmaClie = apmaClie;
    }

    public String getNombClie() {
        return nombClie;
    }

    public void setNombClie(String nombClie) {
        this.nombClie = nombClie;
    }

    public Date getFechNaciClie() {
        return fechNaciClie;
    }

    public void setFechNaciClie(Date fechNaciClie) {
        this.fechNaciClie = fechNaciClie;
    }

    public String getLogiClie() {
        return logiClie;
    }

    public void setLogiClie(String logiClie) {
        this.logiClie = logiClie;
    }

    public String getPassClie() {
        return passClie;
    }

    public void setPassClie(String passClie) {
        this.passClie = passClie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiClie != null ? codiClie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codiClie == null && other.codiClie != null) || (this.codiClie != null && !this.codiClie.equals(other.codiClie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Clientes[ codiClie=" + codiClie + " ]";
    }
    
}
