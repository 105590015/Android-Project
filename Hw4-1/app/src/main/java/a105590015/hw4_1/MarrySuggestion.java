package a105590015.hw4_1;

/**
 * Created by hjki3 on 4/1/2018.
 */

public class MarrySuggestion {
    public String getMarrySuggestion(int sex, String iAgeRange){
        String sug="建議:";
        if(sex==1){
            switch(iAgeRange) {
                case "(男)小於30歲,(女)小於28歲":
                    sug += "還不急";
                    break;
                case "(男)30到40歲,(女)28到35歲":
                    sug += "開始找對象";
                    break;
                case "(男)大於40歲,(女)大於35歲":
                    sug += "趕快結婚";
                    break;
            }
        }
        else if(sex==2){
            switch(iAgeRange) {
                case "(男)小於30歲,(女)小於28歲":
                    sug += "還不急";
                    break;
                case "(男)30到40歲,(女)28到35歲":
                    sug += "開始找對象";
                    break;
                case "(男)大於40歲,(女)大於35歲":
                    sug += "趕快結婚";
                    break;
            }
        }
        return sug;
    }
}
