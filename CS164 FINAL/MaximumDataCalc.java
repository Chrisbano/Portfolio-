import java.util.List;

public class MaximumDataCalc extends AbstractDataCalc {

public MaximumDataCalc(DataSet set) {
    super(set);
}

@Override
public String getType() {
        return "MAX";
}

@Override
public double calcLine(List<Double> line) {
    double maximum = line.get(0);

    for(double num : line){
        if(num > maximum){
            maximum = num;
        }
    }
    return maximum;
}
    
}
