import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public abstract class AbstractDataCalc{
private List<Double> results;
private DataSet set;
    


public AbstractDataCalc(DataSet set){
    setAndRun(set);
}




public void runCalculations() {
    results = new ArrayList<Double>();

    for(int i = 0; i < set.rowCount(); i++){
        results.add(calcLine(set.getRow(i)));
    }
}

public void setAndRun(DataSet set){
    this.set = set;

    if(set != null){
        runCalculations();
    }
}

@Override
public String toString(){
    String result = "Dataset Results (Method: " + getType() + ")\n";
    double calculated;
    for(int i = 0; i < results.size(); i++ ){
        calculated = calcLine(set.getRow(i));
        int currentrow = i + 1;

        result += "Row " + currentrow + ": " + String.format("%.1f", calculated) + "\n";
    }
    return result;
}

public abstract String getType();
public abstract double calcLine(List<Double> line);



}