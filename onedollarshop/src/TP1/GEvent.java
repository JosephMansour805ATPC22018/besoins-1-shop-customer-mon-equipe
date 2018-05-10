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
package TP1;

/**
 *
 * @author pfares
 * @param <S> source de l'événement
 * @param <D>
 */
public class GEvent<S extends Source<D>,D> {

    /**
     * @return the _source
     */
    public S getSource() {
        return _source;
    }

    /**
     * @param _source the _source to set
     */
    public void setSource(S _source) {
        this._source = _source;
    }

    /**
     * @return the _data
     */
    public D getData() {
        return _data;
    }

    /**
     * @param _data the _data to set
     */
    public void setData(D _data) {
        this._data = _data;
    }
    
    private S _source;
    private D _data;
    
    public GEvent(S source, D data) {
        _source = source;
        _data = data;
    }
    
    public GEvent(S source) {
        _source = source;
        _data = null;
    }
    
}