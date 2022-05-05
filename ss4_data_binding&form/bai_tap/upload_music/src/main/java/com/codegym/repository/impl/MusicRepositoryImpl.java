package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class MusicRepositoryImpl implements IMusicRepository {

    static Map<Integer, Music> musicMap;
    static {
        musicMap = new TreeMap<>();
        musicMap.put(1, new Music("Dap mo cuoc tinh","Dan Truong", "bolero", "https://james.codegym.vn/mod/assign/view.php?id=12657&forceview=1"));
        musicMap.put(2, new Music("Thanh pho buon","Dan Truong", "bolero", "https://james.codegym.vn/mod/assign/view.php?id=12657&forceview=1"));
        musicMap.put(3, new Music("Qua con me","Dan Truong", "bolero", "https://james.codegym.vn/mod/assign/view.php?id=12657&forceview=1"));
    }

    @Override
    public List<Music> findAll() {
        return new ArrayList<>(musicMap.values());
    }

    @Override
    public void upload(Music music) {
        Integer id = (int)(Math.random()*1000);
        musicMap.put(id,music);
    }
}
