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
package TP1;

/**
 *
 * @author mansourjo
 */
import java.util.ArrayList;

/**
 *
 * @author pfares
 * @param <D>
 */
public class  Source<D> {
    ArrayList<GEventListener> listListener;
    
    public Source() {
         listListener=new ArrayList<>();
    }
    public void addGEventListener(GEventListener listener) {
        listListener.add(listener);
    }
    public void removeGEventListener(GEventListener listener) {
        listListener.remove(listener);
    }
    
    public void dispatch(GEvent<Source<D>,D> ev) {
        listListener.forEach((gel) ->  gel.action(ev));
    }
    public GEvent<Source<D>,D> genEvent(D d) {
        return new GEvent<Source<D>,D>(this, d);
    }
}