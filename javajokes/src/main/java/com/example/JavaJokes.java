package com.example;

import java.util.Random;

public class JavaJokes {
    String jokes[] = {"Once all the engineering professors were sitting in a plane, before the take off there was an announcement " +
            "made, \"This plane is made by your students\", then all professors stood up and ran outside, but the principal was still sitting.. one student " +
            "came and asked, are you not scared Mr. Prinicpal? principal replied, I trust my students very well and I am damn sure the plane won't even start!!",
            "Husband put a status on Facebook. \"Good morning!, such a Lovely day.. I am so happy today!!\"\r"
                    + " Wife Posted: Challenge accepted!!",
            "Daughter:\"What is marriage?\"\n"
            +"Mother:\"Marriage is just a fancy word for adopting an overgrown male child who cannot be handled by his parents anymore..\"",
            "Especially for English Language lovers.. Can any one tell the difference between 'Completed' and 'Finished' ? No dictionary has ever" +
                    "been able to define the difference between 'Complete' and 'Finished'.  However, in a linguistic conference,  Sun Sherman an Indian American, was" +
            "was the clever winner.  He said, \"when you marry the right wonman, you are 'Complete', if you marry the wrong woman, you are 'Finished'. And " +
                    "when the right woman catches you with the wrong woman, you are 'Completely Finished'.\"",
            "I love being a writer... what I can't stand is the paperwork..",
            "Whenever I find the key to success, someone changes the lock"
    };

    public String getJoke() {
        Random r = new Random();
        int i1 = r.nextInt(4 - 0) + 4;
        return jokes[i1];
    }
}
