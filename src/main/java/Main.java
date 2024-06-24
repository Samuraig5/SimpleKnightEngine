import MathHelper.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < 50; i++)
        {
            double newVal = Randoms.range(0,10,true);
            res.add(newVal);
        }

        for (Double d:res)
        {
            System.out.println(d);
        }
    }
}
