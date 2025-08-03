package org.mowitnow.service;

import org.mowitnow.model.Lawn;
import org.mowitnow.model.Mower;

import java.util.List;


//Service principale qui lance les tondeuses à partir de la liste des commandes
public class MowerService {

    public String executeCommands(List<String> inputLines) {

        Lawn lawn = Lawn.fromString(inputLines.getFirst());
        StringBuilder output = new StringBuilder();

        int i = 1;
        while(i < inputLines.size()) {

            String mowerPosition = inputLines.get(i);
            String commands = inputLines.get(i+1);

            Mower  mower = Mower.fromStringAndLawn(mowerPosition, lawn);
            mower.executeCommand(commands);
            output.append(mower).append(" ");

            i+=2;
        }
        return output.toString();
    }
}
