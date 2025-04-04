package org.data_structure.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Pgs완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // 1. participant로 완주자: 사람수 HashMap을 만든다.
        HashMap<String,Integer> players = new HashMap<>();
        for(String name: participant){
            if(players.containsKey(name)){
                players.put(name, players.get(name)+1);
            }
            else {
                players.put(name, 1);
            }
        }

        // 2. completion으로 HashMap 완주자:사람수 를 채운다 완주자가 있으면 사람수를 -1 한다.
        for(String name: completion){
            if(players.containsKey(name)){
                players.put(name, players.get(name)-1);
            }
        }

        // 3. 최종적으로 사람수가 1 이상인 value가 답이다.
        Set<String> keySet = players.keySet();
        for(String key: keySet){
            if(players.get(key) >= 1){
                answer += key;
                break;
            }
        }
        return answer;
    }
}
