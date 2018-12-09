package _kingmbc;
/**
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 * @date 2016.11.17	
 * http://www.johndcook.com/blog/standard_deviation/
 */
public class RunningStat {

	int nOfData;
    double oldMean, newMean, oldSumOfSquareOfDeviation, newSumOfSquareOfDeviation;
    public static void main(String[] args) {
    	RunningStat rs = new RunningStat();

        rs.Push(17.0);
        rs.Push(19.0);
        rs.Push(24.0);
        rs.Push(24.0);
        double mean = rs.Mean();
        double variance = rs.Variance();
        double stdev = rs.StandardDeviation();
    }

    public RunningStat(){
    	nOfData = 0;
    }
    void Clear()
    {
        nOfData = 0;
    }

    void Push(double x)
    {
        nOfData++;

        // See Knuth TAOCP vol 2, 3rd edition, page 232
        if (nOfData == 1)
        {
            oldMean = newMean = x;
            oldSumOfSquareOfDeviation = 0.0;
        }
        else
        {
            newMean = oldMean + (x - oldMean)/nOfData;
            newSumOfSquareOfDeviation = oldSumOfSquareOfDeviation + (x - oldMean)*(x - newMean);

            // set up for next iteration
            oldMean = newMean; 
            oldSumOfSquareOfDeviation = newSumOfSquareOfDeviation;
        }
        System.out.println("N:" + nOfData + "\t" + "newMean: " + newMean + "\t" + "newSumOfDeviation:" + newSumOfSquareOfDeviation );
        System.out.println("Mean:" + Mean() + "\tVariance" + Variance());
    }

    int NumDataValues()
    {
        return nOfData;
    }

    double Mean()
    {
        return (nOfData > 0) ? newMean : 0.0;
    }

    double Variance()
    {
        return ( (nOfData > 1) ? newSumOfSquareOfDeviation/(nOfData - 1) : 0.0 );
    }

    double StandardDeviation()
    {
        return Math.sqrt( Variance() );
    }	
}