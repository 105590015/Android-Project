package a105590015.hw3;

/**
 * Created by hjki3 on 3/24/2018.
 */

public class MarrySuggestion {
    public String getMarrySuggestion(String sex, int iAgeRange, int familyNum){
        String sug="建議:";
        if(sex.equals("male")){
            switch(iAgeRange) {
                case 1:
                    if (familyNum < 4)
                        sug += "趕快結婚";
                    else if (familyNum <= 10)
                        sug += "趕快結婚";
                    else
                        sug += "還不急";
                    break;
                case 2:
                    if (familyNum < 4)
                        sug += "趕快結婚";
                    else if (familyNum <= 10)
                        sug += "開始找對象";
                    else
                        sug += "還不急";
                    break;
                case 3:
                    if (familyNum < 4)
                        sug += "開始找對象";
                    else if (familyNum <= 10)
                        sug += "趕快結婚";
                    else
                        sug += "開始找對象";
                    break;
            }
        }
        else if(sex.equals("female")){
            switch(iAgeRange) {
                case 1:
                    if (familyNum < 4)
                        sug += "趕快結婚";
                    else if (familyNum <= 10)
                        sug += "趕快結婚";
                    else
                        sug += "還不急";
                    break;
                case 2:
                    if (familyNum < 4)
                        sug += "趕快結婚";
                    else if (familyNum <= 10)
                        sug += "開始找對象";
                    else
                        sug += "還不急";
                    break;
                case 3:
                    if (familyNum < 4)
                        sug += "開始找對象";
                    else if (familyNum <= 10)
                        sug += "趕快結婚";
                    else
                        sug += "開始找對象";
                    break;
            }
        }
        return sug;
    }
}