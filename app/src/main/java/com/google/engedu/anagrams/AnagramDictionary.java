package com.google.engedu.anagrams;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();

    public ArrayList<String> wordlist = new ArrayList<String>();
    ArrayList<String> result2 = new ArrayList<String>();
    ArrayList<String> result = new ArrayList<String>();
    ArrayList<String> result3 = new ArrayList<String>();
    ArrayList<String> result0 = new ArrayList<String>();
    HashMap<String,HashSet<String>> lettersTowords = new HashMap<String,HashSet<String>>();
    HashSet<String> wordset = new HashSet<String>(wordlist);



    public AnagramDictionary(InputStream wordListStream) throws IOException {
       BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while ((line = in.readLine()) != null) {
            String word = line.trim();
          //  wordlist.add(word);
           }

          /*

        Iterator it=wordset.iterator();

        while(it.hasNext())
        {
            String value =(String)it.next();
         String sortedword = sortLetter(value);
            if(!lettersTowords.containsKey(sortedword))
            {
                lettersTowords.put(sortedword,new HashSet<String>());
            }
            lettersTowords.get(sortedword).add(value);
        }
        */

    }


    public boolean isGoodWord(String word, String base) {
       /* boolean flag=false;
        for (int i = 0; i < wordlist.size(); i++) {
           if(word.equalsIgnoreCase(wordlist.get(i))    &&  word.indexOf(base) == -1 )
           {
               flag=true;
            }
        }
        return flag; */
        return true;
    }
    public ArrayList<String> getAnagrams(String targetWord) {

        String rev1 = sortLetter(targetWord);

        for (int i = 0; i < wordlist.size(); i++)
        {
            String temp = sortLetter(wordlist.get(i));
            result.add(temp);                                //rev dictionary
        }
        for (int i = 0; i<result.size(); i++) {
            if ( rev1.length()==result.get(i).length()  && rev1.equalsIgnoreCase(result.get(i)) ) {
                if (!targetWord.equals(wordlist.get(i)))
                {
                    result2.add(wordlist.get(i));        //anagram of target word
                }
            }
        }
        return result2;
    }


    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        for (char c = 'a'; c <= 'z'; c++) {

            String target=word+c;

            String rev1 = sortLetter(target);

            for (int i = 0; i < wordlist.size(); i++)
            {
                String temp = sortLetter(wordlist.get(i));
                result0.add(temp);                                //rev dictionary
            }
            for (int i = 0; i<result0.size(); i++) {
                if ( rev1.length()==result0.get(i).length()  && rev1.equalsIgnoreCase(result.get(i)) ) {
                    if (!word.equals(wordlist.get(i)))
                    {
                        result3.add(wordlist.get(i));        //anagram of target word
                    }
                }
            }
        } return result3;
    }



    public String pickGoodStarterWord() {
        return "stop";
    }


    public String sortLetter(String wordtosort) {
        char[] chars = wordtosort.toCharArray();
        Arrays.sort(chars);
        String newWord = new String(chars);
        return newWord;

    }


}