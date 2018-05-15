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
package TP1.boundary;

import Entities.ClientJpaController;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mansourjo
 */
public class Parametres {

    public static String maxClientID(String pays,String ville){
         EntityManagerFactory emf=Persistence.createEntityManagerFactory("onedollarshop_jpaPU");
        ClientJpaController cjc=new ClientJpaController(emf);
        //generer le ID à partir du nombre de records pour chque pays/ville 
        //Les 3 premiers characteres du PAYS&Les 3 premiers characteres de la ville&nombre de records +1
        return pays.substring(0,3).toUpperCase()+ville.substring(0,3).toUpperCase()+String.format("%07d",cjc.maxID(pays, ville)+1);
        
    }

    


}


