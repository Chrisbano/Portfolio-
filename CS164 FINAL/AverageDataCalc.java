import java.util.List;

public class AverageDataCalc extends AbstractDataCalc {

public AverageDataCalc(DataSet set) {
    super(set);
}

@Override
public String getType(){
    return "AVERAGE";

}

@Override
public double calcLine(List<Double> line) {
    double sum = 0;
    double total = 0;

    for(double num : line){
        total++;
        sum += num;
    }

    return sum/total;
}
    
}
