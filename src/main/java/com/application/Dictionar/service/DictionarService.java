package com.application.Dictionar.service;

import com.application.Dictionar.entity.Dictionar;
import com.application.Dictionar.repository.DictionarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DictionarService {

    @Autowired
    private DictionarRepository dictionarRepository;

    @Transactional
    public String createDictionar(Dictionar dictionar){
        try {
            if (!dictionarRepository.existsByRomanian(dictionar.getRomanian())){
                dictionar.setId(null == dictionarRepository.findMaxId()? 0 : dictionarRepository.findMaxId() + 1);
                dictionarRepository.save(dictionar);
                return "Dictionar record created successfully.";
            }else {
                return "Dictionar already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Dictionar> readDictionar(){
        return dictionarRepository.findAll();
    }

    @Transactional
    public String updateDictionar(Dictionar dictionar){
        if (dictionarRepository.existsByRomanian(dictionar.getRomanian())){
            try {
                List<Dictionar> dictionars = dictionarRepository.findByRomanian(dictionar.getRomanian());
                dictionars.stream().forEach(s -> {
                    Dictionar dictionarToBeUpdate = dictionarRepository.findById(s.getId()).get();
                    dictionarToBeUpdate.setJapanese(dictionar.getJapanese());
                    dictionarToBeUpdate.setRomanian(dictionar.getRomanian());
                    dictionarRepository.save(dictionarToBeUpdate);
                });
                return "Dictionar record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Dictionar does not exists in the database.";
        }
    }

    @Transactional
    public String deleteDictionar(Dictionar dictionar){
        if (dictionarRepository.existsByRomanian(dictionar.getRomanian())){
            try {
                List<Dictionar> dictionars = dictionarRepository.findByRomanian(dictionar.getRomanian());
                dictionarRepository.deleteAll(dictionars);
                return "Dictionar record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Dictionar does not exist";
        }
    }
}
