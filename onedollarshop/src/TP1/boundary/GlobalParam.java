/*
 * Copyright (C) 2018 Lenovo
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

/**
 *
 * @author Lenovo
 */
public class GlobalParam {

    //La directoire base où les fichiers vont etre residés
    public final static String BASE_DIR = "Customers\\";

    public static List<File> listf(String directoryName) throws IOException {
        File directory = new File( directoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        List<File> resultList = new ArrayList<>();

        // Liste des fichiers dans la directoire
        FilenameFilter filefilter=(File file, String filename) -> filename.toLowerCase().endsWith(".json")||file.isDirectory();
              
        
        File[] fList = directory.listFiles(filefilter);
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (!file.isFile()) {
                if (file.isDirectory()) {
                    resultList.remove(file);
                    resultList.addAll(listf(file.getAbsolutePath()));
                }
               
            }
          //   else System.out.println(file.getAbsolutePath());
        }
        return resultList;

    }

    
    public static void listSourceFiles(String dir) throws IOException {
      Files.newDirectoryStream(Paths.get(dir),
        path -> path.toString().endsWith(".json"))
        .forEach(System.out::println);
   }
}


