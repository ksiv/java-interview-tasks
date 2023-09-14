package interviewtasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static interviewtasks.lib.paramhelper.isStringIntegerValue;

public class textalignment {


    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        int tmpStrLength = 0;
        int counter = 0;
        boolean isLastRow = false;

        for (int i = 0; true; i++) {
            // the first word in a row

            if (tmpStrLength == 0 && i < words.length) {
                tmpStrLength = words[i].length();
                counter++;
                continue;
            } else if (i < words.length) {
                // not the first word + space fit?
                int newTmpStrLength = tmpStrLength + 1 + words[i].length();
                if (newTmpStrLength <= maxWidth) {
                    counter++;
                    tmpStrLength = newTmpStrLength;

                    continue;
                } else {
                    i--;
                }
            } else if (i == words.length) {
                isLastRow = true;
                i--;
            }

            int wordSpacingsNum;
            if (counter == 1) {
                wordSpacingsNum = counter;
            } else {
                wordSpacingsNum = counter - 1;
            }
            //extra word spacing for left alignment
            if (isLastRow && tmpStrLength<maxWidth && counter>1){
                wordSpacingsNum++;
            }

            String[] wordSpacings = new String[wordSpacingsNum];

            int thisRowWordsLength = 0;
            for (int k = counter - 1; k >= 0; k--) {
                thisRowWordsLength += words[i - k].length();

            }
            int amountOfSpaces = maxWidth - thisRowWordsLength;
            boolean isLeftPossible = thisRowWordsLength+counter<=maxWidth;

            // fill word spacings for justify alignment
            int j = 0;
            if (!isLastRow || !isLeftPossible){
                while (amountOfSpaces > 0) {
                    if (wordSpacings[j] != null) {
                        wordSpacings[j] = wordSpacings[j] += " ";
                    } else {
                        wordSpacings[j] = " ";
                    }
                    amountOfSpaces--;
                    j++;
                    if (j == wordSpacings.length) j = 0;
                }
            }else{
                // fill spaces for left alignment
                while (amountOfSpaces > 0) {
                    if (wordSpacings[j] != null) {
                        wordSpacings[j] = wordSpacings[j] += " ";
                    } else {
                        wordSpacings[j] = " ";
                    }
                    amountOfSpaces--;
                    j++;
                    if (j == wordSpacings.length) j--;
                }
            }


            // width justify
            StringBuilder sb = new StringBuilder();
            if ((!isLastRow || !isLeftPossible) && counter >1){

                    for (int k = counter - 1; k >= 0; k--) {
                        sb.append(words[i - k]) ;
                        if (k == 0) {
                            continue;
                        }
                        sb.append(wordSpacings[wordSpacings.length-k]) ;

                    }

            // left alignment
            }else{
                if (counter > 1) {
                    for (int k = counter-1; k >= 0; k--) {
                        sb.append(words[i - k]) ;
                        sb.append(wordSpacings[wordSpacings.length-1-k]) ;

                    }

                } else {

                    sb.append(words[i]) ;
                    if(wordSpacings[0]!=null){
                        sb.append(wordSpacings[0]);
                    }

                }

            }
            list.add(sb.toString());
            tmpStrLength = 0;
            counter = 0;
            if (isLastRow) break;

        }
        return list;
    }

    public static void main(String[] args) {
        String helpMessage = "\"word1\" \"word2\" \"wordN\"  \"16\" words to justify and rowLength are expected as input";
        if (args.length < 1) {
            System.out.println("wrong argument count");
            System.out.println(helpMessage);
            return;
        } else {
            String[] str = new String[args.length-1];
            int rowLength=0;
            System.arraycopy(args,0,str,0,args.length-1);
            if(isStringIntegerValue(args[args.length-1])){
                rowLength = Integer.parseInt(args[args.length-1]);
            }
            System.out.println(Arrays.toString(str));
            System.out.println("row length: "+rowLength);
            System.out.println(fullJustify(str, rowLength));
        }
        }
}
