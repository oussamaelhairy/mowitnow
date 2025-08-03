package org.mowitnow;

import org.mowitnow.parser.FileParser;
import org.mowitnow.service.MowerService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        if(args.length == 0)
            throw new IllegalArgumentException("Pas de fichier précisé");
        List<String> inputLines = FileParser.parseFile(args[0]);
        MowerService mowerService = new MowerService();
        String result = mowerService.executeCommands(inputLines);
        System.out.println(result);
    }
}