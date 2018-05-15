/*
 * Copyright (C) 2018 mansourjo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Entities;

import com.google.gson.Gson;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mansourjo
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id")
    , @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom")
    , @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Client.findByPays", query = "SELECT c FROM Client c WHERE c.pays = :pays")
    , @NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c.ville = :ville")
    , @NamedQuery(name = "Client.findByEtat", query = "SELECT c FROM Client c WHERE c.etat = :etat")
    , @NamedQuery(name = "Client.findByRue", query = "SELECT c FROM Client c WHERE c.rue = :rue")
    , @NamedQuery(name = "Client.findByCode", query = "SELECT c FROM Client c WHERE c.code = :code")
    , @NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c.mail = :mail")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "pays")
    private String pays;
    @Column(name = "ville")
    private String ville;
    @Column(name = "etat")
    private String etat;
    @Column(name = "rue")
    private String rue;
    @Column(name = "code")
    private String code;
    @Column(name = "mail")
    private String mail;

    public Client() {
    }

    public Client(String id) {
        this.id = id;
    }

    public Client(String id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }
public Client(ClientBuilder cb) {
        id = cb._id;
        prenom = cb._prenom;
        nom = cb._nom;
        telephone = cb._telephone;
        rue = cb._rue;
        ville = cb._ville;
        etat = cb._etat;
        code = cb._code;
        pays = cb._pays;
        mail = cb._mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "Entities.Client[ id=" + id + " ]";
         return new Gson().toJson(this);
    }
    
    public static class ClientBuilder {

        /**
         * Id du Client (obligatoire)
         */
        String _id;

        /**
         * Prenom du Client (obligatoire)
         */
        String _prenom;

        /**
         * Nom du Client (obligatoire)
         */
        String _nom;

        /**
         * Telephone du Client (optionnel)
         */
        String _telephone;

        /**
         * Rue du Client (optionnel)
         */
        String _rue;

        /**
         * Ville du Client (optionnel)
         */
        String _ville;

        /**
         * Etat du Client (optionnel)
         */
        String _etat;

        /**
         * Code du Client (optionnel)
         */
        String _code;

        /**
         * Pays du Client (optionnel)
         */
        String _pays;

        /**
         * Mail du Client (optionnel)
         */
        String _mail;

        /**
         * Constructeur minimal du pattern Builder est la Liste des attributs
         * obligatoires
         *
         * @param id
         * @param prenom
         * @param nom
         */
        public ClientBuilder(String id, String prenom, String nom) {
            _id = id;
            _prenom = prenom;
            _nom = nom;
        }

        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         *
         * @param nom
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         *
         * public ClientBuilder nom(String nom) { _nom=nom; return this; }
         */
        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         *
         * @param telephone
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder telephone(String telephone) {
            _telephone = telephone;
            return this;
        }

        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         *
         * @param rue
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder rue(String rue) {
            _rue = rue;
            return this;
        }

        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         *
         * @param ville
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder ville(String ville) {
            _ville = ville;
            return this;
        }

        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         *
         * @param etat
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder etat(String etat) {
            _etat = etat;
            return this;
        }

        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         *
         * @param code
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder code(String code) {
            _code = code;
            return this;
        }

        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         *
         * @param pays
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder pays(String pays) {
            _pays = pays;
            return this;
        }

        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         *
         * @param mail
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder mail(String mail) {
            _mail = mail;
            return this;
        }

        /**
         * Le build
         *
         * @return objet a creer
         */
        public Client build()  {

            return new Client(this);
        }
    }
    
}
