import java.util.List;

public class MinimumDataCalc extends AbstractDataCalc {

public MinimumDataCalc(DataSet set) {
    super(set);
}

@Override
public String getType() {
    return "MIN";
}

@Override
public double calcLine(List<Double> line) {
    double minimum = line.get(0);

    for(double num : line){
        if(num < minimum){
            minimum = num;
        }
    }
    return minimum;
        
}
    
}
