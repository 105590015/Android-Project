package a105590015.hw4_2;

/**
 * Created by hjki3 on 4/2/2018.
 */

public class ComputerPlay {
    public String getPlay(int play, int comPlay)
    {
        if ((play==1 && comPlay==3)||(play==2 && comPlay==1)||(play==3 && comPlay==2))
            return "贏";
        else if ((play==1 && comPlay==2)||(play==2 && comPlay==3)||(play==3 && comPlay==1))
            return "輸";
        else
            return "平";
    }
}
