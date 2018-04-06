package TP0;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
     * Nom du Client (optionnel)
     */
    private final String _nom;

    /**
     * Telephone du Client (optionnel)
     */
    private String _telephone;

    /**
     * Rue du Client (optionnel)
     */
    private String _rue;

    /**
     * Ville du Client (optionnel)
     */
    private String _ville;

    /**
     * Etat du Client (optionnel)
     */
    private String _etat;

    /**
     * Code du Client (optionnel)
     */
    private String _code;

    /**
     * Pays du Client (optionnel)
     */
    private String _pays;

    /**
     * Mail du Client (optionnel)
     */
    private String _mail;
    private static String _status;

    public Client(String id) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        _id = id;
        _prenom = "";
        _nom = "";
    }

    /**
     * Le constructeur avec un builder
     *
     * @param cb
     */
    @Override
    public String toString() {

        return _status;
    }

    public void readJsonFile() {
        File f = new File("Data_Files/" + _id + ".json");
        if (f.exists() && !f.isDirectory()) {
            BufferedReader br = null;
            FileReader fr = null;

            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);

                String sCurrentLine;
                _status = "";
                while ((sCurrentLine = br.readLine()) != null) {
                    _status += sCurrentLine;
                }

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (br != null) {
                        br.close();
                    }

                    if (fr != null) {
                        fr.close();
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();

                }

            }

        } else {
            _status = "ID " + _id + " n'existe pas";
        }

    }

    public Client(ClientBuilder cb) {
        _id = cb._id;
        _prenom = cb._prenom;
        _nom = cb._nom;
        _telephone = cb._telephone;
        _rue = cb._rue;
        _ville = cb._ville;
        _etat = cb._etat;
        _code = cb._code;
        _pays = cb._pays;
        _mail = cb._mail;
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
     *
     *
     * public void setNom(String _nom) { this._nom = _nom; }
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
     * @param _code the _code to set
     */
    public void setCode(String _code) {
        this._code = _code;
    }

    /**
     * @param _pays the _pays to set
     */
    public void setPays(String _pays) {
        this._pays = _pays;
    }

    /**
     * @param _mail the _mail to set
     */
    public void setMail(String _mail) {
        this._mail = _mail;
    }

    /**
     * Une classe builder interne (et static) a utiliser par new
     * Client.ClientBuilder(___).attribut1(_)....build();
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
         * @throws java.io.IOException
         */
        public Client build() throws IOException {

            Gson gson = new Gson();
            String json = gson.toJson(this);
            File file;
            file = new File("Data_Files/" + this._id + ".json");

            /* This logic will make sure that the file 
                 * gets created if it is not present at the
                 * specified location
             */
            if (file.exists()) {
                _status = "ID " + this._id + " déjà existe";
            } else {
                file.createNewFile();

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

                    bw.write(json);

                    _status = "Client crée: " + json;

                } catch (IOException e) {
                }
            }

            return new Client(this);

        }
    }
}
