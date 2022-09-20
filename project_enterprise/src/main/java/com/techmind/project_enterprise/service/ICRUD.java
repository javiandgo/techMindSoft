package com.techmind.project_enterprise.service;

import java.util.List;

public interface ICRUD <T,ID>{
    T create(T t) throws Exception;
    T update(T t) throws Exception;
    List<T>readAll() throws Exception;
    T readById(ID id) throws Exception;
    void delete(ID id) throws Exception;
}
