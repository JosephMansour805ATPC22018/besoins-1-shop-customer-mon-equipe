package TP0;

public class Client {

    /**
     * Id du Client (obligatoire)
     */
    private final String _id;

    /**
     * Prenom du Client (obligatoire)
     */
    private final String _prenom;

    /**
     * Nom du Client  (optionnel)
     */
    private final String _nom;
    
    /**
     * Telephone du Client  (optionnel)
     */
    private String _telephone;
    
    /**
     * Rue du Client  (optionnel)
     */
    private String _rue;
    
    /**
     * Ville du Client  (optionnel)
     */
    private String _ville;

    /**
     * Etat du Client  (optionnel)
     */
    private String _etat;
    
    /**
     * Code du Client  (optionnel)
     */
    private String _code;
    
    /**
     * Pays du Client  (optionnel)
     */
    private String _pays;
    
    /**
     * Mail du Client  (optionnel)
     */
    private String _mail;

    /**
     * Le constructeur avec un builder
     * @param cb 
     */
   
    public Client(ClientBuilder cb) {
        _id=cb._id;
        _prenom=cb._prenom;
        _nom=cb._nom;
        _telephone=cb._telephone;
        _rue=cb._rue;
        _ville=cb._ville;
        _etat=cb._etat;
        _code=cb._code;
        _pays=cb._pays;
        _mail=cb._mail;
    }

       /**
     * @return the _id
     */
    public String getId() {
        return _id;
    }

    /**
     * @return the _prenom
     */
    public String getPrenom() {
        return _prenom;
    }

    /**
     * @return the _nom
     */
    public String getNom() {
        return _nom;
    }

    /**
     * @return the _telephone
     */
    public String getTelephone() {
        return _telephone;
    }

    /**
     * @return the _rue
     */
    public String getRue() {
        return _rue;
    }

    /**
     * @return the _ville
     */
    public String getVille() {
        return _ville;
    }

    /**
     * @return the _etat
     */
    public String getEtat() {
        return _etat;
    }

    /**
     * @return the _code
     */
    public String getCode() {
        return _code;
    }

    /**
     * @return the _pays
     */
    public String getPays() {
        return _pays;
    }

    /**
     * @return the _mail
     */
    public String getMail() {
        return _mail;
    }

    /**
     * @param _nom the _nom to set
     

    public void setNom(String _nom) {
        this._nom = _nom;
    }
    */

    /**
     * @param _telephone the _telephone to set
     */
    public void setTelephone(String _telephone) {
        this._telephone = _telephone;
    }

    /**
     * @param _rue the _rue to set
     */
    public void setRue(String _rue) {
        this._rue = _rue;
    }

    /**
     * @param _ville the _ville to set
     */
    public void setVille(String _ville) {
        this._ville = _ville;
    }

    /**
     * @param _etat the _etat to set
     */
    public void setEtat(String _etat) {
        this._etat = _etat;
    }

    /**
     * @param _pays the _pays to set
     */
    public void setPays(String _pays) {
        this._pays = _pays;
    }

    /**
     * @param _pays the _pays to set
     */
    public void setMail(String _mail) {
        this._mail = _mail;
    }

    /**
     * Une classe builder interne (et static)
     * a utiliser par new Client.ClientBuilder(___).attribut1(_)....build();
     */
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
     * Nom du Client  (obligatoire)
     */
    String _nom;
    
    /**
     * Telephone du Client  (optionnel)
     */
    String _telephone;
    
    /**
     * Rue du Client  (optionnel)
     */
    String _rue;
    
    /**
     * Ville du Client  (optionnel)
     */
    String _ville;

    /**
     * Etat du Client  (optionnel)
     */
    String _etat;
    
    /**
     * Code du Client  (optionnel)
     */
    String _code;
    
    /**
     * Pays du Client  (optionnel)
     */
    String _pays;
    
    /**
     * Mail du Client  (optionnel)
     */
    String _mail;

        
        /** 
         * Constructeur minimal du pattern Builder 
         * est la Liste des attributs obligatoires
         * @param id
         * @param prenom 
         */
        public ClientBuilder(String id,String prenom, String nom) {
            _id=id;
            _prenom=prenom;
            _nom=nom;
        }
        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         * @param nom
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         
        public ClientBuilder nom(String nom) {
            _nom=nom;
            return this;
        }
	*/
        
        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         * @param telephone
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder telephone(String telephone) {
            _telephone=telephone;
            return this;
        }
  
        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         * @param rue
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder rue(String rue) {
            _rue=rue;
            return this;
        }
  
        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         * @param ville
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder ville(String ville) {
            _ville=ville;
            return this;
        }
  
        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         * @param etat
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder etat(String etat) {
            _etat=etat;
            return this;
        }
  
         /**
         * Parametre de build tout attribut optionnel renvoi un builder
         * @param code
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder code(String code) {
            _code=code;
            return this;
        }
       /**
         * Parametre de build tout attribut optionnel renvoi un builder
         * @param pays
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder pays(String pays) {
            _pays=pays;
            return this;
        }
  
        /**
         * Parametre de build tout attribut optionnel renvoi un builder
         * @param mail
         * @return un ClientBuilder pour enchainer les mise a jour du builder
         */
        public ClientBuilder mail(String mail) {
            _mail=mail;
            return this;
        }
  

  
        /**
         * Le build
         * @return objet a creer
         */
        public Client build(){
            return new Client(this);
        }
    }
}
