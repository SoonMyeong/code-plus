package chap05._13023;

import org.junit.jupiter.api.Test;

public class Sol
{
    @Test
    void sol()
    {
        int answer = 0;
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        String[] jokka = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++)
        {
            for (int j = 0; j < jokka.length; j++)
            {
                babbling[i] = recusive(babbling[i], jokka, j);
            }
        }
        for(String str : babbling) {
            if(str.equals("")) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private String recusive(String s, String[] strs, int idx)
    {
        if (idx == 4)
        {
            return s;
        }

        for (int i = 0; i < 4; i++)
        {
            if (s.startsWith(strs[i]))
            {
                s = s.replace(strs[i], "");
                recusive(s, strs, idx++);
            }
        }
        return s;
    }

}
