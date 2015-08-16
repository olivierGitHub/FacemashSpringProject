package com.oliver.common;

/**
 * Created by oliver on 08/08/15.
 */
public interface Dao<T, PK> {

    public boolean create(T obj);
    public T read(PK id);
    public void update(T obj);
    public void delete(PK id);

}
